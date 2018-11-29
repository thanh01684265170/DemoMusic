package com.example.anh.mp3play.screen.home.base;

public interface BaseContract {
    interface View{
        void showData();
    }

    interface Presenter{
        void getData();
    }
}
