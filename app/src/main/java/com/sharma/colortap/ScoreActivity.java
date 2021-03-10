package com.sharma.colortap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ScoreActivity extends AppCompatActivity {
    TextView txtScore;
    static int mScore;

    public static void show(Context mContxt, int score){
        mScore=score;
        mContxt.startActivity(new Intent(mContxt,ScoreActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        this.setFinishOnTouchOutside(false);
        txtScore=findViewById(R.id.txt_game_score);
        Button btnRestart=findViewById(R.id.btn_restart);
        txtScore.setText("Your score is: "+ mScore);
        btnRestart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            MainActivity.show(ScoreActivity.this,true);
            }
        });

    }
}