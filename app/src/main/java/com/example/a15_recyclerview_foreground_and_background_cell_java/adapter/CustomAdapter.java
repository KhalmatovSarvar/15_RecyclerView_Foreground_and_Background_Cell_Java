package com.example.a15_recyclerview_foreground_and_background_cell_java.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a15_recyclerview_foreground_and_background_cell_java.R;
import com.example.a15_recyclerview_foreground_and_background_cell_java.model.Member;

import java.util.List;


public class CustomAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context context;
    List<Member> members;

    public CustomAdapter(Context context, List<Member> members) {
        this.context = context;
        this.members = members;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_custom_layout,parent,false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {}

    @Override
    public int getItemCount() {
        return members.size();
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        View view;
        public RelativeLayout view_background, view_foreground;
        public CustomViewHolder(View v) {
            super(v);
            view = v;

            view_background = view.findViewById(R.id.view_background);
            view_foreground = view.findViewById(R.id.view_foreground);
        }
    }
}
