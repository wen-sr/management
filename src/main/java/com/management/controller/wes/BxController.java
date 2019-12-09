package com.management.controller.wes;

import com.management.common.EasyuiTableResponse;
import com.management.service.wes.IBxService;
import com.management.vo.salTbShpcd.BxVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wes")
public class BxController {
    @Autowired
    IBxService bxService;
    @RequestMapping("/bx")
    public EasyuiTableResponse queryInfo(BxVo bxVo){

        return bxService.bx(bxVo);
    }
}
