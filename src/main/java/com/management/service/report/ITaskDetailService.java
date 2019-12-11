package com.management.service.report;

import com.management.common.ServerResponse;

public interface ITaskDetailService {
    ServerResponse getQingPeiData(String date_begin, String date_end);
}
