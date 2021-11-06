package com.khacngoc.zingmp3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class song extends AppCompatActivity {
    private String Title;
    private int File;
    Button bai1;
    Button bai2;
    Button bai3;
    Button bai4;
    Button bai5;
    Button bai6;

    public void setTitle(String title) {
        Title = title;
    }

    public int getFile() {
        return File;
    }

    public void setFile(int file) {
        File = file;
    }

    public song(String title, int file) {
        Title = title;
        File = file;

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        bai1 = (Button) findViewById(R.id.bai1);
        bai2 = (Button) findViewById(R.id.bai2);
        bai3 = (Button) findViewById(R.id.bai3);
        bai4 = (Button) findViewById(R.id.bai4);
        bai5 = (Button) findViewById(R.id.bai5);
        bai6 = (Button) findViewById(R.id.bai6);
        bai1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent b1 = new Intent(song.this, MainActivity.class);
                startActivity(b1);
            }
        });
    }

}
