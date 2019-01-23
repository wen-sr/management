package com.management.controller.jc;

import com.management.common.EasyuiTableResponse;
import com.management.common.ServerResponse;
import com.management.pojo.jc.AllowDistribution;
import com.management.service.jc.IAllowDistributionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: wen-sir
 * Description:
 * DateCrated: 2019/1/23 15:23
 * Modified By：
 */
@RestController
@RequestMapping("/jc/allowDistribution")
public class AllowDistributionController {

    @Autowired
    IAllowDistributionService allowDistributionService;

    @RequestMapping("/info")
    public EasyuiTableResponse info(@RequestParam(value = "rows", defaultValue = "10") Integer pageSize,
                                    @RequestParam(value = "page", defaultValue = "1") Integer pageNum,
                                    AllowDistribution allowDistribution){
        ServerResponse response = allowDistributionService.getInfo(pageSize, pageNum, allowDistribution);
        return response.parseToEasyuiTableResponse(response);
    }

}
