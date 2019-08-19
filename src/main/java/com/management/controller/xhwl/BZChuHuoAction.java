package com.management.controller.xhwl;

import com.management.common.EasyuiTableResponse;
import com.management.common.ServerResponse;
import com.management.pojo.busi.BusiMessageWx;
import com.management.pojo.xhwl.BZChuHuo;
import com.management.service.xhwl.IBZChuHuoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: wen-sir
 * Description:
 * DateCrated: 2019/8/12 10:31
 * Modified By：
 */
@RestController
@RequestMapping("/xhwl/bzch")
public class BZChuHuoAction {

    @Autowired
    IBZChuHuoService bzChuHuoService;

    @RequestMapping("/loadData")
    public EasyuiTableResponse loadData(@RequestParam(value = "rows", defaultValue = "20") Integer pageSize,
                                        @RequestParam(value = "page", defaultValue = "1") Integer pageNum,
                                        BZChuHuo bzChuHuo){
        return bzChuHuoService.loadData(pageSize, pageNum, bzChuHuo);
    }

    @RequestMapping("/addInfo")
    public ServerResponse addInfo(BZChuHuo bzChuHuo) {
        return bzChuHuoService.addInfo(bzChuHuo);
    }

}
