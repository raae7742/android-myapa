package kr.teamcadi.myapa.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import kr.teamcadi.myapa.R;
import kr.teamcadi.myapa.fragment.HomeFragment;
import kr.teamcadi.myapa.fragment.MyPageFragment;
import kr.teamcadi.myapa.fragment.NotificationFragment;

// 화면 설명 : 메인 화면
// Author : Jang Soo Hyun, Jaey, Seung Hyun Kim, Last Updated : 2021.02.17
public class MainActivity extends AppCompatActivity
{
    private FragmentManager fragmentManager = getSupportFragmentManager(); // Fragment 관리를 위한 요소

    // Fragment 객체
    private HomeFragment homeFragment = new HomeFragment();
    private MyPageFragment myPageFragment = new MyPageFragment();
    private NotificationFragment notificationFragment = new NotificationFragment();

    DrawerLayout drawerLayout; // 사이드바를 위한 레이아웃
    NavigationView navigationView; // 사이드바
    View headerView; // 사이드바의 헤더 부분
    ImageView iv_user_image; // 사이드바의 헤더의 사용자 프로필 사진
    ImageButton btn_close; // 사이드바의 닫기 버튼

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 처음 화면 설정
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.main_fragment, homeFragment).commitAllowingStateLoss();

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navi);
        bottomNavigationView.setOnNavigationItemSelectedListener(new ItemSelectedListener());

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation_view);
        headerView = navigationView.getHeaderView(0);
        iv_user_image = headerView.findViewById(R.id.iv_user_image);
        btn_close = headerView.findViewById(R.id.btn_close);

        // 사이드바의 메뉴 클릭시
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();

                switch (id) {
                    case R.id.item_daily_report:
                        startActivity(new Intent(MainActivity.this, ReportActivity.class)); // 사이드바의 데일리리포트 클릭시 복약리포트(ReportActivity)로 이동
                        break;
                    case R.id.item_shopping:
                        break;
                    case R.id.item_setting:
                        break;
                    case R.id.item_question:
                        Intent intent = new Intent(Intent.ACTION_SEND); // 이메일 보내는 인텐트 생성
                        intent.setType("plain/text");
                        String[] address = {"cadi@gmail.com"}; // 받는 사람 이메일 주소
                        intent.putExtra(Intent.EXTRA_EMAIL, address); // 이메일 주소 전달
                        startActivity(intent); // 인텐트 실행
                        break;
                }
                return true;
            }
        });

        // 사이드바의 사용자 프로필 사진 클릭시 -> 추후 카메라 아이콘 클릭시로 바꿀 예정
        iv_user_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CharSequence[] list = new CharSequence[]{"이미지 촬영", "갤러리에서 선택", "이미지 삭제"}; // 팝업창 내용 리스트
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this); // 팝업창 생성
                builder.setNegativeButton("취소", null);
                builder.setItems(list, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        dialog.dismiss();
                    }
                });
                builder.show();
            }
        });

        // 사이드바의 닫기 버튼 클릭시 -> 사이드바 닫힘
        btn_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
                    drawerLayout.closeDrawer(GravityCompat.START);
                }
            }
        });
    }

    // 하단바 클릭 시
    class ItemSelectedListener implements BottomNavigationView.OnNavigationItemSelectedListener
    {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item)
        {
            FragmentTransaction transaction = fragmentManager.beginTransaction();

            switch(item.getItemId())
            {
                case R.id.slideMenu:
                    drawerLayout.openDrawer(GravityCompat.START); // 사이드바 열림
                    break;

                case R.id.home:
                    transaction.replace(R.id.main_fragment, homeFragment).commitAllowingStateLoss();
                    break;

                case R.id.myPage:
                    transaction.replace(R.id.main_fragment, myPageFragment).commitAllowingStateLoss();
                    break;

                case R.id.notification:
                    transaction.replace(R.id.main_fragment, notificationFragment).commitAllowingStateLoss();
                    break;
            }
            return true;
        }
    }

    // 사이드바에서 뒤로가기 눌렀을 경우
    @Override
    public void onBackPressed() {
        // 사이드 바에서 뒤로가기 눌렀을 경우
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START); // 사이드바 닫힘
        } else {
            super.onBackPressed();
        }
    }
}