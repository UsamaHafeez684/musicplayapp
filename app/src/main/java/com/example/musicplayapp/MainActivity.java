package com.example.musicplayapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btnplay(View view) {
        if (mediaPlayer==null){
            mediaPlayer= MediaPlayer.create(this,R.raw.des);

            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    stopplayer();
                }
            });
        }
        mediaPlayer.start();
    }

    public void btnpause(View view) {
        if(mediaPlayer!=null){
            mediaPlayer.pause();
        }
    }

    public void btnstop(View view) {
        stopplayer();

    }

    private void stopplayer(){
        if (mediaPlayer!=null){
            mediaPlayer.release();
            mediaPlayer=null;
            Toast.makeText(this, "jawad got fucked", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        stopplayer();
    }
}
