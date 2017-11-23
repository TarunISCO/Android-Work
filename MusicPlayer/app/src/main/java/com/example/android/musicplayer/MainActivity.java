package com.example.android.musicplayer;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button playbutton = (Button) findViewById(R.id.playButton);
        Button pausebutton = (Button) findViewById(R.id.pauseButton);
        Button stopbutton = (Button) findViewById(R.id.stopButton);
        final MediaPlayer mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.shakirawakawaka);


        playbutton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        Toast.makeText(MainActivity.this, "Audio Over", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        pausebutton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                mediaPlayer.pause();
            }
        });

        stopbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.stop();
            }
        });

    }


}
