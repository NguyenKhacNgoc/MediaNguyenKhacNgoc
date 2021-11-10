package com.khacngoc.zingmp3;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private TextView tvTenBai, tvBaiSo, tvThoiGian;
    private Button btnPlay, btnPause, btnChonBai;
    private ArrayList<Song> arraySong;
    int position = 0;
    MediaPlayer mediaPlayer;
    private ActivityResultLauncher<Intent> activityResultLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if(result.getResultCode() == RESULT_OK) {
                        Intent intent = result.getData();
                        position = intent.getIntExtra("Position",0);
                        if(mediaPlayer.isPlaying()){
                            mediaPlayer.stop();
                        }
                        khoiTaoMedia();
                        mediaPlayer.start();
                    }
                }
            });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Trình nghe nhạc");

        getView();
        addSong();
        khoiTaoMedia();
        play();
        pause();
        chonBai();


    }
    private void setTime(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("mm:ss");
        tvThoiGian.setText(simpleDateFormat.format(mediaPlayer.getDuration()));
    }
    private void chonBai() {
        btnChonBai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Activity_2.class);
                activityResultLauncher.launch(intent);
            }
        });
    }

    private void pause() {
        btnPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.stop();
            }
        });
    }

    private void play(){
        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.start();
                setTime();
            }
        });

    }

    private void khoiTaoMedia(){
        mediaPlayer = MediaPlayer.create(MainActivity.this, arraySong.get(position).getFile());
        tvTenBai.setText(arraySong.get(position).getTitle());
        tvBaiSo.setText("Bai " + (position + 1));
    }
    private void addSong() {
        arraySong = new ArrayList<>();
        arraySong.add(new Song("Ái nộ", R.raw.a));
        arraySong.add(new Song("Cưới thôi", R.raw.b));
        arraySong.add(new Song("Dịu dàng em đến", R.raw.c));
        arraySong.add(new Song("Độ tộc", R.raw.d));
        arraySong.add(new Song("Phải chăng em đã yêu", R.raw.e));
        arraySong.add(new Song("Thức giấc", R.raw.f));

    }

    private void getView(){
        tvTenBai = (TextView) findViewById(R.id.tvTenBai);
        tvBaiSo = (TextView) findViewById(R.id.tvBaiSo);
        btnChonBai = (Button) findViewById(R.id.btnChon);
        btnPlay = (Button) findViewById(R.id.btnPlay);
        btnPause = (Button) findViewById(R.id.btnPause);
        tvThoiGian = (TextView) findViewById(R.id.tvThoiGian);
    }
}
