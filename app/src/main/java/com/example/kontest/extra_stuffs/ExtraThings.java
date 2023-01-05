package com.example.kontest.extra_stuffs;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kontest.Pojo;
import com.example.kontest.R;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.text.DecimalFormat;
import java.util.List;

public class ExtraThings {

    private static TextView name,start_time,start_time_time,end_time,end_time_time,duration,in_24_hours;
    private static ImageView imageView,status_img;
    private static final DecimalFormat df = new DecimalFormat("0.00");

    public static void showBottomSheetDialog(Context context, List<Pojo> list,int position) {

        final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(context);
        bottomSheetDialog.setContentView(R.layout.bottom_sheet);

        imageView = bottomSheetDialog.findViewById(R.id.image);
        status_img = bottomSheetDialog.findViewById(R.id.status_img);

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

        bottomSheetDialog.show();
    }
}
