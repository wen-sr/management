package com.management.controller.wcs;

import com.management.common.ServerResponse;
import com.management.service.wcs.IConfigWcsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wcs/config")
public class ConfigWcsController {

    @Autowired
    IConfigWcsService configWcsService;

    @RequestMapping("/select")
    public ServerResponse selectWcsController(String key){
        return configWcsService.selectConfigWcs(key);
    }

    @RequestMapping("/update")
    public ServerResponse updateConfigWcs(String key, String value){
        return configWcsService.updateConfigWcs(key, value);
    }
}
