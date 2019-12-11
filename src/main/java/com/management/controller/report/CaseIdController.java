package com.management.controller.report;


import com.management.common.EasyuiTableResponse;
import com.management.service.report.ICaseIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/report")
public class CaseIdController {
    @Autowired
    ICaseIdService caseIdService;

    @RequestMapping("/queryInfo")
    public EasyuiTableResponse queryInfo(String date_begin, String date_end, String type){

        return caseIdService.getCaseIdData(date_begin,date_end, type);
    }
}
