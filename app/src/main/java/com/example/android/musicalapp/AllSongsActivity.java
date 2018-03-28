package com.example.android.musicalapp;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class AllSongsActivity extends AppCompatActivity {
private static MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.song_list);

        /**
         * declaring an arrayList of Song object
         */
        final ArrayList<Song> songs = new ArrayList<>();

        // Adding our song to the arrayList each by creating new Song object
        // Song object has 4 arguments : songName , artistName , imageResourceId , audioResourceId

        songs.add(new Song("Insan","Hamza Namira",R.drawable.insan,R.raw.insan));
        songs.add(new Song("Ghammed Einak","Cairokee",R.drawable.nas_we_nas,
                R.raw.cairokee_ghammed_einak));
        songs.add(new Song("El Hekaia","Hany Adel ",R.drawable.elhekaia,
                R.raw.el_hakaiah));
        songs.add(new Song("Ya Fatinah","Hany Adel",R.drawable.yafatenah,
                R.raw.ya_fatinah));
        songs.add(new Song("To2a3 we t2om","Masar Egbary",
                R.drawable.to2a3_wet2om,R.raw.to2a3_we_t2om));
        songs.add(new Song("kanet htefr2","Masar Egbary",
                R.drawable.nas_we_nas,R.raw.kanet_hatefr2));
        songs.add(new Song("Darey Ya 2lby","Hamza Namira",R.drawable.darey,R.raw.darey));
        songs.add(new Song("Kol Haga Betaady","Cairokee",
                R.drawable.nas_we_nas,R.raw.cairokee_kol_haga_betaady));
        songs.add(new Song("Marboot B Astek.","Cairokee",
                R.drawable.nas_we_nas,R.raw.cairokee_marboot_be_astek));
        songs.add(new Song("Ana Lak 3ltol ","Abdelhalem Hafez",
                R.drawable.haleem,R.raw.ana_lak_3altool));
        songs.add(new Song("Ahwak","Abdelhalem Hafez",
                R.drawable.haleem,R.raw.ahwak));
        songs.add(new Song("Enta 3omry","Om Kalthom",
                R.drawable.om_kalthom,R.raw.enta_3omry));
        songs.add(new Song("Moonlight ","Beethoven",
                R.drawable.beethoven_sonata,R.raw.beethoven_moonlight_third_movement));
        songs.add(new Song("Kreutzer ","Beethoven",
                R.drawable.beethoven_kreutzer_first_movement,R.raw.beethoven_kreutzer_first_movement));
        songs.add(new Song("Étude ","Chopin",
                R.drawable.elhekaia,R.raw.chopin_etude_in_c_sharp_minor));
        songs.add(new Song("Wenter Wind","Chopin",
                R.drawable.insan,R.raw.chopin_wenter_wind));

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
                Intent intent = new Intent(AllSongsActivity.this,NowPlayingActivity.class);
                intent.putExtra("song name",songName);
                intent.putExtra("artist name",artistName);
                intent.putExtra("song",audioResourceId);
                startActivity(intent);
            }
        });
    }
}
