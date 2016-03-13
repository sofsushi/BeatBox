package com.silmood.beatbox;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public abstract class SimpleItemAdapter<T,E extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<E> {

    private List<T> mList;

    public SimpleItemAdapter() {
        mList = new ArrayList<>();
    }

    @Override
    public E onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).
                inflate(getItemView(), parent, false);

        return getViewHolder(v);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public void setItems(List<T> items) {
        mList = items;
        notifyDataSetChanged();
    }

    public void addAll(List<T> items) {
        int finalPos = mList.size() - 1;

        mList.addAll(items);
        notifyItemRangeInserted(finalPos, items.size());
    }

    public void addItem(T item) {
        int finalPos = mList.size() - 1;

        mList.add(item);
        notifyItemInserted(finalPos);
    }

    public T getItem (int position) {
        return mList.get(position);
    }
    protected abstract int getItemView();

    protected abstract E getViewHolder(View view);
}
