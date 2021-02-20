package kr.teamcadi.myapa.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import kr.teamcadi.myapa.R;
import kr.teamcadi.myapa.domain.FeedImage;
import kr.teamcadi.myapa.domain.Report;

// 화면 설명 : 피드 화면의 이미지 리사이클러뷰 아이템 어댑터
// Author : Soohyun, Last Modified : 2021.02.18
public class FeedImageAdapter extends RecyclerView.Adapter<FeedImageAdapter.ViewHolder>{
    ArrayList<FeedImage> imageList; // 피드의 이미지 리스트

    // 생성자
    public FeedImageAdapter(ArrayList<FeedImage> imageList){
        this.imageList = imageList;
    }

    // 뷰 홀더 객체 생성
    @NonNull
    @Override
    public FeedImageAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.activity_feed_item_image, parent, false); // 아이템 뷰와 연결
        FeedImageAdapter.ViewHolder vh = new FeedImageAdapter.ViewHolder(view); // 뷰 홀더와 어댑터 연결

        return vh ;
    }

    // 뷰 홀더와 실제 데이터를 연결
    @Override
    public void onBindViewHolder(@NonNull FeedImageAdapter.ViewHolder holder, int position) {
        FeedImage item = imageList.get(position); // 피드의 이미지 리스트 중 해당 위치 객체 가져옴

        // 객체의 데이터를 가져와 아이템 뷰와 연결
        holder.image.setImageResource(item.getImage());
    }

    // 피드의 이미지 리스트의 전체 데이터 개수 반환
    @Override
    public int getItemCount() {
        return imageList.size();
    }

    // 뷰 홀더
    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView image;

        ViewHolder(View itemView) {
            super(itemView) ;

            // 아이템 뷰와 연결
            image = itemView.findViewById(R.id.iv_feed_image);
        }
    }
}
