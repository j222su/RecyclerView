package com.example.recyclerview;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.CustomViewHolder> {

    private int layout; //부분화면을 구성하는 xml을 생성자로 받는다.
    private ArrayList<MainData> list; //부분화면에 들어갈 데이터 클래스를 ArrayList 타입으로 정의한다.

    public MainAdapter(int layout, ArrayList<MainData> list) {
        this.layout = layout;
        this.list = list;
    }

    /**
     * RecyclerView는  RecyclerView.Adapter를 상속받아 Adapter를 직접 구현해야 한다.
     * ->RecyclerView.Adapter<MainAdapter.CustomViewHolder>
     * CustomViewHolder는 내가 지은 것!
     */

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
