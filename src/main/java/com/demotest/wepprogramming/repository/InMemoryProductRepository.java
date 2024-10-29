package com.demotest.wepprogramming.repository;

import com.demotest.wepprogramming.bootstrap.DataHolder;
import com.demotest.wepprogramming.model.Category;
import com.demotest.wepprogramming.model.Manufacturer;
import com.demotest.wepprogramming.model.Product;
import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.tags.form.OptionsTag;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Repository
public class InMemoryProductRepository {

    /**
     * List all product
     * @return
     */
    public Optional<List<Product>> listAll() {
        return Optional.of(DataHolder.products);
    }

    /**
     * Find product by id
     * @param id
     * @return
     */
    public Optional<Product> findById(Long id) {
        return DataHolder
                .products
                .stream()
                .filter(product -> product.getId().equals(id))
                .findFirst();
    }

    /**
     * Find product by name
     * @param name
     * @return
     */
    public Optional<Product> findByName(String name) {
        return DataHolder
                .products
                .stream()
                .filter(product -> product.getName().equals(name))
                .findFirst();
    }

    /**
     * Delete product by id
     * @param id
     * @return
     */
    public Optional<Product> deleteById(Long id) {
        return DataHolder
                .products
                .stream()
                .filter(product -> product.getId().equals(id))
                .findFirst();
    }

    /**
     * Save the product in the in-memory db
     * @param name
     * @param price
     * @param quantity
     * @param category
     * @param manufacturer
     * @return
     */
    public Optional<Product> save(String name, Double price, Integer quantity,
                                          Category category, Manufacturer manufacturer) {
        if (category == null || manufacturer == null) {
            throw new IllegalArgumentException();
        }
        Product product = new Product(name, price, quantity, category, manufacturer);
        DataHolder.products.removeIf(x -> x.getName().equals(product.getName()));
        DataHolder.products.add(product);
        return Optional.of(product);
    }

}
