package com.management.controller.report;

import com.management.common.ServerResponse;
import com.management.service.report.IXiuGWService;
import com.management.vo.xgw.XgwVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/report")
public class XgwController {
    @Autowired
    IXiuGWService xiuGWService;

    @RequestMapping("/xgw")
    @ResponseBody
    public ServerResponse cx(XgwVo xgwVo) {
        return xiuGWService.cx(xgwVo);
    }

    @RequestMapping("/goo")
    @ResponseBody
    public ServerResponse go(XgwVo xgwVo) {
        return xiuGWService.go(xgwVo);
    }
    @RequestMapping("/go1")
    @ResponseBody
    public ServerResponse go1(XgwVo xgwVo) {
        return xiuGWService.go1(xgwVo);
    }
    @RequestMapping("/go2")
    @ResponseBody
    public ServerResponse go2(XgwVo xgwVo) {
        return xiuGWService.go2(xgwVo);
    }
}



