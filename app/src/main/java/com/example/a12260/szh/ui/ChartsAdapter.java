package com.example.a12260.szh.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.a12260.szh.R;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ChartsAdapter extends RecyclerView.Adapter {
    public static final int ONE_CHART = 0, TWO_CHART = 1;
    private List<List<View>> views;
    private List<Integer> viewTypes;

    public ChartsAdapter(List<List<View>> views, List<Integer> viewTypes) {
        this.views = views;
        this.viewTypes = viewTypes;
    }

    @Override
    public int getItemViewType(int position) {
        return viewTypes.get(position);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == ONE_CHART) {

            return new OneChartViewHolder(
                    LayoutInflater.from(parent.getContext()).inflate(R.layout.one_chart, parent, false));
        }

        if (viewType == TWO_CHART) {
            return new OneChartViewHolder(
                    LayoutInflater.from(parent.getContext()).inflate(R.layout.two_chart, parent, false));

        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        List<View> view = views.get(position);
        if (holder instanceof TwoChartViewHolder) {
            ((ViewGroup)((TwoChartViewHolder) holder).chartDown).addView(view.get(0));
            ((ViewGroup)((TwoChartViewHolder) holder).chartUp).addView(view.get(1));
        }

        if (holder instanceof OneChartViewHolder) {

            ((ViewGroup)((OneChartViewHolder) holder).chart).addView(view.get(0));
        }
    }

    @Override
    public int getItemCount() {
        return Math.max(views.size(), viewTypes.size());
    }
}
