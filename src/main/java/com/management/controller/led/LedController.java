package com.management.controller.led;


import com.management.common.ServerResponse;
import com.management.service.led.ILedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/led")
public class LedController {

    @Autowired
    ILedService ledService;

    @RequestMapping("/lushunku")
    @ResponseBody
    public ServerResponse luShunKu(){
        return ledService.getLuShunKuData();
    }

}
