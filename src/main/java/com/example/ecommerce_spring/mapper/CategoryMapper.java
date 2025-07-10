package com.example.ecommerce_spring.mapper;

import com.example.ecommerce_spring.dto.CategoryDTO;
import com.example.ecommerce_spring.entity.Category;

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
}
