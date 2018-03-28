package com.example.android.musicalapp;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Essam on 08/03/2018.
 */

public class SongAdapter extends ArrayAdapter<Song> {

    /**
     * This is my own custom constructor (it doesn't mirror a superclass constructor).
     * The context is used to inflate the layout file, and the list is the data we want
     * to populate into the lists.
     *
     * @param context  The current context. Used to inflate the layout file.
     * @param songs A List of Songs objects to display in a list
     */
    public SongAdapter(Activity context, ArrayList<Song> songs) {

        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, songs);
    }

    /**
     * Provides a view for an AdapterView (ListView, GridView, etc.)
     *
     * @param position The position in the list of data that should be displayed in the
     *                 list item view.
     * @param convertView The recycled view to populate.
     * @param parent The parent ViewGroup that is used for inflation.
     * @return The View for the position in the AdapterView.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link Song} object located at this position in the list
        Song currentSong = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID song_name
        TextView nameTextView =  listItemView.findViewById(R.id.song_name);
        // Get the version name from the current Song object and
        // set this text on the song_name TextView
        nameTextView.setText(currentSong.getSongName());

        // Find the TextView in the list_item.xml layout with the ID artist_name
        TextView numberTextView = listItemView.findViewById(R.id.artist_name);
        // Get the version number from the current Song object and
        // set this text on the number TextView
        numberTextView.setText(currentSong.getArtistName());

        // Find the ImageView in the list_item.xml layout with the ID song_image
         ImageView iconView =listItemView.findViewById(R.id.song_image);
         // Get the image resource ID from the current Song object and
         // set the image to iconView
         iconView.setImageResource(currentSong.getImageResourceId());

         // Return the whole list item layout (containing 2 TextViews and an ImageView)
         // so that it can be shown in the ListView */

        return listItemView;
    }
}
