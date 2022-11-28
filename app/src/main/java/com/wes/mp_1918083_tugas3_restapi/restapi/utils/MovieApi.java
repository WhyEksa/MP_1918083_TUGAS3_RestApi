package com.wes.mp_1918083_tugas3_restapi.restapi.utils;

import com.wes.mp_1918083_tugas3_restapi.recyclerview.response.PopularMovieResponses;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MovieApi {
    // popular movie
    @GET("movie/popular")
    Call<PopularMovieResponses> getPopularMovie(@Query("api_key") String key,
                                                @Query("page") int page);

}