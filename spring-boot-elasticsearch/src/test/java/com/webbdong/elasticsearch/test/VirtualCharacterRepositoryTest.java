package com.webbdong.elasticsearch.test;

import com.webbdong.elasticsearch.App;
import com.webbdong.elasticsearch.entity.VirtualCharacter;
import com.webbdong.elasticsearch.repository.VirtualCharacterRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

/**
 * @author WebbDong
 * @createTime 2023-10-17 01:47
 */
@SpringBootTest(classes = App.class)
public class VirtualCharacterRepositoryTest {

    @Autowired
    private VirtualCharacterRepository virtualCharacterRepository;

    @Test
    public void testFindById() {
        Optional<VirtualCharacter> virtualCharacter = virtualCharacterRepository.findById(1701787129066090498L);
        System.out.println(virtualCharacter.get());
    }

    @Test
    public void testFindByMbti() {
        List<VirtualCharacter> list = virtualCharacterRepository.findByMbti("ENTJ");
        for (VirtualCharacter vc : list) {
            System.out.println(vc.getId());
        }
    }

    @Test
    public void testFindByMbtiContaining() {
        // page参数从0开始
        PageRequest pageRequest = PageRequest.of(0, 10, Sort.by(Sort.Order.desc("id")));
        Page<VirtualCharacter> page = virtualCharacterRepository.findByMbtiContaining("P", pageRequest);
        System.out.println("numberOfElements:" + page.getNumberOfElements());
        System.out.println("totalPages:" + page.getTotalPages());
        System.out.println("number:" + page.getNumber());
        for (VirtualCharacter vc : page.getContent()) {
            System.out.println(vc.getId());
        }
    }

    @Test
    public void testfindByMbtiWithAnnon() {
        PageRequest pageRequest = PageRequest.of(0, 10, Sort.by(Sort.Order.desc("id")));
        Page<VirtualCharacter> page = virtualCharacterRepository.findByMbtiWithAnnotation("ENTJ", pageRequest);
        System.out.println("numberOfElements:" + page.getNumberOfElements());
        System.out.println("totalPages:" + page.getTotalPages());
        System.out.println("number:" + page.getNumber());
        for (VirtualCharacter vc : page.getContent()) {
            System.out.println(vc.getId());
        }
    }

    @Test
    public void testFindByMbtiContainingWithAnnotation() {
        PageRequest pageRequest = PageRequest.of(0, 10, Sort.by(Sort.Order.desc("id")));
        Page<VirtualCharacter> page = virtualCharacterRepository.findByMbtiContainingWithAnnotation("P", pageRequest);
        System.out.println("numberOfElements:" + page.getNumberOfElements());
        System.out.println("totalPages:" + page.getTotalPages());
        System.out.println("number:" + page.getNumber());
        for (VirtualCharacter vc : page.getContent()) {
            System.out.println(vc.getId());
        }
    }

    @Test
    public void test() {
    }

}
