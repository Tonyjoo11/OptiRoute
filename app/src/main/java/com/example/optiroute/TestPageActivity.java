package com.example.optiroute;

// TestPageActivity.java
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class TestPageActivity extends AppCompatActivity {

    private ButtonHandler buttonHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_page);
    }
    public void onImageButtonClick(View view) {
        buttonHandler.navigationButtonClick(view);
    }
}

