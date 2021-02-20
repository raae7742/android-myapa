package kr.teamcadi.myapa.domain;

// 화면 설명 : 피드 화면의 이미지 리사이클러뷰 아이템 클래스
// Author : Soohyun, Last Modified : 2021.02.18
public class FeedImage {
    private int image; // 첨부된 이미지

    public FeedImage(int image) {
        this.image = image;
    }

    public int getImage() {
        return image;
    }
}
