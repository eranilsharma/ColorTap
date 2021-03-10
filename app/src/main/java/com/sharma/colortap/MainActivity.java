package com.sharma.colortap;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    View view1,view2,view3,view4;
    int mScore=0;
    TextView textScore;
    private long mLastClickTime = 0;
    boolean isTouch=true;
    static boolean mIsRestart=false;
    public static void show(Context mContext, Boolean isRestart){
        mIsRestart=isRestart;
        mContext.startActivity(new Intent(mContext,MainActivity.class));
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        view1=findViewById(R.id.view1);
        view2=findViewById(R.id.view2);
        view3=findViewById(R.id.view3);
        view4=findViewById(R.id.view4);
        textScore=findViewById(R.id.text_score);
        if(mIsRestart){
            mScore=0;
            textScore.setText("Score:"+mScore);
        }
        genrateRandomNum();
        //getCountDown();
        view1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (SystemClock.elapsedRealtime() - mLastClickTime < 1000) {
                    return false;
                }
                mLastClickTime = SystemClock.elapsedRealtime();
                int colorId=getColourID(view1);
                if(colorId==getResources().getColor(R.color.grey)){
                    mScore++;
                    isTouch=true;
                    textScore.setText("Score: "+mScore);
                }
                else {
                    showGameFinishDialog();
                }
                return false;
            }
        });
        view2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (SystemClock.elapsedRealtime() - mLastClickTime < 1000) {
                    return false;
                }
                mLastClickTime = SystemClock.elapsedRealtime();
                int colorId=getColourID(view2);
                if(colorId==getResources().getColor(R.color.grey)){
                    mScore++;
                    isTouch=true;
                    textScore.setText("Score: "+mScore);
                }
                else {
                    showGameFinishDialog();
                }
                return false;
            }
        });
        view3.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (SystemClock.elapsedRealtime() - mLastClickTime < 1000) {
                    return false;
                }
                mLastClickTime = SystemClock.elapsedRealtime();
                int colorId=getColourID(view3);
                if(colorId==getResources().getColor(R.color.grey)){
                    mScore++;
                    isTouch=true;
                    textScore.setText("Score: "+mScore);
                }
                else {
                    showGameFinishDialog();
                }
                return false;
            }
        });
        view4.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (SystemClock.elapsedRealtime() - mLastClickTime < 1000) {
                    return false;
                }
                mLastClickTime = SystemClock.elapsedRealtime();
                int colorId=getColourID(view4);
                if(colorId==getResources().getColor(R.color.grey)){
                    mScore++;
                    isTouch=true;
                    textScore.setText("Score: "+mScore);

                }
                else {
                    showGameFinishDialog();
                }
                return false;
            }
        });
    }


    private void showGameFinishDialog() {
        ScoreActivity.show(MainActivity.this,mScore);

        /*AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View view = LayoutInflater.from(this).inflate(R.layout.game_funish_layout, null);
        TextView txtScore=view.findViewById(R.id.txt_game_score);
        Button btnRestart=view.findViewById(R.id.btn_restart);
        txtScore.setText("Your score is: "+ mScore);
        builder.setView(view);
        final AlertDialog alertDialog = builder.create();
        alertDialog.setCanceledOnTouchOutside(false);
        alertDialog.show();
        onPause();
        btnRestart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mScore=0;
                textScore.setText("Score:"+mScore);
                alertDialog.dismiss();
            }
        });*/
    }

    private void genrateRandomNum() {
        if(isTouch){
            isTouch=false;
            Random random=new Random();
            int num=random.nextInt(3)+1;
            switch (num){
                case 1:
                    view1.setBackgroundColor(getResources().getColor(R.color.grey));
                    view2.setBackgroundColor(getResources().getColor(R.color.blue));
                    view3.setBackgroundColor(getResources().getColor(R.color.yellow));
                    view4.setBackgroundColor(getResources().getColor(R.color.green));
                    break;
                case 2:
                    view2.setBackgroundColor(getResources().getColor(R.color.grey));
                    view1.setBackgroundColor(getResources().getColor(R.color.red));
                    view3.setBackgroundColor(getResources().getColor(R.color.yellow));
                    view4.setBackgroundColor(getResources().getColor(R.color.green));
                    break;
                case 3:
                    view3.setBackgroundColor(getResources().getColor(R.color.grey));
                    view2.setBackgroundColor(getResources().getColor(R.color.blue));
                    view1.setBackgroundColor(getResources().getColor(R.color.red));
                    view4.setBackgroundColor(getResources().getColor(R.color.green));
                    break;
                case 4:
                    view4.setBackgroundColor(getResources().getColor(R.color.grey));
                    view2.setBackgroundColor(getResources().getColor(R.color.blue));
                    view3.setBackgroundColor(getResources().getColor(R.color.yellow));
                    view1.setBackgroundColor(getResources().getColor(R.color.red));
                    break;
            }
            Handler handler=new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    genrateRandomNum();
                }
            },1500);
        }
        else {
        showGameFinishDialog();
        }

    }

    public int getColourID(View view){
        ColorDrawable viewColor = (ColorDrawable) view.getBackground();
        int colorId = viewColor.getColor();
        return colorId;
    }

 /*@Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        genrateRandomNum();
        getCountDown();
    }*/

}