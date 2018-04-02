package com.innopolis.mjazz.mendeleytable;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    ElementFragmentFactory factory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        factory = new ElementFragmentFactory(getFragmentManager(), this);
        factory.initElements();
    }


}
