package com.huida.kindergarten.activity.util;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by 赵发
 * 2017/10/23.
 */

public class NoCcroolViewPager extends ViewPager {

    private boolean isCanScroll=false;

    public NoCcroolViewPager(Context context) {
        super(context);
    }

    public NoCcroolViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void scrollTo(int x, int y) {
        super.scrollTo(x, y);
    }

    public void setScanScroll(boolean isCanScroll){
        this.isCanScroll = isCanScroll;
    }

    @Override
    public void setCurrentItem(int item) {
        super.setCurrentItem(item);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        if(isCanScroll){
            return super.onTouchEvent(ev);
        }else {
            return false;
        }
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        if(isCanScroll){
            return super.onInterceptTouchEvent(ev);
        }else{
            return false;
        }
    }
}
