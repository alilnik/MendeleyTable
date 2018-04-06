package com.innopolis.mjazz.mendeleytable;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;

public class ElementFragmentFactory {
    private ElementFragment elementFragment;
    private FragmentManager fragmentManager;
    private static Bundle bundle = new Bundle();
    private static Context context;

    public ElementFragmentFactory(FragmentManager fragmentManager, Context context) {
        this.fragmentManager = fragmentManager;
        this.context = context;
    }

    public void initElements() {
        String jsonString = readJSON();
        if (jsonString != null) {
            try {
                JSONObject json = new JSONObject(jsonString);
                JSONArray elements = json.getJSONArray("elements");
                for (int i = 0; i < 36; i++) {
                    ElementModel.elementName = elements.getJSONObject(i).getString("name");
                    ElementModel.elementShortcut = elements.getJSONObject(i).getString("symbol");
                    ElementModel.elementNumber = i + 1;
                    ElementModel.elementColor = Color.parseColor(elements.getJSONObject(i).getString("color"));
                    int id = context.getResources().getIdentifier("fragment_" + ElementModel.elementShortcut, "id", context.getPackageName());
                    composeElementFragment(id, ElementModel.elementNumber, ElementModel.elementShortcut, ElementModel.elementName, ElementModel.elementColor);
                }

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public void composeElementFragment(int fragmentId, int textElementNumber, String textElementShortcut, String textElementName, int color) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        elementFragment = new ElementFragment();
        composeBundle(textElementNumber, textElementShortcut, textElementName, color);
        elementFragment.setArguments(bundle);
        fragmentTransaction.add(fragmentId, elementFragment);
        fragmentTransaction.commit();
    }

    private void composeBundle(int textElementNumber, String textElementShortcut, String textElementName, int color) {
        bundle.putString("name", textElementName);
        bundle.putString("shortcut", textElementShortcut);
        bundle.putString("number", Integer.toString(textElementNumber));
        bundle.putInt("color", color);
    }


    private String readJSON() {
        String json = null;
        try {
            InputStream is = context.getAssets().open("elem.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

    private static class ElementModel {
        private static int elementNumber;
        private static String elementShortcut;
        private static String elementName;
        private static int elementColor;
    }
}
