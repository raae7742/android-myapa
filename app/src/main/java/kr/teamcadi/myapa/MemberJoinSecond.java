package kr.teamcadi.myapa;

import android.app.AppComponentFactory;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

// 화면 설명 : 회원가입 기본 정보 입력 화면 2
// Author : Kim Seung Hyun, Last Modified : 2021.02.18
public class MemberJoinSecond extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_join_2);

        ImageButton btn_mj2_next = (ImageButton)findViewById(R.id.btn_mj2_next);
        ImageView iv_mj2_backarrow = (ImageView)findViewById(R.id.iv_mj2_backarrow);

        btn_mj2_next.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MemberJoinSecond.this, MemberJoinThird.class);
                startActivity(i);
                finish();

            }
        });

        iv_mj2_backarrow.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MemberJoinSecond.this, MemberJoinFirst.class);
                startActivity(i);
                finish();
            }
        });


    }

}
