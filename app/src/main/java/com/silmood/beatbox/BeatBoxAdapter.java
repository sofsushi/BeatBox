package com.silmood.beatbox;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import butterknife.Bind;
import butterknife.ButterKnife;

public class BeatBoxAdapter extends SimpleItemAdapter<Sound, BeatBoxAdapter.SoundHolder>{

    @Override
    protected int getItemView() {
        return R.layout.list_item_sound;
    }

    @Override
    protected SoundHolder getViewHolder(View view) {
        return new SoundHolder(view);
    }

    @Override
    public void onBindViewHolder(SoundHolder holder, int position) {
        holder.bindSound(getItem(position));
    }


    public static class SoundHolder extends RecyclerView.ViewHolder{
        @Bind(R.id.button_sound)
        Button mButton;

        private Sound mSound;

        public SoundHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bindSound(Sound sound) {
            mSound = sound;
            mButton.setText(sound.getName());
        }
    }

}
