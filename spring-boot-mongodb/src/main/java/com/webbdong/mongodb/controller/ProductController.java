package com.webbdong.mongodb.controller;

import com.webbdong.mongodb.model.Product;
import com.webbdong.mongodb.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: Webb Dong
 * @date: 2021-11-18 12:29 PM
 */
@RestController
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping("/{id}")
    public Product getById(@PathVariable("id") String id) {
        return productService.getById(id);
    }

    @RequestMapping("/all")
    public List<Product> allProducts() {
        return productService.getAllProducts();
    }

    @RequestMapping("/page")
    public Page<Product> page(@Param("page") int page, @Param("size") int size) {
        return productService.page(page, size);
    }

}
