package com.management.service.report;

import com.management.common.ServerResponse;

public interface IBaoZService {
    ServerResponse getBaoZData(String date_begin, String date_end);
}
