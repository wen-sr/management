package com.management.controller.jc;

import com.management.service.jc.IJiaoCaiPrintService;
import com.management.vo.jc.JiaoCaiComputeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * Author: wen-sir
 * Description:
 * DateCrated: 2019/2/15 9:25
 * Modified By：
 */
@RestController
@RequestMapping("/jc/print")
public class JiaoCaiPrintController {

    @Autowired
    IJiaoCaiPrintService jiaoCaiPrintService;

    @RequestMapping("/wholeCaseList")
    public Map<String, Object> wholeCaseList(@RequestParam(value = "batchno")String batchno){
        Map<String, Object> response = jiaoCaiPrintService.wholeCaseList(batchno);
        return response;
    }

    @RequestMapping("/allocationList")
    public Map<String, Object> allocationList(@RequestParam(value = "batchno")String batchno){
        Map<String, Object> response = jiaoCaiPrintService.allocationList(batchno);
        return response;
    }

    @RequestMapping("/s_ticketList")
    public Map<String, Object> s_ticketList(@RequestParam(value = "batchno")String batchno){
        Map<String, Object> response = jiaoCaiPrintService.s_ticketList(batchno);
        return response;
    }

    @RequestMapping("/t_ticketList")
    public Map<String, Object> t_ticketList(@RequestParam(value = "batchno")String batchno){
        Map<String, Object> response = jiaoCaiPrintService.s_ticketList(batchno);
        return response;
    }

    @RequestMapping("/pickList")
    public Map<String, Object> pickList(@RequestParam(value = "pickno")String pickno){
        Map<String, Object> response = jiaoCaiPrintService.pickList(pickno);
        return response;
    }
    @RequestMapping("/oddCaseList")
    public Map<String, Object> oddCaseList(@RequestParam(value = "batchno")String batchno){
        Map<String, Object> response = jiaoCaiPrintService.oddCaseList(batchno);
        return response;
    }
    @RequestMapping("/oddTicketList")
    public JiaoCaiComputeVo oddTicketList(@RequestParam(value = "batchno")String batchno){
        JiaoCaiComputeVo response = jiaoCaiPrintService.oddTicketList(batchno);
        return response;
    }

    @RequestMapping("/loadBatchno")
    public List<JiaoCaiComputeVo> loadBatchno(){
        List<JiaoCaiComputeVo> response = jiaoCaiPrintService.loadBatchno();
        return response;
    }

    @RequestMapping("/loadPickno")
    public List<JiaoCaiComputeVo> loadPickno(){
        List<JiaoCaiComputeVo> response = jiaoCaiPrintService.loadPickno();
        return response;
    }



}
