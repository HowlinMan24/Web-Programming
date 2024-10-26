package com.demotest.wepprogramming.repository;

import com.demotest.wepprogramming.bootstrap.DataHolder;
import com.demotest.wepprogramming.model.Category;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class InMemoryCategoryRepository {
    public Category save(Category category) {
        DataHolder.categories.removeIf(x -> x.getName().equals(category.getName()));
        DataHolder.categories.add(category);
        return category;
    }

    public List<Category> findAll() {
        return DataHolder.categories;
    }

    public List<Category> findByName(String name) {
        return DataHolder.categories.stream().filter(x -> x.getName().contains(name)).toList();
    }

    public List<Category> search(String text) {
        return DataHolder.categories.stream().filter(x -> x.getName().contains(text) || x.getDescription().contains(text)).toList();
    }

    public void delete(String name) {
        DataHolder.categories.removeIf(x -> x.getName().equals(name));
    }

}
