package kr.teamcadi.myapa.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

import kr.teamcadi.myapa.R;
import kr.teamcadi.myapa.fragment.RecentSearchFragment;
import kr.teamcadi.myapa.fragment.SearchDetailFragment;

// 화면 설명 : 검색화면
// Author : Soohyun, Last Modified : 2021.01.16
public class SearchActivity extends AppCompatActivity {
    public static EditText et_search; // 검색창
    public static ArrayList<String> recent_search_list; // 최근 검색어 리스트
    FragmentManager fragmentManager; // 액티비티와 프래그먼트를 이어줌
    FragmentTransaction transaction; // 프래그먼트와 관련된 작업 처리를 해줌
    RecentSearchFragment recentSearchFragment; // 검색 전 최근 검색어 & 해시태그 화면
    SearchDetailFragment searchDetailFragment; // 검색 후 화면

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        et_search = (EditText)findViewById(R.id.et_search);
        recent_search_list = new ArrayList<String>();
        fragmentManager = getSupportFragmentManager();
        recentSearchFragment = new RecentSearchFragment();
        searchDetailFragment = new SearchDetailFragment();

        // 검색창 클릭 시 최근 검색어 & 해시태그 화면 보여줌
        et_search.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.frame_layout, recentSearchFragment).commit();
            }
        });

        // 검색 버튼 클릭 시
        et_search.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                switch (i) {
                    case EditorInfo.IME_ACTION_SEARCH:
                        // 검색어 텍스트를 최근 검색어 & 해시태그 화면으로 전달
                        Bundle bundle = new Bundle();
                        bundle.putString("query",et_search.getText().toString());
                        recentSearchFragment.setArguments(bundle);

                        // 검색 후 화면으로 전환
                        transaction = fragmentManager.beginTransaction();
                        transaction.replace(R.id.frame_layout, searchDetailFragment).commit();
                        break;
                }
                return true;
            }
        });

        // 검색창 텍스트 변경 시
        et_search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // 최근 검색어 & 해시태그 화면으로 전환
                transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.frame_layout, recentSearchFragment).commit();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }
}