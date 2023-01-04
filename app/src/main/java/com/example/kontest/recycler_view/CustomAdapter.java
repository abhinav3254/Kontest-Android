package com.example.kontest.recycler_view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kontest.Pojo;
import com.example.kontest.R;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {

    private Context context;
    private List<Pojo> list;

    public CustomAdapter(Context context, List<Pojo> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.recycler_layout,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.name.setText(list.get(position).getName());
        holder.url.setText(list.get(position).getUrl());
        holder.start_time.setText(list.get(position).getStart_time());
        holder.end_time.setText(list.get(position).getEnd_time());
        holder.duration.setText(list.get(position).getDuration());
        holder.site.setText(list.get(position).getSite());
        holder.in_24_hours.setText(list.get(position).getIn_24_hours());
        holder.status.setText(list.get(position).getStatus());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name,url,start_time,end_time,duration,site,in_24_hours,status;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            url = itemView.findViewById(R.id.url);
            start_time = itemView.findViewById(R.id.start_time);
            end_time = itemView.findViewById(R.id.end_time);
            duration = itemView.findViewById(R.id.duration);
            site = itemView.findViewById(R.id.site);
            in_24_hours = itemView.findViewById(R.id.in_24_hours);
            status = itemView.findViewById(R.id.status);

        }
    }
}
