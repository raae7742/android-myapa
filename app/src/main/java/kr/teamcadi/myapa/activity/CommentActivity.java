package kr.teamcadi.myapa.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;

import java.util.ArrayList;

import kr.teamcadi.myapa.R;
import kr.teamcadi.myapa.adapter.CommentAdapter;
import kr.teamcadi.myapa.adapter.FeedImageAdapter;
import kr.teamcadi.myapa.domain.Comment;
import kr.teamcadi.myapa.domain.FeedImage;

// 화면 설명 : 답글쓰기 화면 -> 피드화면(FeedActivity)의 댓글의 답글쓰기 클릭시 연결
// Author : Soohyun, Last Modified : 2021.01.28
public class CommentActivity extends AppCompatActivity {
    Toolbar toolbar; // 상단바
    RecyclerView rv_comment; // 답글쓰기 리사이클러뷰
    CommentAdapter adpater; // 답글쓰기 어댑터
    ArrayList<Comment> commentList = new ArrayList<>(); // 답글쓰기의 댓글 리스트

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);

        // 상단바 설정
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false); //기본 타이틀 삭제
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //back버튼

        init(); // 임시 데이터 추가

        rv_comment = findViewById(R.id.rv_comment);

        rv_comment.setLayoutManager(new LinearLayoutManager(this)); // 리사이클러뷰와 레이아웃 매니저 연결

        adpater = new CommentAdapter(commentList); // 어댑터와 답글쓰기의 댓글 리스트 연결
        rv_comment.setAdapter(adpater); // 리사이클러뷰와 어댑터 연결
        adpater.notifyDataSetChanged(); // 어댑터에게 데이터 변화를 알려줌
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:{ //상단바의 back키 눌렀을 때
                finish();
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }

    // 임시 데이터 추가하는 메소드
    public void init() {
        commentList.add(new Comment(0, "사용자2", "2020.01.01 18:26", "도움되는 내용이네요~ 감사합니다!"));
        commentList.add(new Comment(0, "사용자3", "2020.01.01 19:20", "오늘부터 해봐야겠어요~"));
        commentList.add(new Comment(1, "사용자4", "2020.01.01 19:26", "좋아요~"));
    }
}