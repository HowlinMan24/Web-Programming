package com.demotest.wepprogramming.bootstrap;

import com.demotest.wepprogramming.model.Category;
import com.demotest.wepprogramming.model.Manufacturer;
import com.demotest.wepprogramming.model.Product;
import com.demotest.wepprogramming.model.User;
import jakarta.annotation.PostConstruct;

import java.util.ArrayList;
import java.util.List;

public class DataHolder {
    public static List<Category> categories = new ArrayList<>();
    public static List<User> users = new ArrayList<>();
    public static List<Product> products = new ArrayList<>();
    public static List<Manufacturer> manufacturers = new ArrayList<>();


    @PostConstruct
    public void init() {
        categories.add(new Category("Movies","Movies category"));
        categories.add(new Category("Books","Books category"));
        categories.add(new Category("Sport","Sport category"));
        categories.add(new Category("Food","Food category"));

        users.add(new User("kiro","Rosana<3","Hristijan","Mijalkov"));
        users.add(new User("rosana","KiRo<3","Sandra","Ivanova"));
        users.add(new User("cicmco", "KiRo<3", "Mario", "Cimerovski"));

        manufacturers.add(new Manufacturer("Nike","USA"));
        manufacturers.add(new Manufacturer("Coca-Cola","Germany"));
        manufacturers.add(new Manufacturer("Pastjet","USSR"));

        products.add(new Product("Nike Air Max",100.0,10,categories.get(0),manufacturers.get(0)));
        products.add(new Product("Fanta",3.47,1000,categories.get(3),manufacturers.get(2)));
        products.add(new Product("Lovecka Pastjet",1.12,100,categories.get(3),manufacturers.get(2)));
    }
}
