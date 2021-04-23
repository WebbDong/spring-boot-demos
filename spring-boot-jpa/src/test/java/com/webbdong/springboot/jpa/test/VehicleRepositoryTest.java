package com.webbdong.springboot.jpa.test;

import com.google.gson.Gson;
import com.webbdong.springboot.jpa.entity.any.Vehicle;
import com.webbdong.springboot.jpa.repository.VehicleRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author Webb Dong
 * @date 2021-04-24 1:17 AM
 */
@SpringBootTest
public class VehicleRepositoryTest {

    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private Gson gson;

    @Test
    public void testFindAll() {
        List<Vehicle> vehicleList = vehicleRepository.findAll();
        System.out.println(gson.toJson(vehicleList));
    }

}
