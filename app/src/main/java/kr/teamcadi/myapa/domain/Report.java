package kr.teamcadi.myapa.domain;

// 화면 설명 : 복약리포트 화면의 리사이클러뷰 아이템 클래스
// Author : Soohyun, Last Modified : 2021.02.18
public class Report {
    private String medicine_name; // 약 이름
    private String medicine_time; // 약 복용 시간
    private Boolean isChecked; // 약 섭취 체크

    public Report(String medicine_name, String medicine_time, Boolean isChecked) {
        this.medicine_name = medicine_name;
        this.medicine_time = medicine_time;
        this.isChecked = isChecked;
    }

    public String getMedicine_name() {
        return medicine_name;
    }

    public String getMedicine_time() {
        return medicine_time;
    }

    public Boolean getChecked() {
        return isChecked;
    }

    public void setChecked(Boolean checked) {
        isChecked = checked;
    }
}
