package com.example.agung.latihan_android1.jaringan;

import com.example.agung.latihan_android1.model.DataDosen;
import com.example.agung.latihan_android1.model.DosenMatkul;
import com.example.agung.latihan_android1.model.FileMatakuliah;
import com.example.agung.latihan_android1.model.JenisKelamin;
import com.example.agung.latihan_android1.model.Matakuliah;
import com.example.agung.latihan_android1.model.MhsLogin;
import com.example.agung.latihan_android1.model.MhsProdi;
import com.example.agung.latihan_android1.model.SemesterMhs;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by agung on 24/12/17.
 */

public interface RouteUrl {

    @FormUrlEncoded @POST("api/v1/auth/login")
    Call<MhsLogin> login(
            @Field("nim") String nim,
            @Field("password") String pass,
            @Field("token") String token
    );

    @GET("prodi")
    Call<ArrayList<MhsProdi>> getProdi();

    @GET("matakuliah")
    Call<ArrayList<Matakuliah>> getMatakuliah();

    @GET("matakuliah")
    Call<ArrayList<Matakuliah>> getMatakuliahByMatkul(
            @Query("semester") String semester,
            @Query("prodi") String prodi
    );

    @GET("dosen")
    Call<ArrayList<DataDosen>> getDosen();

    @GET("jkdetail")
    Call<ArrayList<JenisKelamin>> getJk();

    @GET("filematkul")
    Call<ArrayList<FileMatakuliah>> getFileMatkul();

    @GET("filematkul")
    Call<ArrayList<FileMatakuliah>> getFileMatkulByMatkul(
            @Query("matkul_id") String matkulId
    );

    @GET("matkuldosen")
    Call<ArrayList<DosenMatkul>> getDosenMatkul();

    @GET("semester")
    Call<ArrayList<SemesterMhs>> getSemester();

}
