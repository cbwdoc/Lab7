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

    String[] colors = {"#800000", "RED", "#FF6000", "YELLOW",
            "GREEN", "#004000", "CYAN", "BLUE",
            "PURPLE", "WHITE", "GREY", "BLACK"};

    PaletteInterface paletteInterface;

    public PaletteFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_palette, container, false);

        PaletteArrayAdapter adapter = new PaletteArrayAdapter(PaletteFragment.this.getActivity(),
                android.R.layout.simple_spinner_dropdown_item,
                colors);

        Spinner spinner = (Spinner) layout.findViewById(R.id.spinner);
        spinner.setAdapter(adapter);


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                paletteInterface.changeColor(Color.parseColor(colors[position]));
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
            paletteInterface = (PaletteInterface) activity;
        } else {
            throw new RuntimeException("Not Implemented");
        }


    }

    public interface PaletteInterface {
        void changeColor(int color);
    }
}
