package com.webbdong.springboot.mybatis.mapper;

import com.webbdong.springboot.mybatis.entity.discriminator.CorporateUser;
import com.webbdong.springboot.mybatis.entity.discriminator.PersonalUser;
import com.webbdong.springboot.mybatis.entity.discriminator.Vehicle;
import org.apache.ibatis.annotations.Case;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.TypeDiscriminator;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * @author Webb Dong
 * @date 2018-04-23 4:02 PM
 */
@Mapper
public interface VehicleMapper {

    List<Vehicle> selectCascadeAll();

    @Select("SELECT * FROM t_vehicle")
    @TypeDiscriminator(
            column = "owner_type",
            javaType = String.class,
            cases = {
                    @Case(
                            value = "pu",
                            type = Vehicle.class,
                            results = {
                                    @Result(property = "ownerId", column = "owner_id"),
                                    @Result(property = "owner",
                                               column = "owner_id",
                                               javaType = PersonalUser.class,
                                               one = @One(fetchType = FetchType.LAZY,
                                                          select = "com.webbdong.springboot.mybatis.mapper.PersonalUserMapper.selectById"))
                            }
                    ),
                    @Case(
                            value = "cu",
                            type = Vehicle.class,
                            results = {
                                    @Result(property = "ownerId", column = "owner_id"),
                                    @Result(property = "owner",
                                               column = "owner_id",
                                               javaType = CorporateUser.class,
                                               one = @One(fetchType = FetchType.LAZY,
                                                         select = "com.webbdong.springboot.mybatis.mapper.CorporateUserMapper.selectById"))
                            }
                    )
            }
    )
    List<Vehicle> selectCascadeAllByAnnotation();

}
