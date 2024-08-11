package com.example.optiroute;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RouteAdapter extends RecyclerView.Adapter<RouteAdapter.RouteViewHolder> {

    private List<Route> routeList;

    public RouteAdapter(List<Route> routeList) {
        this.routeList = routeList;
    }

    @Override
    public RouteViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_route, parent, false);
        return new RouteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RouteViewHolder holder, int position) {
        Route route = routeList.get(position);
        holder.transportIcon.setImageResource(route.getTransportIcon());
        holder.routeInfo.setText(route.getRouteInfo());
        holder.travelTime.setText(route.getTravelTime());
    }

    @Override
    public int getItemCount() {
        return routeList.size();
    }

    public static class RouteViewHolder extends RecyclerView.ViewHolder {

        ImageView transportIcon;
        TextView routeInfo;
        TextView travelTime;

        public RouteViewHolder(View itemView) {
            super(itemView);
            transportIcon = itemView.findViewById(R.id.transport_icon);
            routeInfo = itemView.findViewById(R.id.route_info);
            travelTime = itemView.findViewById(R.id.travel_time);
        }
    }
}

