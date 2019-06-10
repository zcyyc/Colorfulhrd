package com.abner.ming.colorfulhrd;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Rank extends AppCompatActivity {
    private TextView mTvHistory1,mTvHistory2,mTvHistory3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_rank);

        mTvHistory1 = (TextView)findViewById(R.id.tv_history_jiang);
        mTvHistory1.setText("在将拥曹营中，您的最佳成绩为："+Data.getA());

        mTvHistory2 = (TextView)findViewById(R.id.tv_history_heng);
        mTvHistory2.setText("在横刀立马中，您的最佳成绩为："+Data.getB());

        mTvHistory3 = (TextView)findViewById(R.id.tv_history_feng);
        mTvHistory3.setText("在峰回路转中，您的最佳成绩为："+Data.getC());


    }


    public void clear(View view) {
        Data.setA("");
        Data.setB("");
        Data.setC("");
    }
}
