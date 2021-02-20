package kr.teamcadi.myapa.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import kr.teamcadi.myapa.R;
import kr.teamcadi.myapa.activity.CommentActivity;
import kr.teamcadi.myapa.domain.Comment;

// 화면 설명 : 피드 화면의 댓글 리사이클러뷰 아이템 어댑터
// Author : Soohyun, Last Modified : 2021.02.18
public class CommentAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    ArrayList<Comment> commentList; // 피드의 댓글 리스트

    // 생성자
    public CommentAdapter(ArrayList<Comment> commentList){
        this.commentList = commentList;
    }

    // 뷰 홀더 객체 생성
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int type) {
        View view;
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if(type == 0){ // 댓글 뷰일 경우
            view = inflater.inflate(R.layout.activity_feed_item_comment, parent,false); // 아이템 뷰와 연결
            return new CommentViewHolder(view); // 뷰 홀더와 어댑터 연결
        } else if(type == 1){ // 답글 뷰일 경우
            view = inflater.inflate(R.layout.activity_feed_item_reply, parent,false);
            return new ReplyViewHolder(view);
        } else
            return null;
    }

    // 뷰 홀더와 실제 데이터를 연결
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Comment item = commentList.get(position); // 피드의 이미지 리스트 중 해당 위치 객체 가져옴

        // 객체의 데이터를 가져와 아이템 뷰와 연결
        if(holder instanceof CommentViewHolder){ // 댓글 뷰일 경우
            ((CommentViewHolder)holder).name.setText(item.getName());
            ((CommentViewHolder)holder).date.setText(item.getDate());
            ((CommentViewHolder)holder).content.setText(item.getContent());
        } else if(holder instanceof ReplyViewHolder){ // 답글 뷰일 경우
            ((ReplyViewHolder)holder).name.setText(item.getName());
            ((ReplyViewHolder)holder).date.setText(item.getDate());
            ((ReplyViewHolder)holder).content.setText(item.getContent());
        }
    }

    // 피드의 이미지 리스트의 전체 데이터 개수 반환
    @Override
    public int getItemCount() {
        return commentList.size();
    }

    // 댓글 리사이클러뷰의 아이템의 뷰 타입 리턴
    @Override
    public int getItemViewType(int position) {
        return commentList.get(position).getType();
    }

    // 댓글 뷰 홀더
    public class CommentViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView name; // 댓글 작성자
        TextView date; // 댓글 작성 시간
        TextView content; // 댓글 내용
        TextView tv_write_reply; // 답글쓰기 텍스트

        public CommentViewHolder(View itemView) {
            super(itemView) ;

            // 아이템 뷰와 연결
            name = itemView.findViewById(R.id.tv_comment_user_name);
            date = itemView.findViewById(R.id.tv_comment_date);
            content = itemView.findViewById(R.id.tv_comment_content);
            tv_write_reply = itemView.findViewById(R.id.tv_write_reply);

            tv_write_reply.setOnClickListener(this); // 답글쓰기에 클릭리스너 부착
        }

        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.tv_write_reply: // 답글쓰기를 클릭한 경우 답글쓰기(FeedActivity)화면으로 이동
                    view.getContext().startActivity(new Intent(view.getContext(), CommentActivity.class));
                    break;
            }
        }
    }

    // 답글 뷰 홀더
    public class ReplyViewHolder extends RecyclerView.ViewHolder {
        TextView name; // 답글 작성자
        TextView date; // 답글 작성한 시간
        TextView content; // 답글 내용

        public ReplyViewHolder(View itemView) {
            super(itemView) ;

            // 아이템 뷰와 연결
            name = itemView.findViewById(R.id.tv_reply_user_name);
            date = itemView.findViewById(R.id.tv_reply_date);
            content = itemView.findViewById(R.id.tv_reply_content);
        }
    }
}
