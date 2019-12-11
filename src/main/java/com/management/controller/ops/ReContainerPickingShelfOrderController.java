package com.management.controller.ops;


import com.management.common.EasyuiTableResponse;
import com.management.service.ops.IReContainerPickingShelfOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ops")
public class ReContainerPickingShelfOrderController {
    @Autowired
    IReContainerPickingShelfOrderService reContainerPickingShelfOrderService;

    @RequestMapping("/queryInfo")
    public EasyuiTableResponse queryInfo(String date_begin, String date_end){
        return  reContainerPickingShelfOrderService.getReContainerPickingShelfOrderData(date_begin,date_end);
    }

}
