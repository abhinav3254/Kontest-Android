package com.example.kontest.recycler_view;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kontest.Pojo;
import com.example.kontest.R;
import com.example.kontest.database.DataBaseModel;
import com.example.kontest.extra_stuffs.ExtraThings;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.button.MaterialButton;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
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
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.new_layout_recycler_view,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.name.setText(list.get(position).getName());
        holder.start_time.setText(list.get(position).getStart_time().substring(0,10));
        holder.end_time.setText(list.get(position).getEnd_time().substring(0,10));

        holder.shareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                String shareBody = ""
                        +list.get(holder.getAdapterPosition()).getName()
                        +"\nstarts at "
                        +list.get(holder.getAdapterPosition()).getStart_time().substring(0,10)
                        +"\nand ends at "+list.get(holder.getAdapterPosition()).getEnd_time().substring(0,10)
                        +"\nregister at "+list.get(holder.getAdapterPosition()).getUrl()
                        +"\nget this app from https://github.com/abhinav3254";
                sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, ""+list.get(holder.getAdapterPosition()).getName());
                sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
                context.startActivity(Intent.createChooser(sharingIntent, "Share via"));
            }
        });

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

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ExtraThings.showBottomSheetDialog(context,list,holder.getAdapterPosition());
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
        MaterialButton register;
        ImageButton shareButton;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            start_time = itemView.findViewById(R.id.start_time);
            end_time = itemView.findViewById(R.id.end_time);
            imageView = itemView.findViewById(R.id.imageView);
            cardView = itemView.findViewById(R.id.cardView);
            register = itemView.findViewById(R.id.register);
            shareButton = itemView.findViewById(R.id.shareButton);

        }
    }
}
