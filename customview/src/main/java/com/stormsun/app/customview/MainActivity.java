package com.stormsun.app.customview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.stormsun.app.customview.step1.activity.BallMoveActivity;
import com.stormsun.app.customview.step1.activity.CircleDemoActivity;
import com.stormsun.app.customview.step1.activity.ClipActivity;
import com.stormsun.app.customview.step1.activity.Coordinate2Activity;
import com.stormsun.app.customview.step1.activity.CoordinateActivity;
import com.stormsun.app.customview.step1.activity.Line1Activity;
import com.stormsun.app.customview.step1.activity.Line2Activity;
import com.stormsun.app.customview.step1.activity.Rect1Activity;
import com.stormsun.app.customview.step1.activity.VerificationCodeActivity;
import com.stormsun.app.customview.step1.activity.WatchActivity;

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

    @OnClick(R.id.id_btn_coordinate)
    void openCoordinate(){
        startActivity(new Intent(this, CoordinateActivity.class));
    }

    @OnClick(R.id.id_btn_coordinate2)
    void openCoordinate2(){
        startActivity(new Intent(this, Coordinate2Activity.class));
    }

    @OnClick(R.id.id_btn_clip)
    void openClip(){
        startActivity(new Intent(this, ClipActivity.class));
    }

    @OnClick(R.id.id_btn_watch)
    void openWatch(){
        startActivity(new Intent(this, WatchActivity.class));
    }

    @OnClick(R.id.id_btn_line1)
    void openLine1(){
        startActivity(new Intent(this, Line1Activity.class));
    }

    @OnClick(R.id.id_btn_line2)
    void openLine2(){
        startActivity(new Intent(this, Line2Activity.class));
    }

    @OnClick(R.id.id_btn_rect1)
    void openRect1(){
        startActivity(new Intent(this, Rect1Activity.class));
    }

}
