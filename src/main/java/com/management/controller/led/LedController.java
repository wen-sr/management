package com.management.controller.led;


import com.management.common.ServerResponse;
import com.management.service.led.BaoZhuangLedService;
import com.management.service.led.ILedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/led")
public class LedController {

    @Autowired
    ILedService ledService;
    @Autowired
    BaoZhuangLedService baoZhuangLedService;

    @RequestMapping("/lushunku")
    @ResponseBody
    public ServerResponse luShunKu(){
        return ledService.getLuShunKuData();
    }

    @RequestMapping(value = {"/baozhuang" }, method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse baozhuang(){
        ServerResponse response = baoZhuangLedService.getBaoZhuangLedData();
        return response;
    }

}
