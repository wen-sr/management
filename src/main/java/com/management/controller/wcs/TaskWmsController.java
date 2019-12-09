package com.management.controller.wcs;


import com.management.common.ServerResponse;
import com.management.pojo.wcs.TaskWms;
import com.management.service.wcs.ITaskWmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/wcs")
public class TaskWmsController {
    @Autowired
    ITaskWmsService taskWmsService;
    @RequestMapping("/queryInfo5")
    @ResponseBody
    public ServerResponse queryInfo5(TaskWms taskWms){

        return taskWmsService.getTaskWmsData(taskWms);
    }
}
