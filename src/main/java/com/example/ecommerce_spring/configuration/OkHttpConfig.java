package com.example.ecommerce_spring.configuration;

import okhttp3.OkHttpClient;
import org.springframework.context.annotation.Bean;

public class OkHttpConfig {

    @Bean
    public OkHttpClient okhttpclient() {
        return new OkHttpClient.Builder()
                .build();
    }
}
