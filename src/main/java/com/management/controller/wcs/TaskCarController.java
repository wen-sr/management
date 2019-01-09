package com.management.controller.wcs;

import com.management.common.ServerResponse;
import com.management.pojo.wcs.TaskCar;
import com.management.service.wcs.ITaskCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wcs/taskCar")
public class TaskCarController {

    @Autowired
    ITaskCarService taskCarService;


    @RequestMapping("/updateStatus")
    public ServerResponse updateStatus(TaskCar taskCar){
        return taskCarService.updateStatus(taskCar);
    }

}
