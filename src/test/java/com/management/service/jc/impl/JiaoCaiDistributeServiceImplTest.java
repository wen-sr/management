package com.management.service.jc.impl;

import base.BaseJunitTest;
import com.management.dao.jc.JiaoCaiComputeMapper;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Author: wen-sir
 * Description:
 * DateCrated: 2019/2/12 9:30
 * Modified By：
 */
public class JiaoCaiDistributeServiceImplTest extends BaseJunitTest {
    private final static Logger logger = LoggerFactory.getLogger(JiaoCaiDistributeServiceImplTest.class);
    @Autowired
    JiaoCaiComputeMapper jiaoCaiComputeMapper;

    @Autowired
    JiaoCaiDistributeServiceImpl jiaoCaiDistributeService;

    @Test
    public void getComputeNo() {
        int bundle = 1,pack = 10,qty = 11;
        int caseQty = qty / (bundle * pack);
        int odd = ((qty%(bundle*pack))%pack);
        int oddpack= (qty%(bundle*pack))/pack;
        logger.info("caseQty=" + caseQty + ",odd=" + odd + ",oddpack=" +  oddpack);
    }

}