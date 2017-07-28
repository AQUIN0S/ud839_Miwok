package com.example.android.miwok;

/**
 * Created by Daniel Schimanski at 12:57 on 26/07/2017
 */

public class Word {

    private String mMiwokTranslation;
    private String mDefaultTranslation;

    public Word(String miwokTranslation, String defaultTranslation) {
        this.mDefaultTranslation = defaultTranslation;
        this.mMiwokTranslation = miwokTranslation;
    }

    public void setMiwokTranslation(String mMiwokTranslation) {
        this.mMiwokTranslation = mMiwokTranslation;
    }

    public String getMiwokTranslation() {
        return mMiwokTranslation;
    }

    public void setDefaultTranslation(String mDefaultTranslation) {
        this.mDefaultTranslation = mDefaultTranslation;
    }

    public String getDefaultTranslation() {
        return mDefaultTranslation;
    }

}
