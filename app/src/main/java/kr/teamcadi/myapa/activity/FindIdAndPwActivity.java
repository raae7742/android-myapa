package kr.teamcadi.myapa.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;

import kr.teamcadi.myapa.R;
import kr.teamcadi.myapa.fragment.FindIdFragment;
import kr.teamcadi.myapa.fragment.FindPwFragment;

// 화면 설명 : 아이디/비밀번호 찾기 화면
// Author : Soohyun, Last Modified : 2021.01.28
public class FindIdAndPwActivity extends AppCompatActivity {
    Toolbar toolbar; // 상단바
    TabLayout tabLayout; // 탭
    FragmentManager fragmentManager; // 액티비티와 프래그먼트를 이어줌
    FragmentTransaction transaction; // 프래그먼트와 관련된 작업 처리를 해줌
    FindIdFragment findIdFragment; // 아이디 찾기 프래그먼트
    FindPwFragment findPwFragment; // 비밀번호 찾기 프래그먼트

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_id_and_pw);

        // 상단바 설정
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false); //기본 타이틀 삭제
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //back버튼

        fragmentManager = getSupportFragmentManager();
        findIdFragment = new FindIdFragment();
        findPwFragment = new FindPwFragment();

        // 처음 화면(아이디찾기 화면) 설정
        transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.frame_layout, findIdFragment).commit();

        // tab 설정
        tabLayout = (TabLayout)findViewById(R.id.tab_layout);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int pos = tab.getPosition(); // 선택된 탭 위치값
                // 선택된 탭에 따른 화면 정의
                switch (pos) {
                    case 0: // 아이디 찾기 탭 선택시 -> 아이디 찾기 프래그먼트로 전환
                        transaction = fragmentManager.beginTransaction();
                        transaction.replace(R.id.frame_layout, findIdFragment).commit();
                        break;
                    case 1: // 비밀번호 찾기 탭 선택시 -> 비밀번호 찾기 프래그먼트로 전환
                       transaction = fragmentManager.beginTransaction();
                        transaction.replace(R.id.frame_layout, findPwFragment).commit();
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

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
}