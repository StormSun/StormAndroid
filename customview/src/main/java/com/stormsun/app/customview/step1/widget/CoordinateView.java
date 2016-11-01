package com.stormsun.app.customview.step1.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by StormSun on 01,十一月,2016
 */

public class CoordinateView extends View {

    private static final String TAG = CoordinateView.class.getSimpleName();

    private Paint mPaint;
    private static final int COLOR = Color.RED;

    public CoordinateView(Context context) {
        super(context);
        init(context);
    }

    public CoordinateView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public CoordinateView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    /**
     * 初始化
     *
     * @param context
     */
    private void init(Context context) {
        mPaint = new Paint();
        mPaint.setColor(COLOR);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(2);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.save();
        for (int i = 0; i < 5; i++) {
            canvas.translate(20, 20);
            canvas.drawRect(0, 0, 100, 100, mPaint);
        }
        canvas.restore();

        canvas.translate(0, 220);
        canvas.save();
        for (int i = 0; i < 5; i++) {
            canvas.scale(0.9f, 0.9f, 50, 50);
            canvas.drawRect(0, 0, 100, 100, mPaint);
        }
        canvas.restore();

        canvas.translate(0, 100);

        canvas.save();
        canvas.drawCircle(200, 200, 200, mPaint);
        for (int i = 0; i < 12; i++) {
            canvas.drawLine(350, 200, 400, 200, mPaint);
            canvas.rotate(30, 200,200);
        }
        canvas.restore();
    }
}
