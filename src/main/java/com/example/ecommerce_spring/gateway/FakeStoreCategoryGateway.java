package com.example.ecommerce_spring.gateway;


import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.ecommerce_spring.dto.CategoryDTO;
import com.example.ecommerce_spring.dto.FakeStoreCategoryResponseDTO;
import com.example.ecommerce_spring.gateway.api.IFakeStoreCategoryApi;

@Component
public class FakeStoreCategoryGateway implements ICategoryGateway {

    private final IFakeStoreCategoryApi fakestorecategoryapi;
    public FakeStoreCategoryGateway(IFakeStoreCategoryApi fakestorecategoryapi){
        this.fakestorecategoryapi = fakestorecategoryapi;
    }

    @Override
    public List<CategoryDTO> getAllCategories() throws IOException {
        FakeStoreCategoryResponseDTO response = this.fakestorecategoryapi.getAllFakeCategories().execute().body();
        if(response == null) {
            throw new IOException("Failed to fetch categories");
        }
        return response.getCategories().stream()
                .map(category -> CategoryDTO.builder()
                        .name(category)
                        .build())
                .toList();
    }
}
