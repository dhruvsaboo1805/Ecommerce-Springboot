package com.example.ecommerce_spring.configuration;

import com.example.ecommerce_spring.gateway.api.IFakeStoreCategoryApi;
import com.example.ecommerce_spring.gateway.api.IFakeStoreProductAPI;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Configuration
public class RetrofitConfig {

    @Value("${FAKESTORE-BASEURL}")
    private String baseurl;

    @Bean
    public Retrofit retroFit() {

        return new Retrofit.Builder()
                .baseUrl(baseurl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

    }

    @Bean
    public IFakeStoreCategoryApi iFakeStoreCategoryApi(Retrofit retrofit) {
        return retrofit.create(IFakeStoreCategoryApi.class);
    }

    @Bean
    public IFakeStoreProductAPI iFakeStoreProductAPI(Retrofit retrofit) {
        return retrofit.create(IFakeStoreProductAPI.class);
    }
}

