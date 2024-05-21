package com.tesji.quizzdragonball;

import android.content.Context;
import android.media.MediaPlayer;

public class AudioPlayer {
    private static AudioPlayer instance;
    private MediaPlayer mediaPlayer;

    private AudioPlayer(Context context) {
        mediaPlayer = MediaPlayer.create(context, R.raw.soundfondo);
        mediaPlayer.setLooping(true);
    }

    public static synchronized AudioPlayer getInstance(Context context) {
        if (instance == null) {
            instance = new AudioPlayer(context.getApplicationContext());
        }
        return instance;
    }

    public void start() {
        if (!mediaPlayer.isPlaying()) {
            mediaPlayer.start();
        }
    }

    public void stop() {
        if (mediaPlayer.isPlaying()) {
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
            instance = null;
        }
    }
}

