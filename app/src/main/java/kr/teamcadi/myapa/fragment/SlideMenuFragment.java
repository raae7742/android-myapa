package kr.teamcadi.myapa.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import kr.teamcadi.myapa.R;

// 화면 설명 : 슬라이드 메뉴(사이드바) -> MainActivity로 연결
// Author : Jaey, Last Modified : 2021.01.16
public class SlideMenuFragment extends Fragment
{
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.fragment_bottom_slidemenu, container, false);
    }
}
