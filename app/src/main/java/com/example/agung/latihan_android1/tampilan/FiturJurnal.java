package com.example.agung.latihan_android1.tampilan;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.agung.latihan_android1.R;

/**
 * Created by agung on 22/12/17.
 */

public class FiturJurnal extends AppCompatActivity {

     Button btnBack;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fitur_jurnal);

        btnBack = (Button) findViewById(R.id.button1);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pindah = new Intent(FiturJurnal.this, MainActivity.class);
                startActivity(pindah);
                finish();
            }
        });
    }
}
