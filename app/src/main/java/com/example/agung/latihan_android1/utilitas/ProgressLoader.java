package com.example.agung.latihan_android1.utilitas;

import android.app.AlertDialog;
import android.content.Context;

/**
 * Created by agung on 24/12/17.
 */

public class ProgressLoader {

    private AlertDialog alert;
    private Context context;

    public ProgressLoader(Context context) {
        this.context = context;
        alert = new AlertDialog.Builder(this.context).create();
        alert.setMessage("Silahkan tunggu...");
        alert.setCancelable(false);
    }

    public void show() {
        alert.show();
    }

    public void hide() {
        alert.dismiss();
    }

}
