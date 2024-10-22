package com.example.uidesign;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("data-pipeline/v1/mock-frontend/homepage/1")
    Call<List<Section>> getHomeData();
}
