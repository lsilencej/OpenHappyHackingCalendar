package com.lsilencej.openhappyhackingcalendar.activity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.haibin.calendarview.CalendarView;
import com.lsilencej.openhappyhackingcalendar.R;
import com.lsilencej.openhappyhackingcalendar.databinding.ActivityMonthBinding;

public class MonthActivity extends AppCompatActivity implements CalendarView.OnMonthChangeListener {

    private ActivityMonthBinding activityMonthBinding;

    private final String[] monthName = new String[] {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        activityMonthBinding = ActivityMonthBinding.inflate(getLayoutInflater());
        setContentView(activityMonthBinding.getRoot());
        initView();
    }

    private void initView() {
        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/SpaceMono.ttf");
        activityMonthBinding.tvMonth.setTypeface(typeface);
        activityMonthBinding.tvYear.setTypeface(typeface);
        CalendarView calendarView = findViewById(R.id.calendar_view);
        activityMonthBinding.tvMonth.setText(monthName[calendarView.getCurMonth() - 1]);
        activityMonthBinding.tvYear.setText(String.valueOf(calendarView.getCurYear()));
        calendarView.setOnMonthChangeListener(this);
    }

    @Override
    public void onMonthChange(int year, int month) {
//        Toast.makeText(this, monthName[month - 1], Toast.LENGTH_SHORT).show();
        activityMonthBinding.tvMonth.setText(monthName[month - 1]);
        activityMonthBinding.tvYear.setText(String.valueOf(year));
    }
}