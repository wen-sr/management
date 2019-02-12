package com.management.controller.jc;

import com.management.common.EasyuiTableResponse;
import com.management.common.ServerResponse;
import com.management.pojo.jc.JiaoCaiDistribute;
import com.management.service.jc.IJiaoCaiDistributeService;
import com.management.vo.jc.JiaoCaiDistributeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Author: wen-sir
 * Description:
 * DateCrated: 2019/1/24 14:06
 * Modified By：
 */
@RestController
@RequestMapping("/jc/distribute")
public class JiaoCaiDistributionController {
    @Autowired
    IJiaoCaiDistributeService jiaoCaiDistributeService;

    @RequestMapping("/add")
    public ServerResponse add(JiaoCaiDistribute jiaoCaiDistribute){
        return jiaoCaiDistributeService.add(jiaoCaiDistribute);
    }

    @RequestMapping("/update")
    public ServerResponse update(JiaoCaiDistribute jiaoCaiDistribute){
        return jiaoCaiDistributeService.update(jiaoCaiDistribute);
    }
    @RequestMapping("/delete")
    public ServerResponse delete(JiaoCaiDistribute jiaoCaiDistribute){
        return jiaoCaiDistributeService.delete(jiaoCaiDistribute);
    }

    @RequestMapping("/info")
    public EasyuiTableResponse info(@RequestParam(value = "rows", defaultValue = "10") Integer pageSize,
                                    @RequestParam(value = "page", defaultValue = "1") Integer pageNum,
                                    JiaoCaiDistribute jiaoCaiDistribute){
        ServerResponse response = jiaoCaiDistributeService.getInfo(pageSize, pageNum, jiaoCaiDistribute);
        return response.parseToEasyuiTableResponse(response);
    }

    @RequestMapping("/loadWaitComputeData")
    public EasyuiTableResponse loadWaitComputeData(@RequestParam(value = "rows", defaultValue = "10") Integer pageSize,
                                                   @RequestParam(value = "page", defaultValue = "1") Integer pageNum,
                                                   JiaoCaiDistributeVo jiaoCaiDistributeVo){
        ServerResponse response = jiaoCaiDistributeService.loadWaitComputeData(pageSize, pageNum, jiaoCaiDistributeVo);
        return response.parseToEasyuiTableResponse(response);
    }

    @RequestMapping("/compute")
    public ServerResponse compute(@RequestParam(value = "ids[]") List<Long> ids, @RequestParam(value = "pack") Integer pack, @RequestParam(value = "bundle") Integer bundle){
        return jiaoCaiDistributeService.compute(ids, pack, bundle);
    }

}
