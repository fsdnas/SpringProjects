package com.rentalapp.service;


import com.rentalapp.exceptions.CategoryNotFoundException;
import com.rentalapp.exceptions.PropertyNotFoundException;
import com.rentalapp.model.Category;
import com.rentalapp.repository.ICategoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements ICategoryService {
    private ICategoryRepository categoryRepository;

    @Autowired
    public void setCategoryRepository(ICategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    @Override
    public Category addCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public void updateCategory(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public void deleteCategory(int categoryId) {
        categoryRepository.deleteById(categoryId);
    }

    @Override
    public Category getById(int categoryId) throws PropertyNotFoundException {
        return categoryRepository.findById(categoryId).orElseThrow(CategoryNotFoundException::new);
    }
}
