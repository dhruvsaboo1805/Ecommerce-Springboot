package com.example.ecommerce_spring.gateway;

import com.example.ecommerce_spring.dto.ProductDTO;

public interface IProductGateway {
    ProductDTO getProductById(Long id) throws Exception;
}
