package com.demotest.wepprogramming.service.impl;

import com.demotest.wepprogramming.model.Manufacturer;
import com.demotest.wepprogramming.repository.InMemoryManufacturerRepository;
import com.demotest.wepprogramming.service.ManufacturerService;

import java.util.List;
import java.util.Optional;

public class ManufacturerServiceImpl implements ManufacturerService {

    private final InMemoryManufacturerRepository manufacturerRepository;

    public ManufacturerServiceImpl(InMemoryManufacturerRepository manufacturerRepository) {
        this.manufacturerRepository = manufacturerRepository;
    }

    @Override
    public Optional<List<Manufacturer>> findAll() {
        return this.manufacturerRepository.listAll();
    }

    @Override
    public Optional<Manufacturer> findById(Long id) {
        return this.manufacturerRepository.findById(id);
    }
}
