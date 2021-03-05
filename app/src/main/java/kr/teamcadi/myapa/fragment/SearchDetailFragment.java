package kr.teamcadi.myapa.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import kr.teamcadi.myapa.R;
import kr.teamcadi.myapa.adapter.ReportAdapter;
import kr.teamcadi.myapa.adapter.SearchAdapter;
import kr.teamcadi.myapa.domain.Report;
import kr.teamcadi.myapa.domain.Search;

// 화면 설명 : 검색 화면에서 검색 후 보여지는 화면 (검색된 글)
// Author : Soohyun, Last Modified : 2021.02.20
public class SearchDetailFragment extends Fragment {
    RecyclerView rv_search_detail; // 검색된 글 리사이클러뷰
    SearchAdapter adapter; // 검색된 글 어댑터
    ArrayList<Search> searchList = new ArrayList<>(); // 검색된 글 리스트

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search_detail, container, false);

        init(); // 임시 데이터 추가

        rv_search_detail= view.findViewById(R.id.rv_search_detail);

        rv_search_detail.setLayoutManager(new LinearLayoutManager(getContext())); // 리사이클러뷰와 레이아웃 매니저 연결

        adapter = new SearchAdapter(searchList); // 어댑터와 검색된 글 리스트 연결
        rv_search_detail.setAdapter(adapter); // 리사이클러뷰와 어댑터 연결
        adapter.notifyDataSetChanged(); // 어댑터에게 데이터 변화를 알려줌

        return view;
    }

    // 임시 데이터 추가하는 메소드
    public void init() {
        searchList.add(new Search("사용자1", "1시간 전", "제가 효과본 운동을 추천합니다.\n단, 절대 과하게 하지 마세요!", "609", "120"));
        searchList.add(new Search("사용자2", "1시간 전", "제가 효과본 운동을 추천합니다.\n단, 절대 과하게 하지 마세요!", "609", "120"));
    }
}