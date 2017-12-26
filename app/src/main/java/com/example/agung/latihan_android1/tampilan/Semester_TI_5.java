package com.example.agung.latihan_android1.tampilan;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.agung.latihan_android1.R;
import com.example.agung.latihan_android1.adapter.MatkulAdapter;
import com.example.agung.latihan_android1.jaringan.NetworkClient;
import com.example.agung.latihan_android1.jaringan.RouteUrl;
import com.example.agung.latihan_android1.model.Matakuliah;
import com.example.agung.latihan_android1.model.SemesterMhs;
import com.example.agung.latihan_android1.utilitas.ClickListener;
import com.example.agung.latihan_android1.utilitas.Konstanta;
import com.mindorks.placeholderview.InfinitePlaceHolderView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by agung on 24/12/17.
 */

public class Semester_TI_5 extends AppCompatActivity {

    private InfinitePlaceHolderView lstSms5;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.semester_ti_5);
        lstSms5 = (InfinitePlaceHolderView) findViewById(R.id.lst_matkul_sms5);
        getMatkulByProdiSemster("2", "5"); //2 = TI, semester = 5
    }

    private void getMatkulByProdiSemster(String prodi, String semester) {
        RouteUrl req = NetworkClient.client(Konstanta.BASEURL).create(RouteUrl.class);

        Call<ArrayList<Matakuliah>> datas = req.getMatakuliahByMatkul(semester, prodi);
        datas.enqueue(new Callback<ArrayList<Matakuliah>>() {
            @Override
            public void onResponse(Call<ArrayList<Matakuliah>> call, final Response<ArrayList<Matakuliah>> response) {
                if (response.code() == 200) {
                    lstSms5.removeAllViews();
                    for (int i=0; i < response.body().size(); i++) {
                        final int index = i;
                        lstSms5.addView(new MatkulAdapter(i)
                                .setMatkul(response.body().get(i))
                                .setClick(new ClickListener() {
                                    @Override
                                    public void onClickApapun(int position) {
                                        Intent keFileMatkul = new Intent(Semester_TI_5.this, File_Matkul.class);
                                        keFileMatkul.putExtra("matkul_id", response.body().get(index).getId());
                                        startActivity(keFileMatkul);
                                    }
                                }));
                    }
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Matakuliah>> call, Throwable t) {

            }
        });
    }
}
