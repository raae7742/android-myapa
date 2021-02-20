package kr.teamcadi.myapa.domain;

// 화면 설명 : 내 알림 화면의 리사이클러뷰 아이템 클래스
// Author : Soohyun, Last Modified : 2021.02.17
public class Notification {
    private String noti; // 알람 메세지
    private String noti_detail; // 알람 세부 메세지

    public Notification(String noti, String noti_detail) {
        this.noti = noti;
        this.noti_detail = noti_detail;
    }

    public String getNoti() {
        return noti;
    }

    public String getNoti_detail() {
        return noti_detail;
    }
}
