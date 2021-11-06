package com.khacngoc.zingmp3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button chonbai;
    Button play;
    Button pause;
    TextView nghenhac;
    ArrayList<song> arraysong;
    int posittion = 0;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addSong();
        chonbai = (Button) findViewById(R.id.chonbai);
        play = (Button) findViewById(R.id.play);
        pause = (Button) findViewById(R.id.pause);
        chonbai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, song.class);
                startActivity(intent);
            }
        });
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer = MediaPlayer.create(MainActivity.this, arraysong.get(posittion).getFile());
                mediaPlayer.start();
                
            }
        });
        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mediaPlayer.isPlaying())
                {
                    mediaPlayer.pause();
                }

            }
        });


    }
    private void addSong ()
    {
        arraysong = new ArrayList<>();
        arraysong.add(new song("1", R.raw.a));
        arraysong.add(new song("2", R.raw.b));
        arraysong.add(new song("3", R.raw.c));
        arraysong.add(new song("4", R.raw.d));
        arraysong.add(new song("5", R.raw.e));
        arraysong.add(new song("6", R.raw.f));

    }
}