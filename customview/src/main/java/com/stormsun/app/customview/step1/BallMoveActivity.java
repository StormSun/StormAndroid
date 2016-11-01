package com.stormsun.app.customview.step1;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.stormsun.app.customview.R;
import com.stormsun.app.customview.step1.widget.BallMoveView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by StormSun on 01,十一月,2016
 */

public class BallMoveActivity extends AppCompatActivity {

    @BindView(R.id.id_widget_ball_move)
    BallMoveView mBallMove;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ball_move);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.id_btn_start)
    void startMove() {
        mBallMove.start();
    }

    @OnClick(R.id.id_btn_stop)
    void stopMove() {
        mBallMove.stop();
    }

}
