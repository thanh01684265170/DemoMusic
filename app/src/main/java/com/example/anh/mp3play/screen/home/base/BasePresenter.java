package com.example.anh.mp3play.screen.home.base;

import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.util.ArrayList;

public class BasePresenter implements BaseContract.Presenter {
    @Override
    public void getData() {
        Log.d("thanh","hello");
//        ArrayList lstDuongDan = new ArrayList<>();
//        // DOc trong thu muc downloads cua the nho
//        String path = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Zing MP3";
//        File thumuc = new File(path);
//        File []files = thumuc.listFiles(); // Lay tat ca cac file trong thu muc Zing MP3
//        for (int i = 0; i < files.length; i++){
//            // Doc tat cac file trong Zing MP3 them vao list nhac
//            String s = files[i].getName();
//            if (s.endsWith(".mp3") || s.endsWith(".MP3") || s.endsWith(".m4a")){// Kiem tra xem co phai dinh dangj cua am thanh khong
//                lstDuongDan.add(files[i].getAbsolutePath());
//            }
//        }
    }
}
