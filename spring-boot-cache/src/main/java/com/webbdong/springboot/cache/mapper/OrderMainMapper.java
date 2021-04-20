package com.webbdong.springboot.cache.mapper;

import com.webbdong.springboot.cache.base.MyBaseMapper;
import com.webbdong.springboot.cache.model.domain.OrderMainDo;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 订单主表 Mapper 接口
 * </p>
 *
 * @author Webb Dong
 * @since 2020-08-06
 */
@Mapper
public interface OrderMainMapper extends MyBaseMapper<OrderMainDo> {

}
