package com.stormsun.app.customview.step1.imageeditor;

import android.graphics.Color;
import android.graphics.Paint;

/**
 * 属性工具类
 *
 * Created by StormSun on 02,十一月,2016
 */

public class AttributesTool {

    private static AttributesTool mInstance;
    private static Paint mPaint;

    private int mBorderWidth;
    private int mColor;
    private boolean mFill;

    private AttributesTool(){
        reset();
    }

    /**
     * 取实例
     *
     * @return AttributesTool实例
     */
    public static AttributesTool getInstance() {
        if (mInstance == null) {
            synchronized (AttributesTool.class) {
                if (mInstance == null) {
                    mInstance = new AttributesTool();
                }
            }
        }
        return mInstance;
    }

    /**
     * 取画笔
     *
     * @return Paint对象
     */
    public Paint getPaint() {
        if (mPaint == null) {
            mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        }
        mPaint.setStyle(mFill ? Paint.Style.FILL : Paint.Style.STROKE);
        mPaint.setColor(mColor);
        mPaint.setStrokeWidth(mBorderWidth);
        mPaint.setTextSize(30);
        return mPaint;
    }


    /**
     * 设置是否填充
     *
     * @param fill true 填充 false 不填充
     */
    public void setFill(boolean fill) {
        this.mFill = fill;
    }

    /**
     * 设置颜色
     *
     * @param color
     */
    public void setColor(int color) {
        this.mColor = color;
    }

    /**
     * 设置边框宽度
     *
     * @param borderWidth
     */
    public void setmBorderWidth(int borderWidth) {
        this.mBorderWidth = borderWidth;
    }

    public int getColor() {
        return this.mColor;
    }

    public int getBorderWidth() {
        return this.mBorderWidth;
    }

    /**
     * 是否填充
     * @return
     */
    public boolean isFill() {
        return mFill;
    }

    /**
     * 重置
     */
    public void reset(){
        this.mFill = false;
        this.mColor = Color.BLACK;
        this.mBorderWidth = 1;
    }

}
