package com.example.user_pc.films;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {
 // MediaPlayer mPlayer;
  // Button button9,button10;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
/*
       mPlayer=MediaPlayer.create(this, R.raw.alabama);
        mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {*/
       /* public void onCompletion(/*MediaPlayer mp*/
               // stopPlay();

        }
      /*  button9 = findViewById(R.id.button9);
        button10 = findViewById(R.id.button10);
        button10.setEnabled(false);*/
    /* private void stopPlay(){
        mPlayer.stop();
        button10.setEnabled(false);
        try {
            mPlayer.prepare();
            mPlayer.seekTo(0);
            button9.setEnabled(true);
        }
        catch (Throwable t) {
            Toast.makeText(this, t.getMessage(), Toast.LENGTH_SHORT).show();
        }


    }
/*
    public void OnClick(View view){

       /* mPlayer.start();
        button9.setEnabled(false);
        button10.setEnabled(true);
    }
    public void stop(View view){
        stopPlay();
    } @Override
    public void onDestroy() {
        super.onDestroy();
        if (mPlayer.isPlaying()) {
            stopPlay();
        }
    }*/
        public void Continue (View view){
            Intent intent = new Intent(MainActivity.this, CentralActivity.class);
            startActivity(intent);

        }
    }

