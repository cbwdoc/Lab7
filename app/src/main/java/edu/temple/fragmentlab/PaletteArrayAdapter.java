package edu.temple.fragmentlab;

import android.content.Context;
import android.graphics.Color;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;


import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by Casey on 2/8/2017.
 */

public class PaletteArrayAdapter extends ArrayAdapter {

    public PaletteArrayAdapter(Context context, int resource) {
        super(context, resource);
    }

    public PaletteArrayAdapter(Context context, int resource, int textViewResourceId) {
        super(context, resource, textViewResourceId);
    }

    public PaletteArrayAdapter(Context context, int resource, Object[] objects) {
        super(context, resource, objects);
    }

    public PaletteArrayAdapter(Context context, int resource, int textViewResourceId, Object[] objects) {
        super(context, resource, textViewResourceId, objects);
    }

    public PaletteArrayAdapter(Context context, int resource, List objects) {
        super(context, resource, objects);
    }

    public PaletteArrayAdapter(Context context, int resource, int textViewResourceId, List objects) {
        super(context, resource, textViewResourceId, objects);
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {

        View view = super.getDropDownView(position, convertView, parent);
        TextView tv = (TextView) view;

        // Set the Text color
        tv.setBackgroundColor(Color.parseColor((String) this.getItem(position)));
        if (position < 2 && position > 4 && (position != 6 || position != 10))
            tv.setTextColor(Color.parseColor("WHITE"));
        else
            tv.setTextColor(Color.parseColor("BLACK"));

        return view;
    }

}

