package com.silmood.beatbox;

import android.view.View;
import android.widget.Button;

import butterknife.Bind;

public class BeatBoxAdapter extends SimpleItemAdapter<Sound, BeatBoxAdapter.SoundHolder> {

    private ItemClickListener<Sound> mItemClickListener;

    public BeatBoxAdapter(ItemClickListener itemClickListener) {
        mItemClickListener = itemClickListener;
    }

    @Override
    protected int getItemView() {
        return R.layout.list_item_sound;
    }

    @Override
    protected SoundHolder getViewHolder(View view) {
        return new SoundHolder(view, mItemClickListener);
    }

    @Override
    public void onBindViewHolder(SoundHolder holder, int position) {
        holder.bindData(getItem(position));
    }

    public static class SoundHolder extends ViewHolderClickable<Sound> {
        @Bind(R.id.button_sound)
        Button mButton;

        public SoundHolder(View itemView, ItemClickListener<Sound> itemClickListener) {
            super(itemView, itemClickListener);
        }

        @Override
        public void bindData(Sound data) {
            super.bindData(data);

            mButton.setText(data.getName());
        }
    }

}
