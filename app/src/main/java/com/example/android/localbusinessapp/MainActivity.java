package com.example.android.localbusinessapp;

import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Drawable background = ContextCompat.getDrawable(this, R.drawable.background);
      background.setAlpha(150);
        setContentView(R.layout.activity_main);
    }
}
