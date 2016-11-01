package com.stormsun.app.customview.step1.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by StormSun on 01,十一月,2016
 */

public class BallMoveView extends View {

    private static final int RADIUS = 30;
    private static final int Y = 100;
    private static final String TAG = BallMoveView.class.getSimpleName();
    private static final int COLOR = Color.RED;
    private Paint mPaint;
    private int x;
    // 放向  true x轴正方向  false x负方向
    private boolean direction;

    private Timer mTimer;

    public BallMoveView(Context context) {
        super(context);
        init(context);
    }

    public BallMoveView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public BallMoveView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    /**
     * 初始化
     *
     * @param context 上下文对象
     */
    private void init(Context context) {
        // 初始化画笔
        mPaint = new Paint();
        mPaint.setColor(COLOR);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setAntiAlias(true);
        x = RADIUS;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawCircle(x, Y, RADIUS, mPaint);

        int width = getMeasuredWidth();

        if (2 * RADIUS > width) {
            return;
        }

        if (x <= RADIUS) {
            direction = true;
        } else if (x > width - RADIUS) {
            direction = false;
        }
        x += (direction ? 5 : -5);
    }

    public void start() {
        mTimer = new Timer();
        mTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                postInvalidate();
            }
        }, 200, 50);
    }

    public void stop() {
        mTimer.cancel();
        mTimer.purge();
    }
}
