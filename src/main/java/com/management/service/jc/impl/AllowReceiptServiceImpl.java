package com.management.service.jc.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.management.common.ServerResponse;
import com.management.dao.jc.AllowReceiptMapper;
import com.management.pojo.jc.AllowDistribution;
import com.management.pojo.jc.AllowReceipt;
import com.management.service.jc.IAllowReceiptService;
import com.management.util.DataSourceContextHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Author: wen-sir
 * Description:
 * DateCrated: 2019/1/24 19:55
 * Modified By：
 */
@Service
@Transactional
public class AllowReceiptServiceImpl implements IAllowReceiptService {
    @Autowired
    AllowReceiptMapper allowReceiptMapper;

    @Override
    public ServerResponse getInfo(Integer pageSize, Integer pageNum, AllowReceipt allowReceipt) {
        DataSourceContextHolder. setDbType(DataSourceContextHolder.SESSION_FACTORY_WMS);
        List<AllowReceipt> allowReceiptList = null;
        PageHelper.startPage(pageNum,pageSize);

        allowReceiptList = allowReceiptMapper.findAll(allowReceipt);

        PageInfo pageInfo = new PageInfo(allowReceiptList);

        return ServerResponse.createBySuccess(pageInfo);
    }
}
