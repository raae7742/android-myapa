package kr.teamcadi.myapa.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;
import com.prolificinteractive.materialcalendarview.OnDateSelectedListener;

import kr.teamcadi.myapa.R;
import kr.teamcadi.myapa.activity.ReportActivity;

// 화면 설명 : 마이 페이지 화면 -> MainActivity로 연결
// Author : Hyeonae, Last Modified : 2021.02.24
public class MyPageFragment extends Fragment
{
    MaterialCalendarView cv_week;       // 위클리 캘린더뷰

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_bottom_mypage, container, false);

        // 위클리 캘린더뷰 설정
        cv_week = view.findViewById(R.id.cv_week);
        cv_week.setOnDateChangedListener(new OnDateSelectedListener() {
            @Override
            public void onDateSelected(@NonNull MaterialCalendarView widget, @NonNull CalendarDay date, boolean selected) {
                startActivity(new Intent(getActivity(), ReportActivity.class));     // 날짜 탭하면 리포트화면으로 이동
            }
        });

        return view;
    }
}