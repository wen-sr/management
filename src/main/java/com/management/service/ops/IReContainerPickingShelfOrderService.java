package com.management.service.ops;

import com.management.common.EasyuiTableResponse;

public interface IReContainerPickingShelfOrderService {
    EasyuiTableResponse getReContainerPickingShelfOrderData(String date_begin, String date_end);
}
