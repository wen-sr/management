package com.management.dao.led;



import com.management.pojo.led.PickLed;

import java.util.List;

public interface PickLedMapper {
    int insert(PickLed record);

    int insertSelective(PickLed record);

    List<PickLed> getPickLedData();
}