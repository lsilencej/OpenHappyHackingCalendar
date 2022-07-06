package com.lsilencej.openhappyhackingcalendar.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.lsilencej.openhappyhackingcalendar.databinding.ActivityMouthBinding;

import java.util.Calendar;

public class MouthActivity extends AppCompatActivity {

    private ActivityMouthBinding activityMouthBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        activityMouthBinding = ActivityMouthBinding.inflate(getLayoutInflater());
        setContentView(activityMouthBinding.getRoot());
        initView();
    }

    private void initView() {
        Calendar calendar = Calendar.getInstance();
    }
}