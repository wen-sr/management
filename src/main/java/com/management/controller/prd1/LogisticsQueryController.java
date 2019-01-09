package com.management.controller.prd1;

import com.management.common.ServerResponse;
import com.management.service.prd1.ILogisticsQueryService;
import com.management.vo.prd1.LogisticsQueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/logisticsQuery")
public class LogisticsQueryController {

    @Autowired
    ILogisticsQueryService logisticsQueryService;

    @RequestMapping(value = "/bookShipQuery", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public ServerResponse bookShipQuery(LogisticsQueryVo logisticsQueryVo) {
        ServerResponse response = logisticsQueryService.bookShipQuery(logisticsQueryVo);
        return response;
    }
}
