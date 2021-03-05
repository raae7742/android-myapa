package kr.teamcadi.myapa.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;
import com.prolificinteractive.materialcalendarview.OnDateSelectedListener;

import kr.teamcadi.myapa.R;
import kr.teamcadi.myapa.dialog.CalendarDialog;

// 화면 설명 : 캘린더뷰 화면
// Author : Hyeonae, Last Modified : 2021.02.24
public class CalendarActivity extends AppCompatActivity {
    Toolbar toolbar; // 상단바
    MaterialCalendarView calendarView;
    CalendarDialog calendarDialog;          // 캘린더 다이얼로그

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);

        // 다이얼로그 객체 생성
        calendarDialog = new CalendarDialog(this);
        calendarDialog.setContentView(R.layout.dialog_calendar);
        calendarDialog.setOwnerActivity(CalendarActivity.this);
        calendarDialog.setCanceledOnTouchOutside(true);

        // 상단바 설정
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false); //기본 타이틀 삭제
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //back버튼

        // 캘린더뷰 설정
        calendarView = (MaterialCalendarView)findViewById(R.id.cv_week);
        calendarView.setOnDateChangedListener(new OnDateSelectedListener() {
            @Override
            public void onDateSelected(@NonNull MaterialCalendarView widget, @NonNull CalendarDay date, boolean selected) {
                calendarDialog.show();  // 날짜 탭하면 다이얼로그 생성
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:{ //상단바의 back키 눌렀을 때
                finish();
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }

    public void onClick(View view){
        calendarDialog.dismiss();   // 다이얼로그의 x버튼 눌렀을 때
    }
}