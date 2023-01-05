package com.example.kontest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.View;

import com.example.kontest.database.DataBaseModel;
import com.example.kontest.databinding.ActivityBookMarkBinding;
import com.example.kontest.databinding.ActivityMainBinding;
import com.example.kontest.extra_stuffs.ExtraThings;
import com.example.kontest.recycler_view.BookMarkCustomAdapter;
import com.example.kontest.recycler_view.CustomAdapter;

import java.util.List;

public class BookMarkActivity extends AppCompatActivity {

    ActivityBookMarkBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBookMarkBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        recyclerViewMethod();
    }

    void recyclerViewMethod () {
        List<DataBaseModel> list = ExtraThings.readDataFromDatabase(BookMarkActivity.this);
        if (list.size()==0) {
            binding.emptyImageBookMark.setVisibility(View.VISIBLE);
            binding.emptyTextBookMark.setVisibility(View.VISIBLE);
        } else {
            binding.emptyImageBookMark.setVisibility(View.GONE);
            binding.emptyTextBookMark.setVisibility(View.GONE);
            BookMarkCustomAdapter adapter = new BookMarkCustomAdapter(BookMarkActivity.this, list);
            binding.bookmarkActivityRecyclerView.setLayoutManager(new LinearLayoutManager(BookMarkActivity.this));
            binding.bookmarkActivityRecyclerView.setAdapter(adapter);
        }
    }
}