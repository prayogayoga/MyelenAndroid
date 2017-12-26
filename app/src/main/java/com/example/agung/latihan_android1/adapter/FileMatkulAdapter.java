package com.example.agung.latihan_android1.adapter;

import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.agung.latihan_android1.R;
import com.example.agung.latihan_android1.model.FileMatakuliah;
import com.example.agung.latihan_android1.utilitas.ClickListener;
import com.mindorks.placeholderview.annotations.Click;
import com.mindorks.placeholderview.annotations.Layout;
import com.mindorks.placeholderview.annotations.Resolve;
import com.mindorks.placeholderview.annotations.View;

/**
 * Created by agung on 26/12/17.
 */

@Layout(R.layout.card_matkul_item)
public class FileMatkulAdapter {

    @View(R.id.txt_nama_file)
    private TextView txtfilematkul;

    private FileMatakuliah filematkul;
    private ClickListener listener;

    public FileMatkulAdapter setFileMatkul(FileMatakuliah filematkul){
        this.filematkul = filematkul;
        return this;
    }

    @Resolve private void onResolved(){
        txtfilematkul.setText(filematkul.getName());
    }

    @Click(R.id.card_file_matkul)
    public void click() {
        
    }
}
