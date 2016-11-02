package com.stormsun.app.customview.step1.imageeditor;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.stormsun.app.customview.step1.imageeditor.drawer.LineDrawer;
import com.stormsun.app.customview.step1.imageeditor.drawer.ShapeDrawer;

/**
 * Created by StormSun on 02,十一月,2016
 */

public class ImageView extends View {

    private ShapeDrawer shapeDrawer;

    public ImageView(Context context) {
        super(context);
        init();
    }

    public ImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        shapeDrawer = new LineDrawer(this);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        SystemParams.areaWidth = getMeasuredWidth();
        SystemParams.areaHeight = getMeasuredHeight();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return shapeDrawer.onTouchEvent(event);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if (SystemParams.isReDo) {
            // 撤销
            Bitmap bitmap = BitmapBuffer.getInstance().getBitmap();
            canvas.drawBitmap(bitmap, 0, 0, null);
            SystemParams.isReDo = false;
        } else {
            // 画
            shapeDrawer.draw(canvas);
        }
    }

    public void setShapeDrawer(ShapeDrawer shapeDrawer){
        this.shapeDrawer = shapeDrawer;
    }
}
