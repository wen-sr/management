package com.management.controller.jc;

import com.management.common.EasyuiTableResponse;
import com.management.common.ServerResponse;
import com.management.pojo.jc.JiaoCaiOrders;
import com.management.service.jc.IJiaoCaiOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: wen-sir
 * Description:
 * DateCrated: 2019/1/23 11:46
 * Modified By：
 */
@RestController
@RequestMapping("/jc/orders")
public class JiaoCaiOrdersController {

    @Autowired
    IJiaoCaiOrdersService jiaoCaiOrdersService;

    @RequestMapping("/info")
    public EasyuiTableResponse info (@RequestParam(value = "rows", defaultValue = "10") Integer pageSize,
                                     @RequestParam(value = "page", defaultValue = "1") Integer pageNum,
                                     JiaoCaiOrders jiaoCaiOrders){
        ServerResponse response = jiaoCaiOrdersService.getInfo(pageSize, pageNum, jiaoCaiOrders);
        return response.parseToEasyuiTableResponse(response);
    }

    @RequestMapping("/add")
    public ServerResponse add(JiaoCaiOrders jiaoCaiOrders){
        return jiaoCaiOrdersService.add(jiaoCaiOrders);
    }

    @RequestMapping("/update")
    public ServerResponse update(JiaoCaiOrders jiaoCaiOrders){
        return jiaoCaiOrdersService.update(jiaoCaiOrders);
    }

    @RequestMapping("/delete")
    public ServerResponse delete(JiaoCaiOrders jiaoCaiOrders){
        return jiaoCaiOrdersService.delete(jiaoCaiOrders);
    }


}
