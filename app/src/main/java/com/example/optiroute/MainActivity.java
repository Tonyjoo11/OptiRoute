package com.example.optiroute;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity implements APICallback{

    //API 정보 표시를 위한 TextView
    private TextView textView;
    public String dataStr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // ActionBar 설정
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setIcon(R.mipmap.ic_launcher);
        }

        textView = findViewById(R.id.first); //TextView 초기화


        //API 설정 구간
        PuzzleAPITest puzzleApiTest = new PuzzleAPITest();
//        puzzleApiTest.fetchData("2", "2207", this);
        SeoulAPITest.RealtimeStationArrival realtimeStationArrival = new SeoulAPITest().new RealtimeStationArrival();
//        realtimeStationArrival.fetchData("수원", this);

    }
    @Override
    public void onDataLoaded(JSONObject data) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                try {
//                    textView.setText(data.toString(2)); // JSON 데이터를 보기 좋게 출력
                    Log.i("APITest","API Responce : " + data.toString(2));
                    dataStr = data.toString(2);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }
    @Override
    public void onError(Throwable error) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(MainActivity.this, "Error: " + error.getMessage(), Toast.LENGTH_SHORT).show();
                Log.e("APITest", "Error: " + error.getMessage());
            }
        });
        ImageButton settingButton = findViewById(R.id.Setting);

        settingButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TestPageActivity.class);
                startActivity(intent);
            }
        });
    }
}



