package com.example.anh.mp3play.data.model;

import android.graphics.Bitmap;

public class Music {
    private Bitmap mImage;
    private String mSong;
    private String mArtist;

    public Music() {
    }

    public Music(Bitmap image, String song, String artist) {
        mImage = image;
        mSong = song;
        mArtist = artist;
    }

    public Bitmap getImage() {
        return mImage;
    }

    public void setImage(Bitmap image) {
        mImage = image;
    }

    public String getSong() {
        return mSong;
    }

    public void setSong(String song) {
        mSong = song;
    }

    public String getArtist() {
        return mArtist;
    }

    public void setArtist(String artist) {
        mArtist = artist;
    }
}
