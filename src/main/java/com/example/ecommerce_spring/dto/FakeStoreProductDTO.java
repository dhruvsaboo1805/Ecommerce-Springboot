package com.example.ecommerce_spring.dto;

import lombok.*;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class FakeStoreProductDTO {
    private ProductDTO products;
    private String status;
    private String message;
}
