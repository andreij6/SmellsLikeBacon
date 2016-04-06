package com.creativejones.andre.smellslikebacon.app;


import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.creativejones.andre.smellslikebacon.R;

public class MainActivity extends AppCompatActivity implements ListFragment.OnRecipeSelected, GridFragment.OnRecipeSelected {

    public static final String LIST_FRAGMENT = "list_fragment";
    public static final String VIEWPAGER_FRAGMENT = "viewpager_fragment";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        boolean isTablet = getResources().getBoolean(R.bool.is_tablet);

        if(!isTablet){
            ListFragment savedFragment = (ListFragment) getSupportFragmentManager()
                    .findFragmentByTag(LIST_FRAGMENT);

            if(savedFragment == null) {

                ListFragment fragment = new ListFragment();

                FragmentManager fragmentManager = getSupportFragmentManager();

                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                fragmentTransaction.add(R.id.placeHolder, fragment, LIST_FRAGMENT);  //add

                fragmentTransaction.commit();
            }
        } else {
            GridFragment savedFragment = (GridFragment) getSupportFragmentManager()
                    .findFragmentByTag(LIST_FRAGMENT);

            if(savedFragment == null) {

                GridFragment fragment = new GridFragment();

                FragmentManager fragmentManager = getSupportFragmentManager();

                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                fragmentTransaction.add(R.id.placeHolder, fragment, LIST_FRAGMENT);  //add

                fragmentTransaction.commit();
            }
        }



    }

    @Override
    public void onListRecipeSelected(int index) {
        ViewPagerFragment fragment = new ViewPagerFragment();

        Bundle bundle = new Bundle();

        bundle.putInt(ViewPagerFragment.KEY_RECIPE_INDEX, index);

        fragment.setArguments(bundle);

        FragmentManager fragmentManager = getSupportFragmentManager();

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.replace(R.id.placeHolder, fragment, VIEWPAGER_FRAGMENT);  //replace

        fragmentTransaction.addToBackStack(null); //need to override the onBackPressedButton

        fragmentTransaction.commit();
    }

    @Override
    public void onGridRecipeSelected(int index) {
        DualPaneFragment fragment = new DualPaneFragment();

        Bundle bundle = new Bundle();

        bundle.putInt(ViewPagerFragment.KEY_RECIPE_INDEX, index);

        fragment.setArguments(bundle);

        FragmentManager fragmentManager = getSupportFragmentManager();

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.replace(R.id.placeHolder, fragment, VIEWPAGER_FRAGMENT);  //replace

        fragmentTransaction.addToBackStack(null); //need to override the onBackPressedButton

        fragmentTransaction.commit();
    }
}
