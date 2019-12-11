package com.management.controller.report;


import com.management.common.ServerResponse;
import com.management.service.report.IBaoZService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/report")
public class BaoZController {
    @Autowired
    IBaoZService baoZService;
    @RequestMapping("/baoZ")
    @ResponseBody
    public ServerResponse queryInfo(String date_begin, String date_end){
        return baoZService.getBaoZData(date_begin,date_end);
    }
}
