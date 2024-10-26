package com.demotest.wepprogramming.bootstrap;

import com.demotest.wepprogramming.model.Category;
import jakarta.annotation.PostConstruct;

import java.util.ArrayList;
import java.util.List;

public class DataHolder {
    public static List<Category> categories = new ArrayList<>();

    @PostConstruct
    public void init() {
        categories = new ArrayList<Category>();
        categories.add(new Category("Movies","Movies category"));
        categories.add(new Category("Books","Books category"));
    }
}
