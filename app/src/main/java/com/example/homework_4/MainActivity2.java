package com.example.homework_4;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.Dialog;
import android.content.ClipData;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
TextView txt,txt1,txt2,txt3,txt4;
MediaPlayer mp;
Button calbtn;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        txt = findViewById(R.id.textView2);
        txt1 = findViewById(R.id.textView3);
        txt2 = findViewById(R.id.textView4);
        txt3 = findViewById(R.id.textView5);
        txt4 = findViewById(R.id.textView9);
        calbtn = findViewById(R.id.button8);
        mp = MediaPlayer.create(this,R.raw.nas);



        String s1 = getIntent().getStringExtra("date");
        String s2 = getIntent().getStringExtra("time");
        String s3 = getIntent().getStringExtra("name");
        String s4 = getIntent().getStringExtra("number");
        String s5 = getIntent().getStringExtra("spinner");
       // String s1 = getIntent().getStringExtra("date");

        txt.setText(s1);
        txt1.setText(s2);
        txt2.setText(s3);
        txt3.setText(s4);
        txt4.setText(s5);

        calbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent calin = new Intent(Intent.ACTION_DIAL);
                calin.setData(Uri.parse("tel:" + txt3));
                startActivity(calin);
            }
        });

    }


    public void exitBtn(MenuItem item) {
     moveTaskToBack(true);
     android.os.Process.killProcess(android.os.Process.myPid());
     System.exit(1);
    }

    public void confirmBtn(View view) {
        Dialog dgg = new Dialog(MainActivity2.this);
        dgg.setContentView(R.layout.confrim);
        dgg.show();
    }

    public void searchBtn(MenuItem item) {
        startActivity(new Intent(MainActivity2.this,MainActivity3.class));
    }

    public void ply(View view) {
        mp.start();
    }

    public void pas(View view) {
        mp.pause();
    }

    public void stp(View view) {
        mp.stop();
    }
}