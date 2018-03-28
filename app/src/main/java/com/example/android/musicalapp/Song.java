package com.example.android.musicalapp;

/**
 * Created by Essam on 08/03/2018.
 */

public class Song {

    /** Song Name  */
    private String mSongName ;

    /** Artist Name  */
    private String mArtistName ;

    /** Image of song ( resource id)  */
    private int mImageResourceId ;

    /** Song Audio ( resource id) */
    private int mAudioResourceId ;

    /** class constructor */

    public Song (String songName , String artistName, int imageResourceId, int audioResourceId){
        mSongName = songName;
        mArtistName = artistName;
        mImageResourceId = imageResourceId;
        mAudioResourceId = audioResourceId;
    }

    public int getImageResourceId(){

        return mImageResourceId;
    }

    public int getAudioResourceId(){

        return mAudioResourceId;
    }

    public String getArtistName() {
        return mArtistName;
    }

    public String getSongName(){

        return mSongName;
    }
}
