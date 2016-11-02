package com.stormsun.app.customview.step1.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by StormSun on 02,十一月,2016
 */

public class Line1View extends View {

    private static final String TAG = Line1View.class.getSimpleName();
    private int currentX;
    private int currentY;
    private int preX;
    private int preY;
    private Paint mPaint;
    private Bitmap bitmapBuffer;
    private Canvas canvasBuffer;

    public Line1View(Context context) {
        super(context);
        init();
    }

    public Line1View(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public Line1View(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    /**
     * 初始化
     */
    private void init() {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setStrokeWidth(3);
        mPaint.setColor(Color.RED);
//        mPaint.setAntiAlias(true);
//        mPaint.setStyle(Paint.Style.FILL);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        Log.d(TAG, "onSizeChanged --->> w = " + w + " h = " + h + " oldw = " + oldw + "oldh = " + oldh);
        if (bitmapBuffer == null) {
            int width = getMeasuredWidth();
            int height = getMeasuredHeight();
            bitmapBuffer = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
            canvasBuffer = new Canvas(bitmapBuffer);
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Log.d(TAG, "onDraw");
        canvas.drawBitmap(bitmapBuffer, 0, 0, null);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x = (int) event.getX();
        int y = (int) event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                preX = x;
                preY = y;
                break;
            case MotionEvent.ACTION_MOVE:
                currentX = x;
                currentY = y;
                canvasBuffer.drawLine(preX, preY, currentX, currentY, mPaint);
                invalidate();
                preX = currentX;
                preY = currentY;
                break;
            case MotionEvent.ACTION_UP:
                break;
        }
        return true;
    }
}
