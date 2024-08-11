package com.example.optiroute;

import android.content.Context;
import android.content.Intent;
import android.view.View;
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
            Intent intent = new Intent(context, ExploreActivity.class);
            context.startActivity(intent);
        } else if (id == R.id.Go) {
            Intent intent = new Intent(context, GoActivity.class);
            context.startActivity(intent);
        } else if (id == R.id.Ai) {
            Intent intent = new Intent(context, AiActivity.class);
            context.startActivity(intent);
        } else if (id == R.id.Saved) {
            Intent intent = new Intent(context, SavedActivity.class);
            context.startActivity(intent);
        } else if (id == R.id.Setting) {
            Intent intent = new Intent(context, SettingActivity.class);
            context.startActivity(intent);
        } else {
            Toast.makeText(context, "Button not recognized", Toast.LENGTH_SHORT).show();
        }
    }
}
