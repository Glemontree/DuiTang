package com.glemontree.duitang.ui;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.view.ScrollingView;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ScrollView;

import com.glemontree.duitang.R;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by Administrator on 2016/10/29.
 */

public class PersonActivity extends AppCompatActivity implements ScrollNotifyView.OnScrollListener {
    @InjectView(R.id.scroll_view)
    ScrollNotifyView mScrollView;

    ActionBar mActionBar;
    private ColorDrawable actionBarBackground;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person);
        ButterKnife.inject(this);
        Animation alphaShow = AnimationUtils.loadAnimation(this, R.anim.alpha_show);
        mScrollView.startAnimation(alphaShow);
//        setActionBar();
        initView();
    }

    private void initView() {
        mScrollView.setOnScrollListener(this);
    }

    @Override
    public void onScroll(int l, int t, int oldl, int oldt) {
        // do something
    }
}
