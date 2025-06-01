package com.ghsoft.simplerecyclerview;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Random;

public class myAdapter extends RecyclerView.Adapter<myAdapter.MyViewHolder> {

    public int counter = 0;
    @NonNull
    @Override
    public myAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        return new MyViewHolder(view);
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textView;

        public MyViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textViewItem);
        }

        private int getRandomColor() {
            Random random = new Random();
            String colorCode = String.format("#%06X", (0xFFFFFF & random.nextInt()));
            return Color.parseColor(colorCode);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull myAdapter.MyViewHolder holder, int position) {
        counter++;
        holder.textView.setText(String.valueOf(counter));
        holder.textView.setTextColor(holder.getRandomColor());


    }

    @Override
    public int getItemCount() {
        return 100;
    }


}
