package com.creativejones.andre.smellslikebacon.app;

import com.creativejones.andre.smellslikebacon.models.Recipes;

public class DirectionsFragment extends CheckBoxesFragment {
    @Override
    public String[] getContents(int index) {
        return Recipes.directions[index].split("`");
    }
}
