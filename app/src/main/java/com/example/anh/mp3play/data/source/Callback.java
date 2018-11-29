package com.example.anh.mp3play.data.source;

public interface Callback<K> {
    void onGetDataSuccess(K data);
    void onGetDataFail(Error error);
}
