package com.creativejones.andre.smellslikebacon.app;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.creativejones.andre.smellslikebacon.R;
import com.creativejones.andre.smellslikebacon.models.Recipes;

public class ViewPagerFragment extends Fragment {

    public static final String KEY_RECIPE_INDEX = "recipe_index";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_viewpager, container, false);

        int index = getArguments().getInt(KEY_RECIPE_INDEX);

        getActivity().setTitle(Recipes.names[index]);

        ViewPager viewPager = (ViewPager) view.findViewById(R.id.viewPager);

        final CheckBoxesFragment ingredientsFragment = new IngredientsFragment();

        Bundle bundle = new Bundle();
        bundle.putInt(KEY_RECIPE_INDEX, index);
        ingredientsFragment.setArguments(bundle);

        final CheckBoxesFragment directionsFragment = new DirectionsFragment();

        Bundle dbundle = new Bundle();
        dbundle.putInt(KEY_RECIPE_INDEX, index);
        directionsFragment.setArguments(dbundle);

        //when dealing with fragments within fragments we need to use the child fragment manager
        viewPager.setAdapter(new FragmentPagerAdapter(getChildFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return position == 0 ? ingredientsFragment : directionsFragment;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return position == 0 ? "Ingredients" : "Directions"; //should be in string resource but this prj doesnt matter
            }

            @Override
            public int getCount() {
                return 2;
            }
        });

        TabLayout tabLayout = (TabLayout) view.findViewById(R.id.tabLayout);

        tabLayout.setupWithViewPager(viewPager);

        return view;
    }


    @Override
    public void onStop() {
        super.onStop();

        getActivity().setTitle(getResources().getString(R.string.app_name));
    }
}
