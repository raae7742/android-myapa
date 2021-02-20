package kr.teamcadi.myapa.fragment_medicial;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import kr.teamcadi.myapa.R;

// 화면 설명 : 홈 화면(메인 컨텐츠 영역) -> MainActivity로 연결
// Author : Jaey, Last Modified : 2021.01.16
public class InternalFragment extends Fragment
{
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.fragment_internal, container, false);
    }
}
