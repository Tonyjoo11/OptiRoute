package com.example.optiroute;

import org.json.JSONObject;

public interface APICallback {
    void onDataLoaded(JSONObject data);
    void onError(Throwable error);
}