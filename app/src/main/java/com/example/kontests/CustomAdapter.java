package com.example.kontests;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {


    Context context;
    List<Pojo> list;

    public CustomAdapter(Context context, List<Pojo> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycler_view_layout,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.name.setText(list.get(position).getName());
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

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView name,url,start_time,end_time,duration,site,in_24_hours,status;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
//            url = itemView.findViewById(R.id.ur);
            start_time = itemView.findViewById(R.id.start_time);
            end_time = itemView.findViewById(R.id.end_time);
            duration = itemView.findViewById(R.id.duration);
            site = itemView.findViewById(R.id.site);
            in_24_hours = itemView.findViewById(R.id.in_24_hours);
            status = itemView.findViewById(R.id.status);
        }
    }
}
