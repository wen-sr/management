package com.management.controller.prd1;

import com.management.common.EasyuiTableResponse;
import com.management.service.prd1.ITaskViewService;
import com.management.vo.prd1.TaskViewDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskViewController {

    @Autowired
    ITaskViewService taskViewService;

    @RequestMapping(value = "/TaskQuery" , method = RequestMethod.POST)
    public EasyuiTableResponse getData(TaskViewDto taskView){
        EasyuiTableResponse response = taskViewService.getData(taskView);
        return response;
    }
}
