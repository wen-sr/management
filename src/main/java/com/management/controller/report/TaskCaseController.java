package com.management.controller.report;

import com.management.common.EasyuiTableResponse;
import com.management.common.ServerResponse;
import com.management.pojo.report.TaskCase;
import com.management.service.report.ITaskCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/report")
public class TaskCaseController {
    @Autowired
    ITaskCaseService taskCaseService;
    @RequestMapping("/query")
    public EasyuiTableResponse query(String date_begin, String date_end){
        return  taskCaseService.getTaskCaseData(date_begin,date_end);
    }
    @RequestMapping("/update")
    @ResponseBody
    public EasyuiTableResponse update(TaskCase taskCase){
        return  taskCaseService.updateTaskCaseData(taskCase);
    }

    @RequestMapping("/updateCaseid")
    @ResponseBody
    public ServerResponse updateCaseid(TaskCase taskCase){
        return  taskCaseService.updateCaseid(taskCase);
    }
}
