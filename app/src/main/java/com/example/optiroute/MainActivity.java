package com.example.optiroute;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity implements PuzzleAPITest.ApiCallback{

    //API 정보 표시를 위한 TextView
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // ActionBar 설정
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setIcon(R.mipmap.ic_launcher);
        }

        textView = findViewById(R.id.text_view); //TextView 초기화

        PuzzleAPITest apiTest = new PuzzleAPITest();
        apiTest.fetchData("2", "2207", this);
    }
    @Override
    public void onDataLoaded(JSONObject data) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                try {
                    textView.setText(data.toString(2)); // JSON 데이터를 보기 좋게 출력
                    Log.i("TAG","API Responce : " + data.toString(2));
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
                Log.e("TAG", "Error: " + error.getMessage());
            }
        });
    }
}



