package com.webbdong.mongodb.test;

import com.webbdong.mongodb.model.Product;
import com.webbdong.mongodb.repository.ProductMongoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author: Webb Dong
 * @date: 2021-11-18 1:14 PM
 */
@SpringBootTest
public class ProductMongoRepositoryTest {

    @Autowired
    private ProductMongoRepository productMongoRepository;

    @Test
    public void testInsert() {
        Product product = new Product();
        product.setName("prod7");
        product.setPrice(BigDecimal.valueOf(900L));
        // spring data mongodb 保存时会自动存入 _class 字段，_class 字段用户映射存在子类实体的情况
        productMongoRepository.insert(product);
    }

    @Test
    public void testBatchInsert() {
        List<Product> products = new ArrayList<>();
        for (int i = 50; i < 100; i++) {
            Product product = new Product();
            product.setName("prod" + i);
            product.setPrice(BigDecimal.valueOf(2 * i));
            products.add(product);
        }
        productMongoRepository.insert(products);
    }

    @Test
    public void testPageable() {
        // page 页码从 0 开始计算
        Pageable pageable = PageRequest.of(0, 10, Sort.by(Sort.Order.desc("id"), Sort.Order.asc("name")));
        Page<Product> page = productMongoRepository.findAll(pageable);
        System.out.println(page.getTotalElements());
        System.out.println(page.getContent());
    }

    @Test
    public void testFindOne() {
        Product probe = new Product();
        probe.setId("6195fc40d8e73f4de7c57e09");
//        probe.setName("prod6");

        ExampleMatcher matcher = ExampleMatcher.matching()
                .withIncludeNullValues()
                .withStringMatcher(ExampleMatcher.StringMatcher.DEFAULT);

        // 查询时会自动带上 _class 字段，如果存储的数据没有 _class 字段，将会导致查询不到
        Optional<Product> product = productMongoRepository.findOne(Example.of(probe, matcher));
        System.out.println(product.get());
    }

    @Test
    public void testQueryWithName() {
        List<Product> products = productMongoRepository.queryWithName("prod2");
        System.out.println(products);
    }

    @Test
    public void testQueryGtePrice() {
        List<Product> products = productMongoRepository.queryGtePrice(5000.0);
        System.out.println(products);
    }

    @Test
    public void testQueryLikeName() {
        List<Product> products = productMongoRepository.queryLikeName("prod1");
        System.out.println(products);
    }

    @Test
    public void testQueryByIds() {
        List<String> ids = new ArrayList<>();
        ids.add("619601d506479b34b24d7d84");
        ids.add("619601d506479b34b24d7d88");
        List<Product> products = productMongoRepository.queryByIds(ids);
        System.out.println(products);
    }

    @Test
    public void testFindByName() {
        List<Product> products = productMongoRepository.findByName("prod3");
        System.out.println(products);
    }

    @Test
    public void testCount() {
        long count = productMongoRepository.count();
        System.out.println(count);
    }

    @Test
    public void testCount2() {
        Product probe = new Product();
        probe.setName("prod5");
        long count = productMongoRepository.count(Example.of(probe));
        System.out.println(count);
    }

    @Test
    public void testCountGtePrice() {
        long count = productMongoRepository.countGtePrice(5000.0);
        System.out.println(count);
    }

    @Test
    public void testExistsById() {
        boolean b = productMongoRepository.existsById("619601d506479b34b24d7d7e");
        System.out.println(b);
    }

    @Test
    public void testExists() {
        Product probe = new Product();
        probe.setName("prod7");
        boolean b = productMongoRepository.exists(Example.of(probe));
        System.out.println(b);
    }

    @Test
    public void testExistsGtePrice() {
        boolean b = productMongoRepository.existsGtePrice(5000.0);
        System.out.println(b);
    }

    @Test
    public void testDeleteById() {
        productMongoRepository.deleteById("6195dc617c20c11dfe7642c1");
    }

    @Test
    public void testDelete() {
        Product entity = new Product();
        entity.setId("6195f77c5236384584b3b4ea");
        entity.setName("prod6");
        entity.setPrice(BigDecimal.valueOf(900));
        productMongoRepository.delete(entity);
    }

    @Test
    public void testDeleteGtePrice() {
        productMongoRepository.deleteGtePrice(5000.0);
    }

}
