package com.management.service.report;

import com.management.common.EasyuiTableResponse;
import com.management.common.ServerResponse;
import com.management.pojo.report.TaskCase;

public interface ITaskCaseService {
    EasyuiTableResponse getTaskCaseData(String date_begin, String date_end);
    EasyuiTableResponse updateTaskCaseData(TaskCase taskCase);

    ServerResponse updateCaseid(TaskCase taskCase);
}
