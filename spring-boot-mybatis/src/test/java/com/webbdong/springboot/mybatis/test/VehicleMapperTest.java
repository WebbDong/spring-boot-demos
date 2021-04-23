package com.webbdong.springboot.mybatis.test;

import com.webbdong.springboot.mybatis.entity.discriminator.Vehicle;
import com.webbdong.springboot.mybatis.mapper.VehicleMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author Webb Dong
 * @date 2021-04-23 4:07 PM
 */
@SpringBootTest
public class VehicleMapperTest {

    @Autowired
    private VehicleMapper vehicleMapper;

    @Test
    public void testSelectCascadeById() {
        List<Vehicle> vehicleList = vehicleMapper.selectCascadeAll();
        System.out.println(vehicleList);
    }

    @Test
    public void testSelectCascadeAllByAnnotation() {
        List<Vehicle> vehicleList = vehicleMapper.selectCascadeAllByAnnotation();
        System.out.println(vehicleList);
    }

}
