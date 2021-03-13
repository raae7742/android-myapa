package kr.teamcadi.myapa.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
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

import kr.teamcadi.myapa.R;
import kr.teamcadi.myapa.domain.MemberJoin;

// 화면 설명 : 회원가입 세부 정보 입력 화면3
// Author : Kim Seung Hyun, Soohyun Last Modified : 2021.03.08
public class MemberJoinThird extends AppCompatActivity
{
    private String gender = ""; // 선택된 사용자 성별
    boolean isChecked = false; // 입력된 정보의 유효성 검사의 결과를 담고 있는 변수

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_join_3);

        Button btn_mj3_male = (Button)findViewById(R.id.btn_mj3_male); // 남성 버튼
        Button btn_mj3_female = (Button)findViewById(R.id.btn_mj3_female); // 여성 버튼
        EditText et_mj3_height = (EditText)findViewById(R.id.et_mj3_height); // 키 입력창
        EditText et_mj3_weight = (EditText)findViewById(R.id.et_mj3_weight); // 몸무게 입력창
        EditText et_mj3_job = (EditText)findViewById(R.id.et_mj3_job); // 직업 입력창
        ImageButton btn_mj3_done = (ImageButton)findViewById(R.id.btn_mj3_done); // 완료 버튼
        ImageView iv_mj3_backarrow = (ImageView)findViewById(R.id.iv_mj3_backarrow); // 뒤로가기 화살표 버튼

        Intent intent = getIntent(); // 인텐트 생성
        MemberJoin memberJoin = (MemberJoin)intent.getSerializableExtra("member"); // 회원가입 화면1에서 보냈던 객체 가져오기

        Toast.makeText(getApplicationContext(), memberJoin.getBirthday()+ "/" + memberJoin.getAddress(), Toast.LENGTH_LONG).show();

        // 남성 버튼 클릭시
        btn_mj3_male.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gender = "남성";
            }
        });

        // 여성 버튼 클릭시
        btn_mj3_female.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gender = "여성";
            }
        });

        // 완료 버튼 클릭시
        btn_mj3_done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String height = et_mj3_height.getText().toString().trim(); // 입력된 사용자 키
                String weight = et_mj3_weight.getText().toString().trim(); // 입력된 사용자 몸무게
                String job = et_mj3_job.getText().toString().trim(); // 입력된 사용자 직업

                // 유효성 검사
                if(gender.equals("")) {
                    Toast.makeText(getApplicationContext(), "성별을 입력하세요", Toast.LENGTH_LONG).show();
                } else if(height.equals("")) {
                    Toast.makeText(getApplicationContext(), "키를 입력하세요", Toast.LENGTH_LONG).show();
                } else if(weight.equals("")) {
                    Toast.makeText(getApplicationContext(), "몸무게를 입력하세요", Toast.LENGTH_LONG).show();
                } else if(job.equals("")) {
                    Toast.makeText(getApplicationContext(), "직업을 입력하세요", Toast.LENGTH_LONG).show();
                } else {
                    isChecked = true;
                }

                // 유효성 검사에서 모든 조건을 만족한 경우
                if(isChecked) {
                    // 객체에 입력된 정보를 담음
                    memberJoin.setGender(gender);
                    memberJoin.setHeight(Float.parseFloat(height));
                    memberJoin.setWeight(Float.parseFloat(weight));
                    memberJoin.setJob(job);

                    requestMemberJoin(memberJoin); // 회원가입 요청 메소드 실행
                }
            }
        });

        // 뒤로가기 화살표 버튼 클릭시
        iv_mj3_backarrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MemberJoinThird.this, MemberJoinSecond.class);
                startActivity(i);
                finish();
            }
        });
    }

    // 서버에 회원가입 요청하는 메소드
    public void requestMemberJoin(MemberJoin memberJoin) {

        // 사용자 입력 정보 JSON 형태로 변환
        JSONObject requestJsonObject = new JSONObject();
        try {
            requestJsonObject.put("user_id", memberJoin.getUser_id());
            requestJsonObject.put("user_pw", memberJoin.getUser_pw());
            requestJsonObject.put("user_email", memberJoin.getUser_email());
            requestJsonObject.put("user_name", memberJoin.getUser_name());
            requestJsonObject.put("nickname", memberJoin.getNickname());
            requestJsonObject.put("birthday", memberJoin.getBirthday());
            requestJsonObject.put("address", memberJoin.getAddress());
            requestJsonObject.put("height", memberJoin.getHeight());
            requestJsonObject.put("weight", memberJoin.getWeight());
            requestJsonObject.put("gender", memberJoin.getGender());
            requestJsonObject.put("job", memberJoin.getJob());
        } catch(JSONException e) {
            e.printStackTrace();
        }

        RequestQueue requestQueue = Volley.newRequestQueue(MemberJoinThird.this); // Request 요청 객체 생성

        // 서버에 데이터 전달 (url은 로컬로 설정되어 있음 - 테스트할 때 바꿔줘야함)
        JsonObjectRequest jsonObject = new JsonObjectRequest(Request.Method.POST, "http://192.168.0.18:8080/memberjoin", requestJsonObject, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) { // 서버에 데이터 전달 후 받은 응답

                try {
                    String result = response.getString("code"); // 응답 메시지(key가 code인 값) 가져오기

                    // 응답 메시지에 따른 처리
                    if(result.equals("404")) {
                        Toast.makeText(getApplicationContext(),"에러가 발생했습니다", Toast.LENGTH_SHORT).show();
                    } else if(result.equals("200")) {
                        Toast.makeText(getApplicationContext(), "회원가입이 완료되었습니다", Toast.LENGTH_SHORT).show();

                        // 회원가입 완료 후 다시 로그인 화면으로 돌아감
                        Intent i = new Intent(MemberJoinThird.this, LoginActivity.class);
                        startActivity(i);
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
