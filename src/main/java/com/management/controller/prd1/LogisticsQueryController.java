package com.management.controller.prd1;

import com.management.common.ServerResponse;
import com.management.service.prd1.ILogisticsQueryService;
import com.management.vo.prd1.DeliveryVo;
import com.management.vo.prd1.LogisticsQueryVo;
import com.management.vo.prd1.ReceiptVo;
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


    @RequestMapping(value = "/receiptQuery", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public ServerResponse receiptQuery(ReceiptVo receiptVo) {
        return logisticsQueryService.receiptQuery(receiptVo);
    }

    @RequestMapping(value = "/registerDetail", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public ServerResponse registerDetail(ReceiptVo receiptVo) {
        return logisticsQueryService.registerDetail(receiptVo);
    }

    @RequestMapping(value = "/differenceDetail", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public ServerResponse differenceDetail(ReceiptVo receiptVo) {
        return logisticsQueryService.differenceDetail(receiptVo);
    }

    @RequestMapping(value = "/rejectDetail", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public ServerResponse rejectDetail(ReceiptVo receiptVo) {
        return logisticsQueryService.rejectDetail(receiptVo);
    }

    @RequestMapping(value = "/deliveryQuery", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public ServerResponse deliveryQuery(DeliveryVo deliveryVo) {
        return logisticsQueryService.deliveryQuery(deliveryVo);
    }
    @RequestMapping(value = "/orderCaseQuery", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public ServerResponse orderCaseQuery(DeliveryVo deliveryVo) {
        return logisticsQueryService.orderCaseQuery(deliveryVo);
    }
    @RequestMapping(value = "/caseidQuery", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public ServerResponse caseidQuery(DeliveryVo deliveryVo) {
        return logisticsQueryService.caseidQuery(deliveryVo);
    }


}
