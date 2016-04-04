package com.creativejones.andre.smellslikebacon.app;


import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.creativejones.andre.smellslikebacon.R;

public class ListFragment extends Fragment {

    public static ListFragment newInstance(){
        return new ListFragment();
    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        OnRecipeSelected listener = (OnRecipeSelected) getActivity();

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.listRecyclerView);

        recyclerView.setAdapter(new ListAdapter(listener));

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    }


    public interface OnRecipeSelected {
        void onListRecipeSelected(int index);
    }

}
