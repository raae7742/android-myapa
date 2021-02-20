package kr.teamcadi.myapa.activity;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import kr.teamcadi.myapa.R;
import kr.teamcadi.myapa.domain.FeedImage;

// 화면 설명 : 서비스 실행 시 첫 화면
// Author : Jaey, Last Modified : 2020.11.24
public class SplashActivity extends AppCompatActivity
{
    boolean connectResult = false;
    ConnectivityManager connectivityManager;
    Handler handler;

    @RequiresApi(api = Build.VERSION_CODES.M)
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        connectivityManager = (ConnectivityManager)this.getSystemService(Context.CONNECTIVITY_SERVICE);
        handler = new Handler();

        if(connectivityManager != null)
        {
            NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork());

            if(networkCapabilities != null)
            {
                connectResult = networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) || networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR);
            }

            else
            {
                connectResult = false;
            }
        }

        if(connectResult == true)
        {
            handler.postDelayed(delayRunTask, 3000); // 3초 뒤 실행
        }

        else
        {
            Toast.makeText(getApplicationContext(), "Connection NO", Toast.LENGTH_LONG).show();
        }
    }

    // 3초 후에 Handler를 통해 실행될 동작을 정의하는 부분
    Runnable delayRunTask = new Runnable()
    {
        @Override
        public void run()
        {
            // 로그인 화면으로 이동함
            Intent gotoLogin = new Intent(SplashActivity.this, MainActivity.class);
            startActivity(gotoLogin);
            finish();
        }
    };
}