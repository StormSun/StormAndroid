package com.stormsun.app.customview.step1.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import java.util.Calendar;

/**
 * Created by StormSun on 01,十一月,2016
 */

public class WatchView extends View {

    private Paint mPaint;
    private Calendar mCalender;

    public WatchView(Context context) {
        super(context);
        init();
    }

    public WatchView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public WatchView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPaint = new Paint();
        mCalender = Calendar.getInstance();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int width = getMeasuredWidth();
        int height = getMeasuredHeight();

        int len = Math.min(width, height);
        int r = len / 2;

        drawPlate(canvas, r);
        drawPoints(canvas, r);
    }


    /**
     * 表盘
     *
     * @param canvas
     * @param r
     */
    private void drawPlate(Canvas canvas, int r) {
        canvas.save();

        // 画圆
        mPaint.setStrokeWidth(3);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setAntiAlias(true);

        canvas.drawCircle(r, r, r, mPaint);

        // 画刻度
        for (int i = 0; i < 60; i++) {
            // 360度，60个刻度，每6度一个刻度
            if (i % 5 == 0) {
                // 大刻度 1/10半径
                mPaint.setColor(Color.RED);
                canvas.drawLine(r + 9 * r / 10, r, 2 * r, r, mPaint);
            } else {
                // 小刻度 1/15半径
                mPaint.setColor(Color.GRAY);
                canvas.drawLine(r + 14 * r / 15, r, 2 * r, r, mPaint);
            }
            canvas.rotate(6, r, r);
        }
        canvas.restore();
    }

    /**
     * 指针
     *
     * @param canvas
     * @param r
     */
    private void drawPoints(Canvas canvas, int r) {
        mCalender.setTimeInMillis(System.currentTimeMillis());
        int hour = mCalender.get(Calendar.HOUR) % 12;
        int minute = mCalender.get(Calendar.MINUTE);
        int second = mCalender.get(Calendar.SECOND);

        // 画时针


        // 画分针


        // 画秒针


    }
}
