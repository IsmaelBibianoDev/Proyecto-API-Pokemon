package com.tesji.quizzdragonball;

import com.tesji.quizzdragonball.interfaces.peticiones;
import com.tesji.quizzdragonball.models.Catalogo;
import com.tesji.quizzdragonball.models.ModeloRetorno;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ConsultarApi {
    public static String URL = "https://pokeapi.co/api/v2/";
    public static Retrofit varRetro;
    ModeloRetorno modeloRetorno = new ModeloRetorno();

    public String res;

    public void respuesta(String id){
        varRetro = new Retrofit.Builder().baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create()).build();
        peticiones consApi = varRetro.create(peticiones.class);

        Call<Catalogo> call = consApi.consultar(id);

        call.enqueue(new Callback<Catalogo>() {
            @Override
            public void onResponse(Call<Catalogo> call, Response<Catalogo> response) {
                try {
                    if (response.isSuccessful()){
                        Catalogo catalogo = response.body();
                        modeloRetorno.setId(catalogo.getId());
                        modeloRetorno.setName(catalogo.getName());
                        modeloRetorno.setHeight(catalogo.getHeight());
                        modeloRetorno.setWeight(catalogo.getWeight());
                        modeloRetorno.setFront_default(catalogo.getSprites().getFront_default());
                    } else {
                        System.out.println("MAL");
                        System.out.println(call);
                    }
                }catch (Exception ex){
                    System.out.println("UWUn´t" + ex);
                }
            }

            @Override
            public void onFailure(Call<Catalogo> call, Throwable t) {
                System.out.println("UWUn´t" + t);
            }
        });
    }
}
