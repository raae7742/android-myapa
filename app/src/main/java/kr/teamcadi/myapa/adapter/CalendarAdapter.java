package kr.teamcadi.myapa.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Calendar;

import kr.teamcadi.myapa.R;
import kr.teamcadi.myapa.domain.Report;

// 화면 설명 : 캘린더 팝업 화면의 복약 기록 리사이클러뷰 아이템 어댑터
// Author : Hyeonae, Last Modified : 2021.02.21
public class CalendarAdapter extends RecyclerView.Adapter<CalendarAdapter.ViewHolder>{
    private ArrayList<Report> reportList = null;

    // 생성자
    public CalendarAdapter(ArrayList<Report> reportList) {
        this.reportList = reportList;
    }

    // 뷰 홀더 객체 생성
    @NonNull
    @Override
    public CalendarAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.dialog_calendar_item, parent, false); // 아이템 뷰와 연결
        CalendarAdapter.ViewHolder vh = new CalendarAdapter.ViewHolder(view); // 뷰 홀더와 어댑터 연결

        return vh;
    }

    // 뷰 홀더와 실제 데이터를 연결
    @Override
    public void onBindViewHolder(@NonNull CalendarAdapter.ViewHolder holder, int position) {
        Report item = reportList.get(position) ; // 복약해야할 약 리스트 중 해당 위치 객체 가져옴

        holder.isChecked.setOnCheckedChangeListener(null); // 라디오버튼 리스너 초기화

        // 객체의 데이터를 가져와 아이템 뷰와 연결
        holder.report_name.setText(item.getMedicine_name());
        holder.report_time.setText(item.getMedicine_time());
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
        return reportList.size();
    }

    // 뷰 홀더
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView report_name;
        TextView report_time;
        CheckBox isChecked;

        ViewHolder(View itemView) {
            super(itemView) ;

            // 아이템 뷰와 연결
            report_name = itemView.findViewById(R.id.tv_report_name);
            report_time = itemView.findViewById(R.id.tv_report_time);
            isChecked = itemView.findViewById(R.id.rbtn_checked);
        }
    }
}