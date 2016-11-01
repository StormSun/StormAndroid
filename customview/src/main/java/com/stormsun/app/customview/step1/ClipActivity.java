package com.stormsun.app.customview.step1;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.stormsun.app.customview.R;
import com.stormsun.app.customview.step1.widget.ClipView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by StormSun on 01,十一月,2016
 */

public class ClipActivity extends AppCompatActivity {

    @BindView(R.id.id_widget_clip)
    ClipView mClip;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clip);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.id_btn_auto)
    void onAutoClick() {
        mClip.auto();
    }

    @OnClick(R.id.id_btn_next)
    void onNextClick() {
        mClip.goNext();
    }

    @OnClick(R.id.id_btn_last)
    void onLastClick() {
        mClip.goLast();
    }

    @OnClick(R.id.id_btn_reset)
    void onResetClick() {
        mClip.reset();
    }


}
