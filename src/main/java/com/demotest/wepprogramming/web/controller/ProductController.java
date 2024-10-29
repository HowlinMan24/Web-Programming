package com.demotest.wepprogramming.web.controller;

import com.demotest.wepprogramming.model.Category;
import com.demotest.wepprogramming.model.Manufacturer;
import com.demotest.wepprogramming.model.Product;
import com.demotest.wepprogramming.service.impl.CategoryServiceImpl;
import com.demotest.wepprogramming.service.impl.ManufacturerServiceImpl;
import com.demotest.wepprogramming.service.impl.ProductServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {

    private final ProductServiceImpl productService;
    private final CategoryServiceImpl categoryService;
    private final ManufacturerServiceImpl manufacturerService;

    public ProductController(ProductServiceImpl productService, CategoryServiceImpl categoryService, ManufacturerServiceImpl manufacturerService) {
        this.productService = productService;
        this.categoryService = categoryService;
        this.manufacturerService = manufacturerService;
    }

    @GetMapping
    public String getProductPage(@RequestParam(required = false) String error, Model model) {
        if (error != null && !error.isEmpty()) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }
        List<Product> products = this.productService.findAll().orElseThrow(() -> new RuntimeException("No products found"));
        model.addAttribute("products", products);
        return "products";
    }

    @PostMapping
    public String deleteProduct(@PathVariable Long id) {
        this.productService.deleteById(id);
        return "redirect:/products";
    }

    @GetMapping("/edit-form/{id}")
    public String editProductForm(@PathVariable Long id, Model model) {
        if (this.productService.findById(id).isPresent()) {
            Product product = this.productService.findById(id).get();
            List<Manufacturer> manufacturers = this.manufacturerService.findAll().orElseThrow(() -> new RuntimeException("No manufacturers found"));
            List<Category> categories = this.categoryService.findAll();
            model.addAttribute("manufacturers", manufacturers);
            model.addAttribute("categories", categories);
            model.addAttribute("product", product);
            return "add-product";
        }
        return "redirect:/products?error=ProductNotFound";
    }

    @GetMapping("/add-form")
    public String addProductForm(Model model) {
        List<Manufacturer> manufacturers = this.manufacturerService.findAll().orElseThrow(() -> new RuntimeException("No manufacturers found"));
        List<Category> categories = this.categoryService.findAll();
        model.addAttribute("manufacturers", manufacturers);
        model.addAttribute("categories", categories);
        return "add-product";
    }

    @PostMapping("/add")
    public String saveProduct(@RequestParam String name,
                              @RequestParam Double price,
                              @RequestParam Integer quantity,
                              @RequestParam Long category,
                              @RequestParam Long manufacturer) {
        this.productService.save(name, price, quantity, category, manufacturer);
        return "redirect:/products";
    }
}