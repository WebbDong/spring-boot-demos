package com.webbdong.springboot.cache.model.mapper;

import com.webbdong.springboot.cache.model.domain.OrderMainDo;
import com.webbdong.springboot.cache.model.dto.OrderMainDto;
import com.webbdong.springboot.cache.model.mapper.typemapper.OrderMainModelTypeMapper;
import com.webbdong.springboot.cache.model.vo.OrderMainVo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 订单主表 Mapper 接口
 * unmappedTargetPolicy = ReportingPolicy.IGNORE 当目标类没有对应的字段时，忽略该字段的映射
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, uses = OrderMainModelTypeMapper.class)
public interface OrderMainModelMapper {

    OrderMainModelMapper INSTANCE = Mappers.getMapper(OrderMainModelMapper.class);

    /**
     * DO转DTO
     * @param orderMainDo
     * @return
     */
    OrderMainDto doToDto(OrderMainDo orderMainDo);

    /**
     * DTO转DO
     * @param orderMainDto
     * @return
     */
    OrderMainDo dtoToDo(OrderMainDto orderMainDto);

    /**
     * DTO转VO
     * @param orderMainDto
     * @return
     */
    @Mappings({
            @Mapping(source = "fee.amount", target = "fee.amount"),
            @Mapping(source = "fee.currencyUnit.code", target = "fee.currency"),
            @Mapping(source = "createTime", target = "createTime", dateFormat = "yyyy-MM-dd HH:mm:ss"),
            @Mapping(source = "updateTime", target = "updateTime", dateFormat = "yyyy-MM-dd HH:mm:ss")
    })
    OrderMainVo dtoToVo(OrderMainDto orderMainDto);

    /**
     * VO转DTO
     * @param orderMainVo
     * @return
     */
    @Mappings({
            @Mapping(source = "fee", target = "fee"),
            @Mapping(source = "fee.currency", target = "currency"),
            @Mapping(source = "createTime", target = "createTime", dateFormat = "yyyy-MM-dd HH:mm:ss"),
            @Mapping(source = "updateTime", target = "updateTime", dateFormat = "yyyy-MM-dd HH:mm:ss")
    })
    OrderMainDto voToDto(OrderMainVo orderMainVo);

    /**
     * DO List转DTO List
     * @param doList
     * @return
     */
    List<OrderMainDto> doListToDtoList(List<OrderMainDo> doList);

    /**
     * DTO List转VO List
     * @param dtoList
     * @return
     */
    List<OrderMainVo> dtoListToVoList(List<OrderMainDto> dtoList);

}
