package com.stormsun.app.customview.step1.activity;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.ViewTreeObserver;
import android.widget.ImageView;

import com.github.lzyzsd.randomcolor.RandomColor;
import com.stormsun.app.customview.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 *
 * 请在 ImageView 上绘制尺寸为 20 * 20 的实心圆，
 * 圆的填充颜色随机，
 * 从左上角开始，
 * 从左往右从上往下直到画满整个屏幕为止；
 */

public class CircleDemoActivity extends AppCompatActivity {
    private static final String TAG = CircleDemoActivity.class.getSimpleName();
    private static final int RADIUS = 10;

    @BindView(R.id.id_iv)
    ImageView mIv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_circle_demo);
        ButterKnife.bind(this);

        mIv.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                drawCircle();
            }
        });
    }

    private void drawCircle() {
        int width = mIv.getWidth();
        int height = mIv.getHeight();
        Log.d(TAG, "width = " + width + "\nheight = " + height);
        Bitmap bmpBuffer = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bmpBuffer);
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);

        RandomColor randomColor = new RandomColor();
        int x = 0;
        int y = 0;
        while (y + 2 * RADIUS < height) {
            if (x + 2 * RADIUS < width) {
                paint.setColor(randomColor.randomColor());
                canvas.drawCircle(x + RADIUS, y + RADIUS, RADIUS, paint);
                x += 2 * RADIUS;
            } else {
                x = 0;
                y += 2 * RADIUS;
            }
        }
        mIv.setImageBitmap(bmpBuffer);
    }
}
