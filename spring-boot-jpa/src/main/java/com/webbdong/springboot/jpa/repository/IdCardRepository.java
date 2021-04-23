package com.webbdong.springboot.jpa.repository;

import com.webbdong.springboot.jpa.entity.onetoone.IdCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Webb Dong
 * @date 2018-04-22 11:10 PM
 */
@Repository
public interface IdCardRepository extends JpaRepository<IdCard, Long> {
}
