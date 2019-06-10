package com.abner.ming.colorfulhrd;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.tapadoo.alerter.Alert;
import com.tapadoo.alerter.Alerter;
import com.tapadoo.alerter.OnHideAlertListener;

public class Main5Activity extends AppCompatActivity implements View.OnClickListener {
    public static boolean isStart = false;
    public static boolean isPlay = false;
    private boolean isClick_Start = true;
    private boolean isClick_play = true;
    private Button mBtnStart;
    private Button mBtnRestart;
    private Button mChooseLevel;

    private TextView mTvTime, mTvHistory, mTvNum;
    private NumberHrdView3 mNumberHrdView;
    private RelativeLayout mLayout;
    private MediaPlayer mp=new MediaPlayer();
    private Button play;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main5);

        mBtnStart = (Button) findViewById(R.id.btn_start3);
        mBtnRestart = (Button) findViewById(R.id.btn_restart3);
        mChooseLevel = (Button) findViewById(R.id.btn_choose);

        mTvTime = (TextView) findViewById(R.id.tv_time);
        mNumberHrdView = (NumberHrdView3) findViewById(R.id.numberhrdview3);
        mLayout = (RelativeLayout) findViewById(R.id.layout_success);
        mTvNum = (TextView) findViewById(R.id.tv_num);
        play=(Button) findViewById(R.id.play_music);

        mBtnStart.setOnClickListener(this);
        mBtnRestart.setOnClickListener(this);
        mChooseLevel.setOnClickListener(this);
        play.setOnClickListener(this);

        mp =MediaPlayer.create(this, R.raw.lazyday);


        mNumberHrdView.setOnSuccess(new NumberHrdView3.OnSuccessListener() {
            @Override
            public void success() {
                AlertDialog.Builder myAlertBuilder = new AlertDialog.Builder(Main5Activity.this);
                myAlertBuilder.setTitle("Alert");
                myAlertBuilder.setMessage("恭喜你呀，成功啦！！！");

                myAlertBuilder.setPositiveButton("下一关", new
                        DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // User clicked OK button.
                                if(mp!=null)
                                {
                                    mp.stop();
                                    mp.release();
                                }
                                Intent intent = new Intent(Main5Activity.this, Main5Activity.class);
                                startActivity(intent);
                            }
                        });
                myAlertBuilder.setNegativeButton("取消", new
                        DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // User cancelled the dialog.
                                Toast.makeText(getApplicationContext(), "Pressed Cancel",
                                        Toast.LENGTH_SHORT).show();
                            }
                        });
                myAlertBuilder.show();


                mLayout.setVisibility(View.VISIBLE);
                SharedPreUtils.put(Main5Activity.this, "abnerType", "");
                String scale = SharedPreUtils.getString(Main5Activity.this, "scale");
                if (TextUtils.isEmpty(scale)) {
                    SharedPreUtils.put(Main5Activity.this, "scale", "" + lastTime);
                } else {
                    if (Integer.parseInt(scale) > lastTime) {
                        SharedPreUtils.put(Main5Activity.this, "scale", "" + lastTime);
                    }
                }
                //成功了，保存记录
                createHistory();
                createNumber();
                mHandler.sendEmptyMessageDelayed(2000, 3000);
            }

            @Override
            public void toast() {
                toastMsg("请点击开始键后再滑动");
            }
        });

    }

    private boolean alertShow = true;

    @Override
    public void onBackPressed() {
        if(mp!=null)
        {
            mp.stop();
            mp.release();
        }
        Intent intent = new Intent(this, Main2Activity.class);
        startActivity(intent);
    }

    private void toastMsg(String message) {
        if (alertShow) {
            Log.i("111111111", "触发了该toast");
            alertShow = false;
            Alert mAlerter = Alerter.create(Main5Activity.this).
                    setText(message).
                    setDuration(2000).
                    setBackgroundColor(R.color.colorAccent).
                    show();
            mAlerter.setOnHideListener(new OnHideAlertListener() {
                @Override
                public void onHide() {
                    alertShow = true;
                    Log.i("setOnHideListener", "hint");
                }
            });
        }
    }

    private int clickNum = 1;

    @SuppressLint("WrongCall")
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.play_music:
                if(isClick_play)
                {
                    mp.start();
                    Log.i("123123","点击播放时"+mp.toString());
                    play.setText("停止");
                    Main3Activity.isPlay=true;
                    isClick_play = false;
                }else{
                    mp.pause();
//                    mp.release();
                    Log.i("123123","点击暂停时"+mp.toString());
                    play.setText("播放");
                    Main3Activity.isPlay=false;
                    isClick_play = true;
                }
                break;
            case R.id.btn_start3://开始
                if (isClick_Start) {
                    Log.i("111111111111", "Main5已经点击了开始");
                    mBtnStart.setText("");
                    mBtnStart.setBackgroundResource(R.drawable.pause);
                    mHandler.sendEmptyMessage(1000);
                    Main5Activity.isStart = true;
                    isClick_Start = false;
                } else {
                    mBtnStart.setText("");
                    mBtnStart.setBackgroundResource(R.drawable.begin_g);
                    mHandler.removeMessages(1000);
                    Main5Activity.isStart = false;
                    isClick_Start = true;
                }
                break;

            case R.id.btn_restart3:
                if(mp!=null)
                {
                    mp.stop();
                    mp.release();
                }
                Main5Activity.isStart = false;
                isClick_Start = true;
                mBtnStart.setText("");
                mBtnStart.setBackgroundResource(R.drawable.begin_g);
                mHandler.removeMessages(1000);
                mTvTime.setText("00:00");
                timeNum = 0;
                mTvNum.setText("峰回路转");
                Intent intent = new Intent(this, Main5Activity.class);
                startActivity(intent);

                break;

            case R.id.btn_choose:
                if(mp!=null)
                {
                    mp.stop();
                    mp.release();
                }
                Intent intent2 = new Intent(this, Main2Activity.class);
                startActivity(intent2);
                break;

        }

    }

    private void createHistory(){
        try {
            String history=SharedPreUtils.getString(Main5Activity.this,"scale");
            if(!TextUtils.isEmpty(history)){
                Data.setC(getTime(Integer.parseInt(history)));
                Log.i("1212121",getTime(Integer.parseInt(history)));
            }
        }catch (Exception e){

        }

    }


    /**
     * 点重置后，初始化
     */
    private void createNumber() {
        Main5Activity.isStart = false;
        isClick_Start = true;
        mBtnStart.setText("");
        mBtnStart.setBackgroundResource(R.drawable.begin_g);
        mHandler.removeMessages(1000);
        mTvTime.setText("00:00");
        timeNum = 0;
        mTvNum.setText("峰回路转");
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (!isClick_Start) {
            mHandler.removeMessages(1000);
            mHandler.sendEmptyMessage(1000);
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        mHandler.removeMessages(1000);
    }

    private int timeNum = 0;
    private int lastTime;
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 1000:
                    timeNum = timeNum + 1;
                    String time = getTime();
                    lastTime = timeNum;
                    mTvTime.setText(time);
                    mHandler.sendEmptyMessageDelayed(1000, 1000);
                    break;
                case 2000:
                    mLayout.setVisibility(View.GONE);
                    break;
            }

        }
    };

    private String getTime() {
        String time = "当前用时：00:0" + timeNum;
        if (timeNum <= 9) {
            time = "00:0" + timeNum;
        } else if (timeNum > 9 && timeNum < 60) {
            time = "00:" + timeNum;
        } else {
            int mm = timeNum / 60;
            int ss = timeNum % 60;
            String s = ss + "";
            s = s.length() > 1 ? s : "0" + s;
            if (mm < 10) {
                time = "0" + mm + ":" + s;
            } else {
                time = "" + mm + ":" + s;
            }
        }
        return time;
    }

    private String getTime(int num) {
        String time = "";
        if (num <= 9) {
            time = "00:0" + num;
        } else if (num > 9 && num < 60) {
            time = "00:" + num;
        } else {
            int mm = num / 60;
            int ss = num % 60;
            String s = ss + "";
            s = s.length() > 1 ? s : "0" + s;
            if (mm < 10) {
                time = "0" + mm + ":" + s;
            } else {
                time = "" + mm + ":" + s;
            }
        }
        return time;
    }


}
