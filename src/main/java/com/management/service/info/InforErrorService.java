package com.management.service.info;

import com.management.common.ServerResponse;
import com.management.pojo.info.InforError;
import com.management.pojo.info.OnOff;

public interface InforErrorService {
    ServerResponse addInforError(InforError inforError);

    ServerResponse findAll(InforError inforError, Integer pageSize, Integer pageNum, String organizationId);

    ServerResponse edit(InforError inforError);

    ServerResponse delete(InforError inforError);

    ServerResponse getOnOff();

    ServerResponse updateOnOff(OnOff onOff);
}
