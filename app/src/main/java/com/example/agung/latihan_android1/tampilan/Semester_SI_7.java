package com.example.agung.latihan_android1.tampilan;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.agung.latihan_android1.R;
import com.example.agung.latihan_android1.adapter.MatkulAdapter;
import com.example.agung.latihan_android1.jaringan.NetworkClient;
import com.example.agung.latihan_android1.jaringan.RouteUrl;
import com.example.agung.latihan_android1.model.Matakuliah;
import com.example.agung.latihan_android1.utilitas.Konstanta;
import com.mindorks.placeholderview.InfinitePlaceHolderView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by agung on 26/12/17.
 */

public class Semester_SI_7 extends AppCompatActivity {

    private InfinitePlaceHolderView lstsmtsi5;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.semester_si_3);

        lstsmtsi5 = (InfinitePlaceHolderView) findViewById(R.id.lst_matkul_sms3);
        getMatkulByProdiSemester("1","7");
    }
    private void getMatkulByProdiSemester(String prodi,String semester) {
        RouteUrl req = NetworkClient.client(Konstanta.BASEURL).create(RouteUrl.class);

        Call<ArrayList<Matakuliah>> datas = req.getMatakuliahByMatkul(semester, prodi);
        datas.enqueue(new Callback<ArrayList<Matakuliah>>() {
            @Override
            public void onResponse(Call<ArrayList<Matakuliah>> call, Response<ArrayList<Matakuliah>> response) {
                if (response.code() == 200) {
                    lstsmtsi5.removeAllViews();
                    for (int i = 0; i < response.body().size(); i++) {
                        lstsmtsi5.addView(new MatkulAdapter(i).setMatkul(response.body().get(i)));
                    }
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Matakuliah>> call, Throwable t) {

            }
        });
    }
}
