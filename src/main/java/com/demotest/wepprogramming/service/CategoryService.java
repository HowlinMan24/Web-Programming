package com.demotest.wepprogramming.service;

import com.demotest.wepprogramming.model.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAll();

    Category create(String name, String description);

    Category update(String name, String description);

    void delete(String name);

    List<Category> searchCategories(String categoryName);
}
