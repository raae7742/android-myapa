package kr.teamcadi.myapa.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import kr.teamcadi.myapa.R;

// 화면 설명 : 아이디/비밀번호 찾기 화면의 아이디 찾기 화면 -> FindIdAndPwActivity로 연결
// Author : Soohyun, Last Modified : 2021.01.28
public class FindPwFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_find_pw, container, false);
    }
}