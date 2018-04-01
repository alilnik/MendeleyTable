package com.innopolis.mjazz.mendeleytable;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;

public class ElementFragmentFactory {
    private ElementFragment elementFragment;
    private FragmentManager fragmentManager;
    private static Bundle bundle = new Bundle();

    public ElementFragmentFactory(FragmentManager fragmentManager) {
        this.fragmentManager = fragmentManager;
    }

    public void composeElementFragment(int fragmentId, int textElementNumber, String textElementShortcut, String textElementName){
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        elementFragment = new ElementFragment();
        composeBundle(textElementNumber, textElementShortcut, textElementName);
        elementFragment.setArguments(bundle);
        fragmentTransaction.add(fragmentId, elementFragment);
        fragmentTransaction.commit();
    }

    private int checkColor(int elementNumber){
        return R.color.yellow;
    }

    private void composeBundle(int textElementNumber, String textElementShortcut, String textElementName){
        bundle.putString("name", textElementName);
        bundle.putString("shortcut", textElementShortcut);
        bundle.putString("number", Integer.toString(textElementNumber));
    }

}
