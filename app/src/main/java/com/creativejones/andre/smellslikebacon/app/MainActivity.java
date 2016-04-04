package com.creativejones.andre.smellslikebacon.app;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.creativejones.andre.smellslikebacon.R;
import com.creativejones.andre.smellslikebacon.models.Recipes;

public class MainActivity extends AppCompatActivity implements ListFragment.OnRecipeSelected {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListFragment fragment = new ListFragment();

        FragmentManager fragmentManager = getFragmentManager();

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.add(R.id.placeHolder, fragment);

        fragmentTransaction.commit();

    }

    @Override
    public void onListRecipeSelected(int index) {
        Toast.makeText(this, Recipes.names[index], Toast.LENGTH_SHORT).show();
    }
}
