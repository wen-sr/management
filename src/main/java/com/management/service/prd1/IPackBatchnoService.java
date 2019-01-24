package com.management.service.prd1;

import com.management.common.EasyuiTableResponse;
import com.management.common.ServerResponse;

public interface IPackBatchnoService {
    EasyuiTableResponse getData(String dd, String id);

    ServerResponse gouBaoConfirm(String dd, String id);

    ServerResponse getGouBaoData(String dd, String id);
}
