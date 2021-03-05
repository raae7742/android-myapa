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
import kr.teamcadi.myapa.domain.Search;

// 화면 설명 : 검색 화면 중 검색 후의 리사이클러뷰 아이템 어댑터
// Author : Soohyun, Last Modified : 2021.02.18
public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.ViewHolder>{
    ArrayList<Search> searchList; //  검색된 글 리스트

    // 생성자
    public SearchAdapter(ArrayList<Search> searchList) {
        this.searchList = searchList;
    }

    // 뷰 홀더 객체 생성
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.fragment_search_detail_item, parent, false); // 아이템 뷰와 연결
        ViewHolder vh = new ViewHolder(view); // 뷰 홀더와 어댑터 연결

        return vh ;
    }

    // 뷰 홀더와 실제 데이터를 연결
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Search item = searchList.get(position) ; // 검색된 글 리스트 중 해당 위치 객체 가져옴

        // 객체의 데이터를 가져와 아이템 뷰와 연결
        holder.name.setText(item.getName());
        holder.time.setText(item.getTime());
        holder.content.setText(item.getContent());
        holder.chatNumber.setText(item.getChatNumber());
        holder.heartNumber.setText(item.getHeartNumber());
    }

    // 검색된 글 리스트의 전체 데이터 개수 반환
    @Override
    public int getItemCount() {
        return searchList.size();
    }

    // 뷰 홀더
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView time;
        TextView content;
        TextView chatNumber;
        TextView heartNumber;

        ViewHolder(View itemView) {
            super(itemView) ;

            // 아이템 뷰와 연결
            name = itemView.findViewById(R.id.tv_bynickname);
            time = itemView.findViewById(R.id.tv_tag);
            content = itemView.findViewById(R.id.tv_smallchat);
            chatNumber = itemView.findViewById(R.id.tv_num1);
            heartNumber = itemView.findViewById(R.id.tv_num2);
        }
    }
}
