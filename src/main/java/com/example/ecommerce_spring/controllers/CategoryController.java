package com.example.ecommerce_spring.controllers;

import com.example.ecommerce_spring.dto.CategoryDTO;
import com.example.ecommerce_spring.services.ICategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public List<CategoryDTO> getAllCategories() throws IOException {
        return categoryService.getAllCategories();
    }

}
