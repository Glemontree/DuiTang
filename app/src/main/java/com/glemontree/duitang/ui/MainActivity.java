package com.glemontree.duitang.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.view.ViewPager;
import android.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewConfiguration;

import com.astuetz.PagerSlidingTabStrip;
import com.glemontree.duitang.R;

import java.lang.reflect.Field;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class MainActivity extends AppCompatActivity {
    @InjectView(R.id.pager)
    ViewPager mViewPager;

    @InjectView(R.id.indicator)
    PagerSlidingTabStrip mIndicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
        setActionBar();
//        FragmentAdapter mAdapter = new FragmentAdapter(getFragmentManager());
//        mViewPager.setAdapter(mAdapter);
//        mIndicator.setViewPager(mViewPager);
    }

    private void setActionBar() {
        Bitmap mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.user_default_face);
        android.support.v7.app.ActionBar mActionbar = getSupportActionBar();
        mActionbar.setIcon(new CircleImageDrawable(mBitmap));
        mActionbar.setTitle("用户");
        mActionbar.setHomeButtonEnabled(true);
        setOverflowShowingAlways();
    }

    private void setOverflowShowingAlways() {
        // 通过反射设置显示overflow按钮，即使有物理menu按键
        try {
            ViewConfiguration config = ViewConfiguration.get(this);
            Field munuKeyField = ViewConfiguration.class.getDeclaredField("sHasPermanentMenuKey");
            munuKeyField.setAccessible(true);
            munuKeyField.setBoolean(config, false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case android.R.id.home:
//                Intent i = new Intent(this, PersonActivity.class);
//                startActivity(i);
                break;
            case R.id.action_settings:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
