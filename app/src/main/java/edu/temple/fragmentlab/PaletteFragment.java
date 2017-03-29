package edu.temple.fragmentlab;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;


/**
 * A simple {@link Fragment} subclass.
 */
public class PaletteFragment extends Fragment {


    Spinner spinner;

    String[] colors = {"#800000", "RED", "#FF6000", "YELLOW",
            "GREEN", "#004000", "CYAN", "BLUE",
            "PURPLE", "WHITE", "GREY", "BLACK"};

    PaletteArrayAdapter adapter = new PaletteArrayAdapter(PaletteFragment.this.getContext(),
            android.R.layout.simple_spinner_dropdown_item,
            colors);

    PaletteInterface parent;

    public PaletteFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View layout = inflater.inflate(R.layout.fragment_palette, container, false);

        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // Error:(51, 32) error: non-static method changeColor(int) cannot be referenced from a static context
                // nothing is denoted as static so why am I getting this?
                PaletteInterface.changeColor(Color.parseColor(colors[position]));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        return layout;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        if (activity instanceof  PaletteInterface){
            parent = (PaletteInterface) activity;
        } else {
            throw new RuntimeException("Not Implemented");
        }


    }

    public interface PaletteInterface {
        /*  Error:(79, 32) error: static interface methods are not supported in -source 1.7
            (use -source 8 or higher to enable static interface methods) */
        void changeColor(int color);
    }

}
