package com.example.ecommerce_spring.controllers;

import com.example.ecommerce_spring.dto.CategoryDTO;
import com.example.ecommerce_spring.dto.CategoryWithProductDTO;
import com.example.ecommerce_spring.services.ICategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("api/categories")
public class CategoryController {

    private final ICategoryService categoryService;

    // dependency injection we can also achieve this using @Autowired but sometimes the final keyword
    // issue comes
    public CategoryController(ICategoryService _categoryService) {
        this.categoryService = _categoryService;
    }

    @GetMapping("")
    public ResponseEntity<?> getAllCategories(@RequestParam(required = false) String name) throws Exception {
        if(name != null && !name.isBlank()) {
            CategoryDTO categoryDTO = categoryService.getByName(name);
            return ResponseEntity.ok(categoryDTO);
        } else {
            List<CategoryDTO> result = categoryService.getAllCategories();
            return ResponseEntity.ok(result);
        }

    }

    @GetMapping("/{id}/category/details")
    public ResponseEntity<List<CategoryWithProductDTO>> getCategoryWithProduct(@PathVariable Long id) throws Exception {
        List<CategoryWithProductDTO> result = categoryService.getCategoryWithProduct(id);
        return ResponseEntity.ok(result);
    }

    @PostMapping
    public ResponseEntity<CategoryDTO> createCategory(@RequestBody CategoryDTO categoryDTO) {
        CategoryDTO created = categoryService.createCategory(categoryDTO);
        return ResponseEntity.ok(created);
    }

}
