package com.example.ecommerce_spring.configuration;

import com.example.ecommerce_spring.gateway.api.IFakeStoreCategoryApi;
import com.example.ecommerce_spring.gateway.api.IFakeStoreProductAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.Objects;

@Configuration
public class RetrofitConfig {

    @Autowired
    private Environment env;

    @Bean
    public Retrofit retroFit() {
        String baseurl = env.getProperty("FAKESTORE-BASEURL");
        return new Retrofit.Builder()
                .baseUrl(Objects.requireNonNull(baseurl))
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

