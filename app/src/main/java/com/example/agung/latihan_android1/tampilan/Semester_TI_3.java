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
 * Created by agung on 24/12/17.
 */

public class Semester_TI_3 extends AppCompatActivity {

    private InfinitePlaceHolderView lstsmt3ti;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.semester_ti_3);

        lstsmt3ti = (InfinitePlaceHolderView) findViewById(R.id.lst_matkul_smsti3);
        getMatkulByProdiSemester("2", "3");
    }

    private void getMatkulByProdiSemester(String prodi, String semester) {
        RouteUrl req = NetworkClient.client(Konstanta.BASEURL).create(RouteUrl.class);

        Call<ArrayList<Matakuliah>> datas = req.getMatakuliahByMatkul(semester,prodi);
        datas.enqueue(new Callback<ArrayList<Matakuliah>>() {
            @Override
            public void onResponse(Call<ArrayList<Matakuliah>> call, Response<ArrayList<Matakuliah>> response) {
                if (response.code() == 200){
                    lstsmt3ti.removeAllViews();
                    for (int i = 0; i < response.body().size(); i++){
                        lstsmt3ti.addView(new MatkulAdapter(i).setMatkul(response.body().get(i)));
                    }
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Matakuliah>> call, Throwable t) {

            }
        });
    }
}
