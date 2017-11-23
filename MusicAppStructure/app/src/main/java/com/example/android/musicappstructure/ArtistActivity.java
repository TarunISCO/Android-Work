package com.example.android.musicappstructure;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class ArtistActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artist);

        LinearLayout songsLayout = (LinearLayout) findViewById(R.id.songs_tab_holder);
        songsLayout.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent albumIntent = new Intent(ArtistActivity.this, MainActivity.class);
                startActivity(albumIntent);
            }
        });

        LinearLayout albumLayout = (LinearLayout) findViewById(R.id.album_tab_holder);
        albumLayout.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent artistIntent = new Intent(ArtistActivity.this, AlbumActivity.class);
                startActivity(artistIntent);
            }
        });

        LinearLayout playlistLayout = (LinearLayout) findViewById(R.id.playlist_tab_holder);
        playlistLayout.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent playlistIntent = new Intent(ArtistActivity.this, PlaylistActivity.class);
                startActivity(playlistIntent);
            }
        });

        LinearLayout currentPlaying = (LinearLayout) findViewById(R.id.CurrentSongHolder);
        currentPlaying.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent currentPlayingIntent = new Intent(ArtistActivity.this, NowPlaying.class);
                startActivity(currentPlayingIntent);
            }
        });
    }
}
