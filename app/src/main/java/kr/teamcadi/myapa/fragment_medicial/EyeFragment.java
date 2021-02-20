package kr.teamcadi.myapa.fragment_medicial;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import kr.teamcadi.myapa.R;
import kr.teamcadi.myapa.activity.FeedActivity;
import kr.teamcadi.myapa.activity.WritepageActivity;

// 화면 설명 : 홈 화면(메인 컨텐츠 영역) -> MainActivity로 연결
// Author : Jaey,Soohyun Last Modified : 2021.02.06
public class EyeFragment extends Fragment
{
    ImageButton btn_add_post; // 글 추가 버튼
    RelativeLayout rl_feed;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_eye, container, false);
        btn_add_post = view.findViewById(R.id.btn_add_post);
        rl_feed = view.findViewById(R.id.rl_feed);

        // 글 추가 버튼 클릭시
        btn_add_post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), WritepageActivity.class)); // 글쓰기 화면으로 이동
            }
        });

        rl_feed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), FeedActivity.class));
            }
        });

        return view;
    }
}
