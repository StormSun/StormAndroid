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

public class Coordinate2View extends View {

    private Paint mPaint;
    private static final int COLOR = Color.RED;
    private Matrix mMatrix;

    public Coordinate2View(Context context) {
        super(context);
        init(context);
    }

    public Coordinate2View(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public Coordinate2View(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    /**
     * 初始化
     *
     * @param context 上下文
     */
    private void init(Context context) {
        mPaint = new Paint();
        mPaint.setColor(COLOR);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(2);
        mMatrix = new Matrix();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        mMatrix.setTranslate(10, 10);
            canvas.setMatrix(mMatrix);
        for (int i = 0; i < 5; i++) {
            canvas.drawRect(0, 0, 50, 50, mPaint);
        }

    }
}
