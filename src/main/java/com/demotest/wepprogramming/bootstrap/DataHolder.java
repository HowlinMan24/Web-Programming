package com.demotest.wepprogramming.bootstrap;

import com.demotest.wepprogramming.model.Category;
import com.demotest.wepprogramming.model.User;
import jakarta.annotation.PostConstruct;

import java.util.ArrayList;
import java.util.List;

public class DataHolder {
    public static List<Category> categories = new ArrayList<>();
    public static List<User> users = new ArrayList<>();

    @PostConstruct
    public void init() {
        categories.add(new Category("Movies","Movies category"));
        categories.add(new Category("Books","Books category"));

        users.add(new User("kiro","Rosana<3","Hristijan","Mijalkov"));
        users.add(new User("rosana","KiRo<3","Sandra","Ivanova"));
    }
}
