package com.management.service.jc.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.management.common.ServerResponse;
import com.management.dao.jc.AllowDistributionMapper;
import com.management.pojo.jc.AllowDistribution;
import com.management.pojo.jc.JiaoCaiOrders;
import com.management.service.jc.IAllowDistributionService;
import com.management.util.DataSourceContextHolder;
import com.management.vo.jc.JiaoCaiOrdersVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author: wen-sir
 * Description:
 * DateCrated: 2019/1/23 15:25
 * Modified By：
 */
@Service
public class AllowDistributionServiceImpl implements IAllowDistributionService {

    @Autowired
    AllowDistributionMapper allowDistributionMapper;

    @Override
    public ServerResponse getInfo(Integer pageSize, Integer pageNum, AllowDistribution allowDistribution) {
        DataSourceContextHolder. setDbType(DataSourceContextHolder.SESSION_FACTORY_XH);

        List<AllowDistribution> allowDistributionList = null;
        PageHelper.startPage(pageNum,pageSize);

        allowDistributionList = allowDistributionMapper.findAll(allowDistribution);

        PageInfo pageInfo = new PageInfo(allowDistributionList);

        return ServerResponse.createBySuccess(pageInfo);
    }
}
