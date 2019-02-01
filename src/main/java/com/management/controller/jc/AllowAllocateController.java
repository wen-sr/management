package com.management.controller.jc;

import com.management.common.EasyuiTableResponse;
import com.management.common.ServerResponse;
import com.management.pojo.jc.AllowAllocate;
import com.management.service.jc.IAllowAllocateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: wen-sir
 * Description:
 * DateCrated: 2019/1/30 12:35
 * Modified By：
 */
@RestController
@RequestMapping("/jc/allowAllocate")
public class AllowAllocateController {

    @Autowired
    IAllowAllocateService allowAllocateService;

    @RequestMapping("/info")
    public EasyuiTableResponse info(@RequestParam(value = "rows", defaultValue = "10") Integer pageSize,
                                    @RequestParam(value = "page", defaultValue = "1") Integer pageNum,
                                    AllowAllocate allowAllocate){
        ServerResponse response = allowAllocateService.getInfo(pageSize, pageNum, allowAllocate);
        return response.parseToEasyuiTableResponse(response);
    }
}
