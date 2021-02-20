package kr.teamcadi.myapa.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.prolificinteractive.materialcalendarview.MaterialCalendarView;

import kr.teamcadi.myapa.R;
import kr.teamcadi.myapa.activity.ReportActivity;

// 화면 설명 : 마이 페이지 화면 -> MainActivity로 연결
// Author : Jaey, Last Modified : 2021.01.16
public class MyPageFragment extends Fragment
{
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.fragment_bottom_mypage, container, false);
    }
}