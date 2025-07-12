package com.example.ecommerce_spring.controllers;

import com.example.ecommerce_spring.dto.ProductDTO;
import com.example.ecommerce_spring.dto.ProductsWithCategoryDTO;
import com.example.ecommerce_spring.services.IProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final IProductService productService;

    public ProductController(IProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable Long id) throws Exception {
        ProductDTO res = this.productService.getProductById(id);

        return ResponseEntity.ok(res);
    }

    @GetMapping("/price/{minPrice}")
    public ResponseEntity<List<ProductDTO>> getProductsByMinPrice(@PathVariable double minPrice) throws Exception {
        List<ProductDTO> res = productService.getProductsByMinPrice(minPrice);
        return ResponseEntity.ok(res);
    }

    @GetMapping("/{id}/details")
    public ResponseEntity<ProductsWithCategoryDTO> getProductWithCategory(@PathVariable Long id) throws Exception {
        ProductsWithCategoryDTO productsWithCategoryDTO = productService.getProductWithCategory(id);
        return ResponseEntity.ok(productsWithCategoryDTO);
    }

    @PostMapping
    public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO dto) throws Exception{
        return ResponseEntity.ok(productService.createProduct(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ProductDTO> deleteProduct(@PathVariable Long id) throws Exception {
        return ResponseEntity.ok(productService.deleteProduct(id));
    }



}
