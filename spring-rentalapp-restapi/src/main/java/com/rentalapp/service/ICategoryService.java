package com.rentalapp.service;

import com.rentalapp.exceptions.CategoryNotFoundException;
import com.rentalapp.model.Category;


public interface ICategoryService {
    Category addCategory(Category category);

    void updateCategory(Category category);

    void deleteCategory(int categoryId);

    Category getById(int categoryId) throws CategoryNotFoundException;


}
