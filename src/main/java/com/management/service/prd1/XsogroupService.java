package com.management.service.prd1;

import com.management.common.ServerResponse;

public interface XsogroupService {
    ServerResponse getReceiptAndDelivery(String begin, String end);

    ServerResponse getYield(String begin, String end);
}
