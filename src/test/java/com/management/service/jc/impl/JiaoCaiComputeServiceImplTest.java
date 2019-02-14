package com.management.service.jc.impl;

import base.BaseJunitTest;
import com.management.dao.jc.JiaoCaiComputeMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Author: wen-sir
 * Description:
 * DateCrated: 2019/2/14 14:29
 * Modified By：
 */
public class JiaoCaiComputeServiceImplTest extends BaseJunitTest {
    private final static Logger logger = LoggerFactory.getLogger(JiaoCaiDistributeServiceImplTest.class);
    @Autowired
    JiaoCaiComputeMapper jiaoCaiComputeMapper;

    @Autowired
    JiaoCaiComputeServiceImpl jiaoCaiComputeService;

    //@Test
    //public void getPickno() {
    //    String pickno = jiaoCaiComputeService.getPickNo();
    //    logger.info(pickno);
    //}
}