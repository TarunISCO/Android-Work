package com.example.android.musicappstructure;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class PaymentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        LinearLayout songsLayout = (LinearLayout) findViewById(R.id.songs_tab_holder);
        songsLayout.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent albumIntent = new Intent(PaymentActivity.this, MainActivity.class);
                startActivity(albumIntent);
            }
        });

        LinearLayout artistLayout = (LinearLayout) findViewById(R.id.artist_tab_holder);
        artistLayout.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent artistIntent = new Intent(PaymentActivity.this, ArtistActivity.class);
                startActivity(artistIntent);
            }
        });

        LinearLayout albumLayout = (LinearLayout) findViewById(R.id.album_tab_holder);
        albumLayout.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent playlistIntent = new Intent(PaymentActivity.this, AlbumActivity.class);
                startActivity(playlistIntent);
            }
        });

        LinearLayout playlistLayout = (LinearLayout) findViewById(R.id.playlist_tab_holder);
        playlistLayout.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent playlistIntent = new Intent(PaymentActivity.this, PlaylistActivity.class);
                startActivity(playlistIntent);
            }
        });
    }
}
