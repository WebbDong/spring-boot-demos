package com.webbdong.springboot.jpa.repository;

import com.webbdong.springboot.jpa.entity.any.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Webb Dong
 * @date 2021-04-24 1:16 AM
 */
@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
}
