package com.ajithvgiri.drawing;

import android.Manifest;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by ajithvgiri on 31/10/17.
 */

public class Preference {

    private static final String TAG = "Preference";
    Context context;
    SharedPreferences sharedpreferences;
    boolean storagePermission;

    public Preference(Context context) {
        this.context = context;
        sharedpreferences = PreferenceManager.getDefaultSharedPreferences(context);
    }

    public boolean isStoragePermission() {
        storagePermission = sharedpreferences.getBoolean(Manifest.permission.WRITE_EXTERNAL_STORAGE, false);
        return storagePermission;
    }


    public void setStoragePermission(boolean storagePermission) {
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putBoolean(Manifest.permission.WRITE_EXTERNAL_STORAGE, storagePermission);
        editor.commit();
    }

}
