package com.sample;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.emreakturk.greetingview.GreetingView;
import com.sample.base.BaseActivity;
import com.sample.welcome.WelcomeAdapter;

public class MainActivity extends BaseActivity {


    private GreetingView mGreetingView;

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_main;
    }

    @Override
    public void onContentChanged() {
        super.onContentChanged();

        mGreetingView = (GreetingView) findViewById(R.id.main_greetingview);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        WelcomeAdapter adapter = new WelcomeAdapter(getSupportFragmentManager());
        mGreetingView.setAdapter(adapter);
    }
}
