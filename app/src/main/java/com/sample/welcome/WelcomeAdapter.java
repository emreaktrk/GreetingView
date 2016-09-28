package com.sample.welcome;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.emreakturk.greetingview.GreetingView;


public final class WelcomeAdapter extends GreetingView.Adapter {


    public WelcomeAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case LeftFragment.POSITION:
                return new LeftFragment();
            case CenterFragment.POSITION:
                return new CenterFragment();
            case RightFragment.POSITION:
                return new RightFragment();
            default:
                throw new IllegalArgumentException("Fragment not found.");
        }
    }
}
