package com.management.service.prd1.impl;

import base.BaseJunitTest;
import com.management.service.jc.impl.JiaoCaiDistributeServiceImplTest;
import com.management.service.prd1.ILogisticsQueryService;
import com.management.service.prd1.XsogroupService;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * Author: wen-sir
 * Description:
 * DateCrated: 2019/8/26 15:27
 * Modified By：
 */
public class LogisticsQueryServiceImplTest extends BaseJunitTest {
    private final static Logger logger = LoggerFactory.getLogger(LogisticsQueryServiceImplTest.class);

    @Autowired
    ILogisticsQueryService logisticsQueryService;

    @Test
    public void getZhuPeiGouBao() {

        logisticsQueryService.getZhuPeiGouBao("CGZGSH20190826001320");

    }
}