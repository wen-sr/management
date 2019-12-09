package com.management.controller.wcs;

import com.management.common.ServerResponse;
import com.management.pojo.wcs.TaskOps;
import com.management.service.wcs.ITaskOpsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/wcs")
public class TaskOpsController {
    @Autowired
    ITaskOpsService taskOpsService;

    @RequestMapping("/queryInfo4")
    @ResponseBody
    public ServerResponse queryInfo4(TaskOps taskOps){

        return taskOpsService.getTaskOpsData(taskOps);
    }
}
