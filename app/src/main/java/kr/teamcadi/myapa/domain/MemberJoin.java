package kr.teamcadi.myapa.domain;

import java.io.Serializable;

// 클래스 설명 : 회원가입의 사용자별 데이터를 하나의 객체 단위로 처리하기 위한 DTO 객체
// Author : Soohyun / Last Modified : 2021.03.07
public class MemberJoin implements Serializable {
    private String user_id; // 사용자 아이디
    private String user_pw; // 사용자 비밀번호
    private String user_email; // 사용자 이메일
    private String user_name; // 사용자 이름
    private String nickname; // 사용자 닉네임
    private String birthday; // 사용자 생년월일
    private String address; // 사용자 주소
    private float height; // 사용자 키
    private float weight; // 사용자 몸무게
    private String gender; // 사용자 성별
    private String job; // 사용자 직업

    public MemberJoin() {
        user_id = null;
        user_pw = null;
        user_email = null;
        user_name = null;
        nickname = null;
        birthday = null;
        address = null;
        height = 0;
        weight = 0;
        gender = null;
        job = null;
    }

    public String getUser_id() {
        return user_id;
    }

    public String getUser_pw() {
        return user_pw;
    }

    public String getUser_email() {
        return user_email;
    }

    public String getUser_name() {
        return user_name;
    }

    public String getNickname() {
        return nickname;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getAddress() {
        return address;
    }

    public float getHeight() {
        return height;
    }

    public float getWeight() {
        return weight;
    }

    public String getGender() {
        return gender;
    }

    public String getJob() {
        return job;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public void setUser_pw(String user_pw) {
        this.user_pw = user_pw;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setJob(String job) {
        this.job = job;
    }

}
