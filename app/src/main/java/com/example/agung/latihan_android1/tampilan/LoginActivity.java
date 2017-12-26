package com.example.agung.latihan_android1.tampilan;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.agung.latihan_android1.R;
import com.example.agung.latihan_android1.jaringan.NetworkClient;
import com.example.agung.latihan_android1.jaringan.RouteUrl;
import com.example.agung.latihan_android1.model.MhsLogin;
import com.example.agung.latihan_android1.utilitas.ProgressLoader;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by agung on 03/11/17.
 */

public class LoginActivity extends AppCompatActivity {

    private Button btnLogin;
    private EditText editnim;
    private EditText editpassword;

    private ProgressLoader loader;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loader = new ProgressLoader(this);

        btnLogin = (Button) findViewById(R.id.btn_login);
        editnim = (EditText) findViewById(R.id.edt_nim);
        editpassword = (EditText) findViewById(R.id.edt_password);

        editnim.setText("0110215050");
        editpassword.setText("270696yoga");

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                requestLogin();
            }
        });
    }

    private void requestLogin() {
        loader.show();
        String baseUrl = "http://dhimasganteng.ga:10000/";
        RouteUrl req = NetworkClient.client(baseUrl).create(RouteUrl.class);

        String nim = editnim.getText().toString();
        String pass = editpassword.getText().toString();

        Call<MhsLogin> callLogin = req.login(nim, pass, "sttnfnice");
        if (!nim.isEmpty() || !pass.isEmpty()) {
            callLogin.enqueue(new Callback<MhsLogin>() {
                @Override
                public void onResponse(@NonNull Call<MhsLogin> call, @NonNull Response<MhsLogin> response) {
                    loader.hide();
                    Log.e("TAG", "ini onResponse()");
                    if (response.code() == 403 || response.code() == 200) {
                        Intent pindah = new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(pindah);
                        finish();
                    } else if (response.body().getStatusCode() == 401) {
                        Toast.makeText(LoginActivity.this, "Maaf, nim atau password anda salah", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(LoginActivity.this, response.toString(), Toast.LENGTH_LONG).show();
                    }
                }

                @Override
                public void onFailure(@NonNull Call<MhsLogin> call, @NonNull Throwable t) {
                    loader.hide();

                }
            });
        } else {
            Toast.makeText(LoginActivity.this, "Maaf, nim atau password masih kosong", Toast.LENGTH_LONG).show();
        }
    }
}
