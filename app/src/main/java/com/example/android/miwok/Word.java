package com.example.android.miwok;

/**
 * Created by Daniel Schimanski at 12:57 on 26/07/2017
 */

public class Word {

    private String miwokTranslation;
    private String defaultTranslation;
    private int imageResourceID;
    private int musicResourceID;

    public Word(String miwokTranslation, String defaultTranslation, int imageResourceID,
                int musicResourceID) {
        this.defaultTranslation = defaultTranslation;
        this.miwokTranslation = miwokTranslation;
        this.imageResourceID = imageResourceID;
        this.musicResourceID = musicResourceID;
    }

    public Word(String miwokTranslation, String defaultTranslation, int musicResourceID) {
        this.defaultTranslation = defaultTranslation;
        this.miwokTranslation = miwokTranslation;
        this.musicResourceID = musicResourceID;
    }

    public void setMiwokTranslation(String miwokTranslation) {
        this.miwokTranslation = miwokTranslation;
    }

    public void setDefaultTranslation(String defaultTranslation) {
        this.defaultTranslation = defaultTranslation;
    }

    public void setImageResourceID(int imageResourceID) {
        this.imageResourceID = imageResourceID;
    }

    public void setMusicResourceID(int musicResourceID) {
        this.musicResourceID = musicResourceID;
    }

    public String getMiwokTranslation() {
        return miwokTranslation;
    }

    public String getDefaultTranslation() {
        return defaultTranslation;
    }

    public int getImageResourceID() {
        return imageResourceID;
    }

    public int getMusicResourceID() {
        return musicResourceID;
    }
}
