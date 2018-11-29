package com.example.anh.mp3play.screen.home.song;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.anh.mp3play.R;
import com.example.anh.mp3play.screen.home.base.BaseContract;
import com.example.anh.mp3play.screen.home.base.BaseGroup;
import com.example.anh.mp3play.screen.home.base.BasePresenter;

/**
 * A simple {@link Fragment} subclass.
 */
public class SongFragment extends BaseGroup{
    private BaseContract.Presenter mPresenter;

    @Override
    public Fragment getInstance(Fragment fragment) {
        return fragment;
    }

    @Override
    protected void initComponent(android.view.View view) {
        mPresenter = new SongPresenter();
    }

    @Override
    protected void initData(android.view.View view) {
        showData();
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_song;
    }

    @Override
    public void showData() {
        mPresenter.getData();
    }
}
