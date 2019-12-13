package com.management.dao.led;


import com.management.pojo.led.ShangJiaRKLed;
import com.management.vo.led.SumAndCount;

public interface ShangJiaRKLedMapper {
    int insert(ShangJiaRKLed record);

    int insertSelective(ShangJiaRKLed record);

    SumAndCount getTotalToday();

    SumAndCount getComplete();

    SumAndCount getIncomplete();

    SumAndCount getTotalTodayCase();

    SumAndCount getCompleteCase();

    SumAndCount getIncompletePK();

    SumAndCount getCompletePK();

    Integer getIncompleteZanCunCK();

    Integer getCompleteZanCunCK();

    SumAndCount getTotalTodayCaseCK();

    SumAndCount getBuHuoData();

    SumAndCount getcompleteBuHuoData();

    SumAndCount getIncompleteBuHuoData();
}