package com.example.optiroute;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;

public class ButtonHandler {

    private Context context;

    public ButtonHandler(Context context) {
        this.context = context;
    }

    public void navigationButtonClick(View view) {
        int id = view.getId();
        if (id == R.id.Explore) {
            Toast.makeText(context, "Explore clicked", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.Go) {
            Toast.makeText(context, "Go clicked", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.Ai) {
            Toast.makeText(context, "AI clicked", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.Saved) {
            Toast.makeText(context, "Saved clicked", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.Setting) {
            Intent intent = new Intent(context, TestPageActivity.class);
            context.startActivity(intent);
        }
    }

}

