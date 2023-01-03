package com.example.kontests;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.kontests.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    List<Pojo> list;
    ActivityMainBinding binding;
    String path;

    APInterface apInterface;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        apInterface =RetrofitInstance.getRetrofit().create(APInterface.class);

        recyclerView = findViewById(R.id.recycler);

        list = new ArrayList<>();

        binding.allBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSpecific("hacker_rank");
                Intent intent = new Intent(MainActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        getAllMethod();

    }

    void getAllMethod () {
        apInterface.getAll().enqueue(new Callback<List<Pojo>>() {
            @Override
            public void onResponse(Call<List<Pojo>> call, Response<List<Pojo>> response) {
                list = response.body();
                CustomAdapter adapter = new CustomAdapter(MainActivity.this,list);
                recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<Pojo>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Internet", Toast.LENGTH_SHORT).show();
            }
        });
    }

    void getSpecific (String url) {
        apInterface.getSpecific(url).enqueue(new Callback<List<Pojo>>() {
            @Override
            public void onResponse(Call<List<Pojo>> call, Response<List<Pojo>> response) {
                list = response.body();
                CustomAdapter adapter = new CustomAdapter(MainActivity.this,list);
                recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<Pojo>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Internet", Toast.LENGTH_SHORT).show();
            }
        });
    }
}