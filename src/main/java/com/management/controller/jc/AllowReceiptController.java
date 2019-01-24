package com.management.controller.jc;

import com.management.common.EasyuiTableResponse;
import com.management.common.ServerResponse;
import com.management.pojo.jc.AllowReceipt;
import com.management.service.jc.IAllowReceiptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: wen-sir
 * Description:
 * DateCrated: 2019/1/24 19:53
 * Modified By：
 */
@RestController
@RequestMapping("/jc/allowReceipt")
public class AllowReceiptController {

    @Autowired
    IAllowReceiptService allowReceiptService;

    @RequestMapping("/info")
    public EasyuiTableResponse info(@RequestParam(value = "rows", defaultValue = "10") Integer pageSize,
                                    @RequestParam(value = "page", defaultValue = "1") Integer pageNum,
                                    AllowReceipt allowReceipt){
        ServerResponse response = allowReceiptService.getInfo(pageSize, pageNum, allowReceipt);
        return response.parseToEasyuiTableResponse(response);
    }

}
