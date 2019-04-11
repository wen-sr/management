package com.management.controller.jxlh56;

import com.management.common.EasyuiTableResponse;
import com.management.common.ServerResponse;
import com.management.pojo.jxlh56.News;
import com.management.service.jxlh56.INewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Author: wen-sir
 * Description:
 * DateCrated: 2019/4/4 9:26
 * Modified By：
 */
@RestController
@RequestMapping("/jxlh56/news")
public class NewsController {

    @Autowired
    INewsService newsService;

    @RequestMapping("/queryInfo")
    public EasyuiTableResponse queryInfo(News news) {
        return newsService.queryInfo(news);
    }


    @RequestMapping("/sendToWechat")
    public ServerResponse sendToWechat(@RequestParam(value = "ids[]") List<Integer> ids) {
        return newsService.sendToWechat(ids);
    }
}
