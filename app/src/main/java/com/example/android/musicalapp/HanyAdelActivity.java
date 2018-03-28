package com.example.android.musicalapp;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class HanyAdelActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.song_list);

        /**
         * arrayList of Hany Adel Songs only
         */
        final ArrayList<Song> songs = new ArrayList<>();
        songs.add(new Song("Insan","Hamza Namira",R.drawable.insan,R.raw.insan));
        songs.add(new Song("Ghammed Einak","Cairokee",R.drawable.nas_we_nas,
                R.raw.cairokee_ghammed_einak));
        songs.add(new Song("El Hekaia","Hany Adel ",R.drawable.elhekaia,
                R.raw.el_hakaiah));
        songs.add(new Song("Ya Fatinah","Hany Adel",R.drawable.yafatenah,
                R.raw.ya_fatinah));

        SongAdapter itemsAdapter = new SongAdapter(this,songs);
        ListView listView = findViewById(R.id.list);
        listView.setAdapter(itemsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                // get the position of the item which has been clicked on
                Song song = songs.get(position);

                // preparing to send this details via an intent to a nowPlaying activity
                int audioResourceId = song.getAudioResourceId();
                String songName = song.getSongName();
                String artistName = song.getArtistName();

                // using an intent to send current song details
                Intent intent = new Intent(HanyAdelActivity.this,NowPlayingActivity.class);
                intent.putExtra("song name",songName);
                intent.putExtra("artist name",artistName);
                intent.putExtra("song",audioResourceId);
                startActivity(intent);
            }
        });
    }
}
