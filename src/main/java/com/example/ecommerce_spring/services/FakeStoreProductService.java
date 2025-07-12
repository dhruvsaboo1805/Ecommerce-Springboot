package com.example.ecommerce_spring.services;

import com.example.ecommerce_spring.dto.ProductDTO;
import com.example.ecommerce_spring.dto.ProductsWithCategoryDTO;
import com.example.ecommerce_spring.gateway.IProductGateway;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FakeStoreProductService implements IProductService{
    private final IProductGateway productGateway;

    public FakeStoreProductService(IProductGateway productGateway) {
        this.productGateway = productGateway;
    }


    @Override
    public ProductDTO getProductById(Long id) throws Exception {
       return this.productGateway.getProductById(id);
    }

    @Override
    public ProductDTO createProduct(ProductDTO dto) throws Exception {
        return null;
    }

    @Override
    public List<ProductDTO> getProductsByMinPrice(double minPrice) throws Exception {
        return null;
    }

    @Override
    public ProductsWithCategoryDTO getProductWithCategory(Long id) throws Exception {
        return null;
    }

    @Override
    public ProductDTO deleteProduct(Long id) throws Exception {
        return null;
    }
}
