package com.example.optiroute;

import org.json.JSONObject;
import org.json.XML;

public interface APICallback {
    void onDataLoaded(JSONObject data);
    void onError(Throwable error);
}