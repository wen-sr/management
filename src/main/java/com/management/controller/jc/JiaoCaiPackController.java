package com.management.controller.jc;

import com.management.common.EasyuiTableResponse;
import com.management.common.ServerResponse;
import com.management.pojo.jc.JiaoCaiPack;
import com.management.service.jc.IJiaoCaiPackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Author: wen-sir
 * Description:
 * DateCrated: 2019/1/22 12:44
 * Modified By：
 */
@RestController
@RequestMapping("/jc/pack")
public class JiaoCaiPackController {

    @Autowired
    IJiaoCaiPackService jiaoCaiPackService;

    @RequestMapping("/info")
    public EasyuiTableResponse info(JiaoCaiPack jiaoCaiPack){
        ServerResponse response = jiaoCaiPackService.findAll(jiaoCaiPack);
        return  response.parseToEasyuiTableCommonResponse(response.getStatus(), response.getData(), response.getMsg(), 0, 0);
    }

    @RequestMapping("/tips")
    public List<JiaoCaiPack> tips(JiaoCaiPack jiaoCaiPack){
        ServerResponse<List> response = jiaoCaiPackService.findAll(jiaoCaiPack);
        return  response.getData();
    }

    @RequestMapping("/add")
    public ServerResponse add(JiaoCaiPack jiaoCaiPack){
        return jiaoCaiPackService.add(jiaoCaiPack);
    }

    @RequestMapping("/delete")
    public ServerResponse delete(JiaoCaiPack jiaoCaiPack){
        return jiaoCaiPackService.delete(jiaoCaiPack);
    }

    @RequestMapping("/update")
    public ServerResponse update(JiaoCaiPack jiaoCaiPack){
        return jiaoCaiPackService.update(jiaoCaiPack);
    }

}
