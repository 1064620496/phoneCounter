package com.example.a12260.szh.ui;

import android.view.View;

import com.example.a12260.szh.R;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class OneChartViewHolder extends RecyclerView.ViewHolder {
    public View chart;
    public OneChartViewHolder(@NonNull View itemView) {
        super(itemView);
        chart = itemView.findViewById(R.id.constraintLayout);
    }
}
