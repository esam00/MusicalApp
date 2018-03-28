package com.example.android.musicalapp;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

public class NowPlayingActivity extends AppCompatActivity {
    MediaPlayer mediaPlayer;
    SeekBar seekBar;
    Handler handler;
    Runnable runAble;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_now_playing);

        handler = new Handler();

       // Receiving current song details by intent
        Intent i = getIntent();
        String songName = i.getStringExtra("song name");
        String artistName = i.getStringExtra("artist name");
        int songResourceId = i.getIntExtra("song", 0);

        // put the song name into its textView
        TextView name = findViewById(R.id.song_name_now_playing);
        name.setText(songName);

        // put the artist name into its textView
        TextView artist = findViewById(R.id.artist_name_now_playing);
        artist.setText(artistName);

        // play the audio
        mediaPlayer = MediaPlayer.create(NowPlayingActivity.this, songResourceId);
        mediaPlayer.start();

        seekBar = findViewById(R.id.position);
        seekBar.setMax(mediaPlayer.getDuration());
        playCycle();
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean input) {
                if (input) {
                    mediaPlayer.seekTo(progress);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        /**
         * play and pause the audio
         */
        final ImageView pause = findViewById(R.id.pause);
        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.pause();
                    pause.setBackgroundResource(R.drawable.play_button);
                } else {
                    mediaPlayer.start();
                    pause.setBackgroundResource(R.drawable.pause_button);
                }
            }
        });

    }

    /**
     * actually i'm not very sure if i understand this yet , all i know that this method used to
     * keep the seek bar  following the audio while it is playing
     *
     * get this code from stackOverflow
     */
    public void playCycle() {
        seekBar.setProgress(mediaPlayer.getCurrentPosition());
        if (mediaPlayer.isPlaying()) {
            runAble = new Runnable() {
                @Override
                public void run() {
                    playCycle();
                }
            };
            handler.postDelayed(runAble, 1000);
        }


    }
}
