package com.webbdong.mongodb.test;

import com.mongodb.client.result.UpdateResult;
import com.webbdong.mongodb.model.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * @author: Webb Dong
 * @date: 2021-11-18 5:38 PM
 */
@SpringBootTest
public class MongoTemplateTest {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Test
    public void testInsert() {
        Product product = new Product();
        product.setName("MontBlanc Ferrari");
        product.setPrice(BigDecimal.valueOf(8700));
        mongoTemplate.insert(product);
    }

    @Test
    public void testBatchInsert() {
        List<Product> products = new ArrayList<>();
        for (int i = 116001; i <= 2000000; i++) {
            Product product = new Product();
            product.setName("prod" + i);
            product.setPrice(BigDecimal.valueOf(2 * i));
            products.add(product);
        }
        mongoTemplate.insert(products, Product.class);
    }

    @Test
    public void testUpdate() {
        Product replacement = new Product();
        replacement.setPrice(BigDecimal.valueOf(4));
        Query query = new Query(Criteria.where("price").lt("20"));
        Update update = Update.update("price", "10");
        long modifiedCount = mongoTemplate.update(Product.class)
                .matching(query)
                .apply(update)
                .all()
                .getModifiedCount();
        System.out.println("modifiedCount = " + modifiedCount);
    }

    @Test
    public void testUpdateFirst() {
        Query query = new Query(Criteria.where("id").is("6195fc40d8e73f4de7c57e09"));
        Update update = Update.update("price", "444");
        long modifiedCount = mongoTemplate.updateFirst(query, update, Product.class).getModifiedCount();
        System.out.println("modifiedCount = " + modifiedCount);
    }

    @Test
    public void testUpdateMulti() {
        Query query = new Query(Criteria.where("price").is("10"));
        Update update = Update.update("price", "555");
        UpdateResult updateResult = mongoTemplate.updateMulti(query, update, Product.class);
        System.out.println("modifiedCount = " + updateResult.getModifiedCount());
    }

    @Test
    public void testUpsert() {
        Query query = new Query(Criteria.where("id").is("6195fc40d8e73f4de7c57e09"));
        Update update = new Update();
        update.set("price", "333");
        update.set("name", "Ferrari");
        UpdateResult updateResult = mongoTemplate.upsert(query, update, Product.class);
        System.out.println("modifiedCount = " + updateResult.getModifiedCount());
    }

    @Test
    public void testFindById() {
        Product product = mongoTemplate.findById("6195fc40d8e73f4de7c57e09", Product.class);
        System.out.println(product);
    }

    @Test
    public void testFind() {
        // name = prod8 and price = 16
        Query query = new Query(Criteria
                .where("name").is("prod8")
                .and("price").is("16"));
        List<Product> products = mongoTemplate.find(query, Product.class);
        System.out.println(products);
    }

    @Test
    public void testFind2() {
        // name = prod8 or price = 20
        Query query = new Query(
                new Criteria()
                .orOperator(Criteria.where("name").is("prod8"),
                        Criteria.where("price").is("20")));
        List<Product> products = mongoTemplate.find(query, Product.class);
        System.out.println(products);
    }

    @Test
    public void testFindLike() {
        String key = "prod1";
        // 模糊查询
        // 模糊查询以【^】开始以【$】结束【.*】相当于Mysql中的%
        String regex = String.format("%s%s%s", "^.*", key, ".*$");
        // Pattern.CASE_INSENSITIVE 忽略大小写
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Query query = new Query(Criteria.where("name").regex(pattern));
        List<Product> products = mongoTemplate.find(query, Product.class);
        System.out.println(products);
    }

    @Test
    public void testFindPage() {
        int page = 1;
        int size = 10;
        int offset = (page - 1) * size;
        Query query = new Query();
        long totalCount = mongoTemplate.count(query, Product.class);
        List<Product> products = mongoTemplate.find(query.skip(offset).limit(size), Product.class);
        System.out.println(totalCount);
        System.out.println(products);
    }

}
