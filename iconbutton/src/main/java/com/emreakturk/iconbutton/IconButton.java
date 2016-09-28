package com.emreakturk.iconbutton;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.Button;


public class IconButton extends Button implements Runnable {

    private Rect mRect;
    private Paint mPaint;
    private Drawable mDrawable;
    private int mColor;

    public IconButton(Context context, AttributeSet attrs) {
        super(context, attrs);

        initAttributes(attrs);
        initDefaults();
    }

    public IconButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        initAttributes(attrs);
        initDefaults();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public IconButton(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);

        initAttributes(attrs);
        initDefaults();
    }

    private void initDefaults() {
        post(this);
    }

    private void initAttributes(AttributeSet attrs) {
        TypedArray typedArray = getContext().getTheme().obtainStyledAttributes(attrs, R.styleable.IconButton, 0, 0);

        mDrawable = typedArray.getDrawable(R.styleable.IconButton_leftDrawable);
        mColor = typedArray.getColor(R.styleable.IconButton_leftColor, Color.TRANSPARENT);

        typedArray.recycle();
    }

    @SuppressWarnings("SuspiciousNameCombination")
    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();

        boolean inEditMode = isInEditMode();
        if (inEditMode) {
            int height = getLayoutParams().height;
            boolean fixedSize = height > 0;
            if (fixedSize) {
                setPadding(height, 0, 0, 0);
            }
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawRect(getRect(), getLeftPaint());
        getLeftDrawable().draw(canvas);

        super.onDraw(canvas);
    }

    @SuppressWarnings("SuspiciousNameCombination")
    private Rect getRect() {
        if (mRect == null) {
            mRect = new Rect();
            mRect.top = 0;
            mRect.left = 0;
            mRect.right = getHeight();
            mRect.bottom = getHeight();
        }

        return mRect;
    }

    private Paint getLeftPaint() {
        if (mPaint == null) {
            mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
            mPaint.setColor(mColor);
        }

        return mPaint;
    }

    private Drawable getLeftDrawable() {
        if (mDrawable == null) {
            return new ColorDrawable(Color.TRANSPARENT);
        }

        Rect rect = mDrawable.copyBounds();
        boolean isEmpty = rect.isEmpty();
        if (isEmpty) {
            mDrawable.setBounds(getRect());
        }


        return mDrawable;
    }

    @Override
    public void run() {
        int padding = getHeight();
        setPadding(padding, 0, 0, 0);
    }
}
