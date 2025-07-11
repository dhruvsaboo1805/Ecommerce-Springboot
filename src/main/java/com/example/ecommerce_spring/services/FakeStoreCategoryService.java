package com.example.ecommerce_spring.services;

import com.example.ecommerce_spring.dto.CategoryDTO;
import com.example.ecommerce_spring.gateway.ICategoryGateway;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class FakeStoreCategoryService  implements ICategoryService{

    private final ICategoryGateway categoryGateway;

    public FakeStoreCategoryService(ICategoryGateway _categoryGateway) {
        this.categoryGateway = _categoryGateway;
    }
    @Override
    public List<CategoryDTO> getAllCategories() throws IOException {
       return null;
    }

    @Override
    public CategoryDTO createCategory(CategoryDTO categoryDTO) {
        return null;
    }

    @Override
    public CategoryDTO getByName(String name) throws Exception {
        return null;
    }
}
