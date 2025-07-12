package com.example.ecommerce_spring.mapper;

import com.example.ecommerce_spring.dto.CategoryDTO;
import com.example.ecommerce_spring.dto.CategoryWithProductDTO;
import com.example.ecommerce_spring.dto.ProductDTO;
import com.example.ecommerce_spring.entity.Category;
import com.example.ecommerce_spring.entity.Product;

import java.util.Collections;
import java.util.List;

public class CategoryMapper {
    public static CategoryDTO todto(Category category) {
        return CategoryDTO.builder()
                .id(category.getId())
                .name(category.getName())
                .build();
    }

    public static Category toEntity(CategoryDTO dto) {
        return Category.builder()
                .name(dto.getName())
                .build();
    }

    public static CategoryWithProductDTO tocategoryWithProductDTO(Category category, List<ProductDTO> productDTOs) {
        return CategoryWithProductDTO.builder()
                .id(category.getId())
                .name(category.getName())
                .product(productDTOs)
                .build();
    }


}
