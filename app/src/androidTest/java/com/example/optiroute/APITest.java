package com.example.optiroute;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONObject;

import java.io.IOException;

public class APITest extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String appKey = "sQ4vyaQRNV8IjE7pSqdUS7ft0TkUVymoaWAAlTSc"; // 앱 키 변수로 지정
        String url = "https://apis.openapi.sk.com/puzzle/subway/congestion/rltm/trains/";
        //지하철 노선
        String subwayLine = "2";
        //열차 번호
        String trainNumber = "2207";

        url += subwayLine + "/" + trainNumber;
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .header("appkey", appKey) // 앱 키 헤더 추가
                .get()
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace(); // 에러 처리
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    try {
                        String responseData = response.body().string();
                        JSONObject jsonResponse = new JSONObject(responseData);
                        System.out.println("JSON Response: " + jsonResponse.toString(2));

                        // 응답 데이터 처리 (필요에 따라 추가)

                    } catch (Exception e) {
                        e.printStackTrace(); // JSON 파싱 에러 처리
                    }
                } else {
                    // API 요청 실패 처리
                    System.out.println("API Request Failed: " + response.code());
                }}
        });
    }
}
