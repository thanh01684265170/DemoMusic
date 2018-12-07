package com.example.anh.mp3play.screen.home.base;

import java.util.List;

public interface BaseContract {
    interface View{
        void showData();
    }

    interface Presenter{
        List<String> getPath();
        List getData(List<String> paths);
//        void playMusic(android.view.View view,String path);
    }
}
