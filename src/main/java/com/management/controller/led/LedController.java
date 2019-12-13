package com.management.controller.led;


import com.management.common.ServerResponse;
import com.management.service.led.BaoZhuangLedService;
import com.management.service.led.ILedService;
import com.management.service.led.ZanCunRKLedService;
import com.management.service.led.ZhuPeiLedService;
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
    @Autowired
    ZhuPeiLedService zhuPeiLedService;
    @Autowired
    ZanCunRKLedService zanCunRKLedService;


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
    @RequestMapping(value = {"/zhupei" }, method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse zhupei(){
        ServerResponse response = zhuPeiLedService.getZhuPeiLedData();
        return response;
    }
    @RequestMapping(value = {"/tuopan4" }, method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse tuopan4(){
        ServerResponse response = zanCunRKLedService.getTuoPan4LedData();
        return response;
    }

}
