package com.example.android.musicalapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout all_songs = findViewById(R.id.all_songs);
        LinearLayout artist = findViewById(R.id.artist);

        /**
         * set onClickListener to the all_songs Linear layout so when the user touch it the app
         * goes to all songs Activity  using an explicit intent
         */
        all_songs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent allSongsIntent = new Intent(MainActivity.this, AllSongsActivity.class);
                startActivity(allSongsIntent);
            }
        });

        /**
         * set onClickListener to the artist Linear layout so when the user touch it the app
         * goes to artists Activity using an explicit intent
         */
        artist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent artistIntent = new Intent(MainActivity.this, ArtistActivity.class);
                startActivity(artistIntent);
            }
        });
    }
}
