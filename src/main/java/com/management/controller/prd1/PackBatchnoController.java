package com.management.controller.prd1;

import com.management.common.EasyuiTableResponse;
import com.management.service.prd1.IPackBatchnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PackBatchnoController {

    @Autowired
    IPackBatchnoService packBatchnoService;

    @RequestMapping("/packBatchno")
    public EasyuiTableResponse getData(String dd, String id){
        EasyuiTableResponse response = packBatchnoService.getData(dd,id);
        return response;
    }
}
