package com.example.ecommerce_spring.mapper;

import com.example.ecommerce_spring.dto.ProductDTO;
import com.example.ecommerce_spring.entity.Product;

public class ProductMapper {
    public static ProductDTO todto(Product product) {
        return ProductDTO.builder()
//                .id((long) product.getId())
                .image(product.getImage())
                .color(product.getColor())
                .model(product.getModel())
                .brand(product.getBrand())
                .price(product.getPrice())
                .title(product.getTitle())
                .popular(product.isPopular())
                .description(product.getDescription())
                .discount(product.getDiscount())
                .category(product.getCategory())
                .build();
    }

    public static Product toEntity(ProductDTO dto) {
        return Product.builder()
//                .id(Math.toIntExact(dto.getId()))
                .image(dto.getImage())
                .color(dto.getColor())
                .model(dto.getModel())
                .brand(dto.getBrand())
                .price(dto.getPrice())
                .title(dto.getTitle())
                .popular(dto.isPopular())
                .description(dto.getDescription())
                .discount(dto.getDiscount())
                .category(dto.getCategory())
                .build();
    }
}


