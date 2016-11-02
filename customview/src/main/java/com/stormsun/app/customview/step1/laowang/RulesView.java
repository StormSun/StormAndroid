package com.stormsun.app.customview.step1.laowang;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by wangyingying on 2016/11/2.
 *
 * 老王画的尺子
 */

public class RulesView extends View{

    private Paint mpaint;
    private int a;

    public RulesView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        mpaint = new Paint();
        mpaint.setStyle(Paint.Style.STROKE);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawRect(canvas);
        drawlines(canvas);
    }


    private void drawlines(Canvas canvas) {
        mpaint.setStrokeWidth(3);
        mpaint.setColor(Color.BLUE);
        canvas.save();
        canvas.drawLine(40,310,40,120,mpaint);
        for (int i = 1; i <=13 ; i++) {
//            for (int j = 1; j <=8; i++) {
                if (i==8){
                    canvas.drawLine(40,310,40,120,mpaint);
                }else if (i==5){
                    canvas.drawLine(40,310,40,170,mpaint);
                }else{
                    canvas.drawLine(40,310,40,210,mpaint);
                }
//            }
            canvas.translate(10,0);
            // 这个放到下边去↓
            //canvas.restore();
        }
        // 放到这里
        canvas.restore();

    }

    private void drawRect(Canvas canvas) {
        mpaint.setStrokeWidth(10);
        canvas.save();
        RectF rect=new RectF(10,10,830,310);
        canvas.drawRoundRect(rect,30,30,mpaint);
        canvas.restore();
    }
}
