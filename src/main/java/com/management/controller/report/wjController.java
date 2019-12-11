package com.management.controller.report;

import com.management.common.EasyuiTableResponse;
import com.management.service.report.IWjService;
import com.management.vo.lipsJobsXso.WjVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/report")
public class wjController {
    @Autowired
    IWjService wjService;

    @RequestMapping("/wj")
    public EasyuiTableResponse queryInfo(WjVo wjVo){

        return wjService.wj(wjVo);
    }
}
