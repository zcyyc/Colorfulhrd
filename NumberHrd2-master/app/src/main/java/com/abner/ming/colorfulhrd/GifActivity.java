package com.abner.ming.colorfulhrd;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class GifActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_gif);
    }
}
