package com.example.agung.latihan_android1.tampilan;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.agung.latihan_android1.R;

/**
 * Created by agung on 24/12/17.
 */

public class Semester_TI extends AppCompatActivity {

    Button btnBack;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.semester_ti);

        btnBack = (Button) findViewById(R.id.button1);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pindah = new Intent(Semester_TI.this, Semester_TI_3.class);
                startActivity(pindah);
                finish();
            }
        });

        btnBack = (Button) findViewById(R.id.button2);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pindah = new Intent(Semester_TI.this, Semester_TI_5.class);
                startActivity(pindah);
                finish();
            }
        });

        btnBack = (Button) findViewById(R.id.button3);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pindah = new Intent(Semester_TI.this, Semester_TI_7.class);
                startActivity(pindah);
                finish();
            }
        });


        btnBack = (Button) findViewById(R.id.button5);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pindah = new Intent(Semester_TI.this, FIturCourse.class);
                startActivity(pindah);
                finish();
            }
        });
    }
}
