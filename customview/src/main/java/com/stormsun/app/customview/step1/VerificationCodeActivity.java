package com.stormsun.app.customview.step1;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewTreeObserver;
import android.widget.ImageView;

import com.stormsun.app.customview.R;
import com.stormsun.app.customview.Utils.VerifyCodeUtils;

import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by StormSun on 31,十月,2016
 * <p>
 * 模拟验证码：
 * 在 ImageView 绘制一个空心矩形，
 * 随机产生 100 条干扰线，
 * 并随机生成 4 个数字显示在矩形框内。
 */

public class VerificationCodeActivity extends AppCompatActivity {

    @BindView(R.id.id_iv_verify_code)
    ImageView mIvVerifyCode;
    private Paint mPaint;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verification_code);
        ButterKnife.bind(this);
        mPaint = new Paint();
        mIvVerifyCode.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                drawVerifyCode();
            }
        });
    }

    private void drawVerifyCode() {
        Bitmap bitmapBuffer = Bitmap.createBitmap(600, 400, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapBuffer);
        Random random = new Random();

        String verifyCode = VerifyCodeUtils.generateVerifyCode(4);
        mPaint.setTextSize(50);
        canvas.drawText(verifyCode, 300, 140, mPaint);

        mPaint.reset();
        mPaint.setStrokeWidth(2);
        float[] arr = new float[200];
        for (int i = 0; i < 200; i += 2) {
            int x = random.nextInt(600);
            int y = random.nextInt(400);
            arr[i] = x;
            arr[i + 1] = y;
        }
        canvas.drawLines(arr, mPaint);
        mIvVerifyCode.setImageBitmap(bitmapBuffer);
    }



}
