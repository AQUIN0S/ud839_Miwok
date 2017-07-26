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
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    private ArrayList<Word> words = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);
        setWords();

        ArrayAdapter<Word> itemsAdapter = new ArrayAdapter<>(this, R.layout.list_item, words);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);
    }

    private void setWords() {
        words.add(new Word("Lutti", "One"));
        words.add(new Word("Otiiko", "Two"));
        words.add(new Word("Tolookosu", "Three"));
        words.add(new Word("Oyyisa", "Four"));
        words.add(new Word("Massokka", "Five"));
        words.add(new Word("Temmokka", "Six"));
        words.add(new Word("Kenekaku", "Seven"));
        words.add(new Word("Kawinta", "Eight"));
        words.add(new Word("Wo'e", "Nine"));
        words.add(new Word("Na'aacha", "Ten"));
    }
}
