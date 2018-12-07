package com.example.anh.mp3play.screen.home.base;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaMetadataRetriever;
import android.os.Environment;
import android.os.Message;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.anh.mp3play.R;
import com.example.anh.mp3play.screen.home.song.MusicPlayer;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public abstract class BasePresenter implements BaseContract.Presenter {
    private List<String> mLinks;

    @Override
    public List<String> getPath() {
        mLinks = new ArrayList<>();
        // Doc trong thu muc zing mp3 cua the nho
        String path = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Zing MP3";
        File link = new File(path);
        File []files = link.listFiles(); // Lay tat ca cac file trong thu muc Zing MP3
        for (int i = 0; i < files.length; i++){
            // Doc tat cac file trong Zing MP3 them vao list nhac
            String s = files[i].getName();
            if (s.endsWith(".mp3") || s.endsWith(".MP3") || s.endsWith(".m4a")){// Kiem tra xem co phai dinh dangj cua am thanh khong
                mLinks.add(files[i].getAbsolutePath());
            }
        }
        return mLinks;
    }
}
