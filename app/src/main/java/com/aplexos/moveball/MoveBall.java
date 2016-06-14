package com.aplexos.moveball;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by aplex on 16-6-13.
 */
public class MoveBall extends View implements View.OnClickListener {

    private String mText;
    private Paint mPaint;

    public MoveBall(Context context) {
        this(context, null);
    }

    public MoveBall(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MoveBall(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        TypedArray typedArray = context.getTheme().obtainStyledAttributes(attrs, R.styleable.MoveBall, defStyleAttr, 0);
        int n = typedArray.getIndexCount();
        for (int i = 0; i < n; i++) {
            int attr = typedArray.getIndex(i);
            switch (attr) {
                case R.styleable.MoveBall_text:
                    mText = typedArray.getString(attr);
                    break;
            }

        }
        typedArray.recycle();

        mPaint = new Paint();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        mPaint.setColor(Color.YELLOW);
        mPaint.setStyle(Paint.Style.FILL);

        RectF oval = new RectF();
        oval.left = 0;
        oval.top = 0;
        oval.right = getMeasuredWidth();
        oval.bottom = getMeasuredHeight();
        canvas.drawArc(oval, 0, 90, false, mPaint);    //绘制圆弧

        canvas.drawArc(oval, -90, -90, true, mPaint);    //绘制圆弧

        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(10);

        canvas.drawCircle(getMeasuredWidth()/2, getMeasuredHeight()/2, 180, mPaint);

        mPaint.setColor(Color.BLACK);
        mPaint.setTextSize(180);

        canvas.save();
        canvas.translate(getWidth()/2 - 250, getHeight()/2);
        canvas.drawText("zengjf", 0, 0, mPaint);
        canvas.restore();
        //canvas.drawText("zengjf", 80, 150, mPaint);

        canvas.drawLine(0, 0, getMeasuredWidth(), getMeasuredHeight(), mPaint);
    }

    @Override
    public void onClick(View v) {

    }
}
