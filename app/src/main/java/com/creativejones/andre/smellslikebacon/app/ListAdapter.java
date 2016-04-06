package com.creativejones.andre.smellslikebacon.app;

import com.creativejones.andre.smellslikebacon.R;

public class ListAdapter extends RecyclerAdapter {

    ListFragment.OnRecipeSelected mListener;

    public ListAdapter(ListFragment.OnRecipeSelected listener) {
        mListener = listener;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.list_item;
    }

    @Override
    protected void onRecipeSelected(int index) {
        mListener.onListRecipeSelected(index);
    }
}
