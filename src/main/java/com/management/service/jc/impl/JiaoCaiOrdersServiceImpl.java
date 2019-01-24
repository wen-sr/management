package com.management.service.jc.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.management.common.RequestHolder;
import com.management.common.ServerResponse;
import com.management.dao.jc.JiaoCaiOrdersMapper;
import com.management.dao.jc.JiaoCaiSkuMapper;
import com.management.dao.jc.JiaoCaiStorerMapper;
import com.management.dao.login.LoginMapper;
import com.management.pojo.jc.JiaoCaiOrders;
import com.management.pojo.jc.JiaoCaiSku;
import com.management.pojo.jc.JiaoCaiSkuKey;
import com.management.pojo.jc.JiaoCaiStorer;
import com.management.pojo.login.Login;
import com.management.service.jc.IJiaoCaiOrdersService;
import com.management.util.DataSourceContextHolder;
import com.management.util.DateTimeUtil;
import com.management.vo.jc.JiaoCaiOrdersVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: wen-sir
 * Description:
 * DateCrated: 2019/1/23 11:47
 * Modified By：
 */
@Service
@Transactional
public class JiaoCaiOrdersServiceImpl implements IJiaoCaiOrdersService {

    @Autowired
    JiaoCaiOrdersMapper jiaoCaiOrdersMapper;

    @Autowired
    LoginMapper loginMapper;

    @Autowired
    JiaoCaiSkuMapper jiaoCaiSkuMapper;

    @Autowired
    JiaoCaiStorerMapper jiaoCaiStorerMapper;


    @Override
    public ServerResponse getInfo(Integer pageSize, Integer pageNum, JiaoCaiOrders jiaoCaiOrders) {
        DataSourceContextHolder. setDbType(DataSourceContextHolder.SESSION_FACTORY_WMS);

        List<JiaoCaiOrders> jiaoCaiOrdersList = null;
        PageHelper.startPage(pageNum,pageSize);

        jiaoCaiOrdersList = jiaoCaiOrdersMapper.findAll(jiaoCaiOrders);
        List<JiaoCaiOrdersVo> jiaoCaiOrdersVoList = parseToJiaoCaiOrdersVo(jiaoCaiOrdersList);

        PageInfo pageInfo = new PageInfo(jiaoCaiOrdersList);
        pageInfo.setList(jiaoCaiOrdersVoList);

        return ServerResponse.createBySuccess(pageInfo);
    }

    @Override
    public ServerResponse add(JiaoCaiOrders jiaoCaiOrders) {
        DataSourceContextHolder. setDbType(DataSourceContextHolder.SESSION_FACTORY_WMS);
        jiaoCaiOrders.setAddwho(RequestHolder.getCurrentUser().getId());
        jiaoCaiOrders.setEditwho(RequestHolder.getCurrentUser().getId());
        int i = jiaoCaiOrdersMapper.insertSelective(jiaoCaiOrders);
        if(i > 0 ){
            return ServerResponse.createBySuccessMsg("添加信息成功");
        }else {
            return ServerResponse.createByErrorMessage("添加信息失败");
        }
    }

    @Override
    public ServerResponse update(JiaoCaiOrders jiaoCaiOrders) {
        DataSourceContextHolder. setDbType(DataSourceContextHolder.SESSION_FACTORY_WMS);
        jiaoCaiOrders.setEditwho(RequestHolder.getCurrentUser().getId());
        int i = jiaoCaiOrdersMapper.updateByPrimaryKeySelective(jiaoCaiOrders);
        if(i > 0 ){
            return ServerResponse.createBySuccessMsg("修改信息成功");
        }else {
            return ServerResponse.createByErrorMessage("修改信息失败");
        }
    }

    @Override
    public ServerResponse delete(JiaoCaiOrders jiaoCaiOrders) {
        DataSourceContextHolder. setDbType(DataSourceContextHolder.SESSION_FACTORY_WMS);
        int i = jiaoCaiOrdersMapper.deleteByPrimaryKey(jiaoCaiOrders.getId());
        if(i > 0 ){
            return ServerResponse.createBySuccessMsg("删除信息成功");
        }else {
            return ServerResponse.createByErrorMessage("删除信息失败");
        }
    }


    private List<JiaoCaiOrdersVo> parseToJiaoCaiOrdersVo(List<JiaoCaiOrders> jiaoCaiOrdersList) {
        List<JiaoCaiOrdersVo> jiaoCaiOrdersVoList = new ArrayList<>();
        JiaoCaiOrdersVo jiaoCaiOrdersVo = null;
        for(JiaoCaiOrders j : jiaoCaiOrdersList){
            jiaoCaiOrdersVo = new JiaoCaiOrdersVo();
            jiaoCaiOrdersVo.setAdddate(DateTimeUtil.dateToStr(j.getAdddate()));
            DataSourceContextHolder. setDbType(DataSourceContextHolder.SESSION_FACTORY_XH);
            Login user = loginMapper.selectByPrimaryKey(j.getAddwho());
            Login user2 = loginMapper.selectByPrimaryKey(j.getEditwho());
            if(user != null) {
                jiaoCaiOrdersVo.setAddwho(user.getName());
            }
            if(user2 != null){
                jiaoCaiOrdersVo.setEditwho(user2.getName());
            }

            JiaoCaiSkuKey jiaoCaiSkuKey = new JiaoCaiSkuKey();
            jiaoCaiSkuKey.setIssuenumber(j.getIssuenumber());
            jiaoCaiSkuKey.setSubcode(j.getSubcode());
            DataSourceContextHolder. setDbType(DataSourceContextHolder.SESSION_FACTORY_WMS);
            JiaoCaiSku jiaoCaiSku = jiaoCaiSkuMapper.selectByPrimaryKey(jiaoCaiSkuKey);
            if(jiaoCaiSku != null){
                jiaoCaiOrdersVo.setBarcode(jiaoCaiSku.getBarcode());
                jiaoCaiOrdersVo.setDescr(jiaoCaiSku.getDescr());
                jiaoCaiOrdersVo.setPrice(jiaoCaiSku.getPrice());
                JiaoCaiStorer jiaoCaiStorer = jiaoCaiStorerMapper.selectByStorerKey(jiaoCaiSku.getPublisher());
                if(jiaoCaiStorer != null) {
                    jiaoCaiOrdersVo.setPublisher(jiaoCaiStorer.getStorerkey());
                    jiaoCaiOrdersVo.setShortname(jiaoCaiStorer.getShortname());
                }
            }
            jiaoCaiOrdersVo.setId(j.getId());
            jiaoCaiOrdersVo.setIssuenumber(j.getIssuenumber());
            jiaoCaiOrdersVo.setOrderNumber(j.getOrdernumber());
            jiaoCaiOrdersVo.setOrderqty(j.getOrderqty());
            jiaoCaiOrdersVo.setSubcode(j.getSubcode());
            jiaoCaiOrdersVoList.add(jiaoCaiOrdersVo);
        }
        return jiaoCaiOrdersVoList;
    }
}
