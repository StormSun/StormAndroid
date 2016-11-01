package com.stormsun.app.customview.step1.widget;

import android.content.Context;
import android.content.IntentSender;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Region;
import android.util.AttributeSet;
import android.view.View;

import com.stormsun.app.customview.R;

import java.util.Timer;
import java.util.TimerTask;


/**
 * Created by StormSun on 01,十一月,2016
 */

public class ClipView extends View {


    private Bitmap bmpJingling;
    private int index;
    private static final int COUNT = 5;
    private Timer mTimer;
    private boolean isAuto;

    public ClipView(Context context) {
        super(context);
        init(context);
    }

    public ClipView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public ClipView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        bmpJingling = BitmapFactory.decodeResource(getResources(), R.drawable.jinglingtu1);
        index = 0;
        isAuto = false;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = bmpJingling.getWidth();
        int height = bmpJingling.getHeight();
        int w = width / COUNT;
        canvas.clipRect(0, 0, w, height, Region.Op.INTERSECT);
        canvas.translate(-index * w, 0);
        canvas.drawBitmap(bmpJingling, 0, 0, null);
        if (isAuto) {
            index++;
            if (index >= COUNT) {
                index = 0;
            }
        }
    }

    public void goNext() {
        stopAuto();
        index++;
        if (index >= COUNT) {
            index = 0;
        }
        invalidate();
    }

    public void goLast() {
        stopAuto();
        index--;
        if (index < 0) {
            index = COUNT - 1;
        }
        invalidate();
    }

    public void reset() {
        stopAuto();
        index = 0;
        invalidate();
    }

    public void auto() {
        if (!isAuto) {
            isAuto = true;
            mTimer = new Timer();
            mTimer.schedule(new TimerTask() {
                @Override
                public void run() {
                    postInvalidate();
                }
            }, 200, 100);
        }
    }

    private void stopAuto() {
        if (mTimer != null) {
            mTimer.cancel();
            mTimer.purge();
            mTimer = null;
        }
        isAuto = false;
    }

}
