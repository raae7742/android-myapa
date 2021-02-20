package kr.teamcadi.myapa.domain;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// 클래스 설명 : 사용자 별 데이터들을 하나의 객체 단위로 처리하기 위한 DTO(Data Transfer Object) 객체
// Author : Jaey & Lee Hyun Sun / Last Modified : 2021.01.02
@Data
public class User implements Serializable
{
    private int userIdx; // 사용자 고유 번호
    private String userId; // 사용자 ID
    private String userPassword; // 사용자 비밀번호
    private String userPasswordCheck; // 사용자 비밀번호 재확인
    private String userName; // 사용자 이름
    private String profileImgUrl; // 사용자 프로필 이미지를 저장해 둔 URl 경로
    private Date userCreateDate; // 사용자 가입 일자
    private Date userUpdateDate; // 사용자 최종 접속 일자
}