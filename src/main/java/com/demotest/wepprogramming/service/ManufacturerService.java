package com.demotest.wepprogramming.service;

import com.demotest.wepprogramming.model.Manufacturer;

import java.util.List;
import java.util.Optional;

public interface ManufacturerService {

    Optional<List<Manufacturer>> findAll();

    Optional<Manufacturer> findById(Long id);
}