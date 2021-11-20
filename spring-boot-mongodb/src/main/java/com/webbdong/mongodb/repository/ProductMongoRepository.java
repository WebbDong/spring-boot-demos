package com.webbdong.mongodb.repository;

import com.webbdong.mongodb.model.Product;
import org.springframework.data.mongodb.repository.CountQuery;
import org.springframework.data.mongodb.repository.DeleteQuery;
import org.springframework.data.mongodb.repository.ExistsQuery;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

/**
 * 接口继承MongoRepository<实体类型,主键类型>
 * @author: Webb Dong
 * @date: 2021-11-18 12:28 PM
 */
public interface ProductMongoRepository extends MongoRepository<Product, String> {

    /**
     * 根据方法命名规则定义
     */
    List<Product> findByName(String name);

    @Query("{name:?0}")
    List<Product> queryWithName(String name);

    @Query("{price:{$gte:?0}}")
    List<Product> queryGtePrice(Double price);

    /**
     * 基于正则表达式的模糊查询
     */
    @Query("{name:/^.*?0.*$/}")
    List<Product> queryLikeName(String name);

    @Query("{id:{$in:?0}}")
    List<Product> queryByIds(List<String> ids);

    @CountQuery("{price:{$gte:?0}}")
    long countGtePrice(Double price);

    @ExistsQuery("{price:{$gte:?0}}")
    boolean existsGtePrice(Double price);

    @DeleteQuery("{price:{$gte:?0}}")
    void deleteGtePrice(Double price);

}
