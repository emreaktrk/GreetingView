package com.emreakturk.greetingview;


import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.Display;
import android.view.WindowManager;

public class GreetingView extends ViewPager {


    public GreetingView(Context context, AttributeSet attrs) {
        super(context, attrs);

        initDefaults();
    }

    private void initDefaults() {
        setOffscreenPageLimit(3);
        setOverScrollMode(OVER_SCROLL_NEVER);
    }

    protected float calculateSideWidth() {
        WindowManager manager = (WindowManager) getContext().getSystemService(Context.WINDOW_SERVICE);
        Display display = manager.getDefaultDisplay();

        float height = getLayoutParams().height;
        float width = display.getWidth();

        return height / width;
    }

    @Override
    public void setAdapter(PagerAdapter pagerAdapter) {
        boolean isFactory = pagerAdapter instanceof Adapter;
        if (!isFactory) {
            throw new IllegalArgumentException("Considered Greeting.Adapter Object.");
        }

        Adapter adapter = (Adapter) pagerAdapter;
        adapter.mSideWidth = calculateSideWidth();

        super.setAdapter(adapter);
        setCurrentItem(1);
    }


    public static abstract class Adapter extends FragmentPagerAdapter {


        private float mSideWidth;

        public Adapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public float getPageWidth(int position) {
            if (position == 0 || position == 2) {
                return mSideWidth;
            }

            return super.getPageWidth(position);
        }
    }
}
