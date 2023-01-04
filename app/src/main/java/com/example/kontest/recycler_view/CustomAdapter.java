package com.example.kontest.recycler_view;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kontest.Pojo;
import com.example.kontest.R;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

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
//        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.recycler_layout,parent,false));
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.new_layout_recycler_view,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.name.setText(list.get(position).getName());
//        holder.url.setText(list.get(position).getUrl());
        holder.start_time.setText(list.get(position).getStart_time().substring(0,10));
        holder.end_time.setText(list.get(position).getEnd_time().substring(0,10));
//        holder.duration.setText(list.get(position).getDuration());
//        holder.site.setText(list.get(position).getSite());
        holder.in_24_hours.setText(list.get(position).getIn_24_hours());
        holder.status.setText(list.get(position).getStatus());

        if ((list.get(position).getUrl()).contains("codeforces")) {
            holder.imageView.setImageResource(R.drawable.codeforces_svgrepo_com);
        } else if ((list.get(position).getUrl()).contains("leetcode")) {
            holder.imageView.setImageResource(R.drawable.leetcode_svgrepo_com);
        } else if ((list.get(position).getUrl()).contains("google")) {
            holder.imageView.setImageResource(R.drawable.google_svgrepo_com);
        }else if ((list.get(position).getUrl()).contains("hackerearth")) {
            holder.imageView.setImageResource(R.drawable.hackerearth_svgrepo_com);
        } else if ((list.get(position).getUrl()).contains("hackerrank")) {
            holder.imageView.setImageResource(R.drawable.hackerrank_svgrepo_com);
        } else if ((list.get(position).getUrl()).contains("codechef")) {
            holder.imageView.setImageResource(R.drawable.icons8_codechef);
        }

        holder.register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(list.get(holder.getLayoutPosition()).getUrl()));
                context.startActivity(browserIntent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
//        TextView name,url,start_time,end_time,duration,site,in_24_hours,status;
        TextView name,start_time,end_time,in_24_hours,status;
        ImageView imageView;
        CardView cardView;
        Button register;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
//            url = itemView.findViewById(R.id.url);
            start_time = itemView.findViewById(R.id.start_time);
            end_time = itemView.findViewById(R.id.end_time);
//            duration = itemView.findViewById(R.id.duration);
//            site = itemView.findViewById(R.id.site);
            in_24_hours = itemView.findViewById(R.id.in_24_hours);
            status = itemView.findViewById(R.id.status);
            imageView = itemView.findViewById(R.id.image);
            cardView = itemView.findViewById(R.id.cardView);
            register = itemView.findViewById(R.id.register);

        }
    }
}
