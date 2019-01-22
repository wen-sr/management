package com.management.controller.jc;

import com.management.common.EasyuiTableResponse;
import com.management.common.ServerResponse;
import com.management.pojo.jc.JiaoCaiSku;
import com.management.service.jc.IJiaoCaiSkuService;
import com.management.vo.jc.JiaoCaiSkuVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: wen-sir
 * Description:
 * DateCrated: 2019/1/22 11:13
 * Modified By：
 */
@RestController
@RequestMapping("/jc/sku")
public class JiaoCaiSkuController {

    @Autowired
    IJiaoCaiSkuService jiaoCaiSkuService;

    @RequestMapping("/info")
    public EasyuiTableResponse info(@RequestParam(value = "rows", defaultValue = "10") Integer pageSize,
                                    @RequestParam(value = "page", defaultValue = "1") Integer pageNum,
                                    JiaoCaiSkuVo jiaoCaiSku){
        ServerResponse response = jiaoCaiSkuService.findAll(pageSize, pageNum, jiaoCaiSku);
        return  response.parseToEasyuiTableResponse(response);
    }

    @RequestMapping("/add")
    public ServerResponse add(JiaoCaiSku jiaoCaiSku){
        return  jiaoCaiSkuService.add(jiaoCaiSku);
    }

}
