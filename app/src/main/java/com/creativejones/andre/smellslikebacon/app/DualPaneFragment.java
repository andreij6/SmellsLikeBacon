package com.creativejones.andre.smellslikebacon.app;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.creativejones.andre.smellslikebacon.R;
import com.creativejones.andre.smellslikebacon.models.Recipes;

public class DualPaneFragment extends Fragment {

    private static final String INGREDIENTS_FRAGMENT = "INGREdients_fragment";
    private static final String DIRECTIONS_FRAGMENT = "directions_fragment";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        int index = getArguments().getInt(ViewPagerFragment.KEY_RECIPE_INDEX);
        
        View view = inflater.inflate(R.layout.fragment_dualpane, container, false);

        FragmentManager fragmentManager = getChildFragmentManager();

        IngredientsFragment savedIngredientsFragment = (IngredientsFragment) fragmentManager.findFragmentByTag(INGREDIENTS_FRAGMENT);

        if(savedIngredientsFragment == null){
            final CheckBoxesFragment ingredientsFragment = new IngredientsFragment();

            Bundle bundle = new Bundle();
            bundle.putInt(ViewPagerFragment.KEY_RECIPE_INDEX, index);
            ingredientsFragment.setArguments(bundle);

            fragmentManager.beginTransaction()
                    .add(R.id.leftPlaceholder, ingredientsFragment, INGREDIENTS_FRAGMENT)
                    .commit();

        }

        DirectionsFragment savedDirectionsFragment = (DirectionsFragment) fragmentManager.findFragmentByTag(INGREDIENTS_FRAGMENT);

        if(savedDirectionsFragment == null){
            final CheckBoxesFragment ingredientsFragment = new DirectionsFragment();

            Bundle bundle = new Bundle();
            bundle.putInt(ViewPagerFragment.KEY_RECIPE_INDEX, index);
            ingredientsFragment.setArguments(bundle);

            fragmentManager.beginTransaction()
                    .add(R.id.rightPlaceholder, ingredientsFragment, DIRECTIONS_FRAGMENT)
                    .commit();

        }

        return view;

    }

    @Override
    public void onStop() {
        super.onStop();

        getActivity().setTitle(getResources().getString(R.string.app_name));
    }
}
