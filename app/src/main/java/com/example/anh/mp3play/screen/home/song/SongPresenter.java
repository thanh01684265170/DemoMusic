package com.example.anh.mp3play.screen.home.song;


import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaMetadataRetriever;
import android.os.Message;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.anh.mp3play.R;
import com.example.anh.mp3play.data.model.Song;
import com.example.anh.mp3play.screen.home.base.BaseContract;
import com.example.anh.mp3play.screen.home.base.BasePresenter;

import java.util.ArrayList;
import java.util.List;


public class SongPresenter extends BasePresenter {
    private MusicPlayer mMusicPlayer = new MusicPlayer();;
//    private BaseContract.Presenter mPresenter = new SongPresenter();
    private int mPosition = 0;
    public static final String TAG = "thanh";

    @Override
    public List getData(List<String> paths) {
        List<Song> songs = new ArrayList<>();
        MediaMetadataRetriever mmr = new MediaMetadataRetriever();
        for(int i=0; i<paths.size(); i++)
        {
            //Ten bai hat ten ca si
            mmr.setDataSource(paths.get(i));
            String artist = mmr.extractMetadata(MediaMetadataRetriever.METADATA_KEY_ARTIST);
            String song = mmr.extractMetadata(MediaMetadataRetriever.METADATA_KEY_TITLE);
            byte []bm = mmr.getEmbeddedPicture();
            songs.add(new Song(paths.get(i),song,artist));
        }
        return songs;
    }

    public void playMusic(String path) {
        if (mMusicPlayer.getState() == MusicPlayer.PLAYER_PLAY){
            mMusicPlayer.stop();
        }
        mMusicPlayer.setup(path);
        mMusicPlayer.play();
    }

    public boolean playAndPause(){
        if (mMusicPlayer.getState() == MusicPlayer.PLAYER_PLAY){
            mMusicPlayer.pause();
            return true;
        }else {
            mMusicPlayer.play();
            return false;
        }
    }

}
