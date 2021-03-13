package kr.teamcadi.myapa.activity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import kr.teamcadi.myapa.R;
import kr.teamcadi.myapa.domain.MemberJoin;

// 화면 설명 : 회원가입 기본 정보 입력 화면 2
// Author : Kim Seung Hyun, Soohyun Last Modified : 2021.03.07
public class MemberJoinSecond extends AppCompatActivity
{
    ArrayAdapter<String> stateAdpater; // 군/구 스피너의 어댑터
    Spinner spinner_mj2_state; // 군/구 스피너
    private String birthday = ""; // 사용자 생년월일
    private  String address_area = ""; // 사용자 주소의 시
    private String addresss_state = ""; // 사용자 주소의 군/구
    boolean isChecked = false; // 입력된 정보의 유효성 검사의 결과를 담고 있는 변수

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_join_2);

        ImageView iv_mj2_birth = (ImageView)findViewById(R.id.iv_mj2_birth); // 생년월일 입력창
        TextView tv_mj2_birth = (TextView)findViewById(R.id.tv_mj2_birth); // 입력받은 생년월일을 보여주는 텍스트뷰
        Spinner spinner_mj2_area = (Spinner)findViewById(R.id.spinner_mj2_area); // 거주지역 입력 스피너
        spinner_mj2_state = (Spinner)findViewById(R.id.spinner_mj2_state); // 군/구 입력 스피너
        ImageButton btn_mj2_next = (ImageButton)findViewById(R.id.btn_mj2_next); // 다음 버튼
        ImageView iv_mj2_backarrow = (ImageView)findViewById(R.id.iv_mj2_backarrow); // 뒤로가기 화살표 버튼

        Intent intent = getIntent(); // 인텐트 생성
        MemberJoin memberJoin = (MemberJoin)intent.getSerializableExtra("member"); // 회원가입 화면1에서 보냈던 객체 가져오기

        Toast.makeText(getApplicationContext(), memberJoin.getUser_name() + "/" + memberJoin.getUser_email() + "/" + memberJoin.getUser_id() + "/" + memberJoin.getUser_pw() + "/" + memberJoin.getNickname(), Toast.LENGTH_LONG).show();

        // 생년월일 입력창 클릭시
       iv_mj2_birth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 생년월일 다이얼로그 생성
                DatePickerDialog dialog = new DatePickerDialog(MemberJoinSecond.this, android.R.style.Theme_Holo_Light_Dialog_MinWidth, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        tv_mj2_birth.setText(year + "/" + (month+1) + "/" + dayOfMonth); // 설정 완료시 입력된 생년월일을 텍스트뷰로 보여줌
                        birthday = year + "-" + (month+1) + "-" + dayOfMonth;
                    }
                },2021,1,1);
                dialog.show(); // 다이얼로그 실행
            }
        });

        // 거주지역 스피너 설정
        String[] area = {"서울특별시", "부산광역시", "대구광역시", "인천광역시", "광주광역시", "대전광역시", "울산광역시", "세종특별자치시", "경기도", "강원도", "충청북도", "충청남도", "전라북도", "전라남도", "경상북도", "경상남도", "제주특별자치도"}; // 거주지역 스피너에 넣을 거주지 내용
        ArrayAdapter<String> areaAdapter= new ArrayAdapter<String>(getApplicationContext(), R.layout.spinner_text_writepage, area); // 거주지역 스피너와 내용 연결
        areaAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item); // 스피너 스타일
        spinner_mj2_area.setAdapter(areaAdapter); // 스피너와 어댑터 연결

        // 거주지역 스피너 아이템 클릭시
       spinner_mj2_area.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
           @Override
           public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
               switch (position) {
                   case 0: // 서울 특별시
                       address_area = parent.getItemAtPosition(position).toString(); // 선택된 위치의 스피너 텍스트
                       String[] state_seoul = {"종로구", "중구", "용산구", "성동구", "광진구", "동대문구", "중랑구", "성북구", "강북구", "도봉구", "노원구", "은평구", "서대문구", "마포구", "양천구", "강서구", "구로구", "금천구", "영등포구", "동작구", "관악구", "서초구", "강남구", "송파구", "강동구"}; // 군/구 스피너에 넣을 군/구 내용
                       setStateSpinner(state_seoul); // 군/구 스피너 설정하는 메소드 실행
                       break;
                   case 1: // 부산광역시
                       address_area = parent.getItemAtPosition(position).toString();
                       String[] state_busan = {"중구", "서구", "동구", "영도구", "부산진구", "동래구", "남구", "북구", "해운대구", "사하구", "금정구", "강서구", "연제구", "수영구", "사상구", "기장군"};
                       setStateSpinner(state_busan);
                       break;
                   case 2: // 대구광역시
                       address_area = parent.getItemAtPosition(position).toString();
                       String[] state_daegu = {"중구", "동구", "서구", "남구", "북구", "수성구", "달서구", "달성군"};
                       setStateSpinner(state_daegu);
                       break;
                   case 3: // 인천광역시
                       address_area = parent.getItemAtPosition(position).toString();
                       String[] state_incheon = {"중구", "동구", "미추홀구", "연수구", "남동구", "부평구", "계양구", "서구", "강화군", "옹진군"};
                       setStateSpinner(state_incheon);
                       break;
                   case 4: // 광주광역시
                       address_area = parent.getItemAtPosition(position).toString();
                       String[] state_gwangju = {"동구", "서구", "남구", "북구", "광산구"};
                       setStateSpinner(state_gwangju);
                       break;
                   case 5: // 대전광역시
                       address_area = parent.getItemAtPosition(position).toString();
                       String[] state_daejeon = {"동구", "중구", "서구", "유성구", "대덕구"};
                       setStateSpinner(state_daejeon);
                       break;
                   case 6: // 울산광역시
                       address_area = parent.getItemAtPosition(position).toString();
                       String[] state_ulsan = {"중구", "남구", "동구", "북구", "울주군"};
                       setStateSpinner(state_ulsan);
                       break;
                   case 7: // 세종특별자치시
                       address_area = parent.getItemAtPosition(position).toString();
                       String[] state_sejong = {" "};
                       setStateSpinner(state_sejong);
                       break;
                   case 8: // 경기도
                       address_area = parent.getItemAtPosition(position).toString();
                       String[] state_gyeonggi = {"수원시", "성남시", "고양시", "용인시", "부천시", "안양시", "남양주시", "화성시", "평택시", "의정부시", "시흥시", "파주시", "광명시", "김포시", "군포시", "광주시", "이천시", "양주시", "오산시", "구리시", "안성시", "포천시", "의왕시", "하남시", "여주시", "양평군", "동두천시", "과천시", "가평군", "연천군"};
                       setStateSpinner(state_gyeonggi);
                       break;
                   case 9: // 강원도
                       address_area = parent.getItemAtPosition(position).toString();
                       String[] state_gangwon = {"춘천시", "원주시", "강릉시", "동해시", "태백시", "속초시", "삼척시", "홍천군", "횡성군", "영월군", "평창군", "정선군", "철원군", "화천군", "양구군", "인제군", "고성군", "양양군"};
                       setStateSpinner(state_gangwon);
                       break;
                   case 10: // 충청북도
                       address_area = parent.getItemAtPosition(position).toString();
                       String[] state_chungcheongbuk = {"청주시", "충주시", "제천시", "보은군", "옥천군", "영동군", "진천군", "괴산군", "음성군", "단양군", "증평군"};
                       setStateSpinner(state_chungcheongbuk);
                       break;
                   case 11: // 충청남도
                       address_area = parent.getItemAtPosition(position).toString();
                       String[] state_chungcheongnam = {"천안시", "공주시", "보령시", "아산시", "서산시", "논산시", "계룡시", "당진시", "금산군", "부여군", "서천군", "청양군", "홍성군", "예산군", "태안군"};
                       setStateSpinner(state_chungcheongnam);
                       break;
                   case 12: // 전라북도
                       address_area = parent.getItemAtPosition(position).toString();
                       String[] state_jeollabuk = {"전주시", "군산시", "익산시", "정읍시", "남원시", "김제시", "완주군", "진안군", "무주군", "장수군", "임실군", "순창군", "고창군", "부안군"};
                       setStateSpinner(state_jeollabuk);
                       break;
                   case 13: // 전라남도
                       address_area = parent.getItemAtPosition(position).toString();
                       String[] state_jeollanam = {"목포시", "여수시", "순천시", "나주시", "광양시", "담양군", "곡성군", "구례군", "고흥군", "보성군", "화순군", "장흥군", "강진군", "해남군", "영암군", "무안군", "함평군", "영광군", "장성군", "완도군", "진도군", "신안군"};
                       setStateSpinner(state_jeollanam);
                       break;
                   case 14: // 경상북도
                       address_area = parent.getItemAtPosition(position).toString();
                       String[] state_gyeongsangbuk = {"포항시", "경주시", "김천시", "안동시", "구미시", "영주시", "영천시", "상주시", "문경시", "경산시", "군위군", "의성군", "청송군", "영양군", "영덕군", "청도군", "고령군", "성주군", "칠곡군", "예천군", "봉화군", "을진군", "울릉군"};
                       setStateSpinner(state_gyeongsangbuk);
                       break;
                   case 15: // 경상남도
                       address_area = parent.getItemAtPosition(position).toString();
                       String[] state_gyeonsangnam = {"창원시", "진주시", "통영시", "사천시", "김해시", "밀양시", "거제시", "양산시", "의령군", "함안군", "창녕군", "고성군", "남해군", "하동군", "산청군", "함양군", "거창군", "합천군"};
                       setStateSpinner(state_gyeonsangnam);
                       break;
                   case 16: // 제주특별자치도
                       address_area = parent.getItemAtPosition(position).toString();
                       String[] state_jeju = {"제주시", "서귀포시"};
                       setStateSpinner(state_jeju);
                       break;
               }
           }

           @Override
           public void onNothingSelected(AdapterView<?> parent) {

           }
       });

       // 군/구 스피너 아이템 클릭시
        spinner_mj2_state.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                addresss_state = parent.getItemAtPosition(position).toString(); // 선택된 위치의 스피너 텍스트
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        // 다음 버튼 클릭시
        btn_mj2_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 입력된 정보 유효성 검사
                if(birthday.equals("")) {
                    Toast.makeText(getApplicationContext(), "생년월일을 선택하세요", Toast.LENGTH_LONG).show();
                } else if(address_area.equals("")) {
                    Toast.makeText(getApplicationContext(), "거주지역을 선택하세요", Toast.LENGTH_LONG).show();
                } else if(address_area.equals("세종특별자치시")) {
                    isChecked = true; // 세종특별자치시는 시/군이 없으므로 위의 조건만 만족하면 유효성 검사 결과를 true로 변경
                } else if(addresss_state.equals("")) {
                    Toast.makeText(getApplicationContext(), "시/군을 선택하세요", Toast.LENGTH_LONG).show();
                } else {
                    isChecked = true; // 유효성 검사에서 모든 조건 만족시 결과를 true로 변경
                }

                // 유효성 검사에서 모든 조건을 만족한 경우
                if(isChecked) {
                    // 객체에 입력된 정보를 담음
                    memberJoin.setBirthday(birthday);
                    memberJoin.setAddress((address_area + " " + addresss_state).trim());

                    Intent i = new Intent(MemberJoinSecond.this, MemberJoinThird.class); // 회원가입 화면3으로 이동하는 인텐트 생성
                    i.putExtra("member", memberJoin); // 인텐트에 객체를 담아서 보냄
                    startActivity(i); // 인텐트 실행
                    finish();
                }
            }
        });

        // 뒤로가기 화살표 버튼 클릭시
        iv_mj2_backarrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MemberJoinSecond.this, MemberJoinFirst.class);
                startActivity(i);
                finish();
            }
        });
    }

    // 군/구 스피너를 설정하는 메소드
    public void setStateSpinner(String[] state) {
        stateAdpater= new ArrayAdapter<String>(getApplicationContext(), R.layout.spinner_text_writepage, state); // 시/군/구 스피너와 내용 연결
        stateAdpater.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item); // 스피너 스타일
        spinner_mj2_state.setAdapter(stateAdpater); // 스피너와 어댑터 연결
    }
}