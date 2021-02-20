package kr.teamcadi.myapa.fragment;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import kr.teamcadi.myapa.R;
import kr.teamcadi.myapa.activity.SearchActivity;

// 화면 설명 : 검색 전 화면 (최근 검색어, 해시태그)
// Author : Soohyun, Last Modified : 2021.02.04
public class RecentSearchFragment extends Fragment {
    // 해시태그 버튼 1-6
    Button btn_hashtag1;
    Button btn_hashtag2;
    Button btn_hashtag3;
    Button btn_hashtag4;
    Button btn_hashtag5;

    ListView lv_recent_search; //최근 검색어 리스트뷰
    public static ArrayAdapter<String> adapter; // 최근 검색어 리스트뷰 어댑터

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        RelativeLayout layout = (RelativeLayout)inflater.inflate(R.layout.fragment_recent_search, container, false);

        btn_hashtag1 = (Button)layout.findViewById(R.id.btn_hashtag1);
        btn_hashtag2 = (Button)layout.findViewById(R.id.btn_hashtag2);
        btn_hashtag3 = (Button)layout.findViewById(R.id.btn_hashtag3);
        btn_hashtag4 = (Button)layout.findViewById(R.id.btn_hashtag4);
        btn_hashtag5 = (Button)layout.findViewById(R.id.btn_hashtag5);

        lv_recent_search = (ListView)layout.findViewById(R.id.lv_recent_search);
        // 어댑터 정의
        adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, SearchActivity.recent_search_list) {
            // 리스트뷰 텍스트 컬러 지정
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View view = super.getView(position, convertView, parent);
                TextView textView = view.findViewById(android.R.id.text1);
                textView.setTextColor(Color.parseColor("#2699FB"));
                return view;
            }
        } ;
        lv_recent_search.setAdapter(adapter); // 리스트뷰와 어댑터 연결

        // 전달된 검색어 최근 검색어 리스트뷰에 추가
        Bundle bundle = getArguments();
        if(bundle != null) {
            String query = bundle.getString("query");
            if(SearchActivity.recent_search_list.size() >= 3) // 최근 검색어 리스트에 저장된 검색어가 3개 이상인 경우 오래된 검색어 삭제
                SearchActivity.recent_search_list.remove(0);
            SearchActivity.recent_search_list.add(query); // 최근 검색어 리스트에 검색어 추가
        }
        adapter.notifyDataSetChanged(); // 최근 검색어 리스트뷰 갱신

        // 해시태그버튼 클릭 시 -> 검색어 자동 생성 메소드 실행
        View.OnClickListener clickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.btn_hashtag1:
                        setSearchText(btn_hashtag1);
                        break;
                    case R.id.btn_hashtag2:
                        setSearchText(btn_hashtag2);
                        break;
                    case R.id.btn_hashtag3:
                        setSearchText(btn_hashtag3);
                        break;
                    case R.id.btn_hashtag4:
                        setSearchText(btn_hashtag4);
                        break;
                    case R.id.btn_hashtag5:
                        setSearchText(btn_hashtag5);
                        break;
                }
            }
        };

        btn_hashtag1.setOnClickListener(clickListener);
        btn_hashtag2.setOnClickListener(clickListener);
        btn_hashtag3.setOnClickListener(clickListener);
        btn_hashtag4.setOnClickListener(clickListener);
        btn_hashtag5.setOnClickListener(clickListener);

        return layout;
    }

    // 검색창에 해시태그에 해당하는 검색어 자동 생성 메소드
    public void setSearchText(Button button) {
        String text = button.getText().toString().substring(1);
        SearchActivity.et_search.setText(text);
        SearchActivity.et_search.setSelection(text.length()); // 커서위치를 텍스트 마지막 위치로
    }
}