package com.management.dao.led;



import com.management.pojo.led.BaoZhuangLed;

import java.util.List;

public interface BaoZhuangLedMapper {
    int insert(BaoZhuangLed record);

    int insertSelective(BaoZhuangLed record);

    List<BaoZhuangLed> getBaoZhuangLedData();
}