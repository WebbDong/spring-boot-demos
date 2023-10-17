package com.webbdong.elasticsearch.repository;

import com.webbdong.elasticsearch.entity.VirtualCharacter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author WebbDong
 * @createTime 2023-10-17 00:52
 */
@Repository
public interface VirtualCharacterRepository extends ElasticsearchRepository<VirtualCharacter, Long> {

    List<VirtualCharacter> findByMbti(String mbti);

    Page<VirtualCharacter> findByMbtiContaining(String mbti, Pageable pageable);

    @Query("{\"match\":{\"mbti\":\"?0\"}}")
    Page<VirtualCharacter> findByMbtiWithAnnotation(String mbti, Pageable pageable);

    @Query("{\"wildcard\":{\"mbti\":{\"value\":\"*?0*\"}}}")
    Page<VirtualCharacter> findByMbtiContainingWithAnnotation(String mbti, Pageable pageable);

}
