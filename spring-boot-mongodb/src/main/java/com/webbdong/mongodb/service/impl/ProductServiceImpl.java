package com.webbdong.mongodb.service.impl;

import com.webbdong.mongodb.model.Product;
import com.webbdong.mongodb.repository.ProductMongoRepository;
import com.webbdong.mongodb.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author: Webb Dong
 * @date: 2021-11-18 12:30 PM
 */
@Service
public class ProductServiceImpl implements ProductService {

    private ProductMongoRepository productMongoRepository;

    @Autowired
    public ProductServiceImpl(ProductMongoRepository productMongoRepository) {
        this.productMongoRepository = productMongoRepository;
    }

    @Override
    public List<Product> getAllProducts() {
        return productMongoRepository.findAll();
    }

    @Override
    public Product getById(String id) {
        Optional<Product> optional = productMongoRepository.findById(id);
        return optional.isPresent() ? optional.get() : null;
    }

    @Override
    public Page<Product> page(int page, int size) {
        // page 页码从 0 开始计算
        return productMongoRepository.findAll(PageRequest.of(page, size));
    }

}
