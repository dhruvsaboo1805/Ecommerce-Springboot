package com.example.ecommerce_spring.gateway;

import com.example.ecommerce_spring.dto.CategoryDTO;
import com.example.ecommerce_spring.dto.FakeStoreCategoryResponseDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;

import java.io.IOException;
import java.util.List;

@Primary
public class FakeStoreCategoryGatewayOKHttp {
    private final OkHttpClient okhttpclient;
    @Autowired
    private Environment env;

    public FakeStoreCategoryGatewayOKHttp(OkHttpClient okhttpclient) {
        this.okhttpclient = okhttpclient;
    }
    public List<CategoryDTO> getAllCategories() throws IOException {
        String baseurl = env.getProperty("FAKESTORE-BASEURL");
        String url = baseurl + "products/category";
        Request request = new Request.Builder()
                .url(url)
                .build();
        try(Response response = okhttpclient.newCall(request).execute()) {
            if(!response.isSuccessful()) {
                throw new IOException("Unexpected code " + response);
            }
            String json = response.body().string();
            Gson gson = new Gson();
            FakeStoreCategoryResponseDTO res = gson.fromJson(json, FakeStoreCategoryResponseDTO.class);
            return res.getCategories()
                    .stream()
                    .map(category -> CategoryDTO.builder()
                            .name(category)
                            .build())
                    .toList();
        }

    }
}
