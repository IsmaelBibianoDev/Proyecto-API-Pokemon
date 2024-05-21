package com.tesji.quizzdragonball.interfaces;

import com.tesji.quizzdragonball.models.Catalogo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface peticiones {
    @GET("pokemon/{id}")
    Call<Catalogo> consultar(@Path("id") String id);
}
