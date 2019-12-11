package com.management.controller.report;

import com.management.common.ServerResponse;
import com.management.service.report.ITaskDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/report")
public class TaskDetailController {
    @Autowired
    ITaskDetailService taskDetailService;

    @RequestMapping("/qingPei")
    @ResponseBody
    public ServerResponse queryInfo(String date_begin, String date_end){
        return taskDetailService.getQingPeiData(date_begin,date_end);
    }
}
