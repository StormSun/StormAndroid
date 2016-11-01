package com.stormsun.app.customview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.stormsun.app.customview.step1.BallMoveActivity;
import com.stormsun.app.customview.step1.CircleDemoActivity;
import com.stormsun.app.customview.step1.VerificationCodeActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

    }

    @OnClick(R.id.id_btn_circle)
    void openCircle(){
        startActivity(new Intent(this, CircleDemoActivity.class));
    }

    @OnClick(R.id.id_btn_verify_code)
    void openVerifyCode(){
        startActivity(new Intent(this, VerificationCodeActivity.class));
    }

    @OnClick(R.id.id_btn_ball_move)
    void openBallMove(){
        startActivity(new Intent(this, BallMoveActivity.class));
    }
}
