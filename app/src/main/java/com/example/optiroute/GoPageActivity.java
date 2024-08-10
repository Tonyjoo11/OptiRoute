package com.example.optiroute;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class GoPageActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RouteAdapter adapter;
    private List<Route> routeList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.go_page);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Sample data
        routeList = new ArrayList<>();
        routeList.add(new Route(R.drawable.ic_bus, "Station A to Station B", "30 min"));
        routeList.add(new Route(R.drawable.ic_subway, "Station C to Station D", "45 min"));
        routeList.add(new Route(R.drawable.ic_walk, "Station E to Station F", "15 min"));

        adapter = new RouteAdapter(routeList);
        recyclerView.setAdapter(adapter);
    }
}
