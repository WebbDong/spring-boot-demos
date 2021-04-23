package com.webbdong.springboot.jpa.entity.any;

import java.util.Date;

/**
 * @author Webb Dong
 * @date 2018-04-23 3:48 PM
 */
public interface VehicleOwner {

    Long getId();

    String getName();

    Date getCreatedTime();

    Date getUpdatedTime();

}
