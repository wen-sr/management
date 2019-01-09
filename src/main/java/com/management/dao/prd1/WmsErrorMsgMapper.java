package com.management.dao.prd1;

import com.management.pojo.prd1.WmsErrorMsg;

import java.util.List;

public interface WmsErrorMsgMapper {
    int insert(WmsErrorMsg record);

    int insertSelective(WmsErrorMsg record);

    List<WmsErrorMsg> selectAll();

    int updateFlage(WmsErrorMsg wmsErrorMsg);
}