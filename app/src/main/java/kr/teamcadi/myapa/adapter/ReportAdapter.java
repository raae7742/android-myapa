package kr.teamcadi.myapa.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import kr.teamcadi.myapa.R;
import kr.teamcadi.myapa.activity.ReportActivity;
import kr.teamcadi.myapa.domain.Notification;
import kr.teamcadi.myapa.domain.Report;

// 화면 설명 : 복약리포트 화면의 리사이클러뷰 아이템 어댑터
// Author : Soohyun, Last Modified : 2021.02.18
public class ReportAdapter extends RecyclerView.Adapter<ReportAdapter.ViewHolder>{
    ArrayList<Report> medicineList; //  복약해야할 약 리스트

    // 생성자
    public ReportAdapter(ArrayList<Report> medicineList) {
        this.medicineList = medicineList;
    }

    // 뷰 홀더 객체 생성
    @NonNull
    @Override
    public ReportAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.activity_report_item, parent, false); // 아이템 뷰와 연결
        ReportAdapter.ViewHolder vh = new ReportAdapter.ViewHolder(view); // 뷰 홀더와 어댑터 연결

        return vh ;
    }

    // 뷰 홀더와 실제 데이터를 연결
    @Override
    public void onBindViewHolder(@NonNull ReportAdapter.ViewHolder holder, int position) {
        Report item = medicineList.get(position) ; // 복약해야할 약 리스트 중 해당 위치 객체 가져옴

        holder.isChecked.setOnCheckedChangeListener(null); // 라디오버튼 리스너 초기화

        // 객체의 데이터를 가져와 아이템 뷰와 연결
        holder.medicine_name.setText(item.getMedicine_name());
        holder.medicine_time.setText(item.getMedicine_time());
        holder.isChecked.setChecked(item.getChecked());

        // 라디오버튼의 상태값을 알기 위한 리스너
        holder.isChecked.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                item.setChecked(isChecked); // 상태값에 맞게 데이터 변경
            }
        });
    }

    // 복약해야할 약 리스트의 전체 데이터 개수 반환
    @Override
    public int getItemCount() {
        return medicineList.size();
    }

    // 뷰 홀더
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView medicine_name;
        TextView medicine_time;
        CheckBox isChecked;

        ViewHolder(View itemView) {
            super(itemView) ;

            // 아이템 뷰와 연결
            medicine_name = itemView.findViewById(R.id.tv_medicine_name);
            medicine_time = itemView.findViewById(R.id.tv_medicine_time);
            isChecked = itemView.findViewById(R.id.rbtn_check);
        }
    }
}
