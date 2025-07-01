package com.example.ecommerce_spring.gateway;

import com.example.ecommerce_spring.dto.CategoryDTO;

import java.io.IOException;
import java.util.List;

public interface ICategoryGateway {
    List<CategoryDTO> getAllCategories() throws IOException;
}
