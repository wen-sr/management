package com.management.controller.busi;

import com.management.common.EasyuiTableResponse;
import com.management.common.ServerResponse;
import com.management.pojo.busi.BusiMessageWx;
import com.management.service.busi.IBusiMessageWxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: wen-sir
 * Description:
 * DateCrated: 2019/4/15 13:11
 * Modified By：
 */
@RestController
@RequestMapping("/busi/busiMessageWx")
public class BusiMessageWxController {

    @Autowired
    IBusiMessageWxService busiMessageWxService;


    @RequestMapping("/queryInfo")
    public EasyuiTableResponse queryInfo(@RequestParam(value = "rows", defaultValue = "10") Integer pageSize,
                                         @RequestParam(value = "page", defaultValue = "1") Integer pageNum,
                                         BusiMessageWx busiMessageWx) {
       ServerResponse response = busiMessageWxService.queryInfo(pageSize, pageNum, busiMessageWx);
       return response.parseToEasyuiTableResponse(response);
    }

    @RequestMapping("/queryInfo2")
    public ServerResponse queryInfo2(BusiMessageWx busiMessageWx) {
       return busiMessageWxService.queryInfo2(busiMessageWx);
    }

    @RequestMapping("/addInfo")
    public ServerResponse addInfo(BusiMessageWx busiMessageWx) {
        return busiMessageWxService.addInfo(busiMessageWx);
    }
}
