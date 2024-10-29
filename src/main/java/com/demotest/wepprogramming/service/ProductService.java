package com.demotest.wepprogramming.service;

import com.demotest.wepprogramming.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    Optional<List<Product>> findAll();

    Optional<Product> findById(Long id);

    Optional<Product> findByName(String name);

    Optional<Product> save(String name, Double price, Integer quantity, Long categoryId, Long manufacturerId);

    Optional<Product> deleteById(Long id);
}