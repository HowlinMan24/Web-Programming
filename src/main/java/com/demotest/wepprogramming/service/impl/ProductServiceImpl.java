package com.demotest.wepprogramming.service.impl;

import com.demotest.wepprogramming.model.Category;
import com.demotest.wepprogramming.model.Manufacturer;
import com.demotest.wepprogramming.model.Product;
import com.demotest.wepprogramming.repository.InMemoryCategoryRepository;
import com.demotest.wepprogramming.repository.InMemoryManufacturerRepository;
import com.demotest.wepprogramming.repository.InMemoryProductRepository;
import com.demotest.wepprogramming.service.ProductService;

import java.util.List;
import java.util.Optional;

public class ProductServiceImpl implements ProductService {

    private final InMemoryProductRepository inMemoryProductRepository;
    private final InMemoryCategoryRepository inMemoryCategoryRepository;
    private final InMemoryManufacturerRepository InMemoryManufacturerRepository;

    public ProductServiceImpl(InMemoryProductRepository inMemoryProductRepository, InMemoryCategoryRepository inMemoryCategoryRepository, com.demotest.wepprogramming.repository.InMemoryManufacturerRepository inMemoryManufacturerRepository) {
        this.inMemoryProductRepository = inMemoryProductRepository;
        this.inMemoryCategoryRepository = inMemoryCategoryRepository;
        InMemoryManufacturerRepository = inMemoryManufacturerRepository;
    }

    @Override
    public Optional<List<Product>> findAll() {
        return this.inMemoryProductRepository.listAll();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return this.inMemoryProductRepository.findById(id);
    }

    @Override
    public Optional<Product> findByName(String name) {
        return this.inMemoryProductRepository.findByName(name);
    }

    @Override
    public Optional<Product> save(String name, Double price, Integer quantity, Long categoryId, Long manufacturerId) {
        Category category = this.inMemoryCategoryRepository.findById(categoryId).orElseThrow(() -> new RuntimeException("Category not found"));
        Manufacturer manufacturer = this.InMemoryManufacturerRepository.findById(manufacturerId).orElseThrow(() -> new RuntimeException("Manufacturer not found"));
        return this.inMemoryProductRepository.save(name, price, quantity, category, manufacturer);
    }

    @Override
    public Optional<Product> deleteById(Long id) {
        return this.inMemoryProductRepository.deleteById(id);
    }
}