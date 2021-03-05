package kr.teamcadi.myapa.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import java.util.ArrayList;

import kr.teamcadi.myapa.R;
import kr.teamcadi.myapa.adapter.ReportAdapter;
import kr.teamcadi.myapa.domain.Report;

// 화면 설명 : 복약 리포트 화면 -> 사이드바의 데일리 리포트와 연결
// Author : Soohyun, Last Modified : 2020.02.18
public class ReportActivity extends AppCompatActivity {
    Toolbar toolbar; // 상단바
    RecyclerView rv_report; // 복약리포트 리사이클러뷰
    ReportAdapter adapter; // 복약리포트 어댑터
    ArrayList<Report> medicineList = new ArrayList<>(); // 복약해야할 약 리스트
    ImageButton btn_add_medicine; // 약 추가하기 버튼

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);

        // 상단바 설정
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false); // 기본 타이틀 삭제
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //back버튼

        init(); // 임시 데이터 추가

        rv_report = findViewById(R.id.rv_report);
        btn_add_medicine = findViewById(R.id.btn_add_medicine);

        rv_report.setLayoutManager(new LinearLayoutManager(this)); // 리사이클러뷰와 레이아웃 매니저 연결

        adapter = new ReportAdapter(medicineList); // 어댑터와 복약해야할 약 리스트 연결
        rv_report.setAdapter(adapter); // 리사이클러뷰와 어댑터 연결
        adapter.notifyDataSetChanged(); // 어댑터에게 데이터 변화를 알려줌

        // 약 추가하기 버튼 클릭시 -> 약 추가하기 화면(ReportAddActivity)로 이동
        btn_add_medicine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ReportActivity.this, ReportAddActivity.class));
            }
        });

    }

    // 상단바 오른쪽 메뉴
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.report_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:{ // 상단바의 back키 눌렀을 때
                finish();
                return true;
            }
            case R.id.menu_calendar: { // 상단바 오른쪽의 캘린더 아이콘 눌렀을 때
                startActivity(new Intent(ReportActivity.this, CalendarActivity.class)); // 캘린더 화면으로 이동
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }

    // 임시 데이터 추가하는 메소드
    public void init() {
        medicineList.add(new Report("올로파뇰 점안액", "오전 08:00", false));
        medicineList.add(new Report("싸이포린엔 점안액", "오전 10:00", true));
    }
}