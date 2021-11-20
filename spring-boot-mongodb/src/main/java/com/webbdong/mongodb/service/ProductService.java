package com.webbdong.mongodb.service;

import com.webbdong.mongodb.model.Product;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @author: Webb Dong
 * @date: 2021-11-18 12:30 PM
 */
public interface ProductService {

    List<Product> getAllProducts();

    Product getById(String id);

    Page<Product> page(int page, int size);

}
