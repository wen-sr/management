package com.management.dao.led;



import com.management.pojo.led.ZhuPeiLed;
import com.management.pojo.led.ZhuPeiZongBiao;

import java.util.List;

public interface ZhuPeiLedMapper {
    int insert(ZhuPeiLed record);

    int insertSelective(ZhuPeiLed record);

    List<ZhuPeiLed> getZhuPeiLedData();

    List<ZhuPeiZongBiao> getZhuPeiZongBiaoData();
}