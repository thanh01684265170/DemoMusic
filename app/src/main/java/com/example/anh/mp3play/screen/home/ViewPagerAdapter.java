package com.example.anh.mp3play.screen.home;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.anh.mp3play.screen.home.album.AlbumFragment;
import com.example.anh.mp3play.screen.home.song.SongFragment;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    ViewPagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }
    @Override
    public Fragment getItem(int position) {
        Fragment frag=null;
        switch (position){
            case 0:
                frag = new SongFragment();
                break;
            case 1:
                frag = new AlbumFragment();
                break;
        }
        return frag;
    }

    @Override
    public int getCount() {
        return 2;
    }
    @Override
    public CharSequence getPageTitle(int position) {
        String title = "";
        switch (position){
            case 0:
                title = "Song";
                break;
            case 1:
                title = "Artist";
                break;
        }
        return title;
    }
}