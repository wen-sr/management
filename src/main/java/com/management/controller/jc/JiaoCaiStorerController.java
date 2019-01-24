package com.management.controller.jc;

import com.github.pagehelper.PageInfo;
import com.management.common.EasyuiTableResponse;
import com.management.common.RequestHolder;
import com.management.common.ServerResponse;
import com.management.pojo.jc.JiaoCaiStorer;
import com.management.service.jc.IJiaoCaiStorerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Author: wen-sir
 * Description:
 * DateCrated: 2019/1/22 11:50
 * Modified By：
 */
@RestController
@RequestMapping("/jc/storer")
public class JiaoCaiStorerController {

    private final static Logger logger = LoggerFactory.getLogger(JiaoCaiStorerController.class);

    @Autowired
    IJiaoCaiStorerService jiaoCaiStorerService;

    @RequestMapping("/info")
    public EasyuiTableResponse info(@RequestParam(value = "rows", defaultValue = "10") Integer pageSize,
                                    @RequestParam(value = "page", defaultValue = "1") Integer pageNum,
                                    JiaoCaiStorer jiaoCaiStorer){
        logger.info("*******************" + RequestHolder.getCurrentUser().getId() + "*******************");
        ServerResponse response = jiaoCaiStorerService.getInfo(pageSize, pageNum, jiaoCaiStorer);
        return response.parseToEasyuiTableResponse(response);
    }

    @RequestMapping("/tips")
    public List<JiaoCaiStorer> tips(@RequestParam(value = "rows", defaultValue = "1000000") Integer pageSize,
                                    @RequestParam(value = "page", defaultValue = "1") Integer pageNum,
                                    JiaoCaiStorer jiaoCaiStorer){
        ServerResponse<PageInfo> response = jiaoCaiStorerService.getInfo(pageSize, pageNum, jiaoCaiStorer);
        return response.getData().getList();
    }
}
