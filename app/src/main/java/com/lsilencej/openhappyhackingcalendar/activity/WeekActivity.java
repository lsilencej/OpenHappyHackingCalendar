package com.lsilencej.openhappyhackingcalendar.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.lsilencej.openhappyhackingcalendar.R;
import com.lsilencej.openhappyhackingcalendar.databinding.ActivityWeekBinding;

public class WeekActivity extends AppCompatActivity {

    private ActivityWeekBinding activityWeekBinding;

    float y1 = 0;
    float y2 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        activityWeekBinding = ActivityWeekBinding.inflate(getLayoutInflater());
        setContentView(activityWeekBinding.getRoot());
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            y1 = event.getY();
        }
        if (event.getAction() == MotionEvent.ACTION_UP) {
            y2 = event.getY();
            if (y2 - y1 > 50) {
                startActivity(new Intent(this, MonthActivity.class));
                overridePendingTransition(R.anim.in_from_top, R.anim.out_to_bottom);
                finish();
            }
        }
        return super.onTouchEvent(event);
    }
}