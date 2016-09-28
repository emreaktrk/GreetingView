package com.emreakturk.feedbackview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;

public final class DecisionFragment extends Fragment implements View.OnClickListener {


    static final int POSITION = 1;

    private RadioButton mPositiveView;
    private RadioButton mNegativeView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.component_decision, container, false);
        mPositiveView = (RadioButton) view.findViewById(R.id.decision_positiveview);
        mNegativeView = (RadioButton) view.findViewById(R.id.decision_negativeview);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mPositiveView.setOnClickListener(this);
        mNegativeView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

    }
}