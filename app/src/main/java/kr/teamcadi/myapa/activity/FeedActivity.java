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
import kr.teamcadi.myapa.adapter.ReportAdapter;
import kr.teamcadi.myapa.domain.Comment;
import kr.teamcadi.myapa.domain.FeedImage;
import kr.teamcadi.myapa.domain.Report;

// 화면 설명 : 피드 화면
// Author : Soohyun, Last Modified : 2020.01.15
public class FeedActivity extends AppCompatActivity {
    Toolbar toolbar; // 상단바
    RecyclerView rv_image; // 피드의 이미지 리사이클러뷰
    RecyclerView rv_comment; // 피드의 댓글 리사이클러뷰
    FeedImageAdapter imageAdapter; // 피드의 이미지 어댑터
    CommentAdapter commentAdapter; // 피드의 댓글 어댑터
    ArrayList<FeedImage> imageList = new ArrayList<>(); // 피드의 이미지 리스트
    ArrayList<Comment> commentList = new ArrayList<>(); // 피드의 댓글 리스트

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed);

        // 상단바 설정
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false); //기본 타이틀 삭제
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //back버튼

        init(); // 임시 데이터 추가

        rv_image = findViewById(R.id.rv_image);
        rv_comment = findViewById(R.id.rv_comment);

        // 리사이클러뷰와 레이아웃 매니저 연결
        rv_image.setLayoutManager(new LinearLayoutManager(this));
        rv_comment.setLayoutManager(new LinearLayoutManager(this));

        imageAdapter = new FeedImageAdapter(imageList); // 어댑터와 피드의 이미지 리스트 연결
        commentAdapter = new CommentAdapter(commentList); // 어댑터와 피드의 댓글 리스트 연결
        rv_image.setAdapter(imageAdapter); // 리사이클러뷰와 어댑터 연결
        rv_comment.setAdapter(commentAdapter);
        imageAdapter.notifyDataSetChanged(); // 어댑터에게 데이터 변화를 알려줌
        commentAdapter.notifyDataSetChanged();
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
        // 이미지 리스트에 데이터 추가
        imageList.add(new FeedImage(0));
        imageList.add(new FeedImage(0));
        imageList.add(new FeedImage(0));

        // 댓글 리스트에 데이터 추가
        commentList.add(new Comment(0, "사용자2", "2020.01.01 18:26", "도움되는 내용이네요~ 감사합니다!"));
        commentList.add(new Comment(0, "사용자3", "2020.01.01 19:20", "오늘부터 해봐야겠어요~"));
        commentList.add(new Comment(1, "사용자4", "2020.01.01 19:26", "좋아요~"));
    }
}