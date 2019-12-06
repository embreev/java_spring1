package ru.breev.data.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.breev.data.entities.Category;
import ru.breev.data.entities.Product;
import ru.breev.data.repositories.CategoryRepository;
import ru.breev.data.repositories.ProductRepository;

import java.util.List;

@Service
public class CategoryService {

    CategoryRepository categoryRepository;

    @Autowired
    public void setCategoryRepository(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id).get();
    }
}
