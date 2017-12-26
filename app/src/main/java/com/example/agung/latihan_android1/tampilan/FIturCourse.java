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

public class FIturCourse extends AppCompatActivity {

    Button btnBack;
    Button btnLogin2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fitur_course);

        btnLogin2 = (Button) findViewById(R.id.button1);

        btnLogin2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pindah = new Intent(FIturCourse.this, Prodi_SI.class);
                startActivity(pindah);

            }
        });

        btnLogin2 = (Button) findViewById(R.id.button2);

        btnLogin2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pindah = new Intent(FIturCourse.this, Prodi_TI.class);
                startActivity(pindah);

            }
        });

        btnLogin2 = (Button) findViewById(R.id.button3);

        btnLogin2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pindah = new Intent(FIturCourse.this, Prodi_Gabungan.class);
                startActivity(pindah);

            }
        });

        btnBack = (Button) findViewById(R.id.button4);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pindah = new Intent(FIturCourse.this, MainActivity.class);
                startActivity(pindah);

            }
        });
    }
}
