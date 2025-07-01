package com.example.ecommerce_spring.gateway.api;

import com.example.ecommerce_spring.dto.FakeStoreProductDTO;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.io.IOException;

public interface IFakeStoreProductAPI {
    @GET("products/{id}")
    Call<FakeStoreProductDTO> getFakeProduct(@Path("id") Long id) throws IOException;
}
