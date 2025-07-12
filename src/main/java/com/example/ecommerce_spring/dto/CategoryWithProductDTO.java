package com.example.ecommerce_spring.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class CategoryWithProductDTO {
    private Long id;
    private String name;
    private List<ProductDTO> product;
}
