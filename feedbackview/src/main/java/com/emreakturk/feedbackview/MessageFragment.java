package com.emreakturk.feedbackview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public final class MessageFragment extends Fragment implements View.OnClickListener {


    static final int POSITION = 0;

    private EditText mMessageView;
    private Button mSendView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.component_message, container, false);
        mMessageView = (EditText) view.findViewById(R.id.message_messageview);
//            mSendView = view.findViewById(R.id.message_sendview);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mMessageView.setOnClickListener(this);
//        mSendView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

    }
}