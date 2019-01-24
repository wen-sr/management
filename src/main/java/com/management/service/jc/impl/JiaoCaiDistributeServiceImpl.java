package com.management.service.jc.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.management.common.Constant;
import com.management.common.RequestHolder;
import com.management.common.ServerResponse;
import com.management.dao.jc.AllowDistributionMapper;
import com.management.dao.jc.JiaoCaiDistributeMapper;
import com.management.dao.jc.JiaoCaiSkuMapper;
import com.management.dao.jc.JiaoCaiStorerMapper;
import com.management.dao.login.LoginMapper;
import com.management.pojo.jc.*;
import com.management.pojo.login.Login;
import com.management.service.jc.IJiaoCaiDistributeService;
import com.management.util.DataSourceContextHolder;
import com.management.util.DateTimeUtil;
import com.management.vo.jc.JiaoCaiDistributeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: wen-sir
 * Description:
 * DateCrated: 2019/1/24 14:08
 * Modified By：
 */
@Service
@Transactional
public class JiaoCaiDistributeServiceImpl implements IJiaoCaiDistributeService {

    @Autowired
    JiaoCaiDistributeMapper jiaoCaiDistributeMapper;

    @Autowired
    AllowDistributionMapper allowDistributionMapper;

    @Autowired
    LoginMapper loginMapper;

    @Autowired
    JiaoCaiSkuMapper jiaoCaiSkuMapper;

    @Autowired
    JiaoCaiStorerMapper jiaoCaiStorerMapper;

    @Override
    public ServerResponse add(JiaoCaiDistribute jiaoCaiDistribute) {
        DataSourceContextHolder. setDbType(DataSourceContextHolder.SESSION_FACTORY_WMS);
        jiaoCaiDistribute.setEditwho(RequestHolder.getCurrentUser().getId());
        jiaoCaiDistribute.setAddwho(RequestHolder.getCurrentUser().getId());
        JiaoCaiStorer jiaoCaiStorer = jiaoCaiStorerMapper.selectByStorerKey(jiaoCaiDistribute.getCode());
        if(jiaoCaiStorer != null){
            jiaoCaiDistribute.setShortname(jiaoCaiStorer.getShortname());
        }
        int i = jiaoCaiDistributeMapper.insertSelective(jiaoCaiDistribute);
        if(i > 0 ){
            AllowDistribution allowDistribution = new AllowDistribution();
            allowDistribution.setIssuenumber(jiaoCaiDistribute.getIssuenumber());
            allowDistribution.setSubcode(jiaoCaiDistribute.getSubcode());
            List<AllowDistribution> allowDistributionList = allowDistributionMapper.findAll(allowDistribution);
            return ServerResponse.createBySuccess("添加成功", allowDistributionList);
        }else {
            return ServerResponse.createByErrorMessage("添加失败，请联系管理员");
        }

    }

    @Override
    public ServerResponse getInfo(Integer pageSize, Integer pageNum, JiaoCaiDistribute jiaoCaiDistribute) {
        DataSourceContextHolder. setDbType(DataSourceContextHolder.SESSION_FACTORY_WMS);

        List<JiaoCaiDistribute> jiaoCaiDistributeList = null;
        PageHelper.startPage(pageNum,pageSize);
        jiaoCaiDistributeList = jiaoCaiDistributeMapper.findAll(jiaoCaiDistribute);
        List<JiaoCaiDistributeVo> jiaoCaiDistributeVoList = parseToJiaoCaiDistributeVo(jiaoCaiDistributeList);

        PageInfo pageInfo = new PageInfo(jiaoCaiDistributeList);
        pageInfo.setList(jiaoCaiDistributeVoList);

        return ServerResponse.createBySuccess(pageInfo);
    }

    @Override
    public ServerResponse delete(JiaoCaiDistribute jiaoCaiDistribute) {
        DataSourceContextHolder. setDbType(DataSourceContextHolder.SESSION_FACTORY_WMS);
        int i = jiaoCaiDistributeMapper.deleteByPrimaryKey(jiaoCaiDistribute.getId());
        if(i > 0 ){
            return ServerResponse.createBySuccessMsg("删除成功");
        }else {
            return ServerResponse.createByErrorMessage("删除失败，请联系管理员");
        }
    }

    @Override
    public ServerResponse update(JiaoCaiDistribute jiaoCaiDistribute) {
        DataSourceContextHolder. setDbType(DataSourceContextHolder.SESSION_FACTORY_WMS);
        JiaoCaiStorer jiaoCaiStorer = jiaoCaiStorerMapper.selectByStorerKey(jiaoCaiDistribute.getCode());
        if(jiaoCaiStorer != null){
            jiaoCaiDistribute.setShortname(jiaoCaiStorer.getShortname());
        }
        int i = jiaoCaiDistributeMapper.updateByPrimaryKeySelective(jiaoCaiDistribute);
        if(i > 0 ){
            return ServerResponse.createBySuccessMsg("修改成功");
        }else {
            return ServerResponse.createByErrorMessage("修改失败，请联系管理员");
        }
    }

    private List<JiaoCaiDistributeVo> parseToJiaoCaiDistributeVo(List<JiaoCaiDistribute> jiaoCaiDistributeList) {
        List<JiaoCaiDistributeVo> jiaoCaiDistributeVoList = new ArrayList<>();
        JiaoCaiDistributeVo jiaoCaiDistributeVo = null;
        for(JiaoCaiDistribute d : jiaoCaiDistributeList) {
            jiaoCaiDistributeVo = new JiaoCaiDistributeVo();
            jiaoCaiDistributeVo.setAdddate(DateTimeUtil.dateToStr(d.getAdddate()));
            DataSourceContextHolder. setDbType(DataSourceContextHolder.SESSION_FACTORY_XH);
            Login user = loginMapper.selectByPrimaryKey(d.getAddwho());
            Login user2 = loginMapper.selectByPrimaryKey(d.getEditwho());
            Login user3 = loginMapper.selectByPrimaryKey(d.getPackwho());
            if(user != null && user.getName() != null){
                jiaoCaiDistributeVo.setAddwho(user.getName());
            }
            if(user3 != null && user3.getName() != null){
                jiaoCaiDistributeVo.setPackwho(user3.getName());
            }
            if(user2 != null && user2.getName() != null){
                jiaoCaiDistributeVo.setEditwho(user2.getName());
            }
            jiaoCaiDistributeVo.setBatchno(d.getBatchno());
            jiaoCaiDistributeVo.setCaseqty(d.getCaseqty());
            jiaoCaiDistributeVo.setCode(d.getCode());
            jiaoCaiDistributeVo.setComputeno(d.getComputeno());
            jiaoCaiDistributeVo.setId(d.getId());
            jiaoCaiDistributeVo.setIssuenumber(d.getIssuenumber());
            jiaoCaiDistributeVo.setOdd(d.getOdd());
            jiaoCaiDistributeVo.setOddpack(d.getOddpack());
            jiaoCaiDistributeVo.setPack(d.getPack());
            jiaoCaiDistributeVo.setPackdate(DateTimeUtil.dateToStr(d.getPackdate()));
            jiaoCaiDistributeVo.setCaseqty(d.getCaseqty());
            jiaoCaiDistributeVo.setPickno(d.getPickno());
            jiaoCaiDistributeVo.setQtyallocated(d.getQtyallocated());
            jiaoCaiDistributeVo.setShipno(d.getShipno());
            jiaoCaiDistributeVo.setShortname(d.getShortname());
            jiaoCaiDistributeVo.setStatus(Constant.JiaoCaiDistributeStatus.codeOf(Integer.parseInt(d.getStatus())).getMsg());
            jiaoCaiDistributeVo.setSubcode(d.getSubcode());
            jiaoCaiDistributeVo.setType(d.getType());

            JiaoCaiSkuKey jiaoCaiSkuKey = new JiaoCaiSkuKey();
            jiaoCaiSkuKey.setIssuenumber(d.getIssuenumber());
            jiaoCaiSkuKey.setSubcode(d.getSubcode());

            DataSourceContextHolder. setDbType(DataSourceContextHolder.SESSION_FACTORY_WMS);
            JiaoCaiSku jiaoCaiSku = jiaoCaiSkuMapper.selectByPrimaryKey(jiaoCaiSkuKey);
            if(jiaoCaiSku != null){
                jiaoCaiDistributeVo.setBarcode(jiaoCaiSku.getBarcode());
                jiaoCaiDistributeVo.setDescr(jiaoCaiSku.getDescr());
                jiaoCaiDistributeVo.setPrice(jiaoCaiSku.getPrice());
                JiaoCaiStorer jiaoCaiStorer = jiaoCaiStorerMapper.selectByStorerKey(jiaoCaiSku.getPublisher());
                if(jiaoCaiStorer != null) {
                    jiaoCaiDistributeVo.setPublisher(jiaoCaiStorer.getShortname());
                    jiaoCaiDistributeVo.setStorerkey(jiaoCaiStorer.getStorerkey());
                }
            }

            jiaoCaiDistributeVoList.add(jiaoCaiDistributeVo);
        }
        return jiaoCaiDistributeVoList;
    }
}
