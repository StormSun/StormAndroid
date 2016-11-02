package com.stormsun.app.customview.step1.imageeditor;

import android.graphics.Bitmap;

import java.util.Stack;

/**
 * Created by StormSun on 02,十一月,2016
 */

public class BitmapHistory {

    private static BitmapHistory mInstance;
    private Stack<Bitmap> mBitmapStack;

    public static BitmapHistory getInstance() {
        if (mInstance == null) {
            synchronized (BitmapHistory.class) {
                if (mInstance == null) {
                    mInstance = new BitmapHistory();
                }
            }
        }
        return mInstance;
    }

    private BitmapHistory() {
        if (mBitmapStack == null) {
            mBitmapStack = new Stack<>();
        }
    }

    public void pushBitmap(Bitmap bitmap) {
        if (mBitmapStack.size() >= 5) {
            Bitmap bmp = mBitmapStack.remove(0);
            if (bmp != null) {
                bmp.recycle();
                System.gc();
                bmp = null;
            }
            pushBitmap(bitmap);
        } else {
            mBitmapStack.push(bitmap);
        }
    }

    /**
     * 撤销
     * 将栈顶弹出，同时返回新的栈顶
     *
     * @return
     */
    public Bitmap reDo() {

        if (mBitmapStack.size() == 0) {
            return null;
        }

        Bitmap bmp = mBitmapStack.pop();
        if (bmp != null) {
            bmp.recycle();
            System.gc();
            bmp = null;
        }

        if (mBitmapStack.size() == 0) {
            return null;
        }

        return mBitmapStack.peek();
    }

    /**
     * 是否可进行撤销操作
     * @return true 可以， false 不可以
     */
    public boolean isReDo(){
        return !mBitmapStack.isEmpty();
    }

}
