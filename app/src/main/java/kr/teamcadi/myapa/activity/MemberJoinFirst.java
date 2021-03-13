package kr.teamcadi.myapa.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.regex.Pattern;

import kr.teamcadi.myapa.R;
import kr.teamcadi.myapa.domain.MemberJoin;

// 화면 설명 : 회원가입 기본 정보 입력 화면 1
// Author : Kim Seung Hyun, Soohyun Last Modified : 2021.03.07
public class MemberJoinFirst extends AppCompatActivity
{
    boolean isChecked = false; // 입력된 정보의 유효성 검사의 결과를 담고 있는 변수

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_join_1);

        EditText et_mj1_name = (EditText)findViewById(R.id.et_mj1_name); // 성명 입력창
        EditText et_mj1_email = (EditText)findViewById(R.id.et_mj1_email); // 이메일 입력창
        EditText et_mj1_id = (EditText)findViewById(R.id.et_mj1_id); // 아이디 입력창
        EditText et_mj1_pasword= (EditText)findViewById(R.id.et_mj1_pasword); // 비밀번호 입력창
        EditText et_mj1_nickname = (EditText)findViewById(R.id.et_mj1_nickname); // 닉네임 입력창
        ImageButton btn_mj1_next = (ImageButton)findViewById(R.id.btn_mj1_next); // 다음 버튼

        // 다음 버튼 클릭시
        btn_mj1_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = et_mj1_name.getText().toString().trim(); // 입력된 성명 텍스트
                String email = et_mj1_email.getText().toString().trim(); // 입력된 이메일 텍스트
                String id = et_mj1_id.getText().toString().trim(); // 입력된 아이디 텍스트
                String password = et_mj1_pasword.getText().toString().trim(); // 입력된 비밀번호 텍스트
                String nickname = et_mj1_nickname.getText().toString().trim(); // 입력된 닉네임 텍스트

                MemberJoin memberJoin = new MemberJoin(); // 입력된 정보를 저장할 DTO 객체 생성

                // 입력된 정보 유효성 검사
                if(name.equals("")) {
                    Toast.makeText(getApplicationContext(), "이름을 입력하세요", Toast.LENGTH_LONG).show();
                } else if(email.equals("")) {
                    Toast.makeText(getApplicationContext(), "이메일을 입력하세요", Toast.LENGTH_LONG).show();
                } else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    Toast.makeText(getApplicationContext(), "이메일 형식이 아닙니다", Toast.LENGTH_LONG).show();
                } else if(id.equals("")) {
                    Toast.makeText(getApplicationContext(), "아이디를 입력하세요", Toast.LENGTH_LONG).show();
                } else if(!Pattern.compile("^[A-Za-z0-9]{6,12}$").matcher(id).find()) {
                    Toast.makeText(getApplicationContext(), "아이디는 영문,숫자 포함 6~12자로 입력하세요", Toast.LENGTH_LONG).show();
                } else if(password.equals("")) {
                    Toast.makeText(getApplicationContext(), "비밀번호를 입력하세요", Toast.LENGTH_LONG).show();
                } else if(!Pattern.compile("(?=.*\\d)(?=.*[a-zA-Z]).{8,16}").matcher(password).find()) {
                    Toast.makeText(getApplicationContext(), "비밀번호는 영문,숫자 적어도 하나 포함 8~16자로 입력하세요", Toast.LENGTH_LONG).show();
                } else if(nickname.equals("")) {
                    Toast.makeText(getApplicationContext(), "닉네임을 입력하세요", Toast.LENGTH_LONG).show();
                } else if(!Pattern.compile("^[A-Za-z0-9가-힣]{2,10}$").matcher(nickname).find()) {
                    Toast.makeText(getApplicationContext(), "닉네임은 한글,영문,숫자 포함 2~10자로 입력하세요", Toast.LENGTH_LONG).show();
                } else {
                    isChecked = true; // 유효성 검사에서 모든 조건 만족시 결과를 true로 변경
                }

                // 유효성 검사에서 모든 조건을 만족한 경우
                if(isChecked) {
                    // 객체에 입력된 정보를 담음
                    memberJoin.setUser_name(name);
                    memberJoin.setUser_email(email);
                    memberJoin.setUser_id(id);
                    memberJoin.setUser_pw(password);
                    memberJoin.setNickname(nickname);

                    requestCheckDuplicate(memberJoin); // 중복확인 요청하는 메소드 실행
                }
            }
        });

    }

    // 서버에 이메일,아이디,닉네임 중복 확인을 요청하는 메소드드
    public void requestCheckDuplicate(MemberJoin memberJoin) {

        // 사용자 입력 정보 JSON 형태로 변환
        JSONObject requestJsonObject = new JSONObject();
        try {
            requestJsonObject.put("user_id", memberJoin.getUser_id());
            requestJsonObject.put("user_email", memberJoin.getUser_email());
            requestJsonObject.put("nickname", memberJoin.getNickname());
        } catch(JSONException e) {
            e.printStackTrace();
        }

        RequestQueue requestQueue = Volley.newRequestQueue(MemberJoinFirst.this); // Request 요청 객체 생성

        // 서버에 데이터 전달 (url은 로컬로 설정되어 있음 - 테스트할 때 바꿔줘야함)
        JsonObjectRequest jsonObject = new JsonObjectRequest(Request.Method.POST, "http://192.168.0.18:8080/checkduplicate", requestJsonObject, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) { // 서버에 데이터 전달 후 받은 응답

                try {
                    String result = response.getString("code"); // 응답 메시지(key가 code인 값) 가져오기

                    // 응답 메시지에 따른 처리
                    if(result.equals("204")) {
                        Toast.makeText(getApplicationContext(),"이미 등록된 이메일입니다", Toast.LENGTH_SHORT).show();
                    } else if(result.equals("205")) {
                        Toast.makeText(getApplicationContext(),"이미 존재하는 아이디입니다", Toast.LENGTH_SHORT).show();
                    } else if(result.equals("206")) {
                        Toast.makeText(getApplicationContext(),"이미 등록된 닉네임입니다", Toast.LENGTH_SHORT).show();
                    } else if(result.equals("200")) {
                        Intent i = new Intent(MemberJoinFirst.this, MemberJoinSecond.class); // 회원가입 화면2로 이동하는 인텐트 생성
                        i.putExtra("member", memberJoin); // 인텐트에 객체를 담아서 보냄
                        startActivity(i); // 인텐트 실행
                        finish();
                    }

                } catch(JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() { // 데이터 전달 및 응답 실패시
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), "네트워크 연결 오류", Toast.LENGTH_SHORT).show();
            }
        });

        requestQueue.add(jsonObject);
    }

}