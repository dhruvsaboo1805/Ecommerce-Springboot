package com.example.ecommerce_spring.services;

import com.example.ecommerce_spring.dto.ProductDTO;
import com.example.ecommerce_spring.entity.Category;
import com.example.ecommerce_spring.entity.Product;
import com.example.ecommerce_spring.mapper.ProductMapper;
import com.example.ecommerce_spring.repository.ICategoryRepository;
import com.example.ecommerce_spring.repository.IProductRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Primary
public class ProductService_DB implements IProductService {
    private final IProductRepository productRepository;
    private final ICategoryRepository categoryRepository;

    public ProductService_DB(IProductRepository productRepository , ICategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository= categoryRepository;
    }

    @Override
    public ProductDTO getProductById(Long id) throws Exception {
        return productRepository.findById(id)
                .map(ProductMapper::todto)
                .orElseThrow(() -> new Exception("Product not found"));

    }

    @Override
    public ProductDTO createProduct(ProductDTO dto) throws Exception {
        Category category = categoryRepository.findById(dto.getCategoryId())
                .orElseThrow(() -> new Exception("Category not found"));
        Product saved = productRepository.save(ProductMapper.toEntity(dto,category));
        return ProductMapper.todto(saved);
    }

    @Override
    public List<ProductDTO> getProductsByMinPrice(double minPrice) throws Exception {
        List<Product> products = productRepository.findExpensiveProducts(minPrice);
        List<ProductDTO> result = new ArrayList<>();

        for (Product product : products) {
            result.add(ProductMapper.todto(product));
        }

        return result;
    }
}
