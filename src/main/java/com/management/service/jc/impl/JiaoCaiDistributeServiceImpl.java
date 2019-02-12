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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author: wen-sir
 * Description:
 * DateCrated: 2019/1/24 14:08
 * Modified By：
 */
@Service
@Transactional(value = "transactionManager_wms",readOnly = false)
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

    @Autowired
    JiaoCaiComputeMapper jiaoCaiComputeMapper;

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

    @Override
    public ServerResponse compute(List<Long> ids, Integer pack, Integer bundle) {
        DataSourceContextHolder. setDbType(DataSourceContextHolder.SESSION_FACTORY_WMS);
        int i = 0;
        for(Long l : ids){
            JiaoCaiDistribute jiaoCaiDistribute = jiaoCaiDistributeMapper.selectByPrimaryKey(l);
            jiaoCaiDistribute.setPack(pack);
            jiaoCaiDistribute.setOldpack(bundle);
            String computeNo = getComputeNo();
            jiaoCaiDistribute.setComputeno(computeNo);
            jiaoCaiDistribute.setStatus("1");
            i += jiaoCaiDistributeMapper.updateByPrimaryKeySelective(jiaoCaiDistribute);
            i += computeDo(jiaoCaiDistribute);
        }
        if(i > 0){
            return ServerResponse.createBySuccessMsg("计算完成");
        }
        return ServerResponse.createByErrorMessage("计算失败，请联系管理员");
    }

    private String getComputeNo(){
        DataSourceContextHolder. setDbType(DataSourceContextHolder.SESSION_FACTORY_WMS);
        Map<String, Integer> map = new HashMap<>();
        jiaoCaiComputeMapper.getComputeNo(map);
        return String.valueOf(map.get("computeNo"));
    }
    private int computeDo(JiaoCaiDistribute jiaoCaiDistribute){
        DataSourceContextHolder. setDbType(DataSourceContextHolder.SESSION_FACTORY_WMS);
        int i = 0;
        //库存分发，需占用库存
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
        List<JiaoCaiInventory_detail> jiaoCaiInventoryDetailList = jiaoCaiInventoryDetailMapper.selectByQtyfree(
                new JiaoCaiInventory_detail(jiaoCaiDistribute.getIssuenumber(), jiaoCaiDistribute.getSubcode(), jiaoCaiDistribute.getQtyallocated(), jiaoCaiDistribute.getPack()));
        if(jiaoCaiInventoryDetailList != null && jiaoCaiInventoryDetailList.size() > 0){
            //占用库存
            jiaoCaiInventory_detail = jiaoCaiInventoryDetailList.get(0);
            jiaoCaiInventory_detail.setQtyfree(jiaoCaiInventory_detail.getQtyfree() - jiaoCaiDistribute.getQtyallocated());
            jiaoCaiInventory_detail.setQtyallocated(jiaoCaiInventory_detail.getQtyallocated() + jiaoCaiDistribute.getQtyallocated());
            i += jiaoCaiInventoryDetailMapper.updateByPrimaryKeySelective(jiaoCaiInventory_detail);
            //写入compute表
            i += addCompute(jiaoCaiDistribute, jiaoCaiInventory_detail, null);
        }else {
            //2.如果没有，则选择数量最大
            jiaoCaiInventoryDetailList = jiaoCaiInventoryDetailMapper.selectByQtyfree2(new JiaoCaiInventory_detail(jiaoCaiDistribute.getIssuenumber(), jiaoCaiDistribute.getSubcode(), jiaoCaiDistribute.getQtyallocated(), jiaoCaiDistribute.getPack()));
            if(jiaoCaiInventoryDetailList == null || jiaoCaiInventoryDetailList.size() == 0){
                throw new MyException(-1, "库存在不可分配的储位上，请核实后将库存移至可分配储位");
            }
            int qty = jiaoCaiInventory.getQtyallocated();
            int kucun = 0;
            for(JiaoCaiInventory_detail j : jiaoCaiInventoryDetailList){
                kucun += j.getQtyfree();
            }
            if(qty > kucun) {
                throw new MyException(-1, "库存在不可分配的储位上，请核实后将库存移至可分配储位");
            }
            for(JiaoCaiInventory_detail j : jiaoCaiInventoryDetailList){
                //库存占数量
                int qty1 = (j.getQtyfree() - qty > 0 ? j.getQtyfree() - qty : j.getQtyfree()),
                        //库存剩余数
                        qty2 = j.getQtyfree() - qty > 0 ? j.getQtyfree() - qty : 0;

                //占用库存
                j.setQtyallocated(j.getQtyallocated() + qty1);
                j.setQtyfree(qty2);
                i += jiaoCaiInventoryDetailMapper.updateByPrimaryKeySelective(j);
                //写入compute表
                jiaoCaiDistribute.setQtyallocated(qty1);
                i += addCompute(jiaoCaiDistribute, j, 0);
                qty = qty - qty1;
                jiaoCaiDistribute.setQtyallocated(qty);
                if(qty <= 0){
                    break;
                }
            }
        }
        return i;
    }

    private int addCompute(JiaoCaiDistribute jiaoCaiDistribute, JiaoCaiInventory_detail jiaoCaiInventory_detail, Integer flag) {
        JiaoCaiCompute jiaoCaiCompute = new JiaoCaiCompute();
        jiaoCaiCompute.setBundle(jiaoCaiDistribute.getOldpack());
        jiaoCaiCompute.setComputeno(jiaoCaiDistribute.getComputeno());
        jiaoCaiCompute.setContainerid(jiaoCaiInventory_detail.getContainerId());
        jiaoCaiCompute.setDistributeid(jiaoCaiDistribute.getId());
        jiaoCaiCompute.setIssuenumber(jiaoCaiDistribute.getIssuenumber());
        jiaoCaiCompute.setSubcode(jiaoCaiDistribute.getSubcode());
        jiaoCaiCompute.setLoc(jiaoCaiInventory_detail.getLoc());
        jiaoCaiCompute.setPack(jiaoCaiDistribute.getPack());
        jiaoCaiCompute.setQtyallocated(jiaoCaiDistribute.getQtyallocated());
        jiaoCaiCompute.setStatus("1");
        jiaoCaiCompute.setCode(jiaoCaiDistribute.getCode());
        jiaoCaiCompute.setShortname(jiaoCaiDistribute.getShortname());
        jiaoCaiCompute.setComputewho(RequestHolder.getCurrentUser().getId());
        jiaoCaiCompute.setSendcode(0);
        int bundle = jiaoCaiDistribute.getOldpack(),pack = jiaoCaiDistribute.getPack(),qty = jiaoCaiDistribute.getQtyallocated();
        int caseQty = qty / (bundle * pack);
        int odd = ((qty%(bundle*pack))%pack);
        int oddpack= (qty%(bundle*pack))/pack;
        jiaoCaiCompute.setCaseqty(caseQty);
        jiaoCaiCompute.setOdd(odd);
        jiaoCaiCompute.setOddpack(oddpack);
        //标识整件拣货或零件捡货
        if(caseQty == 0 && oddpack == 0 && flag != 0){
            jiaoCaiCompute.setPicktype(1);
        }else {
            jiaoCaiCompute.setPicktype(0);
        }
        return jiaoCaiComputeMapper.insertSelective(jiaoCaiCompute);
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
