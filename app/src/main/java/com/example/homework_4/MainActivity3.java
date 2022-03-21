package com.example.homework_4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

public class MainActivity3 extends AppCompatActivity {
WebView WebView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        WebView = findViewById(R.id.wb1);
        WebView.loadUrl("https://www.google.com/");
    }
}