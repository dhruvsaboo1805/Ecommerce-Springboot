package com.example.ecommerce_spring.mapper;

import com.example.ecommerce_spring.dto.ProductDTO;
import com.example.ecommerce_spring.dto.ProductsWithCategoryDTO;
import com.example.ecommerce_spring.entity.Category;
import com.example.ecommerce_spring.entity.Product;

public class ProductMapper {
    public static ProductDTO todto(Product product) {
        return ProductDTO.builder()
                .id(product.getId())
                .image(product.getImage())
                .color(product.getColor())
                .model(product.getModel())
                .brand(product.getBrand())
                .price(product.getPrice())
                .title(product.getTitle())
                .popular(product.isPopular())
                .description(product.getDescription())
                .discount(product.getDiscount())
                .CategoryId(product.getCategory().getId())
                .build();
    }

    public static Product toEntity(ProductDTO dto , Category category) {
        return Product.builder()
                .image(dto.getImage())
                .color(dto.getColor())
                .model(dto.getModel())
                .brand(dto.getBrand())
                .price(dto.getPrice())
                .title(dto.getTitle())
                .popular(dto.isPopular())
                .description(dto.getDescription())
                .discount(dto.getDiscount())
                .category(category)
                .build();
    }

    public static ProductsWithCategoryDTO toProductWithCategoryDTO(Product product) {
        return ProductsWithCategoryDTO.builder()
                .id(product.getId())
                .image(product.getImage())
                .color(product.getColor())
                .price(product.getPrice())
                .description(product.getDescription())
                .discount(product.getDiscount())
                .model(product.getModel())
                .title(product.getTitle())
                .brand(product.getBrand())
                .popular(product.isPopular())
                .category(CategoryMapper.todto(product.getCategory()))
                .build();
    }
}


