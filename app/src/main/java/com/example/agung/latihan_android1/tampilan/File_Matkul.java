package com.example.agung.latihan_android1.tampilan;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.agung.latihan_android1.R;
import com.example.agung.latihan_android1.adapter.FileMatkulAdapter;
import com.example.agung.latihan_android1.jaringan.NetworkClient;
import com.example.agung.latihan_android1.jaringan.RouteUrl;
import com.example.agung.latihan_android1.model.FileMatakuliah;
import com.example.agung.latihan_android1.utilitas.Konstanta;
import com.mindorks.placeholderview.InfinitePlaceHolderView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by agung on 26/12/17.
 */

public class File_Matkul extends AppCompatActivity {

    private InfinitePlaceHolderView lstFileMatkul;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.file_matkul);

        lstFileMatkul = (InfinitePlaceHolderView) findViewById(R.id.lst_file_matkul);
        getFileMatkulByMatakuliah(String.valueOf(getIntent().getIntExtra("matkul_id", 0)));
    }
    private void getFileMatkulByMatakuliah(String matakuliah){
        RouteUrl req = NetworkClient.client(Konstanta.BASEURL).create(RouteUrl.class);

        Call<ArrayList<FileMatakuliah>> datas = req.getFileMatkulByMatkul(matakuliah);
        datas.enqueue(new Callback<ArrayList<FileMatakuliah>>() {
            @Override
            public void onResponse(Call<ArrayList<FileMatakuliah>> call, Response<ArrayList<FileMatakuliah>> response) {
                if (response.code() == 200){
                    lstFileMatkul.removeAllViews();
                    for (int i = 0; i < response.body().size(); i++){
                        lstFileMatkul.addView(new FileMatkulAdapter().setFileMatkul(response.body().get(i)));
                    }
                }
              //  Log.e("TAG", response.toString());
            }

            @Override
            public void onFailure(Call<ArrayList<FileMatakuliah>> call, Throwable t) {
            //    Log.e("TAG", t.getMessage());
            }
        });
    }



}
