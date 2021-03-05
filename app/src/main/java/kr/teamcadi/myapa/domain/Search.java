package kr.teamcadi.myapa.domain;

// 화면 설명 : 검색 화면 중 검색 후의 리사이클러뷰 아이템 클래스
// Author : Soohyun, Last Modified : 2021.02.20
public class Search {
    private String name; // 글 작성자
    private String time; // 글 작성 시간
    private String content; // 글 내용
    private String chatNumber; // 글의 댓글 수
    private String heartNumber; // 글의 공감 수

    public Search(String name, String time, String content, String chatNumber, String heartNumber) {
        this.name = name;
        this.time = time;
        this.content = content;
        this.chatNumber = chatNumber;
        this.heartNumber = heartNumber;
    }

    public String getName() {
        return name;
    }

    public String getTime() {
        return time;
    }

    public String getContent() {
        return content;
    }

    public String getChatNumber() {
        return chatNumber;
    }

    public String getHeartNumber() {
        return heartNumber;
    }
}
