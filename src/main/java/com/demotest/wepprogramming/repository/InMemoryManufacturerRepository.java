package com.demotest.wepprogramming.repository;

import com.demotest.wepprogramming.bootstrap.DataHolder;
import com.demotest.wepprogramming.model.Manufacturer;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class InMemoryManufacturerRepository {

    /**
     * Find all manufacturers in the in-memory database
     *
     * @return
     */
    public Optional<List<Manufacturer>> listAll() {
        return Optional.of(DataHolder.manufacturers);
    }

    /**
     * Find the manufacturer with the parameter id
     *
     * @param id
     * @return
     */
    public Optional<Manufacturer> findById(Long id) {
        return DataHolder
                .manufacturers
                .stream()
                .filter(manufacturer -> manufacturer.getId().equals(id))
                .findFirst();
    }
}