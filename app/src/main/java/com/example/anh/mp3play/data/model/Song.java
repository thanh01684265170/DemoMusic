package com.example.anh.mp3play.data.model;

public class Song {
    private String path;
    private String mSong;
    private String mArtist;

    public Song() {
    }

    public Song(String path, String song, String artist) {
        this.path = path;
        mSong = song;
        mArtist = artist;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
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
