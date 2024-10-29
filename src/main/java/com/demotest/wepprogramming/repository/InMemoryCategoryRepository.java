package com.demotest.wepprogramming.repository;

import com.demotest.wepprogramming.bootstrap.DataHolder;
import com.demotest.wepprogramming.model.Category;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class InMemoryCategoryRepository {

    /**
     * Save the category in the in-memory db
     *
     * @param category
     * @return
     */
    public Category save(Category category) {
        DataHolder.categories.removeIf(x -> x.getName().equals(category.getName()));
        DataHolder.categories.add(category);
        return category;
    }

    /**
     * Find all the categories in the in-memory db
     *
     * @return
     */
    public List<Category> findAll() {
        return DataHolder.categories;
    }

    public Optional<Category> findById(Long id) {
        return DataHolder.categories.stream().filter(x -> x.getId().equals(id)).findFirst();
    }

    /**
     * Find all the categories that have the name from the parameter
     *
     * @param name
     * @return
     */
    public List<Category> findByName(String name) {
        return DataHolder.categories.stream().filter(x -> x.getName().contains(name)).toList();
    }

    /**
     * Find all the categories that have the text in their name or description
     *
     * @param text
     * @return
     */
    public List<Category> search(String text) {
        return DataHolder.categories.stream().filter(x -> x.getName().contains(text) || x.getDescription().contains(text)).toList();
    }

    /**
     * Delete the category that has the name from the argument
     *
     * @param name
     */
    public void delete(String name) {
        DataHolder.categories.removeIf(x -> x.getName().equals(name));
    }
}