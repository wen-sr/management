package com.management.service.prd1;

import com.management.common.ServerResponse;

public interface ISkuService {
    ServerResponse getSkuByBarcode(String barcode);
}
