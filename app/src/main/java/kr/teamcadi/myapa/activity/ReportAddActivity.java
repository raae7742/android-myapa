package kr.teamcadi.myapa.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.TimePicker;

import kr.teamcadi.myapa.R;

// 화면 설명 : 약 추가 화면
// Author : Kim Seung Hyun, Soohyun Last Modified : 2021.02.20
public class ReportAddActivity extends AppCompatActivity {
    Toolbar toolbar; // 상단바
    TextView tv_select_time1; // 선택된 시간 텍스트
    TextView tv_select_time2; // 선택된 시간 텍스트

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report_add);

        // 상단바 설정
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false); // 기본 타이틀 삭제
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //back버튼

        tv_select_time1 = findViewById(R.id.tv_select_time1);
        tv_select_time2 = findViewById(R.id.tv_select_time2);

        // 시간 텍스트 클릭시 시간 설정 다이얼로그 실행
        tv_select_time1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TimePickerDialog dialog = new TimePickerDialog(ReportAddActivity.this, android.R.style.Theme_Holo_Light_Dialog, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int hour, int minute) {
                        tv_select_time1.setText(hour + ":" + minute);
                    }
                }, 15,24,false);
                dialog.show();
            }
        });

        // 시간 텍스트 클릭시 시간 설정 다이얼로그 실행
        tv_select_time2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TimePickerDialog dialog = new TimePickerDialog(ReportAddActivity.this, android.R.style.Theme_Holo_Light_Dialog, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int hour, int minute) {
                        tv_select_time2.setText(hour + ":" + minute);
                    }
                }, 15,24,false);
                dialog.show();
            }
        });
    }

    // 상단바 오른쪽 메뉴
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.report_add_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:{ // 상단바의 back키 눌렀을 때
                finish();
                return true;
            }
            case R.id.menu_calendar: { // 상단바 오른쪽의 휴지통 아이콘 눌렀을 때
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }
}