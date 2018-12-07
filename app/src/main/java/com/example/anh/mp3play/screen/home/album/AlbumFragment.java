package com.example.anh.mp3play.screen.home.album;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.anh.mp3play.R;
import com.example.anh.mp3play.screen.base.PlaySongService;
import com.example.anh.mp3play.screen.home.base.BaseGroup;


public class AlbumFragment extends BaseGroup {

    @Override
    public Fragment getInstance(Fragment fragment) {
        return null;
    }

    @Override
    protected void initComponent(View view) {

    }

    @Override
    protected void initData(View view) {
        Button btnStop = view.findViewById(R.id.btn_stop);
        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(getActivity(), PlaySongService.class);
                getActivity().stopService(myIntent);
            }
        });
        showData();
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_album;
    }


    @Override
    public void showData() {

        Toast.makeText(getActivity(),"DA oc cho",Toast.LENGTH_LONG).show();
    }
}
