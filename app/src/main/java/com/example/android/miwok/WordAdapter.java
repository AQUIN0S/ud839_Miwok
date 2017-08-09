package com.example.android.miwok;

import android.app.Activity;
import android.media.MediaPlayer;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * This class was mostly based off of the ud839_CustomAdapter_Example project on GitHub... I
 * understand most of it but would have
 */
public class WordAdapter extends ArrayAdapter {
    private int themeColour;

    /**
     * This constructor doesn't mirror a superclass constructor.
     * The context is used to inflate the layout file, and the list is the data we want
     * to populate into the lists.
     * Because the TextView ID parameter passed to the ArrayAdapter isn't used, any integer value
     * can be used there.
     *
     * @param context       The current context. Used to inflate the layout file.
     * @param words         A List of AndroidFlavor objects to display in a list
     */
    public WordAdapter(Activity context, ArrayList<Word> words, int themeColour) {
        super(context, 0, words);
        this.themeColour = themeColour;
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
    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate a new view from the layout.
        // I get it now!
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }
        final Word currentWord = (Word) getItem(position);

        TextView miwokTranslationView =
                (TextView) listItemView.findViewById(R.id.miwok_word_view);
        miwokTranslationView.setText(currentWord.getMiwokTranslation());

        TextView defaultTranslationView =
                (TextView) listItemView.findViewById(R.id.default_word_view);
        defaultTranslationView.setText(currentWord.getDefaultTranslation());

        ImageView itemImageView = (ImageView) listItemView.findViewById(R.id.item_image_view);

        if (currentWord.getImageResourceID() != 0) {
            itemImageView.setImageResource(currentWord.getImageResourceID());
            itemImageView.setVisibility(View.VISIBLE);
        } else {
            itemImageView.setVisibility(View.GONE);
        }

        // Set the background colour of the TextView
        listItemView.findViewById(R.id.text_views_layout).setBackgroundColor(themeColour);

        return listItemView;
    }

}
