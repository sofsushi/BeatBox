package com.silmood.beatbox;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

public abstract class BaseListFragment extends BaseFragment{

    @Bind(R.id.list)
    RecyclerView mList;

    @Override
    protected int getFragmentLayout() {
        return R.layout.fragment_list;
    }

    @Override
    public void initView(View view, Bundle savedInstanceState) {
        super.initView(view, savedInstanceState);

        mList = setDecoration(getDecorators(), mList);
        mList.setLayoutManager(getLayoutManager());
        mList.setAdapter(getAdapter());
    }



    protected abstract RecyclerView.Adapter getAdapter();

    protected abstract RecyclerView.LayoutManager getLayoutManager();

    /**
     * @return Return a list with all the items to set on RecyclerView
     * */
    protected List<RecyclerView.ItemDecoration> getDecorators() {
        return new ArrayList<>();
    }

    private RecyclerView setDecoration(List<RecyclerView.ItemDecoration> decoration, RecyclerView list){
        for (RecyclerView.ItemDecoration itemDecoration : decoration) {
            list.addItemDecoration(itemDecoration);
        }

        return list;
    }
}
