package com.emreakturk.feedbackview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.AppCompatEditText;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;


public final class FeedbackView extends ViewPager implements View.OnClickListener {


    public FeedbackView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void init(FragmentManager manager) {
        Adapter adapter = new Adapter(manager);
        setAdapter(adapter);
        setCurrentItem(DecisionFragment.POSITION, false);
    }

    @Override
    public void onClick(View view) {

    }


    private class Adapter extends FragmentPagerAdapter {

        private Adapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case MessageFragment.POSITION:
                    return new MessageFragment();
                case DecisionFragment.POSITION:
                    return new DecisionFragment();
                default:
                    throw new IllegalArgumentException("Undefined position.");
            }
        }

        @Override
        public int getCount() {
            return 2;
        }

        @Override
        public float getPageWidth(int position) {
            if (position == 0) {
                return .8f;
            }

            return super.getPageWidth(position);
        }
    }
}
