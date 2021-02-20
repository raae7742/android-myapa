package kr.teamcadi.myapa.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import kr.teamcadi.myapa.R;
import kr.teamcadi.myapa.domain.Notification;

// 화면 설명 : 내 알림 화면의 리사이클러뷰 아이템 어댑터
// Author : Soohyun, Last Modified : 2021.02.17
public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.ViewHolder> {
    ArrayList<Notification> notiList; // 알람 리스트

    // 생성자
    public NotificationAdapter(ArrayList<Notification> notiList) {
        this.notiList = notiList;
    }

    // 뷰 홀더 객체 생성
    @NonNull
    @Override
    public NotificationAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.fragment_bottom_notification_item, parent, false); // 아이템 뷰와 연결
        NotificationAdapter.ViewHolder vh = new NotificationAdapter.ViewHolder(view); // 뷰 홀더와 어댑터 연결

        return vh ;
    }

    // 뷰 홀더와 실제 데이터를 연결
    @Override
    public void onBindViewHolder(@NonNull NotificationAdapter.ViewHolder holder, int position) {
        Notification item = notiList.get(position) ; // 알람 리스트 중 해당 위치 객체 가져옴

        // 객체의 데이터를 가져와 아이템 뷰와 연결
        holder.noti.setText(item.getNoti());
        holder.noti_detail.setText(item.getNoti_detail());
    }

    // 알람 리스트의 전체 데이터 개수 반환
    @Override
    public int getItemCount() {
        return notiList.size();
    }

    // 뷰 홀더
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView noti; // 알람 메세지
        TextView noti_detail; // 알람 세부 메세지

        ViewHolder(View itemView) {
            super(itemView) ;

            // 아이템 뷰와 연결
            noti = itemView.findViewById(R.id.tv_noti);
            noti_detail = itemView.findViewById(R.id.tv_noti_detail);
        }
    }
}
