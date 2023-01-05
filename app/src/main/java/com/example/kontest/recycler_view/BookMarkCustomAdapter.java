package com.example.kontest.recycler_view;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kontest.BookMarkActivity;
import com.example.kontest.R;
import com.example.kontest.database.DataBaseModel;
import com.example.kontest.extra_stuffs.ExtraThings;
import com.google.android.material.button.MaterialButton;

import java.util.List;

public class BookMarkCustomAdapter extends RecyclerView.Adapter<BookMarkCustomAdapter.BookMarksViewHolder> {

    Context context;
    List<DataBaseModel> list;

    public BookMarkCustomAdapter(Context context, List<DataBaseModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public BookMarksViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new BookMarksViewHolder(LayoutInflater.from(context).inflate(R.layout.new_layout_recycler_view,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull BookMarksViewHolder holder, int position) {
        holder.name.setText(list.get(position).getName());
        holder.start_time.setText(list.get(position).getStart_time().substring(0,11));
        holder.end_time.setText(list.get(position).getEnd_time().substring(0,11));

        holder.register.setText("Delete");

        holder.register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                ExtraThings.deleteOneHelper(list.get(holder.getAdapterPosition()).getId(),context);
                ExtraThings.getConfirmDialog(list.get(holder.getAdapterPosition()).getId(),context);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class BookMarksViewHolder extends RecyclerView.ViewHolder {
        TextView name,start_time,end_time,in_24_hours,status;
        ImageView imageView;
        CardView cardView;
        MaterialButton register;
        ImageButton shareButton;
        public BookMarksViewHolder(@NonNull View itemView) {
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
