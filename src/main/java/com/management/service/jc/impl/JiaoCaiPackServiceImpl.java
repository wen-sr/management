package com.management.service.jc.impl;

import com.management.dao.jc.JiaoCaiStorerMapper;
import com.management.service.jc.IJiaoCaiPackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Author: wen-sir
 * Description:
 * DateCrated: 2019/1/22 12:44
 * Modified By：
 */
@Service
@Transactional
public class JiaoCaiPackServiceImpl implements IJiaoCaiPackService {

    @Autowired
    JiaoCaiStorerMapper jiaoCaiStorerMapper;
}
