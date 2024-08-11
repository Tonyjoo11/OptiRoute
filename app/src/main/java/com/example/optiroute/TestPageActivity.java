package com.example.optiroute;

// TestPageActivity.java

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;

import java.util.HashMap;

public class TestPageActivity extends AppCompatActivity {

    private ButtonHandler buttonHandler;

    JSONObject jsonData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_page);
    }
    public void onImageButtonClick(View view) {
        buttonHandler.navigationButtonClick(view);
    }

    //JSON 파싱 코드
//    public void parseJSON(String jsonString, String apiType) {
//        HashMap<String, String> resHashMap = new HashMap<>();
//        try {
//            jsonData = new JSONObject(jsonString);
//            switch (apiType){
//                case "":
//                    Log.e(this + "::JSON Parsing", "NO JSON DATA");
//                case "seoul.realtimeStationArrival":
//                    JSONObject result = jsonData.getJSONObject("RESULT");
//
//                    String code = result.getString("CODE");
//                    resHashMap.put("CODE", code);
//
//                    String message = result.getString("MESSAGE");
//                    resHashMap.put("MESSAGE", message);
//
//                    if (code.contains("ERROR")){
//                        Log.e("TestPageActivity::JSON Parsing", code + "\nMESSAGE : " + message);
//                        Toast.makeText(this, code, Toast.LENGTH_SHORT).show();
//                        break;
//                    }
//                    else{
//                        if(code.equals("INFO-200")){
//                            Log.w("TestPageActivity::JSON Parsing", "Data Not Found");
//                            Toast.makeText(this, "Data Not Found", Toast.LENGTH_SHORT).show();
//                            break;
//                        }
//                        //TODO : 정상 처리 되었을 시 데이터 마저 파싱
//                    }
//            }
//        } catch (JSONException e){
//            e.printStackTrace();
//            Log.e("TestPageActivity::JSON Parsing","Error" + e);
//        }
//    }


}

