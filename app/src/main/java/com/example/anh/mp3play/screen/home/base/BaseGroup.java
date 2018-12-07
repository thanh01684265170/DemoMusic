package com.example.anh.mp3play.screen.home.base;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.ViewGroup;

public abstract class BaseGroup extends Fragment implements BaseContract.View{
    private BaseContract.Presenter mPresenter;
    @Override
    public android.view.View onCreateView(LayoutInflater inflater, ViewGroup container,
                                          Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        android.view.View view = inflater.inflate(getLayoutResource(), container, false);
        initComponent(view);
        initData(view);
        return view;
    }
    public abstract Fragment getInstance(Fragment fragment);
    protected abstract void initComponent(android.view.View view);
    protected abstract void initData(android.view.View view);
    protected abstract int getLayoutResource();
    public void getData(){
        mPresenter.getPath();
    }
}
