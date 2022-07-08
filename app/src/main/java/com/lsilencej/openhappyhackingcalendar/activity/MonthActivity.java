package com.lsilencej.openhappyhackingcalendar.activity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.lsilencej.openhappyhackingcalendar.databinding.ActivityMonthBinding;

import java.util.Calendar;

public class MonthActivity extends AppCompatActivity {

    private ActivityMonthBinding activityMonthBinding;

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
        Calendar calendar = Calendar.getInstance();
        int month = calendar.get(Calendar.MONTH);
        String[] monthName = new String[] {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        activityMonthBinding.tvMonth.setText(monthName[month]);
    }
}