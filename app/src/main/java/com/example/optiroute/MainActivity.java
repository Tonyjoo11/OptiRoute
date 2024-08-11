package com.example.optiroute;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.optiroute.API.PuzzleAPITest;
import com.example.optiroute.API.SeoulAPITest;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import org.json.JSONObject;
import org.json.XML;

public class MainActivity extends AppCompatActivity implements APICallback{

    //API 정보 표시를 위한 TextView
    private TextView textView;
    public static String dataStr = "NO DATA";
    String apiType = "";

    private ButtonHandler buttonHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // ActionBar 설정
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setIcon(R.mipmap.ic_launcher);
        }
        //API 설정 구간
        PuzzleAPITest puzzleApiTest = new PuzzleAPITest();
//        puzzleApiTest.fetchData("2", "2207", this);
//        apiType = "puzzle.realtimeTrainInfo";


        //서울시 API는 서버 이슈로 작동 안됨 (ERROR-500)
        SeoulAPITest.RealtimeStationArrival realtimeStationArrival = new SeoulAPITest().new RealtimeStationArrival();
        realtimeStationArrival.fetchData("수원", this);

        apiType = "seoul.realtimeStationArrival";

        //지도 관련 설정
        MapsMarkerActivity mapsMarkerActivity = new MapsMarkerActivity();
        mapsMarkerActivity.initMapView(savedInstanceState);

        //ButtonHandler 초기화
        buttonHandler = new ButtonHandler(this);
    }


    public void onImageButtonClick(View view) {
        if(buttonHandler != null){
            buttonHandler.navigationButtonClick(view);
        } else {
            Log.e("MainActivity", "ButtonHandler is null!");
        }

    }
    public class MapsMarkerActivity implements OnMapReadyCallback {

        private MapView mapView;
        private static final String MAP_VIEW_BUNDLE_KEY = "MapViewBundleKey";

        public void initMapView(Bundle savedInstanceState) {
            // Get the MapView from the layout
            mapView = findViewById(R.id.mapView);

            // Initialize the MapView
            if (mapView != null ) {
                Bundle mapViewBundle = null;
                if (savedInstanceState != null) {
                    mapViewBundle = savedInstanceState.getBundle(MAP_VIEW_BUNDLE_KEY);
                }
                mapView.onCreate(mapViewBundle);

                // Set the map ready callback
                mapView.getMapAsync(this);
            } else {
                // 로그를 통해 null 상태 확인
                Log.e("MapsMarkerActivity", "MapView is null. Check if the view ID is correct.");
            }
        }

        @Override
        public void onMapReady(GoogleMap googleMap) {
            googleMap.getUiSettings().setZoomControlsEnabled(true);

            LatLng seoul = new LatLng(37.5664056, 126.9778222);
            googleMap.addMarker(new MarkerOptions().position(seoul).title("Marker in Seoul"));
            googleMap.moveCamera(CameraUpdateFactory.newLatLng(seoul));
        }

        // MapView의 수명 주기 관련 메소드들
        public void onResume() {
            if (mapView != null){
                mapView.onResume();
            }
        }

        public void onPause() {
            mapView.onPause();
        }

        public void onDestroy() {
            mapView.onDestroy();
        }

        public void onLowMemory() {
            mapView.onLowMemory();
        }

        public void onSaveInstanceState(@NonNull Bundle outState) {
            Bundle mapViewBundle = outState.getBundle(MAP_VIEW_BUNDLE_KEY);
            if (mapViewBundle == null) {
                mapViewBundle = new Bundle();
                outState.putBundle(MAP_VIEW_BUNDLE_KEY, mapViewBundle);
            }
            mapView.onSaveInstanceState(mapViewBundle);
        }
    }


    @Override
    public void onDataLoaded(JSONObject data) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                try {
//                    textView.setText(data.toString(2)); // JSON 데이터를 보기 좋게 출력
                    byte[] encodedBytes = data.toString(2).getBytes("EUC-KR");
                    Log.i("APITest","API Responce : " +new String(encodedBytes,"UTF-8"));
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
    }
    // 지도 관련 메서드들
    // MainActivity의 수명 주기 메서드에서 지도 관련 메서드 호출
    @Override
    protected void onResume() {
        super.onResume();
        // 지도 관련 작업도 같이 처리
        ((MapsMarkerActivity) new MapsMarkerActivity()).onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        // 지도 관련 작업도 같이 처리
        ((MapsMarkerActivity) new MapsMarkerActivity()).onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // 지도 관련 작업도 같이 처리
        ((MapsMarkerActivity) new MapsMarkerActivity()).onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        // 지도 관련 작업도 같이 처리
        ((MapsMarkerActivity) new MapsMarkerActivity()).onLowMemory();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        // 지도 관련 작업도 같이 처리
        ((MapsMarkerActivity) new MapsMarkerActivity()).onSaveInstanceState(outState);
    }
}




