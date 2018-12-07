package com.example.anh.mp3play.screen.base;

import android.app.Service;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.IBinder;

import java.io.IOException;

public class PlaySongService extends Service implements MediaPlayer.OnCompletionListener{
    public static final int PLAYER_IDLE = -1;
    public static final int PLAYER_PLAY = 1;
    public static final int PLAYER_PAUSE = 2;
    private MediaPlayer mediaPlayer;
    private int state;
    private String path;
    private OnCompletionListener onCompletionListener;

    public PlaySongService(String path, int State) {
        this.path = path;
        this.state = State;
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        // Tạo đối tượng MediaPlayer, chơi file nhạc của bạn.
        try {
            state = PLAYER_IDLE;
            mediaPlayer = new MediaPlayer();
            mediaPlayer.setDataSource(path);
            mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
            mediaPlayer.prepare();
            mediaPlayer.setOnCompletionListener(this);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (state == PLAYER_IDLE || state == PLAYER_PAUSE){
            state = PLAYER_PLAY;
            mediaPlayer.start();
        }
        if (state == PLAYER_PLAY || state == PLAYER_PAUSE){
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
        }
        if (state == PLAYER_PLAY){
            mediaPlayer.pause();
            state = PLAYER_PAUSE;
        }
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        // Giai phong nguon du lieu phat nhac
        mediaPlayer.release();
        super.onDestroy();
    }

    @Override
    public void onCompletion(MediaPlayer mediaPlayer) {
        onCompletionListener.onEndMusic();
    }
    public interface OnCompletionListener{
        void onEndMusic();
    }
    public void setOnCompletionListener(OnCompletionListener onCompletionListener){
        this.onCompletionListener = onCompletionListener;
    }
}
