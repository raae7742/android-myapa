package kr.teamcadi.myapa.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import kr.teamcadi.myapa.R;
import kr.teamcadi.myapa.activity.MainActivity;
import kr.teamcadi.myapa.adapter.NotificationAdapter;
import kr.teamcadi.myapa.domain.Notification;

// 화면 설명 : 내 알림 화면 -> MainActivity로 연결
// Author : Jaey, Soohyun Last Modified : 2021.02.17
public class NotificationFragment extends Fragment
{
    RecyclerView rv_noti; // 알람 리사이클러뷰
    NotificationAdapter adapter; // 알람 어댑터
    ArrayList<Notification> notiList = new ArrayList<>(); // 알람 리스트
    int initNumber = 0; // 데이터 초기화 횟수

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_bottom_notification, container, false);

        if(initNumber == 0) { // 데이터 초기화를 하지 않은 경우 -> 데이터 초기화
            init(); // 임시 데이터 추가
            initNumber++; // 데이터 초기화를 한 번만 하기 위해서 초기화 횟수 변경
        }

        rv_noti = view.findViewById(R.id.rv_noti);

        rv_noti.setLayoutManager(new LinearLayoutManager(getContext())); // 리사이클러뷰와 레이아웃 매니저 연결

        adapter = new NotificationAdapter(notiList); // 어댑터와 알람 리스트 연결
        rv_noti.setAdapter(adapter); // 리사이클러뷰와 어댑터 연결
        adapter.notifyDataSetChanged(); // 어댑터에게 데이터 변화를 알려줌

        return view;
    }

    // 임시 데이터 추가하는 메소드
    public void init() {
        notiList.add(new Notification("XXX님이 XXX게시판에 댓글을 달았습니다.", "\"안녕하세요...하려고 하는데\""));
        notiList.add(new Notification("XXX님이 XXX게시판에 댓글을 달았습니다.", "\"안녕하세요...하려고 하는데\""));
        notiList.add(new Notification("XXX님이 XXX게시판에 댓글을 달았습니다.", "\"안녕하세요...하려고 하는데\""));
        notiList.add(new Notification("XXX님이 XXX게시판에 댓글을 달았습니다.", "\"안녕하세요...하려고 하는데\""));
        notiList.add(new Notification("XXX님이 XXX게시판에 댓글을 달았습니다.", "\"안녕하세요...하려고 하는데\""));
    }
}
