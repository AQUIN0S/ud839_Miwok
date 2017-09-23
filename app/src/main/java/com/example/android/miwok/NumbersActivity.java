/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.miwok;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    private ArrayList<Word> words = new ArrayList<>();
    private MediaPlayer mediaPlayer = new MediaPlayer();
    private AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int focusChange) {
            if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT ||
                    focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                mediaPlayer.pause();
                mediaPlayer.seekTo(0);
            } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                mediaPlayer.start();
            } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                releaseMediaPlayer();
            }
        }
    };

    /**
     * This listener gets triggered when the {@link MediaPlayer} has completed
     * playing the audio file.
     */
    private MediaPlayer.OnCompletionListener completionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            AudioManager audioManager = (AudioManager) getBaseContext().getSystemService(Context.AUDIO_SERVICE);
            audioManager.abandonAudioFocus(onAudioFocusChangeListener);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);
        setWords();

        // Create a new WordAdapter which creates a list item for each word and attach it to the
        // parent listView.
        WordAdapter itemsAdapter = new WordAdapter(this, words,
                ContextCompat.getColor(this, R.color.category_numbers));
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(itemsAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                releaseMediaPlayer();
                AudioManager audioManager = (AudioManager) getBaseContext().getSystemService(Context.AUDIO_SERVICE);
                if (audioManager.requestAudioFocus(onAudioFocusChangeListener, AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT) == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                    mediaPlayer = MediaPlayer.create(NumbersActivity.this, words.get(position).getMusicResourceID());
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(completionListener);
                }
            }
        });
    }

    @Override
    protected void onStop() {
        releaseMediaPlayer();
        super.onStop();
    }

    private void setWords() {
        words.add(new Word("Lutti", "One", R.drawable.number_one, R.raw.number_one));
        words.add(new Word("Otiiko", "Two", R.drawable.number_two, R.raw.number_two));
        words.add(new Word("Tolookosu", "Three", R.drawable.number_three, R.raw.number_three));
        words.add(new Word("Oyyisa", "Four", R.drawable.number_four, R.raw.number_four));
        words.add(new Word("Massokka", "Five", R.drawable.number_five, R.raw.number_five));
        words.add(new Word("Temmokka", "Six", R.drawable.number_six, R.raw.number_six));
        words.add(new Word("Kenekaku", "Seven", R.drawable.number_seven, R.raw.number_seven));
        words.add(new Word("Kawinta", "Eight", R.drawable.number_eight, R.raw.number_eight));
        words.add(new Word("Wo'e", "Nine", R.drawable.number_nine, R.raw.number_nine));
        words.add(new Word("Na'aacha", "Ten", R.drawable.number_ten, R.raw.number_ten));
    }

    /**
     +     * Clean up the media player by releasing its resources.
     +     */
    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mediaPlayer = null;
        }
    }

}
