package com.management.service.jc.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.management.common.Constant;
import com.management.common.RequestHolder;
import com.management.common.ServerResponse;
import com.management.dao.jc.*;
import com.management.dao.login.LoginMapper;
import com.management.exception.MyException;
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
import java.util.Date;
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

    @Autowired
    JiaoCaiInventoryMapper jiaoCaiInventoryMapper;

    @Autowired
    JiaoCaiInventory_detailMapper jiaoCaiInventoryDetailMapper;

    @Autowired
    JiaoCaiPickMapper jiaoCaiPickMapper;

    @Autowired
    AllowAllocateMapper allowAllocateMapper;

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
            if(0 ==jiaoCaiDistribute.getType()){
                AllowDistribution allowDistribution = new AllowDistribution();
                allowDistribution.setIssuenumber(jiaoCaiDistribute.getIssuenumber());
                allowDistribution.setSubcode(jiaoCaiDistribute.getSubcode());
                List<AllowDistribution> allowDistributionList = allowDistributionMapper.findAll(allowDistribution);
                if(allowDistributionList != null && allowDistributionList.size() > 0){
                    return ServerResponse.createBySuccess("添加成功", allowDistributionList);
                }{
                    allowDistributionList = new ArrayList<AllowDistribution>();
                    AllowDistribution a =  new AllowDistribution();
                    a.setQtyfree(0);
                    allowDistributionList.add(a);
                    return ServerResponse.createBySuccess("添加成功", allowDistributionList);
                }
            }else if(1 == jiaoCaiDistribute.getType()){
                AllowAllocate allowAllocate = new AllowAllocate();
                allowAllocate.setIssuenumber(jiaoCaiDistribute.getIssuenumber());
                allowAllocate.setSubcode(jiaoCaiDistribute.getSubcode());
                List<AllowAllocate> allowAllocateList = allowAllocateMapper.findAll(allowAllocate);
                if(allowAllocateList != null && allowAllocateList.size() > 0){
                    return ServerResponse.createBySuccess("添加成功", allowAllocateList);
                }else {
                    allowAllocateList = new ArrayList<>();
                    AllowAllocate a  = new AllowAllocate();
                    a.setAllowallocate(0);
                    allowAllocateList.add(a);
                    return ServerResponse.createBySuccess("添加成功", allowAllocateList);
                }
            }
        }else {
            return ServerResponse.createByErrorMessage("添加失败，请联系管理员");
        }
        return ServerResponse.createByErrorMessage("添加失败，请联系管理员");
    }

    public ServerResponse compute(JiaoCaiDistribute jiaoCaiDistribute){
        int i = 0;
        //库存分发，需占用库存
        //todo 1.判断整件还是零件
        //库存表头
        JiaoCaiInventory jiaoCaiInventory = jiaoCaiInventoryMapper.selectByIssuenumberAndSubcode(new JiaoCaiInventory(jiaoCaiDistribute.getIssuenumber(), jiaoCaiDistribute.getSubcode()));
        jiaoCaiInventory.setQtyallocated(jiaoCaiInventory.getQtyallocated() + jiaoCaiDistribute.getQtyallocated());
        if(jiaoCaiInventory.getQtyfree() - jiaoCaiDistribute.getQtyallocated() > 0){
            jiaoCaiInventory.setQtyfree(jiaoCaiInventory.getQtyfree() - jiaoCaiDistribute.getQtyallocated());
        } else {
            throw new MyException(-1, "库存不足，无法分发");
        }
        i += jiaoCaiInventoryMapper.updateByPrimaryKeySelective(jiaoCaiInventory);
        //库存明细
        JiaoCaiInventory_detail jiaoCaiInventory_detail = null;
        JiaoCaiPick jiaoCaiPick = null;
        //1.查找一块托盘能符合的，选择数量最接近的那条
        List<JiaoCaiInventory_detail> jiaoCaiInventoryDetailList = jiaoCaiInventoryDetailMapper.selectByQtyfree(new JiaoCaiInventory_detail(jiaoCaiDistribute.getIssuenumber(), jiaoCaiDistribute.getSubcode(), jiaoCaiDistribute.getPack(), jiaoCaiDistribute.getQtyallocated()));
        if(jiaoCaiInventoryDetailList != null && jiaoCaiInventoryDetailList.size() > 0){
            //占用库存
            jiaoCaiInventory_detail = jiaoCaiInventoryDetailList.get(0);
            jiaoCaiInventory_detail.setQtyfree(jiaoCaiInventory_detail.getQtyfree() - jiaoCaiDistribute.getQtyallocated());
            jiaoCaiInventory_detail.setQtyallocated(jiaoCaiInventory_detail.getQtyallocated() + jiaoCaiDistribute.getQtyallocated());
            i += jiaoCaiInventoryDetailMapper.updateByPrimaryKeySelective(jiaoCaiInventory_detail);
            //写入pick表
            i += addPick(jiaoCaiDistribute, jiaoCaiInventory_detail);
        }{
            //2.如果没有，则选择数量最大
            jiaoCaiInventoryDetailList = jiaoCaiInventoryDetailMapper.selectByQtyfree2(new JiaoCaiInventory_detail(jiaoCaiDistribute.getIssuenumber(), jiaoCaiDistribute.getSubcode(), jiaoCaiDistribute.getPack(), jiaoCaiDistribute.getQtyallocated()));
            int qty = jiaoCaiInventory.getQtyallocated();
            for(JiaoCaiInventory_detail j : jiaoCaiInventoryDetailList){
                //占用库存
                j.setQtyfree(j.getQtyfree() - qty > 0 ? j.getQtyfree() - qty : 0 );
                j.setQtyallocated(j.getQtyallocated() + (j.getQtyfree() - qty > 0 ? j.getQtyfree() - qty : j.getQtyfree()));
                i += jiaoCaiInventoryDetailMapper.updateByPrimaryKeySelective(j);
                //写入pick表
                i += addPick(jiaoCaiDistribute, j);
                qty = qty - j.getQtyfree();
                if(qty == 0){
                    break;
                }
            }
        }
        return null;
    }

    private int addPick(JiaoCaiDistribute jiaoCaiDistribute,JiaoCaiInventory_detail jiaoCaiInventory_detail){
        JiaoCaiPick jiaoCaiPick = new JiaoCaiPick();
        jiaoCaiPick.setAddwho(RequestHolder.getCurrentUser().getId());
        jiaoCaiPick.setContainerid(jiaoCaiInventory_detail.getContainerId());
        jiaoCaiPick.setDistributeid(jiaoCaiDistribute.getId());
        jiaoCaiPick.setIssuenumber(jiaoCaiInventory_detail.getIssuenumber());
        jiaoCaiPick.setLoc(jiaoCaiInventory_detail.getLoc());
        jiaoCaiPick.setPack(jiaoCaiInventory_detail.getPack());
        jiaoCaiPick.setQty(jiaoCaiDistribute.getQtyallocated());
        jiaoCaiPick.setSendcode("0");
        jiaoCaiPick.setSenddate(new Date());
        jiaoCaiPick.setStatus("-1");
        return jiaoCaiPickMapper.insertSelective(jiaoCaiPick);
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

    @Override
    public ServerResponse loadWaitComputeData(Integer pageSize, Integer pageNum, JiaoCaiDistributeVo jiaoCaiDistributeVo) {
        DataSourceContextHolder. setDbType(DataSourceContextHolder.SESSION_FACTORY_WMS);
        PageHelper.startPage(pageNum,pageSize);
        List<JiaoCaiDistributeVo> jiaoCaiDistributeVoList = jiaoCaiDistributeMapper.loadWaitComputeData(jiaoCaiDistributeVo);
        PageInfo pageInfo = new PageInfo(jiaoCaiDistributeVoList);
        return ServerResponse.createBySuccess(pageInfo);
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
