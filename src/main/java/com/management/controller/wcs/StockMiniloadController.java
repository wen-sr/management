package com.management.controller.wcs;


import com.management.common.ServerResponse;
import com.management.pojo.wcs.StockMiniload;
import com.management.service.wcs.IStockMiniloadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/wcs")
public class StockMiniloadController {
    @Autowired
    IStockMiniloadService StockMiniloadService;

    @RequestMapping("/queryInfo")
    @ResponseBody
    public ServerResponse queryInfo(StockMiniload stockMiniload){
        return StockMiniloadService.getStockMiniloadData(stockMiniload);
    }
    @RequestMapping("/queryInfo1")
    @ResponseBody
    public ServerResponse queryInfo1(StockMiniload stockMiniload){
        return StockMiniloadService.getStockMiniloadData1(stockMiniload);
    }
    @RequestMapping("/queryInfo2")
    @ResponseBody
    public ServerResponse queryInfo2(@RequestParam(value = "ids[]") List<Long> ids){
        return StockMiniloadService.getStockMiniloadData2(ids);
    }
    @RequestMapping("/queryInfo3")
    @ResponseBody
    //因为复选框的值是多个,因此用数组来接收
    public ServerResponse queryInfo3(@RequestParam(value = "ids1[]") List<Long> ids1){
        return StockMiniloadService.getStockMiniloadData3(ids1);
    }
}
