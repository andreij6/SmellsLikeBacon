package com.creativejones.andre.smellslikebacon.app;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.creativejones.andre.smellslikebacon.R;

public class GridFragment extends Fragment {

    public static ListFragment newInstance() {
        return new ListFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recyclerview, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        OnRecipeSelected listener = (OnRecipeSelected) getActivity();

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);

        recyclerView.setAdapter(new GridAdapter(listener));
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();

        float dpWidth = displayMetrics.widthPixels / displayMetrics.density;

        int numColumns = (int) (dpWidth / 200);

        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), numColumns));
    }


    public interface OnRecipeSelected {
        void onGridRecipeSelected(int index);
    }
}