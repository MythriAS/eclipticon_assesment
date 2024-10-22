package com.example.uidesign;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder> {
    private List<Section> sections;

    public HomeAdapter(List<Section> sections) {
        this.sections = sections;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_section, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Section section = sections.get(position);
        holder.title.setText(section.getTitle());

        holder.horizontalRecyclerView.setLayoutManager(new LinearLayoutManager(holder.itemView.getContext(), LinearLayoutManager.HORIZONTAL, false));
        HorizontalItemAdapter horizontalItemAdapter = new HorizontalItemAdapter(section.getItems());
        holder.horizontalRecyclerView.setAdapter(horizontalItemAdapter);
    }

    @Override
    public int getItemCount() {
        return sections.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        RecyclerView horizontalRecyclerView;

        ViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.section_title);
            horizontalRecyclerView = itemView.findViewById(R.id.horizontal_recycler_view);
        }
    }
}


