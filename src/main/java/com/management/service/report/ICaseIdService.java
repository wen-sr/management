package com.management.service.report;

import com.management.common.EasyuiTableResponse;

public interface ICaseIdService {
    EasyuiTableResponse getCaseIdData(String date_begin, String date_end, String type);

}
