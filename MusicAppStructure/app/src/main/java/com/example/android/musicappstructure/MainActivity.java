package com.example.android.musicappstructure;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import static android.R.interpolator.linear;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView downloadTextView = (TextView) findViewById(R.id.downloadButton);
        downloadTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent downloadIntent = new Intent(MainActivity.this, PaymentActivity.class);
                startActivity(downloadIntent);
            }
        });

        LinearLayout albumLayout = (LinearLayout) findViewById(R.id.album_tab_holder);
        albumLayout.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent albumIntent = new Intent(MainActivity.this, AlbumActivity.class);
                startActivity(albumIntent);
            }
        });

        LinearLayout artistLayout = (LinearLayout) findViewById(R.id.artist_tab_holder);
        artistLayout.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent artistIntent = new Intent(MainActivity.this, ArtistActivity.class);
                startActivity(artistIntent);
            }
        });

        LinearLayout playlistLayout = (LinearLayout) findViewById(R.id.playlist_tab_holder);
        playlistLayout.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent playlistIntent = new Intent(MainActivity.this, PlaylistActivity.class);
                startActivity(playlistIntent);
            }
        });

        LinearLayout currentPlaying = (LinearLayout) findViewById(R.id.CurrentSongHolder);
        currentPlaying.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent currentPlayingIntent = new Intent(MainActivity.this, NowPlaying.class);
                startActivity(currentPlayingIntent);
            }
        });
    }

}
