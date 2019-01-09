package com.management.service.prd1;

import com.management.common.EasyuiTableResponse;
import com.management.vo.prd1.TaskViewDto;

public interface ITaskViewService {
    EasyuiTableResponse getData(TaskViewDto taskView);
}
