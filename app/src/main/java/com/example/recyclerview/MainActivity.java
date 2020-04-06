package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private RecyclerView recyclerView;
    private ArrayList<MainData> list=new ArrayList<>();
    private Button btnAdd;
    private LinearLayoutManager linearLayoutManager;
    private MainAdapter mainAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=findViewById(R.id.recyclerView);
        btnAdd=findViewById(R.id.btnAdd);
        linearLayoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        mainAdapter=new MainAdapter(R.layout.list_item, list);
        recyclerView.setAdapter(mainAdapter);

        btnAdd.setOnClickListener(this);

        Log.d("리사이클러뷰", "onCreate()");
    }

    @Override
    public void onClick(View view) {
        MainData mainData=new MainData(R.mipmap.ic_launcher, "Hello");
        list.add(mainData);
        mainAdapter.notifyDataSetChanged();
    }
}
