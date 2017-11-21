package com.example.mariam.projectssresource.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

/**
 * Created by DELL on 5/22/2017.
 */

public class Utils {
    public static boolean isNetworkConnected(Context context) {

        ConnectivityManager cm = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);

        return cm.getActiveNetworkInfo() != null;
    }

    public static boolean checkFieldsRequired(ViewGroup viewGroup){

        int count = viewGroup.getChildCount();
        for (int i = 0; i < count; i++) {
            View view = viewGroup.getChildAt(i);

            if (view instanceof EditText) {
                EditText edittext = (EditText) view;
                if (edittext.getText().toString().trim().equals("")) {
                    edittext.setError("Required!");
                    return false;
                }
            }
        }

        return true;
    }


}
