package com.management.service.jc.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.management.common.ServerResponse;
import com.management.dao.jc.JiaoCaiInventoryMapper;
import com.management.dao.jc.JiaoCaiInventory_detailMapper;
import com.management.dao.jc.JiaoCaiSkuMapper;
import com.management.dao.jc.JiaoCaiStorerMapper;
import com.management.dao.login.LoginMapper;
import com.management.pojo.jc.*;
import com.management.service.jc.IJiaoCaiInventoryService;
import com.management.util.DataSourceContextHolder;
import com.management.vo.jc.JiaoCaiInventoryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: wen-sir
 * Description:
 * DateCrated: 2019/1/24 18:53
 * Modified By：
 */
@Service
@Transactional(value = "transactionManager_wms",readOnly = false)
public class JiaoCaiInventoryServiceImpl implements IJiaoCaiInventoryService {

    @Autowired
    JiaoCaiInventoryMapper jiaoCaiInventoryMapper;

    @Autowired
    JiaoCaiInventory_detailMapper jiaoCaiInventoryDetailMapper;

    @Autowired
    LoginMapper loginMapper;

    @Autowired
    JiaoCaiSkuMapper jiaoCaiSkuMapper;

    @Autowired
    JiaoCaiStorerMapper jiaoCaiStorerMapper;

    @Override
    public int add(JiaoCaiInventory jiaoCaiInventory, JiaoCaiInventory_detail jiaoCaiInventory_detail) {
        DataSourceContextHolder. setDbType(DataSourceContextHolder.SESSION_FACTORY_WMS);
        int i = 0,j = 0;
        if(isExistInventory(jiaoCaiInventory)){
            i += jiaoCaiInventoryMapper.addInventory(jiaoCaiInventory);
        }else {
            i += jiaoCaiInventoryMapper.insertSelective(jiaoCaiInventory);
        }

        jiaoCaiInventory_detail.setLoc("STAGE");
        if(isExistInventoryDetail(jiaoCaiInventory_detail)){
            j += jiaoCaiInventoryDetailMapper.addInventoryDetail(jiaoCaiInventory_detail);
        }else {
            j += jiaoCaiInventoryDetailMapper.insertSelective(jiaoCaiInventory_detail);
        }

        return i + j;
    }

    @Override
    public ServerResponse<PageInfo> selectInventoryDetail(Integer pageSize, Integer pageNum,JiaoCaiInventory_detail jiaoCaiInventory_detail) {
        DataSourceContextHolder. setDbType(DataSourceContextHolder.SESSION_FACTORY_WMS);
        PageHelper.startPage(pageNum,pageSize);
        List<JiaoCaiInventory_detail> jiaoCaiInventoryDetailList = jiaoCaiInventoryDetailMapper.selectAll(jiaoCaiInventory_detail);
        List<JiaoCaiInventoryVo> jiaoCaiInventoryVoList = parseToJiaoCaiInventoryVo2(jiaoCaiInventoryDetailList);
        PageInfo pageInfo = new PageInfo(jiaoCaiInventoryDetailList);
        pageInfo.setList(jiaoCaiInventoryVoList);
        return ServerResponse.createBySuccess(pageInfo);
    }


    private boolean isExistInventory(JiaoCaiInventory jiaoCaiInventory){
        DataSourceContextHolder. setDbType(DataSourceContextHolder.SESSION_FACTORY_WMS);
        JiaoCaiInventory j = jiaoCaiInventoryMapper.selectByIssuenumberAndSubcode(jiaoCaiInventory);
        if(j != null){
            return true;
        }
        return false;
    }

    private boolean isExistInventoryDetail(JiaoCaiInventory_detail jiaoCaiInventory_detail){
        DataSourceContextHolder. setDbType(DataSourceContextHolder.SESSION_FACTORY_WMS);
        JiaoCaiInventory_detail j = jiaoCaiInventoryDetailMapper.selectByIssuenumberAndSubcodeAndPack(jiaoCaiInventory_detail);
        if(j != null){
            return true;
        }
        return false;

    }

    private List<JiaoCaiInventoryVo> parseToJiaoCaiInventoryVo2(List<JiaoCaiInventory_detail> jiaoCaiInventoryDetailList){
        List<JiaoCaiInventoryVo> jiaoCaiInventoryVoList = new ArrayList<>();
        JiaoCaiInventoryVo jiaoCaiInventoryVo = null;
        for(JiaoCaiInventory_detail d : jiaoCaiInventoryDetailList){
            jiaoCaiInventoryVo = new JiaoCaiInventoryVo();

            JiaoCaiSkuKey jiaoCaiSkuKey = new JiaoCaiSkuKey();
            jiaoCaiSkuKey.setIssuenumber(d.getIssuenumber());
            jiaoCaiSkuKey.setSubcode(d.getSubcode());
            DataSourceContextHolder. setDbType(DataSourceContextHolder.SESSION_FACTORY_WMS);
            JiaoCaiSku jiaoCaiSku = jiaoCaiSkuMapper.selectByPrimaryKey(jiaoCaiSkuKey);
            if(jiaoCaiSku != null){
                jiaoCaiInventoryVo.setBarcode(jiaoCaiSku.getBarcode());
                jiaoCaiInventoryVo.setDescr(jiaoCaiSku.getDescr());
                jiaoCaiInventoryVo.setPrice(jiaoCaiSku.getPrice());
                JiaoCaiStorer jiaoCaiStorer = jiaoCaiStorerMapper.selectByStorerKey(jiaoCaiSku.getPublisher());
                if(jiaoCaiStorer != null) {
                    jiaoCaiInventoryVo.setPublisher(jiaoCaiStorer.getShortname());
                    jiaoCaiInventoryVo.setStorerkey(jiaoCaiStorer.getStorerkey());
                }
            }
            jiaoCaiInventoryVo.setBk1(d.getBk1());
            jiaoCaiInventoryVo.setBk2(d.getBk2());
            jiaoCaiInventoryVo.setBk3(d.getBk3());
            jiaoCaiInventoryVo.setBk4(d.getBk4());
            jiaoCaiInventoryVo.setBk5(d.getBk5());
            jiaoCaiInventoryVo.setId(d.getId());
            jiaoCaiInventoryVo.setIssuenumber(d.getIssuenumber());
            jiaoCaiInventoryVo.setLoc(d.getLoc());
            jiaoCaiInventoryVo.setPack(d.getPack());
            jiaoCaiInventoryVo.setQtyallocated(d.getQtyallocated());
            jiaoCaiInventoryVo.setQtyfree(d.getQtyfree());
            jiaoCaiInventoryVo.setQtyreceipt(d.getQtyreceipt());
            jiaoCaiInventoryVo.setQtyshipped(d.getQtyshipped());
            jiaoCaiInventoryVo.setSubcode(d.getSubcode());
            jiaoCaiInventoryVoList.add(jiaoCaiInventoryVo);
        }
        return jiaoCaiInventoryVoList;
    }

    private List<JiaoCaiInventoryVo> parseToJiaoCaiInventoryVo(List<JiaoCaiInventory> jiaoCaiInventoryList){
        List<JiaoCaiInventoryVo> jiaoCaiInventoryVoList = new ArrayList<>();
        JiaoCaiInventoryVo jiaoCaiInventoryVo = null;
        for(JiaoCaiInventory d : jiaoCaiInventoryList){
            jiaoCaiInventoryVo = new JiaoCaiInventoryVo();
            JiaoCaiSkuKey jiaoCaiSkuKey = new JiaoCaiSkuKey();
            jiaoCaiSkuKey.setIssuenumber(d.getIssuenumber());
            jiaoCaiSkuKey.setSubcode(d.getSubcode());
            DataSourceContextHolder. setDbType(DataSourceContextHolder.SESSION_FACTORY_WMS);
            JiaoCaiSku jiaoCaiSku = jiaoCaiSkuMapper.selectByPrimaryKey(jiaoCaiSkuKey);
            if(jiaoCaiSku != null){
                jiaoCaiInventoryVo.setBarcode(jiaoCaiSku.getBarcode());
                jiaoCaiInventoryVo.setDescr(jiaoCaiSku.getDescr());
                jiaoCaiInventoryVo.setPrice(jiaoCaiSku.getPrice());
                JiaoCaiStorer jiaoCaiStorer = jiaoCaiStorerMapper.selectByStorerKey(jiaoCaiSku.getPublisher());
                if(jiaoCaiStorer != null) {
                    jiaoCaiInventoryVo.setPublisher(jiaoCaiStorer.getShortname());
                    jiaoCaiInventoryVo.setStorerkey(jiaoCaiStorer.getStorerkey());
                }
            }
            jiaoCaiInventoryVo.setId(d.getId());
            jiaoCaiInventoryVo.setIssuenumber(d.getIssuenumber());
            jiaoCaiInventoryVo.setQtyallocated(d.getQtyallocated());
            jiaoCaiInventoryVo.setQtyfree(d.getQtyfree());
            jiaoCaiInventoryVo.setQtyreceipt(d.getQtyreceipt());
            jiaoCaiInventoryVo.setQtyshipped(d.getQtyshipped());
            jiaoCaiInventoryVo.setSubcode(d.getSubcode());
            jiaoCaiInventoryVoList.add(jiaoCaiInventoryVo);
        }
        return jiaoCaiInventoryVoList;
    }
}