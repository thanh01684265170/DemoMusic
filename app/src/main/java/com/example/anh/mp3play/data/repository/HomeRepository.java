package com.example.anh.mp3play.data.repository;

import com.example.anh.mp3play.data.HomeDataSource;

public class HomeRepository implements HomeDataSource.Local, HomeDataSource.Remote {
    private HomeDataSource.Local mLocal;
    private HomeDataSource.Remote mRemote;

    public HomeRepository(HomeDataSource.Local mLocal, HomeDataSource.Remote mRemote) {
        this.mLocal = mLocal;
        this.mRemote = mRemote;
    }

    
}
