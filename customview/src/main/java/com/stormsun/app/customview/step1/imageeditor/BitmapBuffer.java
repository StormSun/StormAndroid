package com.stormsun.app.customview.step1.imageeditor;

import android.graphics.Bitmap;
import android.graphics.Canvas;

/**
 * Created by StormSun on 02,十一月,2016
 */

public class BitmapBuffer {

    private static BitmapBuffer mInstance;
    private Bitmap mBitmap;
    private Canvas mCanvas;

    private BitmapBuffer(int width, int height) {
        init(width, height);
    }

    private void init(int width, int height) {
        mBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        mCanvas = new Canvas(mBitmap);
    }

    /**
     * 取实例
     *
     * @return
     */
    public static BitmapBuffer getInstance() {
        if (mInstance == null) {
            synchronized (BitmapBuffer.class) {
                if (mInstance == null) {
                    mInstance = new BitmapBuffer(SystemParams.areaWidth, SystemParams.areaHeight);
                }
            }
        }
        return mInstance;
    }

    public void pushBitmap() {
        BitmapHistory.getInstance().pushBitmap(mBitmap.copy(Bitmap.Config.ARGB_8888, false));
    }

    public Bitmap getBitmap() {
        return this.mBitmap;
    }

    public Canvas getCanvas() {
        return this.mCanvas;
    }

    public void reDo(){
        BitmapHistory his = BitmapHistory.getInstance();
        if(his.isReDo()){
            Bitmap bmp = his.reDo();
            if (bmp != null) {
                mBitmap = bmp.copy(Bitmap.Config.ARGB_8888, true);
                mCanvas.setBitmap(mBitmap);
                if(!bmp.isRecycled()){
                    bmp.recycle();
                    System.gc();
                    bmp = null;
                }
            }
        }
    }
}
