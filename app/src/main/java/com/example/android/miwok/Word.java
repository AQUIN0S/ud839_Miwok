package com.example.android.miwok;

/**
 * Created by Daniel Schimanski at 12:57 on 26/07/2017
 */

class Word {

    private String mMiwokTranslation;
    private String mDefaultTranslation;

    Word(String miwokTranslation, String defaultTranslation) {
        this.mDefaultTranslation = defaultTranslation;
        this.mMiwokTranslation = miwokTranslation;
    }

    public void setmMiwokTranslation(String mMiwokTranslation) {
        this.mMiwokTranslation = mMiwokTranslation;
    }

    public String getmMiwokTranslation() {
        return mMiwokTranslation;
    }

    public void setmDefaultTranslation(String mDefaultTranslation) {
        this.mDefaultTranslation = mDefaultTranslation;
    }

    public String getmDefaultTranslation() {
        return mDefaultTranslation;
    }

}
