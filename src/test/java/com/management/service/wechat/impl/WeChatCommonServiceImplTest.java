package com.management.service.wechat.impl;

import base.BaseJunitTest;
import com.management.service.wechat.IWeChatCommonService;
import me.chanjar.weixin.common.error.WxErrorException;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * Author: wen-sir
 * Description:
 * DateCrated: 2019/4/2 15:37
 * Modified By：
 */
public class WeChatCommonServiceImplTest extends BaseJunitTest {

    @Autowired
    IWeChatCommonService weChatCommonService;

    @Test
    public void test1() {
        try {
            weChatCommonService.test();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}