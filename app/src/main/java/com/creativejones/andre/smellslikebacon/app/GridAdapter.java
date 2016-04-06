package com.creativejones.andre.smellslikebacon.app;

import com.creativejones.andre.smellslikebacon.R;

public class GridAdapter extends RecyclerAdapter {

    GridFragment.OnRecipeSelected mListenter;

    public GridAdapter(GridFragment.OnRecipeSelected listener) {
        mListenter = listener;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.griditem;
    }

    @Override
    protected void onRecipeSelected(int index) {
        mListenter.onGridRecipeSelected(index);
    }
}
