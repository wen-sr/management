package com.management.service.prd1;

import com.management.pojo.prd1.WmsErrorMsg;

import java.util.List;

public interface IWmsErrorMsgService {
    List<WmsErrorMsg> selectAll();

    void updateFlage(WmsErrorMsg wmsErrorMsg);
}
