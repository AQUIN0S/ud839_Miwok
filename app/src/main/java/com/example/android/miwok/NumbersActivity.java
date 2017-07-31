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

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    private ArrayList<Word> words = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);
        setWords();

        // Create a new WordAdapter which creates a list item for each word and attach it to the
        // parent listView.
        WordAdapter itemsAdapter = new WordAdapter(this, words);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(itemsAdapter);
    }

    private void setWords() {
        words.add(new Word("Lutti", "One", R.drawable.number_one));
        words.add(new Word("Otiiko", "Two", R.drawable.number_two));
        words.add(new Word("Tolookosu", "Three", R.drawable.number_three));
        words.add(new Word("Oyyisa", "Four", R.drawable.number_four));
        words.add(new Word("Massokka", "Five", R.drawable.number_five));
        words.add(new Word("Temmokka", "Six", R.drawable.number_six));
        words.add(new Word("Kenekaku", "Seven", R.drawable.number_seven));
        words.add(new Word("Kawinta", "Eight", R.drawable.number_eight));
        words.add(new Word("Wo'e", "Nine", R.drawable.number_nine));
        words.add(new Word("Na'aacha", "Ten", R.drawable.number_ten));
    }

}
