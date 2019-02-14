package com.management.controller.jc;

import com.github.pagehelper.PageInfo;
import com.management.common.EasyuiTableResponse;
import com.management.common.ServerResponse;
import com.management.pojo.jc.JiaoCaiCompute;
import com.management.service.jc.IJiaoCaiComputeService;
import com.management.vo.jc.JiaoCaiComputeVo;
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

    @RequestMapping("/pickInfoTotal")
    public EasyuiTableResponse pickInfoTotal(@RequestParam(value = "rows", defaultValue = "10") Integer pageSize,
                                   @RequestParam(value = "page", defaultValue = "1") Integer pageNum,
                                   JiaoCaiCompute jiaoCaiCompute){
        ServerResponse response = jiaoCaiComputeService.pickInfoTotal(pageSize, pageNum, jiaoCaiCompute);
        return response.parseToEasyuiTableResponse(response);
    }

    @RequestMapping("/pickInfo")
    public EasyuiTableResponse pickInfo(@RequestParam(value = "rows", defaultValue = "10") Integer pageSize,
                                   @RequestParam(value = "page", defaultValue = "1") Integer pageNum,
                                   JiaoCaiCompute jiaoCaiCompute){
        ServerResponse response = jiaoCaiComputeService.pickInfo(pageSize, pageNum, jiaoCaiCompute);
        return response.parseToEasyuiTableResponse(response);
    }

    @RequestMapping("/wholeShipInfoTotal")
    public EasyuiTableResponse wholeShipInfoTotal(@RequestParam(value = "rows", defaultValue = "10") Integer pageSize,
                                                  @RequestParam(value = "page", defaultValue = "1") Integer pageNum,
                                                  JiaoCaiCompute jiaoCaiCompute){
        ServerResponse response = jiaoCaiComputeService.wholeShipInfoTotal(pageSize, pageNum, jiaoCaiCompute);
        return response.parseToEasyuiTableResponse(response);
    }

    @RequestMapping("/wholeShipInfoTotalTips")
    public List<JiaoCaiComputeVo> wholeShipInfoTotalTips(@RequestParam(value = "rows", defaultValue = "10") Integer pageSize,
                                                  @RequestParam(value = "page", defaultValue = "1") Integer pageNum,
                                                  JiaoCaiCompute jiaoCaiCompute){
        ServerResponse<PageInfo> response = jiaoCaiComputeService.wholeShipInfoTotal(pageSize, pageNum, jiaoCaiCompute);
        return response.getData().getList();
    }

    @RequestMapping("/wholeShipInfo")
    public EasyuiTableResponse wholeShipInfo(@RequestParam(value = "rows", defaultValue = "10") Integer pageSize,
                                   @RequestParam(value = "page", defaultValue = "1") Integer pageNum,
                                   JiaoCaiCompute jiaoCaiCompute){
        ServerResponse response = jiaoCaiComputeService.wholeShipInfo(pageSize, pageNum, jiaoCaiCompute);
        return response.parseToEasyuiTableResponse(response);
    }

    @RequestMapping("/wholeShipInfoEnd")
    public EasyuiTableResponse wholeShipInfoEnd(@RequestParam(value = "rows", defaultValue = "10") Integer pageSize,
                                   @RequestParam(value = "page", defaultValue = "1") Integer pageNum,
                                   JiaoCaiCompute jiaoCaiCompute){
        ServerResponse response = jiaoCaiComputeService.wholeShipInfoEnd(pageSize, pageNum, jiaoCaiCompute);
        return response.parseToEasyuiTableResponse(response);
    }

    @RequestMapping("/wholeShipInfoEndTips")
    public List<JiaoCaiComputeVo> wholeShipInfoEndTips(@RequestParam(value = "rows", defaultValue = "10") Integer pageSize,
                                   @RequestParam(value = "page", defaultValue = "1") Integer pageNum,
                                   JiaoCaiCompute jiaoCaiCompute){
        ServerResponse<PageInfo> response = jiaoCaiComputeService.wholeShipInfoEnd(pageSize, pageNum, jiaoCaiCompute);
        return response.getData().getList();
    }

    @RequestMapping("/addBatchno")
    public ServerResponse addBatchno(@RequestParam(value = "ids[]") List<Long> ids){
        return jiaoCaiComputeService.addBatchno(ids);
    }

        @RequestMapping("/cancel")
    public ServerResponse cancel(@RequestParam(value = "ids[]") List<Long> ids){
        return jiaoCaiComputeService.cancel(ids);
    }

    @RequestMapping("/startPick")
    public ServerResponse startPick(@RequestParam(value = "ids[]") List<Long> ids){
        return jiaoCaiComputeService.startPick(ids);
    }

    @RequestMapping("/confirmPick")
    public ServerResponse confirmPick(@RequestParam(value = "ids[]") List<Long> ids){
        return jiaoCaiComputeService.confirmPick(ids);
    }

    @RequestMapping("/oddPackInfo")
    public EasyuiTableResponse oddPackInfo(@RequestParam(value = "rows", defaultValue = "10") Integer pageSize,
                                      @RequestParam(value = "page", defaultValue = "1") Integer pageNum,
                                      JiaoCaiCompute jiaoCaiCompute){
        ServerResponse response = jiaoCaiComputeService.oddPackInfo(pageSize, pageNum, jiaoCaiCompute);
        return response.parseToEasyuiTableResponse(response);
    }

    @RequestMapping("/oddPackTips")
    public List<JiaoCaiComputeVo> oddPackTips(JiaoCaiCompute jiaoCaiCompute){
        return (List<JiaoCaiComputeVo>)jiaoCaiComputeService.oddPackTips(jiaoCaiCompute).getData();
    }


}
