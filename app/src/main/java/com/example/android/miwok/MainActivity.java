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

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.numbers)
    public void openNumbersActivity() {
        Intent OpenNumbers = new Intent(this, NumbersActivity.class);
        startActivity(OpenNumbers);
    }

    @OnClick(R.id.family)
    public void openFamilyActivity() {
        Intent OpenFamily = new Intent(this, FamilyActivity.class);
        startActivity(OpenFamily);
    }

    @OnClick(R.id.colors)
    public void openColorsActivity() {
        Intent OpenColors = new Intent(this, ColorsActivity.class);
        startActivity(OpenColors);
    }

    @OnClick(R.id.phrases)
    public void openPhrasesActivity() {
        Intent OpenPhrases = new Intent(this, PhrasesActivity.class);
        startActivity(OpenPhrases);
    }

}
