package com.example.anh.mp3play.screen.home.song;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaMetadataRetriever;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.anh.mp3play.R;
import com.example.anh.mp3play.data.model.Song;
import com.example.anh.mp3play.screen.home.ItemClickListener;

import java.security.acl.Group;
import java.util.List;

public class SongAdapter extends RecyclerView.Adapter<SongAdapter.ViewHolder> {
    private Context mContext;
    private List<Song> mSongs;
    private ItemClickListener mListener;

    public SongAdapter(Context context, List<Song> songs, ItemClickListener listener) {
        mContext = context;
        mSongs = songs;
        mListener = listener;
    }

    @NonNull
    @Override
    public SongAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_song,viewGroup,false);
        final ViewHolder vhs = new ViewHolder(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.onClick(view,vhs.getPosition());
            }
        });
        return vhs;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public void onBindViewHolder(@NonNull final SongAdapter.ViewHolder viewHolder, int i) {
        Song song = mSongs.get(i);
        viewHolder.mTextItemSong.setText(song.getSong());
        viewHolder.mTextItemArtist.setText(song.getArtist());
//        Glide.with(mContext).load(song.getPath()).into(viewHolder.mImageSong);
        MediaMetadataRetriever mmr = new MediaMetadataRetriever();
        mmr.setDataSource(song.getPath());
        byte []bm = mmr.getEmbeddedPicture();
        if (bm != null){
            Bitmap hinh = BitmapFactory.decodeByteArray(bm, 0, bm.length);
            viewHolder.mImageItemSong.setImageBitmap(hinh);
        }

    }

    @Override
    public int getItemCount() {
        return mSongs!=null?mSongs.size():0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView mTextItemSong;
        private TextView mTextItemArtist;
        private ImageView mImageItemSong;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mTextItemSong = itemView.findViewById(R.id.text_item_song);
            mTextItemArtist = itemView.findViewById(R.id.text_item_artist);
            mImageItemSong = itemView.findViewById(R.id.image_item_song);
        }
    }
}
