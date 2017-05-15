package com.example.lixuantingpc.customviewapp;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by LiXuantingPC on 2017/5/15.
 */
public class CustomView extends View {

    private Paint mTextPaint;
    private Paint mImagePaint;
    private Paint mBackgroundPaint;
    private Rect mBounds;
    private Bitmap mBitmap;

    private String mInfo;
    private boolean mIsSelect;
    private boolean mIsBackgroundBlue;
    private int[] mBackGroundColor;

    private int mCustomViewWidth;
    private int mCustomViewHeight;
    private int mCustomViewRound;
    private int mCircleRadius;
    private int mCircleX;
    private int mCircleY;
    private int mTextX;
    private int mBitmapLeft;
    private int mBitmapTop;

    public CustomView(Context context) {
        this(context, null);
    }

    public CustomView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mBitmap = BitmapFactory.decodeResource(context.getResources(),R.drawable.cat_check);
        mBackGroundColor = new int[]{Color.GRAY,Color.BLUE,Color.GREEN};
        mCircleRadius = context.getResources().getDimensionPixelSize(R.dimen.circle_radius);
        mCircleX = context.getResources().getDimensionPixelSize(R.dimen.circle_x);
        mCircleY = context.getResources().getDimensionPixelSize(R.dimen.circle_y);
        mTextX = context.getResources().getDimensionPixelSize(R.dimen.text_x);
        mBitmapLeft = context.getResources().getDimensionPixelSize(R.dimen.bitmap_left);
        mBitmapTop = context.getResources().getDimensionPixelSize(R.dimen.bitmap_top);
        mCustomViewWidth = context.getResources().getDimensionPixelSize(R.dimen.custom_view_width);
        mCustomViewHeight = context.getResources().getDimensionPixelSize(R.dimen.custom_view_height);
        mCustomViewRound = context.getResources().getDimensionPixelSize(R.dimen.custom_view_round);

        mTextPaint = new Paint();
        mTextPaint.setAntiAlias(true);
        mTextPaint.setColor(Color.WHITE);
        mTextPaint.setTextSize(context.getResources().getDimensionPixelSize(R.dimen.text_paint_size));

        mImagePaint = new Paint();
        mImagePaint.setAntiAlias(true);
        mImagePaint.setStyle(Paint.Style.STROKE);

        mBackgroundPaint = new Paint();
        mBackgroundPaint.setAntiAlias(true);

        mBounds = new Rect();
    }

    public void setInfo(String info){
        this.mInfo = info;
    }

    public void setIsSelect(boolean isSelect){
        this.mIsSelect = isSelect;
    }

    public void setIsBackgroundBlue(boolean isBlue){
        this.mIsBackgroundBlue = isBlue;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if(mIsSelect){
            if(mIsBackgroundBlue){
                //setBackgroundColor(mBackGroundColor[1]);
                mBackgroundPaint.setColor(mBackGroundColor[1]);
                canvas.drawRoundRect(new RectF(0, 0, mCustomViewWidth, mCustomViewHeight), mCustomViewRound, mCustomViewRound, mBackgroundPaint);
                canvas.drawBitmap(mBitmap, mBitmapLeft, mBitmapTop, mImagePaint);
            }else{
                //setBackgroundColor(mBackGroundColor[2]);
                mBackgroundPaint.setColor(mBackGroundColor[2]);
                canvas.drawRoundRect(new RectF(0, 0, mCustomViewWidth, mCustomViewHeight), mCustomViewRound, mCustomViewRound, mBackgroundPaint);
                canvas.drawBitmap(mBitmap, mBitmapLeft, mBitmapTop, mImagePaint);
            }
        }else{
            //setBackgroundColor(mBackGroundColor[0]);
            mBackgroundPaint.setColor(mBackGroundColor[0]);
            canvas.drawRoundRect(new RectF(0, 0, mCustomViewWidth, mCustomViewHeight), mCustomViewRound, mCustomViewRound, mBackgroundPaint);
            canvas.drawCircle(mCircleX, mCircleY, mCircleRadius, mImagePaint);
        }

        mTextPaint.getTextBounds(mInfo,0,mInfo.length(),mBounds);
        canvas.drawText(mInfo, mTextX, getMeasuredHeight() / 2 + mBounds.height() / 2, mTextPaint);
    }
}
