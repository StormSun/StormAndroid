package com.stormsun.app.customview.step1.imageeditor.drawer;

import android.graphics.Canvas;
import android.view.View;

import com.stormsun.app.customview.step1.imageeditor.AttributesTool;

/**
 * Created by StormSun on 02,十一月,2016
 */

public class LineDrawer extends RectDrawer {

    public LineDrawer(View view) {
        super(view);
    }

    @Override
    protected void drawShape(Canvas canvas, int left, int top, int right, int bottom) {
        canvas.drawLine(left, top, right, bottom, AttributesTool.getInstance().getPaint());
    }
}
