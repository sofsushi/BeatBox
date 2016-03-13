package com.silmood.beatbox;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import butterknife.ButterKnife;

public class ViewHolderClickable<T> extends RecyclerView.ViewHolder implements View.OnClickListener {

    ItemClickListener<T> mItemClickListener;
    T mData;

    public ViewHolderClickable(View itemView, ItemClickListener<T> itemClickListener) {
        super(itemView);
        mItemClickListener = itemClickListener;
        ButterKnife.bind(this, itemView);
        itemView.setOnClickListener(this);
    }

    public void bindData(T data) {
        mData = data;
    }

    @Override
    public void onClick(View v) {
        mItemClickListener.onItemClick(mData);
    }
}

