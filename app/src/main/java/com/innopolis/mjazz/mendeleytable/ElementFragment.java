package com.innopolis.mjazz.mendeleytable;

import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by mjazz on 11.03.2018.
 */

public class ElementFragment extends Fragment implements View.OnClickListener{
    private static final String wikiURL = "https://en.wikipedia.org/wiki/";
    private TextView textElementNumber;
    private TextView textElementShortcut;
    private TextView textElementName;
    private String elementNumber;
    private String elementShortcut;
    private String elementName;
    private int color;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_element_layout, container, false);
        view.setOnClickListener(this);
        return view;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        textElementNumber = view.findViewById(R.id.text_element_number);
        textElementNumber.setText(elementNumber);
        textElementShortcut = view.findViewById(R.id.text_element_shortcut);
        textElementShortcut.setText(elementShortcut);
        textElementName = view.findViewById(R.id.text_element_name);
        textElementName.setText(elementName);
        this.getView().setBackgroundColor(color);
    }


    @Override
    public void setArguments(Bundle args) {
        elementName = args.getString("name");
        elementShortcut = args.getString("shortcut");
        elementNumber = args.getString("number");
        color = args.getInt("color");
    }


    @Override
    public void onClick(View view) {
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(wikiURL + elementName));
        startActivity(i);
    }
}
