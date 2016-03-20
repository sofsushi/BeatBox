package com.silmood.beatbox;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class BeatBoxFragment extends BaseListFragment {

    public static final int SPAN_COUNT = 3;

    private BeatBoxAdapter mBeatBoxAdapter;
    private BeatBox mBeatBox;

    public static BeatBoxFragment newInstance() {

        Bundle args = new Bundle();

        BeatBoxFragment fragment = new BeatBoxFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        mBeatBox = new BeatBox(getContext());
    }

    @Override
    public void initView(View view, Bundle savedInstanceState) {
        super.initView(view, savedInstanceState);
        mBeatBoxAdapter.addAll(mBeatBox.getSounds());
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mBeatBox.release();
    }

    @Override
    protected RecyclerView.Adapter getAdapter() {
        return mBeatBoxAdapter = new BeatBoxAdapter(new ItemClickListener<Sound>() {
            @Override
            public void onItemClick(Sound item) {
                mBeatBox.play(item);
            }
        });
    }

    @Override
    protected RecyclerView.LayoutManager getLayoutManager() {
        return new GridLayoutManager(getContext(), SPAN_COUNT);
    }
}
