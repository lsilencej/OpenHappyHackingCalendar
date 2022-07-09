package com.lsilencej.openhappyhackingcalendar.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.haibin.calendarview.Calendar;
import com.lsilencej.openhappyhackingcalendar.R;
import com.lsilencej.openhappyhackingcalendar.databinding.ActivityWeekBinding;
import com.sunfusheng.codeviewer.CodeHtmlGenerator;
import com.sunfusheng.codeviewer.CodeView;
import com.sunfusheng.codeviewer.CodeViewUtil;

import java.util.Arrays;
import java.util.List;

public class WeekActivity extends AppCompatActivity {

    private ActivityWeekBinding activityWeekBinding;

    private List<Calendar> calendars;

    private String[] weekName = new String[] {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
    private String[] lunars = new String[] {"初一", "初二", "初三", "初四", "初五", "初六", "初七", "初八", "初九", "初十",
            "十一", "十二", "十三", "十四", "十五", "十六", "十七", "十八", "十九",
            "廿一", "廿二", "廿三", "廿四", "廿五", "廿六", "廿七", "廿八", "廿九", "三十"};
    private List<String> lunarList = Arrays.asList(lunars);

    private float y1 = 0;
    private float y2 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        activityWeekBinding = ActivityWeekBinding.inflate(getLayoutInflater());
        setContentView(activityWeekBinding.getRoot());
        initView();
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

    private void initView() {
        calendars = (List<Calendar>) getIntent().getSerializableExtra("calendars");
        for (int i = 0; i < calendars.size(); i++) {
            Calendar calendar = calendars.get(i);
            int year = calendar.getYear();
            int month = calendar.getMonth();
            int day = calendar.getDay();
            int week = calendar.getWeek();
            String lunar = calendar.getLunar();
            Log.d("lsilencej", calendar.getTraditionFestival());
            Log.d("lsilencej", calendar.getGregorianFestival());
            String halfDay = (month > 9 ? month : "0" + month) + "-" + (day > 9 ? day : "0" + day);
            switch (i) {
                case 0:
                    if (!lunarList.contains(lunar)) {
                        activityWeekBinding.tvLunarMon.setTextColor(0xFFFF4444);
                    }
                    if (calendar.isCurrentDay()) {
                        activityWeekBinding.tvDayMon.setTextColor(0xFFCCCCCC);
                        activityWeekBinding.tvLunarMon.setTextColor(0xFFCCCCCC);
                    }
                    activityWeekBinding.tvDayMon.setText(halfDay);
                    activityWeekBinding.tvLunarMon.setText(lunar);
                    break;
                case 1:
                    if (!lunarList.contains(lunar)) {
                        activityWeekBinding.tvLunarTue.setTextColor(0xFFFF4444);
                    }
                    if (calendar.isCurrentDay()) {
                        activityWeekBinding.tvDayTue.setTextColor(0xFFCCCCCC);
                        activityWeekBinding.tvLunarTue.setTextColor(0xFFCCCCCC);
                    }
                    activityWeekBinding.tvDayTue.setText(halfDay);
                    activityWeekBinding.tvLunarTue.setText(lunar);
                    break;
                case 2:
                    if (!lunarList.contains(lunar)) {
                        activityWeekBinding.tvLunarWed.setTextColor(0xFFFF4444);
                    }
                    if (calendar.isCurrentDay()) {
                        activityWeekBinding.tvDayWed.setTextColor(0xFFCCCCCC);
                        activityWeekBinding.tvLunarWed.setTextColor(0xFFCCCCCC);
                    }
                    activityWeekBinding.tvDayWed.setText(halfDay);
                    activityWeekBinding.tvLunarWed.setText(lunar);
                    break;
                case 3:
                    if (!lunarList.contains(lunar)) {
                        activityWeekBinding.tvLunarThu.setTextColor(0xFFFF4444);
                    }
                    if (calendar.isCurrentDay()) {
                        activityWeekBinding.tvDayThu.setTextColor(0xFFCCCCCC);
                        activityWeekBinding.tvLunarThu.setTextColor(0xFFCCCCCC);
                    }
                    activityWeekBinding.tvDayThu.setText(halfDay);
                    activityWeekBinding.tvLunarThu.setText(lunar);
                    break;
                case 4:
                    if (!lunarList.contains(lunar)) {
                        activityWeekBinding.tvLunarFri.setTextColor(0xFFFF4444);
                    }
                    if (calendar.isCurrentDay()) {
                        activityWeekBinding.tvDayFri.setTextColor(0xFFCCCCCC);
                        activityWeekBinding.tvLunarFri.setTextColor(0xFFCCCCCC);
                    }
                    activityWeekBinding.tvDayFri.setText(halfDay);
                    activityWeekBinding.tvLunarFri.setText(lunar);
                    break;
                case 5:
                    if (!lunarList.contains(lunar)) {
                        activityWeekBinding.tvLunarSat.setTextColor(0xFFFF4444);
                    }
                    if (calendar.isCurrentDay()) {
                        activityWeekBinding.tvDaySat.setTextColor(0xFFCCCCCC);
                        activityWeekBinding.tvLunarSat.setTextColor(0xFFCCCCCC);
                    }
                    activityWeekBinding.tvDaySat.setText(halfDay);
                    activityWeekBinding.tvLunarSat.setText(lunar);
                    break;
                case 6:
                    if (!lunarList.contains(lunar)) {
                        activityWeekBinding.tvLunarSun.setTextColor(0xFFFF4444);
                    }
                    if (calendar.isCurrentDay()) {
                        activityWeekBinding.tvDaySun.setTextColor(0xFFCCCCCC);
                        activityWeekBinding.tvLunarSun.setTextColor(0xFFCCCCCC);
                    }
                    activityWeekBinding.tvDaySun.setText(halfDay);
                    activityWeekBinding.tvLunarSun.setText(lunar);
                    break;
            }
            if (calendars.get(i).isCurrentDay()) {
                String fullDay = year + "-" + (month > 9 ? month : "0" + month) + "-" + (day > 9 ? day : "0" + day);
                activityWeekBinding.tvFullDay.setText(fullDay);
                if (week == 6 || week == 0) {
                    activityWeekBinding.tvWeek.setTextColor(0xFFFF4444);
                } else {
                    activityWeekBinding.tvWeek.setTextColor(0xFF000000);
                }
                activityWeekBinding.tvWeek.setText(weekName[week]);
                activityWeekBinding.tvLunar.setText(lunar);
            }
//            Log.d("lsilencej", calendars.get(i).getLunar());
        }
        CodeView codeView = findViewById(R.id.code_view);
        String sourceCode = CodeViewUtil.INSTANCE.getStringFromAssetsFile(getApplicationContext(), "codes/HackingDate.go");
        String sourceCodeHtml = CodeHtmlGenerator.INSTANCE.generate("codes/HackingDate.v", sourceCode, false, false);
        codeView.loadCodeHtml(sourceCodeHtml);
    }
}