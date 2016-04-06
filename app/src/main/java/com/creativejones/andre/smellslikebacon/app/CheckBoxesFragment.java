package com.creativejones.andre.smellslikebacon.app;


import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;

import com.creativejones.andre.smellslikebacon.R;
import com.creativejones.andre.smellslikebacon.models.Recipes;

public abstract class CheckBoxesFragment extends Fragment {

    private static final String KEY_CHECKED_BOXES = "key_checked_boxes";
    CheckBox[] CheckBoxes;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_checkboxes, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        int index = getArguments().getInt(ViewPagerFragment.KEY_RECIPE_INDEX);

        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.checkboxesLayout);

        String[] contents = getContents(index);

        CheckBoxes = new CheckBox[contents.length];

        boolean[] checkedBoxes = new boolean[CheckBoxes.length];

        if(savedInstanceState != null  && savedInstanceState.containsKey(KEY_CHECKED_BOXES)){
            checkedBoxes = savedInstanceState.getBooleanArray(KEY_CHECKED_BOXES);
        }

        setupCheckBoxes(linearLayout, contents, checkedBoxes);

    }

    public abstract String[] getContents(int index);

    private void setupCheckBoxes(LinearLayout linearLayout, String[] contents, boolean[] checkedBoxes) {
        int i = 0;
        
        for(String content : contents){
            CheckBoxes[i] = new CheckBox(getActivity());
            CheckBoxes[i].setPadding(8, 16, 8, 16);
            CheckBoxes[i].setTextSize(20f);
            CheckBoxes[i].setText(content);
            linearLayout.addView(CheckBoxes[i]);

            if(checkedBoxes[i]){
                CheckBoxes[i].setChecked(true);
            }

            i++;
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        boolean[] stateOfCheckBoxes = new boolean[CheckBoxes.length];
        
        int i = 0;
        
        for(CheckBox checkBox : CheckBoxes){
            stateOfCheckBoxes[i] = checkBox.isChecked();
            i++;
        }
        
        outState.putBooleanArray(KEY_CHECKED_BOXES, stateOfCheckBoxes);
        super.onSaveInstanceState(outState);
    }
}
