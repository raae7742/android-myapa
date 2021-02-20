package kr.teamcadi.myapa.activity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import java.io.InputStream;

import kr.teamcadi.myapa.R;

// 화면 설명 : 글쓰기 화면 -> 홈 화면의 글 추가 버튼과 연결
// Author : Hyeonae, Last Modified : 2021.02.20
public class WritepageActivity extends AppCompatActivity {
    private static final int GET_FROM_GALLERY = 101;        // 사진 불러오기 코드

    ImageView iv;

    Toolbar toolbar; // 상단바
    Spinner wp_spinner; // 진료과 선택 스피너
    ImageButton ib_camera;  // 카메라(사진 추가) 버튼

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_writepage);

        // 상단바 설정
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false); // 기본 타이틀 삭제
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //back버튼

        ib_camera = (ImageButton)findViewById(R.id.ib_camera);  // 카메라 버튼

        wp_spinner = findViewById(R.id.wp_spinner);

        String[] medical = {"안과", "내과", "이비인후과", "소아과", "치과", "산부인과", "비뇨기과", "암", "외과", "피부과"}; // 진료과 선택 스피너에 넣을 진료과 내용
        final ArrayAdapter<String> adapter= new ArrayAdapter<String>(this,R.layout.spinner_writepage, medical); // 진료과 선택 스피너와 내용 연결
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item); // 스피너 스타일
        wp_spinner.setAdapter(adapter); // 스피너와 어댑터 연결

        ib_camera.setOnClickListener(new View.OnClickListener() {   // 카메라 버튼의 OnClickListener
            @Override
            public void onClick(View v) {
                Intent i = new Intent();                            // 갤러리에서 사진 불러오기
                i.setType(MediaStore.Images.Media.CONTENT_TYPE);
                i.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(i, GET_FROM_GALLERY);
            }
        });
    }

    // 상단바 오른쪽 메뉴
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.writepage_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:{ // 상단바의 back키 눌렀을 때
                finish();
                return true;
            }
            case R.id.menu_calendar: { // 상단바 오른쪽의 체크 아이콘 눌렀을 때
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 101 && resultCode == RESULT_OK) { // 카메라 버튼을 눌렀을 때
            try {
                InputStream is = getContentResolver().openInputStream(data.getData());
                Bitmap bm = BitmapFactory.decodeStream(is);
                is.close();
                iv.setImageBitmap(bm);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else if(requestCode == 101 && resultCode == RESULT_CANCELED){

        }
    }
}
