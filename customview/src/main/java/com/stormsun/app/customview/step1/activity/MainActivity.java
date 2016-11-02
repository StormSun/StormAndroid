package com.stormsun.app.customview.step1.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.stormsun.app.customview.R;
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
import com.stormsun.app.customview.step1.imageeditor.ImageEditorActivity;
import com.stormsun.app.customview.step1.laowang.RulesActivity;

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

    @OnClick(R.id.id_btn_image_editor)
    void openImageEditor(){
        startActivity(new Intent(this, ImageEditorActivity.class));
    }

    @OnClick(R.id.id_btn_rules)
    void openRules(){
        startActivity(new Intent(this, RulesActivity.class));
    }

    /**
     *
     * @param len  长度  13cm
     */
    private void sss(int len){
        // 前边特殊处理


        // 开始后边循环
        for (int i = 1; i <= len; i++) {
            for (int j = 1; j <= 8; j++) {
                if(j == 5){
                    // 中

                } else if(j == 8){
                    // 长

                } else {
                    // 短

                }
            }
        }
    }


}
