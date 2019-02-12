package com.management.controller.jc;

import com.management.common.EasyuiTableResponse;
import com.management.common.ServerResponse;
import com.management.pojo.jc.JiaoCaiCompute;
import com.management.service.jc.IJiaoCaiComputeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Author: wen-sir
 * Description:
 * DateCrated: 2019/2/12 13:03
 * Modified By：
 */
@RestController
@RequestMapping("/jc/compute")
public class JiaoCaiComputeController {
    @Autowired
    IJiaoCaiComputeService jiaoCaiComputeService;

    @RequestMapping("/info")
    public EasyuiTableResponse info(@RequestParam(value = "rows", defaultValue = "10") Integer pageSize,
                                    @RequestParam(value = "page", defaultValue = "1") Integer pageNum,
                                    JiaoCaiCompute jiaoCaiCompute){
        ServerResponse response = jiaoCaiComputeService.getInfo(pageSize, pageNum, jiaoCaiCompute);
        return response.parseToEasyuiTableResponse(response);
    }

    @RequestMapping("/cancelCompute")
    public ServerResponse cancelCompute(@RequestParam(value = "ids[]") List<Long> ids){
        return jiaoCaiComputeService.cancelCompute(ids);
    }
}
