package com.stormsun.app.customview.step1.imageeditor.drawer;

import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.View;

import com.stormsun.app.customview.step1.imageeditor.AttributesTool;
import com.stormsun.app.customview.step1.imageeditor.BitmapBuffer;

/**
 * Created by StormSun on 02,十一月,2016
 */

public class RectDrawer extends ShapeDrawer {

    private int firstX, firstY, currentX, currentY;

    public RectDrawer(View view) {
        super(view);
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);

        drawShape(canvas, firstX, firstY, currentX, currentY);
    }

    /**
     * @param left
     * @param top
     * @param right
     * @param bottom
     */
    protected void drawShape(Canvas canvas, int left, int top, int right, int bottom) {
        if(left < right && top > bottom){
            // ↘
            canvas.drawRect(left, top, right, bottom, AttributesTool.getInstance().getPaint());
        } else if(left > right && top > bottom){
            // ↙
            canvas.drawRect(right, top, left, bottom, AttributesTool.getInstance().getPaint());
        } else if(left < right && top < bottom){
            // ↗
            canvas.drawRect(left, bottom, right, top, AttributesTool.getInstance().getPaint());
        } else if(left > right && top < bottom) {
            // ↖
            canvas.drawRect(right, bottom, left, top, AttributesTool.getInstance().getPaint());
        }
    }

    @Override
    public void logic() {

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x = (int) event.getX();
        int y = (int) event.getY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                firstX = x;
                firstY = y;
                break;
            case MotionEvent.ACTION_MOVE:
                currentX = x;
                currentY = y;
                getView().invalidate();
                break;
            case MotionEvent.ACTION_UP:
                getView().invalidate();
                // 缓存本次绘画
                Canvas canvas = BitmapBuffer.getInstance().getCanvas();
                drawShape(canvas, firstX, firstY, currentX, currentY);
                // 推到历史栈
                BitmapBuffer.getInstance().pushBitmap();
                break;
            default:
                break;
        }

        return true;
    }
}
