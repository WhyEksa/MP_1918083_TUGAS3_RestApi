package com.wes.mp_1918083_tugas3_restapi.restapi.request;

import com.wes.mp_1918083_tugas3_restapi.restapi.utils.Credentials;
import com.wes.mp_1918083_tugas3_restapi.restapi.utils.MovieApi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiService {
    private static Retrofit.Builder retrofitBuilder = new Retrofit.Builder().baseUrl(Credentials.BASE_URL).addConverterFactory(GsonConverterFactory.create());
    private static Retrofit retrofit = retrofitBuilder.build();
    private static MovieApi movieApi = retrofit.create(MovieApi.class);

    public static MovieApi getMovieApi() {
        return movieApi;
    }
}

