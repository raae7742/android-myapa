package kr.teamcadi.myapa.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Calendar;

import kr.teamcadi.myapa.R;
import kr.teamcadi.myapa.activity.CalendarActivity;
import kr.teamcadi.myapa.adapter.CalendarAdapter;
import kr.teamcadi.myapa.domain.Comment;
import kr.teamcadi.myapa.domain.Report;

// 화면 설명 : 캘린더 팝업 화면
// Author : Hyeonae, Last Modified : 2021.02.21
public class CalendarDialog extends Dialog {
    private Context context;
    private ImageButton ib_exit;

    RecyclerView rv_calendar = null;
    CalendarAdapter calendarAdapter = null;
    ArrayList<Report> reportList = new ArrayList<>();

    public CalendarDialog(@NonNull Context context) {
        super(context);
        this.context = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_calendar);

        ib_exit = findViewById(R.id.ib_exit);

        // 복약 기록을 보여주는 리싸이클러뷰
        rv_calendar = findViewById(R.id.rv_calendar);

        init();
        calendarAdapter = new CalendarAdapter(reportList);
        rv_calendar.setAdapter(calendarAdapter);

        rv_calendar.setLayoutManager(new LinearLayoutManager(getContext()));
        //addItem();

        calendarAdapter.notifyDataSetChanged();
    }

    public void addItem(String name, String time, boolean isChecked) {
        Report report = new Report(name, time, isChecked);
        reportList.add(report);
    }

    public void init() {
        reportList.add(new Report("올로파뇰 점안액", "오전 08:00", false));
        reportList.add(new Report("싸이포린엔 점안액", "오전 10:00", true));
    }
}
