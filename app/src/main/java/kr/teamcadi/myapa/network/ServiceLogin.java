package kr.teamcadi.myapa.network;

import android.net.http.AndroidHttpClient;
import android.os.AsyncTask;
import android.util.JsonReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

import kr.teamcadi.myapa.domain.MemberDTO;

import static kr.teamcadi.myapa.activity.LoginActivity.loginDTO;
import static kr.teamcadi.myapa.config.AllConfigOption.ipConfig;

// 클래스 설명 : 로그인 동작을 수행하기 위한 클래스
// Author : Jaey, Last Modified : 2021.1.23
public class ServiceLogin extends AsyncTask<Void, Void, String>
{
    String m_id, m_pw; // 입력 받은 아이디와 비밀번호 값

    HttpClient httpClient;
    HttpPost httpPost;
    HttpResponse httpResponse;
    HttpEntity httpEntity;

    public ServiceLogin(String id, String pw)
    {
        this.m_id = id;
        this.m_pw = pw;
    }

    @Override
    protected String doInBackground(Void... voids) // Background에서 도는 작업을 기술하는 부분
    {
        try
        {
            // 문자열을 묶어서 전송하기 위한 MultipartEntityBuild 객체 생성 및 설정
            MultipartEntityBuilder multipartEntityBuilder = MultipartEntityBuilder.create();
            multipartEntityBuilder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
            multipartEntityBuilder.setCharset(Charset.forName("UTF-8"));

            // 문자열 및 데이터 추가
            multipartEntityBuilder.addTextBody("input_id", m_id, ContentType.create("Multipart/related", "UTF-8"));
            multipartEntityBuilder.addTextBody("input_pw", m_pw, ContentType.create("Multipart/related", "UTF-8"));

            // URL Mapping 부분
            String postURL = ipConfig+ "/test/";

            // 전송
            InputStream inputStream = null;
            httpClient = AndroidHttpClient.newInstance("Android");
            httpPost = new HttpPost(postURL);
            httpPost.setEntity(multipartEntityBuilder.build());
            httpResponse = httpClient.execute(httpPost);    //여기 라인에서 DB에 보냄
            httpEntity = httpResponse.getEntity();
            inputStream = httpEntity.getContent();

            //응답 : JSON형태로 받음
            loginDTO = readMessage(inputStream);
        }

        catch(Exception e)
        {
            e.printStackTrace();
        }

        finally
        {
            if(httpEntity != null)
            {
                httpEntity = null;
            }

            if(httpResponse != null)
            {
                httpResponse = null;
            }

            if(httpPost != null)
            {
                httpPost = null;
            }

            if(httpClient != null)
            {
                httpClient = null;
            }
        }

        return "Login DTO Select Complete";
    }

    @Override
    protected void onPostExecute(String s)
    {
        super.onPostExecute(s);
    }

    public MemberDTO readMessage(InputStream inputStream) throws IOException
    {
        JsonReader reader = new JsonReader(new InputStreamReader(inputStream, "UTF-8"));

        String id = "", name = "";

        //비밀번호는 가져올 필요가 없고, 보안을 위해 가져오지 않는다.
        reader.beginObject();

        while (reader.hasNext())
        {
            String readStr = reader.nextName();

            if (readStr.equals("id"))
            {
                id = reader.nextString();
            }

            else if (readStr.equals("name"))
            {
                name = reader.nextString();
            }
        }

        reader.endObject();

        return new MemberDTO(id, name);
    }
}