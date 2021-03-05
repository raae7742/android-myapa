package kr.teamcadi.myapa.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import kr.teamcadi.myapa.R;

// 화면 설명 : 주기 선택 팝업 화면
// Author : Hyeonae, Last Modified : 2021.02.20
public class PickCycleDialog extends Dialog {
    private Context context;
    private ImageButton ib_exit;
    private TextView tv_ok;

    public PickCycleDialog(@NonNull Context context) {
        super(context);
        this.context = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_pick_cycle);

        ib_exit = findViewById(R.id.ib_exit);

        ib_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //pickCycleDialog.setCancelable(true);
            }
        });
    }
}
