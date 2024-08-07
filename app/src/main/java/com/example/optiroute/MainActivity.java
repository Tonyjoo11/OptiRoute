package com.example.optiroute;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);

        Button cat1Button = findViewById(R.id.Cat1);
        Button cat2Button = findViewById(R.id.Cat2);
        Button cat3Button = findViewById(R.id.Cat3);
        Button cat4Button = findViewById(R.id.Cat4);
        Button cat5Button = findViewById(R.id.Cat5);
        Button moreButton = findViewById(R.id.More);

        cat1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Ai pick button clicked", Toast.LENGTH_SHORT).show();
            }
        });

        cat2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Coffee button clicked", Toast.LENGTH_SHORT).show();
            }
        });

        cat3Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Restaurant button clicked", Toast.LENGTH_SHORT).show();
            }
        });

        cat4Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Gas button clicked", Toast.LENGTH_SHORT).show();
            }
        });

        cat5Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Shopping button clicked", Toast.LENGTH_SHORT).show();
            }
        });

        moreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "More button clicked", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
