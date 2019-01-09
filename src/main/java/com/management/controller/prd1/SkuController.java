package com.management.controller.prd1;

import com.management.common.ServerResponse;
import com.management.service.prd1.ISkuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/sku")
public class SkuController {

    @Autowired
    ISkuService skuService;

    @RequestMapping("/getSkuByBarcode")
    @ResponseBody
    public ServerResponse getSkuByBarcode(String barcode){
        if(barcode == ""){
            return ServerResponse.createByErrorMessage("条码空");
        }

        return skuService.getSkuByBarcode(barcode);
    }
}
