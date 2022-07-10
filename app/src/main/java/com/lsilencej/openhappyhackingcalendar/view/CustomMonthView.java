package com.lsilencej.openhappyhackingcalendar.view;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.view.View;

import com.haibin.calendarview.Calendar;
import com.haibin.calendarview.MonthView;

public class CustomMonthView extends MonthView {

    private static final int TEXT_SIZE = 20;
    private static final int LUNAR_TEXT_SIZE = 15;

    private final Paint mRectPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private final Paint mCurrentDayTextPaint = new Paint();
    private final Paint mCurrentDayLunarTextPaint = new Paint();
    private final Paint mSimpleDayTextPaint = new Paint();
    private final Paint mSimpleDayLunarTextPaint = new Paint();
    private final Paint mWeekendTextPaint = new Paint();
    private final Paint mWeekendLunarTextPaint = new Paint();

    public CustomMonthView(Context context) {
        super(context);

        int nightMode = getContext().getResources().getConfiguration().uiMode & Configuration.UI_MODE_NIGHT_MASK;

        Typeface typeface = Typeface.createFromAsset(context.getAssets(), "fonts/SpaceMono.ttf");
        mRectPaint.setTypeface(typeface);
        mRectPaint.setStyle(Paint.Style.STROKE);
        mRectPaint.setStrokeWidth(dipToPx(context, 0.5f));
        mRectPaint.setColor(nightMode == Configuration.UI_MODE_NIGHT_YES ? 0xFFA9A9B3 : 0xFFFFFFFF);

        mCurrentDayTextPaint.setTypeface(typeface);
        mCurrentDayTextPaint.setAntiAlias(true);
        mCurrentDayTextPaint.setTextAlign(Paint.Align.CENTER);
        mCurrentDayTextPaint.setColor(0xFFCCCCCC);
        mCurrentDayTextPaint.setFakeBoldText(true);
        mCurrentDayTextPaint.setTextSize(dipToPx(context, TEXT_SIZE));

        mCurrentDayLunarTextPaint.setTypeface(typeface);
        mCurrentDayLunarTextPaint.setAntiAlias(true);
        mCurrentDayLunarTextPaint.setTextAlign(Paint.Align.CENTER);
        mCurrentDayLunarTextPaint.setColor(0xFFCCCCCC);
        mCurrentDayLunarTextPaint.setTextSize(dipToPx(context, LUNAR_TEXT_SIZE));

        mSimpleDayTextPaint.setTypeface(typeface);
        mSimpleDayTextPaint.setAntiAlias(true);
        mSimpleDayTextPaint.setTextAlign(Paint.Align.CENTER);
        mSimpleDayTextPaint.setColor(nightMode == Configuration.UI_MODE_NIGHT_YES ? 0xFFA9A9B3 : 0xFF000000);
        mSimpleDayTextPaint.setFakeBoldText(true);
        mSimpleDayTextPaint.setTextSize(dipToPx(context, TEXT_SIZE));

        mSimpleDayLunarTextPaint.setTypeface(typeface);
        mSimpleDayLunarTextPaint.setAntiAlias(true);
        mSimpleDayLunarTextPaint.setTextAlign(Paint.Align.CENTER);
        mSimpleDayLunarTextPaint.setColor(nightMode == Configuration.UI_MODE_NIGHT_YES ? 0xFFA9A9B3 : 0xFF000000);
        mSimpleDayLunarTextPaint.setTextSize(dipToPx(context, LUNAR_TEXT_SIZE));

        mWeekendTextPaint.setTypeface(typeface);
        mWeekendTextPaint.setAntiAlias(true);
        mWeekendTextPaint.setTextAlign(Paint.Align.CENTER);
        mWeekendTextPaint.setColor(0xFFFF4444);
        mWeekendTextPaint.setFakeBoldText(true);
        mWeekendTextPaint.setTextSize(dipToPx(context, TEXT_SIZE));

        mWeekendLunarTextPaint.setTypeface(typeface);
        mWeekendLunarTextPaint.setAntiAlias(true);
        mWeekendLunarTextPaint.setTextAlign(Paint.Align.CENTER);
        mWeekendLunarTextPaint.setColor(0xFFFF4444);
        mWeekendLunarTextPaint.setTextSize(dipToPx(context, LUNAR_TEXT_SIZE));

    }

    @Override
    protected boolean onDrawSelected(Canvas canvas, Calendar calendar, int x, int y, boolean hasScheme) {
        return true;
    }

    @Override
    protected void onDrawScheme(Canvas canvas, Calendar calendar, int x, int y) {
    }

    @Override
    protected void onDrawText(Canvas canvas, Calendar calendar, int x, int y, boolean hasScheme, boolean isSelected) {
        canvas.drawRect(x, y, x + mItemWidth, y + mItemHeight, mRectPaint);
        int cx = x + mItemWidth / 2;
        int top = y - mItemHeight / 6;
        int space = mItemHeight / 10;
        canvas.drawText(String.valueOf(calendar.getDay()), cx, mTextBaseLine + top, calendar.isCurrentDay() ? mCurrentDayTextPaint : calendar.isWeekend() ? mWeekendTextPaint : mSimpleDayTextPaint);
        canvas.drawText(calendar.getLunar(), cx, mTextBaseLine + y + space, calendar.isCurrentDay() ? mCurrentDayLunarTextPaint : calendar.isWeekend() ? mWeekendLunarTextPaint : mSimpleDayLunarTextPaint);
        canvas.drawText(calendar.getSolarTerm(), cx, mTextBaseLine + y + space, calendar.isCurrentDay() ? mCurrentDayLunarTextPaint : mWeekendLunarTextPaint);
        canvas.drawText(calendar.getTraditionFestival(), cx, mTextBaseLine + y + space, calendar.isCurrentDay() ? mCurrentDayLunarTextPaint : mWeekendLunarTextPaint);
        canvas.drawText(calendar.getGregorianFestival(), cx, mTextBaseLine + y + space, calendar.isCurrentDay() ? mCurrentDayLunarTextPaint : mWeekendLunarTextPaint);
    }

    @Override
    public void onClick(View v) {

    }

    private static int dipToPx(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }
}
