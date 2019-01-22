package com.management.controller.jc;

import com.github.pagehelper.PageInfo;
import com.management.common.EasyuiTableResponse;
import com.management.common.ServerResponse;
import com.management.pojo.jc.JiaoCaiIssuenumber;
import com.management.service.jc.IJiaoCaiIssuenumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Author: wen-sir
 * Description:
 * DateCrated: 2019/1/22 10:00
 * Modified By：
 */
@RestController
@RequestMapping("/jc/issuenumber")
public class JiaoCaiIssuenumberController {

    @Autowired
    IJiaoCaiIssuenumberService jiaoCaiIssuenumberService;

    @RequestMapping("/info")
    public EasyuiTableResponse info(@RequestParam(value = "rows", defaultValue = "10") Integer pageSize,
                                    @RequestParam(value = "page", defaultValue = "1") Integer pageNum,
                                    JiaoCaiIssuenumber jiaoCaiIssuenumber){
        ServerResponse response = jiaoCaiIssuenumberService.getInfo(pageSize, pageNum, jiaoCaiIssuenumber);
        return response.parseToEasyuiTableResponse(response);
    }

    @RequestMapping("/tips")
    public List<JiaoCaiIssuenumber> tips(@RequestParam(value = "rows", defaultValue = "100000") Integer pageSize,
                                         @RequestParam(value = "page", defaultValue = "1") Integer pageNum,
                                         JiaoCaiIssuenumber jiaoCaiIssuenumber){
        ServerResponse<PageInfo> response = jiaoCaiIssuenumberService.getInfo(pageSize, pageNum, jiaoCaiIssuenumber);
        return response.getData().getList();
    }

    @RequestMapping("/add")
    public ServerResponse add(JiaoCaiIssuenumber jiaoCaiIssuenumber){
        return jiaoCaiIssuenumberService.add(jiaoCaiIssuenumber);
    }

    @RequestMapping("/delete")
    public ServerResponse delete(JiaoCaiIssuenumber jiaoCaiIssuenumber){
        return jiaoCaiIssuenumberService.delete(jiaoCaiIssuenumber);
    }


}
