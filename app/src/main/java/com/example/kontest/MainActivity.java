package com.example.kontest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.kontest.api.APIHandle;
import com.example.kontest.databinding.ActivityMainBinding;
import com.example.kontest.recycler_view.CustomAdapter;

import java.net.URL;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    ActivityMainBinding binding;
    APIHandle.CallAPIInterface callAPIInterface;
    List<Pojo> list;
    CustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.all.setOnClickListener(this);
        binding.codeforces.setOnClickListener(this);
        binding.leetCode.setOnClickListener(this);
        binding.codeforcesGym.setOnClickListener(this);
        binding.topCoder.setOnClickListener(this);
        binding.atCoder.setOnClickListener(this);
        binding.codeChef.setOnClickListener(this);
        binding.csAcademy.setOnClickListener(this);
        binding.hackerRank.setOnClickListener(this);
        binding.hackerEarth.setOnClickListener(this);
        binding.kickStart.setOnClickListener(this);


        byDefault("all");

    }

    void byDefault (String URL) {
        callAPIInterface = APIHandle.getAPIHandleMethod();
        callAPIInterface.getAll(URL).enqueue(new Callback<List<Pojo>>() {
            @Override
            public void onResponse(Call<List<Pojo>> call, Response<List<Pojo>> response) {
                if (response.body().size()>0) {
                    list = response.body();
                    adapter = new CustomAdapter(MainActivity.this,list);
                    binding.recyclerMain.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                    binding.recyclerMain.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<List<Pojo>> call, Throwable t) {

            }
        });
    }

    @Override
    public void onClick(View view) {
        Button button = (Button) view;
        String URL = button.getText().toString();
        byDefault(URL);
        Log.d("URL-->",URL);
    }
}