package com.glemontree.duitang.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.AbsListView;
import android.widget.ScrollView;

/**
 * Created by Administrator on 2016/10/30.
 */

public class ScrollNotifyView extends ScrollView {

    private OnScrollListener mOnScrollListener;

    public ScrollNotifyView(Context context) {
        super(context);
    }

    public ScrollNotifyView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ScrollNotifyView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public interface OnScrollListener {
        void onScroll(int l, int t, int oldl, int oldt);
    }

    public void setOnScrollListener(OnScrollListener l) {
        mOnScrollListener = l;
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        mOnScrollListener.onScroll(l, t, oldl, oldt);
    }
}
