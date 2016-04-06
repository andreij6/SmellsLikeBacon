package com.creativejones.andre.smellslikebacon.app;

import com.creativejones.andre.smellslikebacon.models.Recipes;

public class IngredientsFragment extends CheckBoxesFragment {
    @Override
    public String[] getContents(int index) {
        return Recipes.ingredients[index].split("`");
    }
}
