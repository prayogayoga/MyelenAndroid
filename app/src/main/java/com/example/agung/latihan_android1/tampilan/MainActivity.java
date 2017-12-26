package com.example.agung.latihan_android1.tampilan;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.agung.latihan_android1.R;

/**
 * Created by agung on 03/11/17.
 */

public class MainActivity extends AppCompatActivity {

    Button btnLogin1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        btnLogin1 = (Button) findViewById(R.id.button1);

        btnLogin1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pindah = new Intent(MainActivity.this, FIturCourse.class);
                startActivity(pindah);

            }
        });

        btnLogin1 = (Button) findViewById(R.id.button2);

        btnLogin1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pindah = new Intent(MainActivity.this, FiturJurnal.class);
                startActivity(pindah);

            }
        });

        btnLogin1 = (Button) findViewById(R.id.button3);

        btnLogin1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pindah = new Intent(MainActivity.this, FiturInfoKampus.class);
                startActivity(pindah);

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.my_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.opt1:
                Log.i("Status", "Option One selected");
                return true;
            case R.id.opt2:
                Log.i("Status", "Option two selected");
                return true;
            case R.id.opt3:
                Log.i("Status", "Option three selected");
                return true;
            case R.id.sub1:
                Log.i("Status", "SubOption one selected");
                return true;
            case R.id.sub2:
                Log.i("Status", "SubOption two selected");
                return true;
            default :
                return super.onOptionsItemSelected(item);

        }

    }


}
