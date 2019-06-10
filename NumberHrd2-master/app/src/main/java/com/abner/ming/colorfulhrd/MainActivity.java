package com.abner.ming.colorfulhrd;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu)
//    {
//        MenuInflater menuInflater=getMenuInflater();
//        menuInflater.inflate(R.menu.main,menu);
//        return super.onCreateOptionsMenu(menu);
//    }

    private long firstTime = 0;

    @Override
    public void onBackPressed()
    {
        Toast.makeText(MainActivity.this,"再按一次退出程序",Toast.LENGTH_SHORT).show();
        long secondTime=System.currentTimeMillis();
        if(secondTime-firstTime>8000){
            firstTime=secondTime;
        }else{
            finish();
        }

    }

    public void begin_game(View view) {
        Intent intent = new Intent(this,Main2Activity.class);
        startActivity(intent);
    }
}
