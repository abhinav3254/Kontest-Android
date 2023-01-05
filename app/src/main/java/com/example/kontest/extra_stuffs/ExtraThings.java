package com.example.kontest.extra_stuffs;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;

import com.example.kontest.BookMarkActivity;
import com.example.kontest.MainActivity;
import com.example.kontest.Pojo;
import com.example.kontest.R;
import com.example.kontest.database.DBHelper;
import com.example.kontest.database.DataBaseModel;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class ExtraThings {

    static Context context;
    static DBHelper dbHelper;
    static List<DataBaseModel> list;
    static DataBaseModel model;

    private static TextView name,start_time,start_time_time,end_time,end_time_time,duration,in_24_hours;
    private static ImageView imageView,status_img,bookmark_btn;
    private static final DecimalFormat df = new DecimalFormat("0.00");

    public static void showBottomSheetDialog(Context context, List<Pojo> list,int position) {

        final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(context);
        bottomSheetDialog.setContentView(R.layout.bottom_sheet);

        imageView = bottomSheetDialog.findViewById(R.id.image);
        status_img = bottomSheetDialog.findViewById(R.id.status_img);
        bookmark_btn = bottomSheetDialog.findViewById(R.id.bookmark_btn);

        name = bottomSheetDialog.findViewById(R.id.name);
        start_time = bottomSheetDialog.findViewById(R.id.start_time);
        start_time_time = bottomSheetDialog.findViewById(R.id.start_time_time);
        end_time = bottomSheetDialog.findViewById(R.id.end_time);
        end_time_time = bottomSheetDialog.findViewById(R.id.end_time_time);
        duration = bottomSheetDialog.findViewById(R.id.duration);
        in_24_hours = bottomSheetDialog.findViewById(R.id.in_24_hours);

        name.setText(list.get(position).getName());
        start_time.setText(list.get(position).getStart_time().substring(0,10));
        end_time.setText(list.get(position).getEnd_time().substring(0,10));
        duration.setText((df.format(Double.parseDouble(list.get(position).getDuration())/3600.0))+" hrs");

        if (list.get(position).getIn_24_hours().equalsIgnoreCase("YES")) {
            in_24_hours.setText("Within 24 Hours");
        }

        start_time_time.setText(list.get(position).getStart_time().substring(11,16));
        end_time_time.setText(list.get(position).getEnd_time().substring(11,16));

        if (list.get(position).getStatus().charAt(0) == 'C') {
            status_img.setImageResource(R.drawable.live);
        }

        if ((list.get(position).getUrl()).contains("codeforces")) {
            imageView.setImageResource(R.drawable.codeforces_svgrepo_com);
        } else if ((list.get(position).getUrl()).contains("leetcode")) {
            imageView.setImageResource(R.drawable.leetcode_svgrepo_com);
        } else if ((list.get(position).getUrl()).contains("google")) {
            imageView.setImageResource(R.drawable.google_svgrepo_com);
        }else if ((list.get(position).getUrl()).contains("hackerearth")) {
            imageView.setImageResource(R.drawable.hackerearth_svgrepo_com);
        } else if ((list.get(position).getUrl()).contains("hackerrank")) {
            imageView.setImageResource(R.drawable.hackerrank_svgrepo_com);
        } else if ((list.get(position).getUrl()).contains("codechef")) {
            imageView.setImageResource(R.drawable.icons8_codechef);
        }

        bookmark_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbHelper = new DBHelper(context);
                dbHelper.insertData(list.get(position).getName(),list.get(position).getUrl(),list.get(position).getStart_time(),list.get(position).getEnd_time(),list.get(position).getDuration(),list.get(position).getSite(),list.get(position).getIn_24_hours(),list.get(position).getStatus());
                bookmark_btn.setVisibility(View.GONE);
            }
        });

        bottomSheetDialog.show();
    }

    public static List<DataBaseModel> readDataFromDatabase (Context context) {
        DBHelper dbHelper = new DBHelper(context);
        Cursor cursor = dbHelper.readAllData();
        List<DataBaseModel> dataBaseModelList = new ArrayList<>();

        if (cursor!=null && cursor.getCount()>0) {
            if (cursor.moveToFirst()) {
                do {
                    dataBaseModelList.add(new DataBaseModel(cursor.getString(0),cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(4),cursor.getString(5),cursor.getString(6),cursor.getString(7),cursor.getString(8)));
                } while (cursor.moveToNext());
            }
        } else {
            Toast.makeText(context, "Nothing to show", Toast.LENGTH_SHORT).show();
        }
        return dataBaseModelList;
    }

    public static void deleteOneHelper (String id,Context context1) {
        dbHelper = new DBHelper(context1);
        dbHelper.deleteDataOne(id);
    }

    public static void getConfirmDialog(String id,Context context1) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context1);
        builder.setTitle("Delete All?");
        builder.setMessage("Are you sure to delete all Data ?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                deleteOneHelper(id,context1);
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });

        builder.create().show();
    }
}

