package com.example.agung.latihan_android1.adapter;

import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.agung.latihan_android1.R;
import com.example.agung.latihan_android1.model.Matakuliah;
import com.example.agung.latihan_android1.utilitas.ClickListener;
import com.mindorks.placeholderview.annotations.Click;
import com.mindorks.placeholderview.annotations.Layout;
import com.mindorks.placeholderview.annotations.Resolve;
import com.mindorks.placeholderview.annotations.View;
import com.mindorks.placeholderview.annotations.expand.ParentPosition;

/**
 * Created by agung on 26/12/17.
 */

@Layout(R.layout.card_prodi_item)
public class MatkulAdapter {

    @View(R.id.txt_nama_matkul)
    private TextView txtMatkul;

    @View(R.id.txt_nama_dosen)
    private TextView txtNamaDosen;

    @ParentPosition
    private int position;

    private Matakuliah matkul;
    private ClickListener listener;

    public MatkulAdapter(int position) {
        this.position = position;
    }

    public MatkulAdapter setMatkul(Matakuliah matkul) {
        this.matkul = matkul;
        return this;
    }

    public MatkulAdapter setClick(ClickListener listener) {
        this.listener = listener;
        return this;
    }

    @Resolve
    private void onResolved() {
        txtMatkul.setText(matkul.getNama());
        txtNamaDosen.setText(matkul.getDosen().getName());
    }

    @Click(R.id.card_matkul)
    public void click() {
        listener.onClickApapun(position);
    }
}
