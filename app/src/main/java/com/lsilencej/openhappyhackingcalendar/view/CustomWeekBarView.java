package com.lsilencej.openhappyhackingcalendar.view;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.widget.TextView;

import com.haibin.calendarview.WeekBar;
import com.lsilencej.openhappyhackingcalendar.R;

public class CustomWeekBarView extends WeekBar {

    public CustomWeekBarView(Context context) {
        super(context);
        LayoutInflater.from(context).inflate(R.layout.view_week_bar, this, true);
        int padding = dipToPx(context, 10);
        setPadding(padding, 0, padding, 0);
        Typeface typeface = Typeface.createFromAsset(context.getAssets(), "fonts/SpaceMono.ttf");
        setTypeface(typeface);
        setTextSize(20);
    }

    @Override
    protected void setTextSize(int size) {
        for (int i = 0; i < getChildCount(); i++) {
            ((TextView) getChildAt(i)).setTextSize(size);
        }
    }

    @Override
    protected void onWeekStartChange(int weekStart) {
        int nightMode = getContext().getResources().getConfiguration().uiMode & Configuration.UI_MODE_NIGHT_MASK;
        if (nightMode == Configuration.UI_MODE_NIGHT_YES) {
            for (int i = 0; i < getChildCount(); i++) {
                ((TextView) getChildAt(i)).setTextColor(0xFFA9A9B3);
            }
        }
        for (int i = 0; i < getChildCount(); i++) {
            ((TextView) getChildAt(i)).setText(getWeekString(i, weekStart));
            if (i == 5 || i == 6) {
                ((TextView) getChildAt(i)).setTextColor(0xFFFF4444);
            }
        }
    }

    private String getWeekString(int index, int weekStart) {
        String[] weeks = getContext().getResources().getStringArray(R.array.english_week_string_array);

        if (weekStart == 1) {
            return weeks[index];
        }
        if (weekStart == 2) {
            return weeks[index == 6 ? 0 : index + 1];
        }
        return weeks[index == 0 ? 6 : index - 1];
    }

    private void setTypeface(Typeface typeface) {
        for (int i = 0; i < getChildCount(); i++) {
            ((TextView) getChildAt(i)).setTypeface(typeface);
        }
    }

    private static int dipToPx(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

}
