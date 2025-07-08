package com.example.ecommerce_spring.services;

import com.example.ecommerce_spring.dto.ProductDTO;
import com.example.ecommerce_spring.entity.Product;
import com.example.ecommerce_spring.mapper.ProductMapper;
import com.example.ecommerce_spring.repository.IProductRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class ProductService_DB implements IProductService {
    private final IProductRepository productRepository;

    public ProductService_DB(IProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ProductDTO getProductById(Long id) throws Exception {
        return productRepository.findById(id)
                .map(ProductMapper::todto)
                .orElseThrow(() -> new Exception("Product not found"));

    }

    @Override
    public ProductDTO createProduct(ProductDTO dto) throws Exception {
        Product saved = productRepository.save(ProductMapper.toEntity(dto));
        return ProductMapper.todto(saved);
    }
}
