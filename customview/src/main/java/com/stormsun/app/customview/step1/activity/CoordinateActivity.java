package com.stormsun.app.customview.step1.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.stormsun.app.customview.R;
import com.stormsun.app.customview.step1.widget.CoordinateView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by StormSun on 01,十一月,2016
 */

public class CoordinateActivity extends AppCompatActivity {

    @BindView(R.id.id_widget_coordinate)
    CoordinateView mCoordinate;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coordinate);

        ButterKnife.bind(this);

    }
}
