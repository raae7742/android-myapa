package kr.teamcadi.myapa.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import kr.teamcadi.myapa.R;

// 화면 설명 : 검색 화면에서 검색 후 보여지는 화면 (검색된 글)
// Author : Soohyun, Last Modified : 2021.01.05
public class SearchDetailFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_search_detail, container, false);
    }
}