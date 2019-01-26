package com.management.controller.jc;

import com.management.common.EasyuiTableResponse;
import com.management.common.ServerResponse;
import com.management.pojo.jc.JiaoCaiInventory;
import com.management.pojo.jc.JiaoCaiInventory_detail;
import com.management.service.jc.IJiaoCaiInventoryService;
import com.management.vo.jc.JiaoCaiInventoryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: wen-sir
 * Description:
 * DateCrated: 2019/1/24 18:51
 * Modified By：
 */
@RestController
@RequestMapping("/jc/inventory")
public class JiaoCaiInventoryController {

    @Autowired
    IJiaoCaiInventoryService jiaoCaiInventoryService;

    @RequestMapping("/info")
    public EasyuiTableResponse info(@RequestParam(value = "rows", defaultValue = "10") Integer pageSize,
                                    @RequestParam(value = "page", defaultValue = "1") Integer pageNum,
                                    JiaoCaiInventory jiaoCaiInventory){
        ServerResponse response = jiaoCaiInventoryService.selectInventory(pageSize, pageNum, jiaoCaiInventory);
        return response.parseToEasyuiTableResponse(response);
    }

    @RequestMapping("/infoDetail")
    public EasyuiTableResponse info(@RequestParam(value = "rows", defaultValue = "10") Integer pageSize,
                                    @RequestParam(value = "page", defaultValue = "1") Integer pageNum,
                                    JiaoCaiInventory_detail jiaoCaiInventory_detail){
        ServerResponse response = jiaoCaiInventoryService.selectInventoryDetail(pageSize, pageNum, jiaoCaiInventory_detail);
        return response.parseToEasyuiTableResponse(response);

    }

    @RequestMapping("/move")
    public ServerResponse move(JiaoCaiInventoryVo jiaoCaiInventoryVo){
        return jiaoCaiInventoryService.move(jiaoCaiInventoryVo);
    }


}
