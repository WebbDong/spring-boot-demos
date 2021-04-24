package com.webbdong.springboot.redis.cache.model.query;

import com.webbdong.springboot.redis.cache.base.BaseQuery;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderMainQuery extends BaseQuery {

    /**
     * 主键ID
     */
    private Long id;

    /**
     * 订单名
     */
    private String name;

}
