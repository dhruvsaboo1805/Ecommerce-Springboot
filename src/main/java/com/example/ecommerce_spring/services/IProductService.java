package com.example.ecommerce_spring.services;

import com.example.ecommerce_spring.dto.ProductDTO;
import com.example.ecommerce_spring.dto.ProductsWithCategoryDTO;

import java.util.List;

public interface IProductService {
    ProductDTO getProductById(Long id) throws Exception;
    ProductDTO createProduct(ProductDTO dto) throws Exception;
    List<ProductDTO> getProductsByMinPrice(double minPrice) throws Exception;
    ProductsWithCategoryDTO getProductWithCategory(Long id) throws Exception;
    ProductDTO deleteProduct(Long id) throws Exception;
}
