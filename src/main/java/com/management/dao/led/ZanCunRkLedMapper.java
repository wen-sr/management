package com.management.dao.led;


import com.management.pojo.led.ZanCunRkLed;

public interface ZanCunRkLedMapper {
    Integer insert(ZanCunRkLed record);

    Integer insertSelective(ZanCunRkLed record);

    Integer getTotalToday();

    Integer getComplete();

    Integer getIncomplete();
}