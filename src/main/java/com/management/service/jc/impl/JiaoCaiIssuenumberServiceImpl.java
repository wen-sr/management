package com.management.service.jc.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.management.common.ServerResponse;
import com.management.dao.jc.JiaoCaiIssuenumberMapper;
import com.management.pojo.jc.JiaoCaiIssuenumber;
import com.management.service.jc.IJiaoCaiIssuenumberService;
import com.management.util.DataSourceContextHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author: wen-sir
 * Description:
 * DateCrated: 2019/1/22 10:04
 * Modified By：
 */
@Service
public class JiaoCaiIssuenumberServiceImpl implements IJiaoCaiIssuenumberService {

    @Autowired
    JiaoCaiIssuenumberMapper jiaoCaiIssuenumberMapper;

    @Override
    public ServerResponse<PageInfo> getInfo(Integer pageSize, Integer pageNum, JiaoCaiIssuenumber jiaoCaiIssuenumber) {
        DataSourceContextHolder. setDbType(DataSourceContextHolder.SESSION_FACTORY_WMS);
        List<JiaoCaiIssuenumber> jiaoCaiIssuenumberList = null;
        PageHelper.startPage(pageNum,pageSize);
        PageHelper.orderBy("id");

        jiaoCaiIssuenumberList = jiaoCaiIssuenumberMapper.findAll(jiaoCaiIssuenumber);

        PageInfo pageInfo = new PageInfo(jiaoCaiIssuenumberList);

        return ServerResponse.createBySuccess(pageInfo);
    }

    @Override
    public ServerResponse add(JiaoCaiIssuenumber jiaoCaiIssuenumber) {
        int i = jiaoCaiIssuenumberMapper.insertSelective(jiaoCaiIssuenumber);
        if(i > 0){
            return ServerResponse.createBySuccessMsg("添加期号成功");
        }else {
            return ServerResponse.createByErrorMessage("添加期号失败，请联系管理员");
        }
    }

    @Override
    public ServerResponse delete(JiaoCaiIssuenumber jiaoCaiIssuenumber) {
        int i = jiaoCaiIssuenumberMapper.deleteByPrimaryKey(jiaoCaiIssuenumber.getId());
        if(i > 0){
            return ServerResponse.createBySuccessMsg("删除期号成功");
        }else {
            return ServerResponse.createByErrorMessage("删除期号失败，请联系管理员");
        }
    }
}
