package com.webbdong.springboot.aop.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.webbdong.springboot.aop.model.domain.OrderMain;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单主表 Mapper 接口
 *
 * @author Webb Dong
 * @since 2020-08-06
 */
@Mapper
public interface OrderMainMapper extends BaseMapper<OrderMain> {

}
