package com.lviniciusj.br.candidatosonline.api;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface ApiServices {

    @GET("/candidato/{id}")
    Call<Candidato> getCandidato(@Header("Content-Type") String content_type, @Path("id") Long id);

    @GET("/candidato/list")
    Call<List<Candidato>> findAllBCandidatos(@Header("Content-Type") String content_type);

    @PUT("/candidato/{id}/vota")
    Call<Candidato> sendVoto(@Header("Content-Type") String content_type, @Path("id") Long id);
}
