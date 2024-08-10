package com.example.optiroute;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONObject;

import java.io.IOException;

public class PuzzleAPITest {
    private String appKey = "sQ4vyaQRNV8IjE7pSqdUS7ft0TkUVymoaWAAlTSc";
    private String url = "https://apis.openapi.sk.com/puzzle/subway/congestion/rltm/trains/";;
    public interface ApiCallback {
        void onDataLoaded(JSONObject data);
        void onError(Throwable error);
    }

    public void fetchData(String subwayLine, String trainNumber, ApiCallback callback) {
        url += subwayLine + "/" + trainNumber;

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .header("appkey", appKey)
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
    }
}