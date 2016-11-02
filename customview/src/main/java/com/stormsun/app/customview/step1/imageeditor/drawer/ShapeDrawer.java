package com.stormsun.app.customview.step1.imageeditor.drawer;

import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.View;

import com.stormsun.app.customview.step1.imageeditor.BitmapBuffer;

/**
 * Created by StormSun on 02,十一月,2016
 */

public abstract class ShapeDrawer {

    private View view;

    public ShapeDrawer(View view){
        this.view = view;
    }

    public View getView(){
        return this.view;
    }

    public void draw(Canvas canvas) {
        Bitmap bitmap = BitmapBuffer.getInstance().getBitmap();
        canvas.drawBitmap(bitmap, 0, 0, null);
    }

    public abstract void logic();

    public abstract boolean onTouchEvent(MotionEvent event);

}
