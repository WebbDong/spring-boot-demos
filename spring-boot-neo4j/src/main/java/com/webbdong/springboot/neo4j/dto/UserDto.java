package com.webbdong.springboot.neo4j.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;

/**
 * @author Webb Dong
 * @date 2022-07-02 23:26
 */
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
public class UserDto {

    private Long id;

    private String name;

    private List<UserDto> followers;

}
