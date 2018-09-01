package com.lviniciusj.br.candidatosonline;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

import com.lviniciusj.br.candidatosonline.api.ApiClient;
import com.lviniciusj.br.candidatosonline.api.ApiServices;
import com.lviniciusj.br.candidatosonline.api.Candidato;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private ApiServices apiServices;
    private ProgressDialog progress = null;
    private ListView lista;
    private ListaAdapter adapter;
    private List<Candidato> candidatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        myToolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(myToolbar);

        lista = findViewById(R.id.lista);
    }

    @Override
    protected void onResume() {
        super.onResume();
        getCandidato();
    }



    private void getCandidato() {
        progress = ProgressDialog.show(MainActivity.this,
                "Aguarde ...", "Recebendo informações da web", true, true);
        apiServices = ApiClient.getClient().create(ApiServices.class);

        Call<List<Candidato>> call = apiServices.findAllBCandidatos ("application/json");
        call.enqueue(new Callback<List<Candidato>>() {
            @Override
            public void onResponse(Call<List<Candidato>> call, Response<List<Candidato>> response) {
                if (response.isSuccessful()) {
                    candidatos = response.body();
                    updateList();
                    progress.dismiss();
                } else {
                    progress.dismiss();
                }
            }

            @Override
            public void onFailure(Call<List<Candidato>> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    private void updateList() {
        adapter = new ListaAdapter(getApplicationContext(), candidatos);
        lista.setAdapter(adapter);
    }
}
