package com.example.anh.mp3play.screen.home.song;


import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaMetadataRetriever;
import android.support.constraint.Group;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.anh.mp3play.R;
import com.example.anh.mp3play.data.model.Song;
import com.example.anh.mp3play.screen.base.PlaySongService;
import com.example.anh.mp3play.screen.home.ItemClickListener;
import com.example.anh.mp3play.screen.home.base.BaseContract;
import com.example.anh.mp3play.screen.home.base.BaseGroup;

import java.util.List;

//import java.security.acl.Group;

/**
 * A simple {@link Fragment} subclass.
 */
public class SongFragment extends BaseGroup {
    private BaseContract.Presenter mPresenter;
    private SongPresenter mSongPresenter;
    private RecyclerView mRecyclerView;
    private TextView mTxtSong;
    private TextView mTxtArtist;
    private ImageView mImgSong;
    private Button mBtnNext;
    private Button mBtnPrevious;
    private Button mBtnPlay;
    private Group mGroup;
    private Bitmap mImage;
    private int mPosition = 0;
    private List<String> mPaths;
    private List<Song> mSongs;
    public static final String TAG = "thanh";

    @Override
    public Fragment getInstance(Fragment fragment) {
        return fragment;
    }

    @Override
    protected void initComponent(android.view.View view) {
        mPresenter = new SongPresenter();
        mSongPresenter = new SongPresenter();
    }

    @Override
    protected void initData(android.view.View view) {
        initView(view);
        showData();
        OnClick();
    }

    private void OnClick() {
        mBtnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPosition++;
                if (mPosition > mPresenter.getPath().size())
                    mPosition = 0;
                setPlay();
            }
        });
        mBtnPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPosition--;
                if (mPosition < 0)
                    mPosition = mPresenter.getPath().size() - 1;
                setPlay();
            }
        });
        mBtnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                mSongPresenter.playAndPause();
                if(mSongPresenter.playAndPause())
                    mBtnPlay.setBackgroundResource(R.drawable.play);
                else mBtnPlay.setBackgroundResource(R.drawable.pause);
            }
        });
    }

    private void initView(android.view.View view) {
        mRecyclerView = view.findViewById(R.id.recycle_song);
        mTxtSong = view.findViewById(R.id.txt_song);
        mTxtArtist = view.findViewById(R.id.txt_artist);
        mImgSong = view.findViewById(R.id.img_song);
        mGroup = (Group) view.findViewById(R.id.group2);
        mBtnNext = view.findViewById(R.id.btn_next);
        mBtnPrevious = view.findViewById(R.id.btn_previous);
        mBtnPlay = view.findViewById(R.id.btn_play);
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_song;
    }

    @Override
    public void showData() {
        mPaths = mPresenter.getPath();
        mSongs = mPresenter.getData(mPaths);
        SongAdapter mSongAdapter = new SongAdapter(getActivity(), mSongs, new ItemClickListener() {
            @Override
            public void onClick(android.view.View view, int position) {
                mPosition = position;
                setPlay();
                ((View) mGroup).setVisibility(View.VISIBLE);
            }
        });
        RecyclerView.LayoutManager layoutManager =
                new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(mSongAdapter);
    }

    public void setPlay() {
        mTxtSong.setText(mSongs.get(mPosition).getSong());
        mTxtArtist.setText(mSongs.get(mPosition).getArtist());
        MediaMetadataRetriever mmr = new MediaMetadataRetriever();
        mmr.setDataSource(mSongs.get(mPosition).getPath());
        byte[] bm = mmr.getEmbeddedPicture();
        if (bm != null) {
            mImage = BitmapFactory.decodeByteArray(bm, 0, bm.length);
            mImgSong.setImageBitmap(mImage);
        } else {
            mImgSong.setImageResource(R.drawable.album);
        }
        mSongPresenter.playMusic(mPresenter.getPath().get(mPosition));
        Intent myIntent = new Intent(getActivity(), PlaySongService.class);
        getActivity().startService(myIntent);
    }

}
