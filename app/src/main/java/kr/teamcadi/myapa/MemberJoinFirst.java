package kr.teamcadi.myapa;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

// 화면 설명 : 회원가입 기본 정보 입력 화면 1
// Author : Kim Seung Hyun, Last Modified : 2021.02.18
public class MemberJoinFirst extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_join_1);

        EditText et_mj1_name = (EditText)findViewById(R.id.et_mj1_name);
        ImageButton btn_mj1_next = (ImageButton)findViewById(R.id.btn_mj1_next);

        btn_mj1_next.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view){
                if(et_mj1_name.getText().toString().length() == 0){

                }else{
                    
                }
            }
        });

        btn_mj1_next.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MemberJoinFirst.this, MemberJoinSecond.class);
                startActivity(i);
                finish();

            }
        });

    }

}
