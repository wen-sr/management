package com.management.controller.jc;

import com.management.common.EasyuiTableResponse;
import com.management.common.ServerResponse;
import com.management.pojo.jc.JiaoCaiReceipt;
import com.management.service.jc.IJiaoCaiReceiptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: wen-sir
 * Description:
 * DateCrated: 2019/1/24 17:46
 * Modified By：
 */
@RestController
@RequestMapping("/jc/receipt")
public class JiaoCaiReceiptController {
    @Autowired
    IJiaoCaiReceiptService jiaoCaiReceiptService;

    @RequestMapping("/info")
    public EasyuiTableResponse info(@RequestParam(value = "rows", defaultValue = "10") Integer pageSize,
                                    @RequestParam(value = "page", defaultValue = "1") Integer pageNum,
                                    JiaoCaiReceipt jiaoCaiReceipt) {
        ServerResponse response = jiaoCaiReceiptService.getInfo(pageSize, pageNum, jiaoCaiReceipt);
        return response.parseToEasyuiTableResponse(response);
    }

    @RequestMapping("/add")
    public ServerResponse add(JiaoCaiReceipt jiaoCaiReceipt){
        return jiaoCaiReceiptService.add(jiaoCaiReceipt);
    }

    @RequestMapping("/update")
    public ServerResponse update(JiaoCaiReceipt jiaoCaiReceipt){
        return jiaoCaiReceiptService.update(jiaoCaiReceipt);
    }
    @RequestMapping("/delete")
    public ServerResponse delete(JiaoCaiReceipt jiaoCaiReceipt){
        return jiaoCaiReceiptService.delete(jiaoCaiReceipt);
    }

}
