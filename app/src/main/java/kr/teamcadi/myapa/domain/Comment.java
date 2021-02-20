package kr.teamcadi.myapa.domain;

// 화면 설명 : 피드 화면의 댓글 리사이클러뷰 아이템 클래스
// Author : Soohyun, Last Modified : 2021.02.18
public class Comment {
    private int type; // 뷰 타입 (0 - 댓글(activity_feed_item_comment), 1 - 답글(activity_feed_item_reply))
    private String name; // 댓글을 입력한 사용자 이름
    private String date; // 댓글을 입력한 시간
    private String content; // 댓글 내용

    public Comment(int type, String name, String date, String content) {
        this.type = type;
        this.name = name;
        this.date = date;
        this.content = content;
    }

    public int getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    public String getContent() {
        return content;
    }
}
