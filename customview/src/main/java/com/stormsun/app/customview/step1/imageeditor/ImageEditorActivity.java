package com.stormsun.app.customview.step1.imageeditor;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.stormsun.app.customview.R;
import com.stormsun.app.customview.step1.imageeditor.drawer.LineDrawer;
import com.stormsun.app.customview.step1.imageeditor.drawer.RectDrawer;
import com.stormsun.app.customview.step1.imageeditor.drawer.ShapeDrawer;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by StormSun on 02,十一月,2016
 */

public class ImageEditorActivity extends AppCompatActivity {

    @BindView(R.id.id_widget_iv)
    ImageView mIv;

    private ShapeDrawer mShapeDrawer;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_editor);
        ButterKnife.bind(this);



    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.id_menu_rect:
                mShapeDrawer = new RectDrawer(mIv);
                break;
            case R.id.id_menu_line:
                mShapeDrawer = new LineDrawer(mIv);
                break;
        }

        if (mShapeDrawer != null) {
            mIv.setShapeDrawer(mShapeDrawer);
        }

        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_image_editor, menu);
        return true;
    }
}
