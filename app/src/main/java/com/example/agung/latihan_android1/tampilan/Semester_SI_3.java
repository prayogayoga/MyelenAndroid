package com.example.agung.latihan_android1.tampilan;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.agung.latihan_android1.R;
import com.example.agung.latihan_android1.adapter.MatkulAdapter;
import com.example.agung.latihan_android1.jaringan.NetworkClient;
import com.example.agung.latihan_android1.jaringan.RouteUrl;
import com.example.agung.latihan_android1.model.Matakuliah;
import com.example.agung.latihan_android1.utilitas.ClickListener;
import com.example.agung.latihan_android1.utilitas.Konstanta;
import com.mindorks.placeholderview.InfinitePlaceHolderView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by agung on 23/12/17.
 */

public class Semester_SI_3 extends AppCompatActivity {

    private  InfinitePlaceHolderView lstSms3;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.semester_si_3);
        lstSms3 = (InfinitePlaceHolderView) findViewById(R.id.lst_matkul_sms3);
        getMatkulByProdiSemster("1", "3");
    }
    private void getMatkulByProdiSemster(String prodi, String semester){
        RouteUrl req = NetworkClient.client(Konstanta.BASEURL).create(RouteUrl.class);

        Call<ArrayList<Matakuliah>> datas = req.getMatakuliahByMatkul(semester, prodi);
        datas.enqueue(new Callback<ArrayList<Matakuliah>>() {
            @Override
            public void onResponse(Call<ArrayList<Matakuliah>> call, final Response<ArrayList<Matakuliah>> response) {
                if (response.code() == 200){
                    lstSms3.removeAllViews();
                    for (int i=0; i < response.body().size(); i++){
                        final int index = i;
                        lstSms3.addView(new MatkulAdapter(i)
                                .setMatkul(response.body().get(i))
                                .setClick(new ClickListener() {
                                    @Override
                                    public void onClickApapun(int position) {
                                        Intent keFileMatkul = new Intent(Semester_SI_3.this, File_Matkul.class);
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

