package kr.teamcadi.myapa.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import kr.teamcadi.myapa.R;

// 화면 설명 : 아이디/비밀번호 찾기 화면의 비밀번호 찾기 화면 -> FindIdAndPwActivity로 연결
// Author : Soohyun, Last Modified : 2021.01.28
public class FindIdFragment extends Fragment {
    EditText ev_name; // 이름 입력창
    EditText ev_email; // 이메일 입력창
    ImageButton btn_finish; // 완료버튼

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_find_id, container, false);
        ev_name = view.findViewById(R.id.ev_name);
        ev_email = view.findViewById(R.id.ev_email);
        btn_finish = view.findViewById(R.id.btn_finish);

        // 완료버튼 클릭시
        btn_finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = ev_name.getText().toString(); // 입력된 이름 텍스트
                String email = ev_email.getText().toString(); // 입력된 이메일 텍스트

                // 이름이 입력되지 않았을 경우
                if(name.equals(""))
                    Toast.makeText(getActivity(),"이름을 입력하세요.", Toast.LENGTH_LONG).show();
                // 이메일이 입력되지 않았을 경우
                if(email.equals(""))
                    Toast.makeText(getActivity(),"이메일을 입력하세요.", Toast.LENGTH_LONG).show();
                // 이름과 이메일이 모두 입력된 경우
                if(!name.equals("") && !email.equals(""))
                    Toast.makeText(getActivity(), "이메일을 전송했습니다.", Toast.LENGTH_LONG).show();
            }
        });

        return view;
    }
}