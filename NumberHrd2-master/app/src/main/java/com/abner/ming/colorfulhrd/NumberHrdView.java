package com.abner.ming.colorfulhrd;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;


class Square {

    int x_0 = 0;
    int x_1 = 0;
    int y_0 = 0;
    int y_1 = 0;
    String color = "";

    Square() {
        this.x_0 = 0;
        this.x_1 = 0;
        this.y_0 = 0;
        this.y_1 = 0;
        this.color = "";
    }
}

public class NumberHrdView extends View {

    Square[] my_Square = new Square[15];
    public Button mBtnRestart;


    public int floatX_8, floatY_10, floatX, floatY;

    public NumberHrdView(Context context) {
        super(context);
        initView(context);
    }

    public NumberHrdView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public NumberHrdView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    public void initView(Context context) {
        setBackgroundColor(Color.parseColor("#222222"));
        iniPaint();
    }

    /**
     * 初始化画笔，共10个格子
     */
    public Paint mPaintRect, mPaintText;
    public Paint[] mPaint;

    public void iniPaint() {
        mPaint = new Paint[13];

        mPaintRect = new Paint();
        mPaintRect.setAntiAlias(true);
        mPaintRect.setColor(Color.WHITE);
        mPaintRect.setStrokeWidth(2);
        mPaintRect.setStyle(Paint.Style.STROKE);

        mPaintText = new Paint();
        mPaintText.setAntiAlias(true);
        mPaintText.setColor(Color.WHITE);
        mPaintText.setStrokeWidth(2);
        mPaintText.setStyle(Paint.Style.FILL);
        mPaintText.setTextSize(36);

        for (int i = 0; i <= 12; i++) {
            mPaint[i] = new Paint();
            createPaint(mPaint[i]);
        }

    }

    public void createPaint(Paint paint) {
        paint.setAntiAlias(true);
        paint.setStrokeWidth(2);
        paint.setStyle(Paint.Style.FILL);
    }

    public Canvas canvas;

    @Override
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.canvas = canvas;
        onDrawRect();
        onRectLine();
    }

    public int textMargin = 10;

    public void onRectLine() {
        mrect = new Rect[13];
        for (int i = 1; i <= 12; i++) {
            mrect[i] = new Rect(0, 0, mWidth, mHeight);
        }
        for (int i = 1; i <= 10; i++) {
            mrect[i] = new Rect(my_Square[i].x_0, my_Square[i].y_0, my_Square[i].x_1, my_Square[i].y_1);
            my_Square[i].color = numbercolor[i - 1];
            mPaint[i].setColor(Color.parseColor(numbercolor[i - 1]));
            canvas.drawRect(mrect[i], mPaint[i]);
            //Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.caocao);
            //canvas.drawText(number[0], my_Square[1].x_t - textMargin, my_Square[1].y_t + textMargin, mPaintText);
            //canvas.drawBitmap(bitmap,0,my_Square[1].y_0,mPaint[1]);
        }
        for (int i = 11; i < 13; i++) {
            mrect[i] = new Rect(my_Square[i].x_0, my_Square[i].y_0, my_Square[i].x_1, my_Square[i].y_1);
//            my_Square[i].color = numbercolor[10];
//            mPaint[i].setColor(Color.parseColor(numbercolor[10]));
//            canvas.drawRect(mrect[i], mPaint[i]);
        }
    }

    public Rect[] mrect;

    public void onDrawRect() {
        Rect rect = new Rect(0, 0, mWidth, mHeight);
        canvas.drawRect(rect, mPaintRect);
        int floatX = mWidth / 4;
        int floatY = mHeight / 5;
        for (int a = 1; a <= 5; a++) {
            int y = floatY * a;
            canvas.drawLine(0, y, mWidth, y, mPaintRect);
        }
        for (int a = 1; a <= 4; a++) {
            int x = floatX * a;
            if (a == 2) {
                canvas.drawLine(x, 0, x, floatY * 4, mPaintRect);
                break;
            }
            canvas.drawLine(x, 0, x, mHeight, mPaintRect);
        }

    }

    public int mWidth, mHeight;

    @Override
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        for (int i = 0; i <= 12; i++) {
            my_Square[i] = new Square();
        }

        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(widthMeasureSpec, heightMeasureSpec);
        mWidth = getMeasuredWidth();
        mHeight = getMeasuredHeight();
        floatX_8 = mWidth / 8;
        floatY_10 = mHeight / 10;
        floatX = mWidth / 4;
        floatY = mHeight / 5;

        createView_1();
        createView_2();
        createView_3();
        createView_4();
        createView_5();
        createView_6();
        createView_7();
        createView_8();
        createView_9();
        createView_10();
        createView_11(floatX, floatX * 2, floatY * 4, mHeight);
        createView_12(floatX * 2, floatX * 3, floatY * 4, mHeight);

    }

    /**
     * 每次移动格子，记录空白格子的位置
     */
    public void createView_12(int num1, int num2, int num3, int num4) {
        Log.i("createView_12", num1 + "===" + num2 + "===" + num3 + "===" + num4);
        my_Square[12].x_0 = num1;
        my_Square[12].x_1 = num2;
        my_Square[12].y_0 = num3;
        my_Square[12].y_1 = num4;
    }

    public void createView_11(int num1, int num2, int num3, int num4) {
        Log.i("createView_11", num1 + "===" + num2 + "===" + num3 + "===" + num4);
        my_Square[11].x_0 = num1;
        my_Square[11].x_1 = num2;
        my_Square[11].y_0 = num3;
        my_Square[11].y_1 = num4;
    }

    //每个格子的位置
    public void createView_1() {
        my_Square[1].x_0 = 0;
        my_Square[1].x_1 = floatX;
        my_Square[1].y_0 = 0;
        my_Square[1].y_1 = floatY * 2;

    }

    public void createView_2() {
        my_Square[2].x_0 = floatX;
        my_Square[2].x_1 = floatX * 3;
        my_Square[2].y_0 = 0;
        my_Square[2].y_1 = floatY * 2;

    }

    public void createView_3() {
        my_Square[3].x_0 = floatX * 3;
        my_Square[3].x_1 = mWidth;
        my_Square[3].y_0 = 0;
        my_Square[3].y_1 = floatY * 2;
    }

    public void createView_4() {
        my_Square[4].x_0 = 0;
        my_Square[4].x_1 = floatX;
        my_Square[4].y_0 = floatY * 2;
        my_Square[4].y_1 = floatY * 4;
    }

    public void createView_5() {
        my_Square[5].x_0 = floatX;
        my_Square[5].x_1 = floatX * 3;
        my_Square[5].y_0 = floatY * 2;
        my_Square[5].y_1 = floatY * 3;
    }

    public void createView_6() {
        my_Square[6].x_0 = floatX * 3;
        my_Square[6].x_1 = mWidth;
        my_Square[6].y_0 = floatY * 2;
        my_Square[6].y_1 = floatY * 4;
    }

    public void createView_7() {
        my_Square[7].x_0 = floatX;
        my_Square[7].x_1 = floatX * 2;
        my_Square[7].y_0 = floatY * 3;
        my_Square[7].y_1 = floatY * 4;
    }

    public void createView_8() {
        my_Square[8].x_0 = floatX * 2;
        my_Square[8].x_1 = floatX * 3;
        my_Square[8].y_0 = floatY * 3;
        my_Square[8].y_1 = floatY * 4;
    }

    public void createView_9() {
        my_Square[9].x_0 = 0;
        my_Square[9].x_1 = floatX;
        my_Square[9].y_0 = floatY * 4;
        my_Square[9].y_1 = mHeight;
    }

    public void createView_10() {
        my_Square[10].x_0 = floatX * 3;
        my_Square[10].x_1 = mWidth - 0;
        my_Square[10].y_0 = floatY * 4;
        my_Square[10].y_1 = mHeight;
    }

    public String[] number = {"5", "2", "6", "7", "4", "1", "8", "3", "9", "10"};
    public String[] numbercolor = {"#9A32CD", "#1874CD", "#EE9A00", "#FFD700", "#00CD66", "#FF6347", "#f7edb7", "#48D1CC", "#BBFFFF", "#efa5be"};
    public int numberType = 1;


    public int startx, endx, starty, endy;

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                startx = (int) event.getX();
                starty = (int) event.getY();
                break;
            case MotionEvent.ACTION_UP:
                Log.i("123123", "进来了");
                endx = (int) event.getX();
                endy = (int) event.getY();
                if (Math.abs(endx - startx) > floatX + floatX / 2 || Math.abs(endy - starty) > floatY + floatY / 2) {
                    return true;
                }
                if (!Main3Activity.isStart) {
                    listener.toast();
                    return true;
                }
                int dx = endx - startx;
                int dy = endy - starty;

                for (int i = 0; i < 11; i++) {
                    //找到当前玩家移动的方块i
                    if (startx > my_Square[i].x_0 && startx < my_Square[i].x_1 && starty > my_Square[i].y_0 && starty < my_Square[i].y_1) {
                        Log.i("123123", "找到了i");
                        Square s = new Square();
                        /*向左右移动**/
                        if (Math.abs(dx) > floatX / 2 && Math.abs(dy) < floatY / 2) {
                            //向右移动
                            if (dx > 0) {
                                if (my_Square[i].x_1 == my_Square[11].x_0 && my_Square[i].y_0 == my_Square[11].y_0) {
                                    Log.i("123456", "右边挨着11号");
                                    if (my_Square[i].x_1 - my_Square[i].x_0 == floatX && my_Square[i].y_1 - my_Square[i].y_0 == floatY) {
                                        Log.i("123456", "if：x=1");
                                        s = my_Square[11];
                                        my_Square[11] = my_Square[i];
                                        my_Square[i] = s;
                                        break;
                                    } else if (my_Square[i].x_1 - my_Square[i].x_0 == floatX * 2 && my_Square[i].y_1 - my_Square[i].y_0 == floatY) //x=2，y=1
                                    {
                                        Log.i("123456", "else if：x=2, y=1");
                                        my_Square[11].x_0 = my_Square[11].x_0 - floatX * 2;
                                        my_Square[11].x_1 = my_Square[11].x_1 - floatX * 2;
                                        my_Square[i].x_0 = my_Square[i].x_0 + floatX;
                                        my_Square[i].x_1 = my_Square[i].x_1 + floatX;
                                    } else {
                                        Log.i("123456", "else");
                                        if (my_Square[11].x_1 == my_Square[12].x_1 && my_Square[11].y_1 == my_Square[12].y_0) {

                                            if (my_Square[i].x_1 - my_Square[i].x_0 == floatX)  //x=1，y=2
                                            {
                                                Log.i("123456", "else中的if：x=1, y=2");
                                                my_Square[i].x_0 = my_Square[i].x_0 + floatX;
                                                my_Square[i].x_1 = my_Square[i].x_1 + floatX;
                                                my_Square[11].x_0 = my_Square[11].x_0 - floatX;
                                                my_Square[11].x_1 = my_Square[11].x_1 - floatX;
                                                my_Square[12].x_0 = my_Square[12].x_0 - floatX;
                                                my_Square[12].x_1 = my_Square[12].x_1 - floatX;
                                            } else  //x=2，y=2
                                            {
                                                Log.i("123456", "else中的if：x=2, y=2");
                                                my_Square[i].x_0 = my_Square[i].x_0 + floatX;
                                                my_Square[i].x_1 = my_Square[i].x_1 + floatX;
                                                my_Square[11].x_0 = my_Square[11].x_0 - floatX * 2;
                                                my_Square[11].x_1 = my_Square[11].x_1 - floatX * 2;
                                                my_Square[12].x_0 = my_Square[12].x_0 - floatX * 2;
                                                my_Square[12].x_1 = my_Square[12].x_1 - floatX * 2;
                                            }
                                        }
                                    }


                                } else if (my_Square[i].x_1 == my_Square[12].x_0 && my_Square[i].y_0 == my_Square[12].y_0) {
                                    Log.i("123456", "右边挨着12号");
                                    if (my_Square[i].x_1 - my_Square[i].x_0 == floatX && my_Square[i].y_1 - my_Square[i].y_0 == floatY) {
                                        Log.i("123456", "if：x=1");
                                        s = my_Square[12];
                                        my_Square[12] = my_Square[i];
                                        my_Square[i] = s;
                                    } else if (my_Square[i].x_1 - my_Square[i].x_0 == floatX * 2 && my_Square[i].y_1 - my_Square[i].y_0 == floatY) //x=2，y=1
                                    {

                                        my_Square[12].x_0 = my_Square[12].x_0 - floatX * 2;
                                        my_Square[12].x_1 = my_Square[12].x_1 - floatX * 2;
                                        my_Square[i].x_0 = my_Square[i].x_0 + floatX;
                                        my_Square[i].x_1 = my_Square[i].x_1 + floatX;
                                    } else {
                                        if (my_Square[11].x_1 == my_Square[12].x_1 && my_Square[12].y_1 == my_Square[11].y_0) {
                                            if (my_Square[i].x_1 - my_Square[i].x_0 == floatX)  //x=1，y=2
                                            {
                                                my_Square[i].x_0 = my_Square[i].x_0 + floatX;
                                                my_Square[i].x_1 = my_Square[i].x_1 + floatX;
                                                my_Square[11].x_0 = my_Square[11].x_0 - floatX;
                                                my_Square[11].x_1 = my_Square[11].x_1 - floatX;
                                                my_Square[12].x_0 = my_Square[12].x_0 - floatX;
                                                my_Square[12].x_1 = my_Square[12].x_1 - floatX;
                                            } else  //x=2，y=2
                                            {
                                                my_Square[i].x_0 = my_Square[i].x_0 + floatX;
                                                my_Square[i].x_1 = my_Square[i].x_1 + floatX;
                                                my_Square[11].x_0 = my_Square[11].x_0 - floatX * 2;
                                                my_Square[11].x_1 = my_Square[11].x_1 - floatX * 2;
                                                my_Square[12].x_0 = my_Square[12].x_0 - floatX * 2;
                                                my_Square[12].x_1 = my_Square[12].x_1 - floatX * 2;
                                            }
                                        }
                                    }

                                }
                            }


                            //向左移动
                            else if (dx < 0) {
                                if (my_Square[i].x_0 == my_Square[11].x_1 && my_Square[i].y_0 == my_Square[11].y_0)  //左边是11号
                                {
                                    if (my_Square[i].x_1 - my_Square[i].x_0 == floatX && my_Square[i].y_1 - my_Square[i].y_0 == floatY) //x=1，y=1
                                    {
                                        s = my_Square[11];
                                        my_Square[11] = my_Square[i];
                                        my_Square[i] = s;
                                        break;
                                    } else if (my_Square[i].x_1 - my_Square[i].x_0 == floatX * 2 && my_Square[i].y_1 - my_Square[i].y_0 == floatY) //x=2，y=1
                                    {
                                        my_Square[11].x_0 = my_Square[11].x_0 + floatX * 2;
                                        my_Square[11].x_1 = my_Square[11].x_1 + floatX * 2;
                                        my_Square[i].x_0 = my_Square[i].x_0 - floatX;
                                        my_Square[i].x_1 = my_Square[i].x_1 - floatX;
                                    } else  //y=2的情况
                                    {
                                        if (my_Square[11].x_1 == my_Square[12].x_1 && my_Square[11].y_1 == my_Square[12].y_0) {
                                            if (my_Square[i].x_1 - my_Square[i].x_0 == floatX)  //x=1，y=2
                                            {
                                                my_Square[i].x_0 = my_Square[i].x_0 - floatX;
                                                my_Square[i].x_1 = my_Square[i].x_1 - floatX;
                                                my_Square[11].x_0 = my_Square[11].x_0 + floatX;
                                                my_Square[11].x_1 = my_Square[11].x_1 + floatX;
                                                my_Square[12].x_0 = my_Square[12].x_0 + floatX;
                                                my_Square[12].x_1 = my_Square[12].x_1 + floatX;
                                            } else  //x=2，y=2
                                            {
                                                my_Square[i].x_0 = my_Square[i].x_0 - floatX;
                                                my_Square[i].x_1 = my_Square[i].x_1 - floatX;
                                                my_Square[11].x_0 = my_Square[11].x_0 + floatX * 2;
                                                my_Square[11].x_1 = my_Square[11].x_1 + floatX * 2;
                                                my_Square[12].x_0 = my_Square[12].x_0 + floatX * 2;
                                                my_Square[12].x_1 = my_Square[12].x_1 + floatX * 2;
                                            }
                                        }
                                    }


                                } else if (my_Square[i].x_0 == my_Square[12].x_1 && my_Square[i].y_0 == my_Square[12].y_0) //左边是12号
                                {
                                    if (my_Square[i].x_1 - my_Square[i].x_0 == floatX && my_Square[i].y_1 - my_Square[i].y_0 == floatY) //x=1，y=1
                                    {
                                        s = my_Square[12];
                                        my_Square[12] = my_Square[i];
                                        my_Square[i] = s;
                                    } else if (my_Square[i].x_1 - my_Square[i].x_0 == floatX * 2 && my_Square[i].y_1 - my_Square[i].y_0 == floatY) //x=2，y=1
                                    {
                                        my_Square[12].x_0 = my_Square[12].x_0 + floatX * 2;
                                        my_Square[12].x_1 = my_Square[12].x_1 + floatX * 2;
                                        my_Square[i].x_0 = my_Square[i].x_0 - floatX;
                                        my_Square[i].x_1 = my_Square[i].x_1 - floatX;
                                    } else {
                                        if (my_Square[12].x_1 == my_Square[11].x_1 && my_Square[12].y_1 == my_Square[11].y_0) {
                                            if (my_Square[i].x_1 - my_Square[i].x_0 == floatX)  //x=1，y=2
                                            {
                                                my_Square[i].x_0 = my_Square[i].x_0 - floatX;
                                                my_Square[i].x_1 = my_Square[i].x_1 - floatX;
                                                my_Square[11].x_0 = my_Square[11].x_0 + floatX;
                                                my_Square[11].x_1 = my_Square[11].x_1 + floatX;
                                                my_Square[12].x_0 = my_Square[12].x_0 + floatX;
                                                my_Square[12].x_1 = my_Square[12].x_1 + floatX;
                                            } else  //x=2，y=2
                                            {
                                                my_Square[i].x_0 = my_Square[i].x_0 - floatX;
                                                my_Square[i].x_1 = my_Square[i].x_1 - floatX;
                                                my_Square[11].x_0 = my_Square[11].x_0 + floatX * 2;
                                                my_Square[11].x_1 = my_Square[11].x_1 + floatX * 2;
                                                my_Square[12].x_0 = my_Square[12].x_0 + floatX * 2;
                                                my_Square[12].x_1 = my_Square[12].x_1 + floatX * 2;
                                            }
                                        }
                                    }

                                }


                            }

                        }

                        /*上下移动*/
                        else if (Math.abs(dx) <= floatX / 2 && Math.abs(dy) >= floatY / 2) {
                            //向上移动
                            if (dy < 0) {
                                Log.i("123123", "向上移动");
                                if (my_Square[i].y_0 == my_Square[11].y_1 && my_Square[i].x_0 == my_Square[11].x_0) {
                                    Log.i("123123", "上面是11，现在向上移动");
                                    if (my_Square[i].y_1 - my_Square[i].y_0 == floatY && my_Square[i].x_1 - my_Square[i].x_0 == floatX)//x=1，y=1（卒）
                                    {
                                        s = my_Square[11];
                                        my_Square[11] = my_Square[i];
                                        my_Square[i] = s;
                                        break;

                                    } else if (my_Square[i].y_1 - my_Square[i].y_0 == floatY * 2 && my_Square[i].x_1 - my_Square[i].x_0 == floatX)//x=1，y=2
                                    {
                                        my_Square[11].x_0 = my_Square[i].x_0;
                                        my_Square[11].x_1 = my_Square[i].x_1;
                                        my_Square[11].y_0 = my_Square[i].y_0 + floatY;
                                        my_Square[11].y_1 = my_Square[i].y_1;
                                        my_Square[i].y_0 = my_Square[i].y_0 - floatY;
                                        my_Square[i].y_1 = my_Square[i].y_1 - floatY;
                                    } else {
                                        if (my_Square[11].x_1 == my_Square[12].x_0 && my_Square[11].y_0 == my_Square[12].y_0) {
                                            if (my_Square[i].y_1 - my_Square[i].y_0 == floatY) //x=2，y=1的情况
                                            {
                                                my_Square[i].y_0 = my_Square[i].y_0 - floatY;
                                                my_Square[i].y_1 = my_Square[i].y_1 - floatY;
                                                my_Square[11].y_0 = my_Square[11].y_0 + floatY;
                                                my_Square[11].y_1 = my_Square[11].y_1 + floatY;
                                                my_Square[12].y_0 = my_Square[12].y_0 + floatY;
                                                my_Square[12].y_1 = my_Square[12].y_1 + floatY;
                                            } else   //x=2，y=2的情况（曹操）
                                            {
                                                my_Square[i].y_0 = my_Square[i].y_0 - floatY;
                                                my_Square[i].y_1 = my_Square[i].y_1 - floatY;
                                                my_Square[11].y_0 = my_Square[11].y_0 + floatY * 2;
                                                my_Square[11].y_1 = my_Square[11].y_1 + floatY * 2;
                                                my_Square[12].y_0 = my_Square[12].y_0 + floatY * 2;
                                                my_Square[12].y_1 = my_Square[12].y_1 + floatY * 2;
                                            }

                                        }
                                    }

                                } else if (my_Square[i].y_0 == my_Square[12].y_1 && my_Square[i].x_0 == my_Square[12].x_0) {
                                    Log.i("123123", "上面是12，现在向上移动");
                                    if (my_Square[i].y_1 - my_Square[i].y_0 == floatY && my_Square[i].x_1 - my_Square[i].x_0 == floatX) {
                                        s = my_Square[12];
                                        my_Square[12] = my_Square[i];
                                        my_Square[i] = s;
                                        break;
                                    } else if (my_Square[i].y_1 - my_Square[i].y_0 == floatY * 2 && my_Square[i].x_1 - my_Square[i].x_0 == floatX) {
                                        my_Square[12].x_0 = my_Square[i].x_0;
                                        my_Square[12].x_1 = my_Square[i].x_1;
                                        my_Square[12].y_0 = my_Square[i].y_0 + floatY;
                                        my_Square[12].y_1 = my_Square[i].y_1;
                                        my_Square[i].y_0 = my_Square[i].y_0 - floatY;
                                        my_Square[i].y_1 = my_Square[i].y_1 - floatY;
                                    } else {
                                        if (my_Square[12].x_1 == my_Square[11].x_0 && my_Square[11].y_0 == my_Square[12].y_0) {
                                            if (my_Square[i].y_1 - my_Square[i].y_0 == floatY) //x=2，y=1的情况
                                            {
                                                my_Square[i].y_0 = my_Square[i].y_0 - floatY;
                                                my_Square[i].y_1 = my_Square[i].y_1 - floatY;
                                                my_Square[11].y_0 = my_Square[11].y_0 + floatY;
                                                my_Square[11].y_1 = my_Square[11].y_1 + floatY;
                                                my_Square[12].y_0 = my_Square[12].y_0 + floatY;
                                                my_Square[12].y_1 = my_Square[12].y_1 + floatY;
                                            } else {
                                                my_Square[i].y_0 = my_Square[i].y_0 - floatY;
                                                my_Square[i].y_1 = my_Square[i].y_1 - floatY;
                                                my_Square[11].y_0 = my_Square[11].y_0 + 2 * floatY;
                                                my_Square[11].y_1 = my_Square[11].y_1 + 2 * floatY;
                                                my_Square[12].y_0 = my_Square[12].y_0 + 2 * floatY;
                                                my_Square[12].y_1 = my_Square[12].y_1 + 2 * floatY;
                                            }

                                        }
                                    }

                                }
                            }


                            //向下移动
                            else if (dy > 0) {
                                Log.i("123123", "向下移动");

                                /*空格是11号**/

                                if (my_Square[i].y_1 == my_Square[11].y_0 && my_Square[i].x_0 == my_Square[11].x_0) {
                                    if (my_Square[i].y_1 - my_Square[i].y_0 == floatY && my_Square[i].x_1 - my_Square[i].x_0 == floatX) //x=1，y=1
                                    {
                                        Log.i("123123第" + i + "个，下面是11", "，进入if" + String.valueOf(my_Square[i].x_1 - my_Square[i].x_0));
                                        s = my_Square[11];
                                        my_Square[11] = my_Square[i];
                                        my_Square[i] = s;
                                        break;
                                    } else if (my_Square[i].y_1 - my_Square[i].y_0 == floatY * 2 && my_Square[i].x_1 - my_Square[i].x_0 == floatX) //x=1，y=2
                                    {
                                        Log.i("123123第" + i + "个，下面是11", "，进入else if" + String.valueOf(my_Square[i].x_1 - my_Square[i].x_0));
                                        s = my_Square[11];
                                        my_Square[11].x_0 = my_Square[i].x_0;
                                        my_Square[11].x_1 = my_Square[i].x_1;
                                        my_Square[11].y_0 = my_Square[i].y_0;
                                        my_Square[11].y_1 = my_Square[i].y_1 - floatY;
                                        my_Square[i].y_0 = my_Square[i].y_0 + floatY;
                                        my_Square[i].y_1 = my_Square[i].y_1 + floatY;

                                    } else {
                                        if (my_Square[11].x_1 == my_Square[12].x_0 && my_Square[11].y_0 == my_Square[12].y_0) //如果11和12并排挨着
                                        {
                                            Log.i("123123第" + i + "个，下面是11", "，进入else" + String.valueOf(my_Square[i].x_1 - my_Square[i].x_0));
                                            if (my_Square[i].y_1 - my_Square[i].y_0 == floatY) //x=2，y=1的情况
                                            {
                                                my_Square[i].y_0 = my_Square[i].y_0 + floatY;
                                                my_Square[i].y_1 = my_Square[i].y_1 + floatY;
                                                my_Square[11].y_0 = my_Square[11].y_0 - floatY;
                                                my_Square[11].y_1 = my_Square[11].y_1 - floatY;
                                                my_Square[12].y_0 = my_Square[12].y_0 - floatY;
                                                my_Square[12].y_1 = my_Square[12].y_1 - floatY;
                                            } else  //x=2，y=2的情况
                                            {
                                                my_Square[i].y_0 = my_Square[i].y_0 + floatY;
                                                my_Square[i].y_1 = my_Square[i].y_1 + floatY;
                                                my_Square[11].y_0 = my_Square[11].y_0 - floatY * 2;
                                                my_Square[11].y_1 = my_Square[11].y_1 - floatY * 2;
                                                my_Square[12].y_0 = my_Square[12].y_0 - floatY * 2;
                                                my_Square[12].y_1 = my_Square[12].y_1 - floatY * 2;
                                            }

                                        }
                                    }


                                }
                                //空格是12号
                                else if (my_Square[i].y_1 == my_Square[12].y_0 && my_Square[i].x_0 == my_Square[12].x_0) {
                                    if (my_Square[i].y_1 - my_Square[i].y_0 == floatY && my_Square[i].x_1 - my_Square[i].x_0 == floatX) //x=1，y=1
                                    {
                                        Log.i("123123第" + i + "个，下面是12", "，进入if" + String.valueOf(my_Square[i].x_1 - my_Square[i].x_0));
                                        s = my_Square[12];
                                        my_Square[12] = my_Square[i];
                                        my_Square[i] = s;
                                        break;
                                    } else if (my_Square[i].y_1 - my_Square[i].y_0 == floatY * 2 && my_Square[i].x_1 - my_Square[i].x_0 == floatX) //x=1，y=2
                                    {
                                        Log.i("123123第" + i + "个，下面是12", "，进入else if" + String.valueOf(my_Square[i].x_1 - my_Square[i].x_0));
                                        my_Square[12].x_0 = my_Square[i].x_0;
                                        my_Square[12].x_1 = my_Square[i].x_1;
                                        my_Square[12].y_0 = my_Square[i].y_0;
                                        my_Square[12].y_1 = my_Square[i].y_1 - floatY;
                                        my_Square[i].y_0 = my_Square[i].y_0 + floatY;
                                        my_Square[i].y_1 = my_Square[i].y_1 + floatY;

                                    } else //x=2
                                    {
                                        if (my_Square[12].x_1 == my_Square[11].x_0 && my_Square[11].y_0 == my_Square[12].y_0) {
                                            if (my_Square[i].y_1 - my_Square[i].y_0 == floatY) //x=2，y=1的情况
                                            {
                                                Log.i("123123第" + i + "个，下面是12", "，进入else" + String.valueOf(my_Square[i].x_1 - my_Square[i].x_0));
                                                my_Square[i].y_0 = my_Square[i].y_0 + floatY;
                                                my_Square[i].y_1 = my_Square[i].y_1 + floatY;
                                                my_Square[11].y_0 = my_Square[11].y_0 - floatY;
                                                my_Square[11].y_1 = my_Square[11].y_1 - floatY;
                                                my_Square[12].y_0 = my_Square[12].y_0 - floatY;
                                                my_Square[12].y_1 = my_Square[12].y_1 - floatY;
                                            } else {
                                                Log.i("123123第" + i + "个，下面是12", "，进入else" + String.valueOf(my_Square[i].x_1 - my_Square[i].x_0));
                                                my_Square[i].y_0 = my_Square[i].y_0 + floatY;
                                                my_Square[i].y_1 = my_Square[i].y_1 + floatY;
                                                my_Square[11].y_0 = my_Square[11].y_0 - floatY * 2;
                                                my_Square[11].y_1 = my_Square[11].y_1 - floatY * 2;
                                                my_Square[12].y_0 = my_Square[12].y_0 - floatY * 2;
                                                my_Square[12].y_1 = my_Square[12].y_1 - floatY * 2;
                                            }

                                        }
                                    }

                                }
                            }

                        }
                    }
                }
                invalidate();
                successNumber();
                break;
            case MotionEvent.ACTION_MOVE:
                int moveX = (int) event.getX();
                int moveY = (int) event.getY();
                break;

        }
        return true;
    }


    /**
     * 回调成功
     */
    public void setOnSuccess(OnSuccessListener listener) {
        this.listener = listener;
    }

    public OnSuccessListener listener;

    public interface OnSuccessListener {
        void success();

        void toast();
    }

    /**
     * 成功时的情况
     */
    public void successNumber() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (my_Square[2].x_0 == floatX && my_Square[2].x_1 == floatX * 3 && my_Square[2].y_0 == floatY * 3 && my_Square[2].y_1 == mHeight) {
                    listener.success();
                }
//                if(my_Square[9].x_0==floatX && my_Square[9].y_1==mHeight){
//                    listener.success();
//                }

            }
        }, 500);

    }
}



