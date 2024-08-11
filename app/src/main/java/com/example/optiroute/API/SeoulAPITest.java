package com.example.optiroute.API;

import com.example.optiroute.APICallback;

import org.json.JSONObject;

import java.io.IOException;
import java.net.URLEncoder;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class SeoulAPITest {
    //역 도착 열차 정보 조회 API 인증키

    private String RTSAappKey = "7a66694449546f6e37354674585577";
    public class RealtimeStationArrival {
        public void fetchData(String stationName, APICallback callback) {
            try {
                StringBuilder urlBuilder = new StringBuilder("http://openapi.seoul.go.kr:8088"); /*URL*/
                urlBuilder.append("/" + URLEncoder.encode(RTSAappKey, "UTF-8")); /*인증키 (sample사용시에는 호출시 제한됩니다.)*/
                urlBuilder.append("/" + URLEncoder.encode("json", "UTF-8")); /*요청파일타입 (xml,xmlf,xls,json) */
                urlBuilder.append("/" + URLEncoder.encode("realtimeStationArrival", "UTF-8")); /*서비스명 (대소문자 구분 필수입니다.)*/
                urlBuilder.append("/" + URLEncoder.encode("0", "UTF-8")); /*요청시작위치 (sample인증키 사용시 5이내 숫자)*/
                urlBuilder.append("/" + URLEncoder.encode("1", "UTF-8")); /*요청종료위치(sample인증키 사용시 5이상 숫자 선택 안 됨)*/
                // 상위 5개는 필수적으로 순서바꾸지 않고 호출해야 합니다.

                //stationName은 "역"을 제외해야 함 ex) 서울역 -> 서울
                urlBuilder.append("/" + URLEncoder.encode(stationName, "UTF-8"));

                OkHttpClient client = new OkHttpClient();
                Request request = new Request.Builder()
                        .url(urlBuilder.toString())
                        .get()
                        .build();

                client.newCall(request).enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        callback.onError(e);
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        if (response.isSuccessful()) {
                            try {
                                String responseData = response.body().string();
                                JSONObject jsonResponse = new JSONObject(responseData);
                                callback.onDataLoaded(jsonResponse);
                            } catch (Exception e) {
                                callback.onError(e);
                            }
                        } else {
                            callback.onError(new Exception("API Request Failed:" + response.code()));
                        }
                    }
                });
            } catch (Exception e) {
                callback.onError(e);
            }
        }
    }
}
