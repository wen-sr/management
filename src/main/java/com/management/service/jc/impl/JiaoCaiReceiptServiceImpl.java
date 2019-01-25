package com.management.service.jc.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.management.common.Constant;
import com.management.common.RequestHolder;
import com.management.common.ServerResponse;
import com.management.dao.jc.JiaoCaiReceiptMapper;
import com.management.dao.jc.JiaoCaiSkuMapper;
import com.management.dao.jc.JiaoCaiStorerMapper;
import com.management.dao.login.LoginMapper;
import com.management.pojo.jc.*;
import com.management.pojo.login.Login;
import com.management.service.jc.IJiaoCaiInventoryService;
import com.management.service.jc.IJiaoCaiReceiptService;
import com.management.util.DataSourceContextHolder;
import com.management.util.DateTimeUtil;
import com.management.vo.jc.JiaoCaiInventoryVo;
import com.management.vo.jc.JiaoCaiReceiptVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: wen-sir
 * Description:
 * DateCrated: 2019/1/24 17:48
 * Modified By：
 */
@Service
@Transactional(value = "transactionManager_wms",readOnly = false)
public class JiaoCaiReceiptServiceImpl implements IJiaoCaiReceiptService {
    @Autowired
    JiaoCaiReceiptMapper jiaoCaiReceiptMapper;

    @Autowired
    LoginMapper loginMapper;

    @Autowired
    JiaoCaiSkuMapper jiaoCaiSkuMapper;

    @Autowired
    JiaoCaiStorerMapper jiaoCaiStorerMapper;

    @Autowired
    IJiaoCaiInventoryService jiaoCaiInventoryService;

    @Override
    public ServerResponse getInfo(Integer pageSize, Integer pageNum, JiaoCaiReceipt jiaoCaiReceipt) {
        DataSourceContextHolder. setDbType(DataSourceContextHolder.SESSION_FACTORY_WMS);

        List<JiaoCaiReceipt> jiaoCaiReceiptList = null;
        PageHelper.startPage(pageNum,pageSize);
        jiaoCaiReceiptList = jiaoCaiReceiptMapper.findAll(jiaoCaiReceipt);
        List<JiaoCaiReceiptVo> jiaoCaiReceiptVoList = parseToJiaoCaiReceiptVo(jiaoCaiReceiptList);

        PageInfo pageInfo = new PageInfo(jiaoCaiReceiptList);
        pageInfo.setList(jiaoCaiReceiptVoList);

        return ServerResponse.createBySuccess(pageInfo);
    }

    @Override
    public ServerResponse delete(JiaoCaiReceipt jiaoCaiReceipt) {
        DataSourceContextHolder. setDbType(DataSourceContextHolder.SESSION_FACTORY_WMS);
        jiaoCaiReceipt = jiaoCaiReceiptMapper.selectByPrimaryKey(jiaoCaiReceipt.getId());
        //库存总账
        JiaoCaiInventory jiaoCaiInventory = new JiaoCaiInventory();
        jiaoCaiInventory.setIssuenumber(jiaoCaiReceipt.getIssuenumber());
        jiaoCaiInventory.setSubcode(jiaoCaiReceipt.getSubcode());
        jiaoCaiInventory.setQtyreceipt(0-jiaoCaiReceipt.getQtyreceipt());
        //库存明细
        JiaoCaiInventory_detail jiaoCaiInventory_detail = new JiaoCaiInventory_detail();
        jiaoCaiInventory_detail.setIssuenumber(jiaoCaiReceipt.getIssuenumber());
        jiaoCaiInventory_detail.setPack(jiaoCaiReceipt.getPack());
        jiaoCaiInventory_detail.setQtyreceipt(0-jiaoCaiReceipt.getQtyreceipt());
        jiaoCaiInventory_detail.setSubcode(jiaoCaiReceipt.getSubcode());
//        判断平置区的库存是否足够，只有未上架的才允许修改收货数量
        jiaoCaiInventory_detail.setLoc("STAGE");
        List<JiaoCaiInventoryVo> jiaoCaiInventoryVoList = jiaoCaiInventoryService.selectInventoryDetail(1, 1,jiaoCaiInventory_detail).getData().getList();
        if(jiaoCaiInventoryVoList == null ||
                jiaoCaiInventoryVoList.size() == 0 || ((jiaoCaiInventoryVoList.get(0).getQtyfree() - jiaoCaiReceipt.getQtyreceipt()) < 0)){
            return ServerResponse.createByErrorMessage("平置区库存已经上架，无法删除收货！");
        }

        //调整库存
        int i = jiaoCaiInventoryService.add(jiaoCaiInventory, jiaoCaiInventory_detail);
        //删除收货记录
        i += jiaoCaiReceiptMapper.deleteByPrimaryKey(jiaoCaiReceipt.getId());
        if(i > 0){
            return ServerResponse.createBySuccessMsg("修改成功");
        }else {
            return ServerResponse.createByErrorMessage("修改失败，请联系管理员");
        }
    }

    @Override
    public ServerResponse add(JiaoCaiReceipt jiaoCaiReceipt) {
        DataSourceContextHolder. setDbType(DataSourceContextHolder.SESSION_FACTORY_WMS);
        jiaoCaiReceipt.setAddwho(RequestHolder.getCurrentUser().getId());
        jiaoCaiReceipt.setEditwho(RequestHolder.getCurrentUser().getId());
        jiaoCaiReceipt.setStatus("0");
        int i = jiaoCaiReceiptMapper.insertSelective(jiaoCaiReceipt);
        if(i > 0){
            //库存总账
            JiaoCaiInventory jiaoCaiInventory = new JiaoCaiInventory();
            jiaoCaiInventory.setIssuenumber(jiaoCaiReceipt.getIssuenumber());
            jiaoCaiInventory.setSubcode(jiaoCaiReceipt.getSubcode());
            jiaoCaiInventory.setQtyreceipt(jiaoCaiReceipt.getQtyreceipt());
            jiaoCaiInventory.setQtyfree(jiaoCaiReceipt.getQtyreceipt());
            //库存明细
            JiaoCaiInventory_detail jiaoCaiInventory_detail = new JiaoCaiInventory_detail();
            jiaoCaiInventory_detail.setIssuenumber(jiaoCaiReceipt.getIssuenumber());
            jiaoCaiInventory_detail.setPack(jiaoCaiReceipt.getPack());
            jiaoCaiInventory_detail.setQtyreceipt(jiaoCaiReceipt.getQtyreceipt());
            jiaoCaiInventory_detail.setQtyfree(jiaoCaiReceipt.getQtyreceipt());
            jiaoCaiInventory_detail.setSubcode(jiaoCaiReceipt.getSubcode());
//            加库存
            i = jiaoCaiInventoryService.add(jiaoCaiInventory, jiaoCaiInventory_detail);
        }
        if(i > 0){
            return ServerResponse.createBySuccessMsg("收货成功");
        }else {
            return ServerResponse.createByErrorMessage("收货失败，请联系管理员");
        }
    }

    @Override
    public ServerResponse update(JiaoCaiReceipt jiaoCaiReceipt) {
        DataSourceContextHolder. setDbType(DataSourceContextHolder.SESSION_FACTORY_WMS);
        JiaoCaiReceipt j = jiaoCaiReceiptMapper.selectByPrimaryKey(jiaoCaiReceipt.getId());
        //库存总账
        JiaoCaiInventory jiaoCaiInventory = new JiaoCaiInventory();
        jiaoCaiInventory.setIssuenumber(j.getIssuenumber());
        jiaoCaiInventory.setSubcode(j.getSubcode());
        jiaoCaiInventory.setQtyreceipt(jiaoCaiReceipt.getQtyreceipt() - j.getQtyreceipt());
        //库存明细
        JiaoCaiInventory_detail jiaoCaiInventory_detail = new JiaoCaiInventory_detail();
        jiaoCaiInventory_detail.setIssuenumber(j.getIssuenumber());
        jiaoCaiInventory_detail.setPack(j.getPack());
        jiaoCaiInventory_detail.setQtyreceipt(jiaoCaiReceipt.getQtyreceipt() - j.getQtyreceipt());
        jiaoCaiInventory_detail.setSubcode(j.getSubcode());
        if((j.getQtyreceipt() - jiaoCaiReceipt.getQtyreceipt() ) != 0){
//        判断平置区的库存是否足够，只有未上架的才允许修改收货数量
            jiaoCaiInventory_detail.setLoc("STAGE");
            List<JiaoCaiInventoryVo> jiaoCaiInventoryVoList = jiaoCaiInventoryService.selectInventoryDetail(1, 1,jiaoCaiInventory_detail).getData().getList();
            if(jiaoCaiInventoryVoList == null ||
                    jiaoCaiInventoryVoList.size() == 0 || ((jiaoCaiInventoryVoList.get(0).getQtyfree() - Math.abs(j.getQtyreceipt())) < 0)){
                return ServerResponse.createByErrorMessage("平置区库存已经上架，无法修改收货！");
            }
        }

        //调整库存
        int i = jiaoCaiInventoryService.add(jiaoCaiInventory, jiaoCaiInventory_detail);
//        调整收货记录
        i += jiaoCaiReceiptMapper.updateByPrimaryKeySelective(jiaoCaiReceipt);
        if(i > 0){
            return ServerResponse.createBySuccessMsg("修改成功");
        }else {
            return ServerResponse.createByErrorMessage("修改失败，请联系管理员");
        }
    }

    private List<JiaoCaiReceiptVo> parseToJiaoCaiReceiptVo(List<JiaoCaiReceipt> jiaoCaiReceiptList) {
        List<JiaoCaiReceiptVo> jiaoCaiReceiptVoList = new ArrayList<>();
        JiaoCaiReceiptVo jiaoCaiReceiptVo = null;
        for(JiaoCaiReceipt d : jiaoCaiReceiptList) {
            jiaoCaiReceiptVo = new JiaoCaiReceiptVo();
            jiaoCaiReceiptVo.setAdddate(DateTimeUtil.dateToStr(d.getAdddate()));
            jiaoCaiReceiptVo.setEditdate(DateTimeUtil.dateToStr(d.getEditdate()));
            DataSourceContextHolder. setDbType(DataSourceContextHolder.SESSION_FACTORY_XH);
            Login user = loginMapper.selectByPrimaryKey(d.getAddwho());
            if(user != null && user.getName() != null){
                jiaoCaiReceiptVo.setAddwho(user.getName());
            }
            Login user2 = loginMapper.selectByPrimaryKey(d.getEditwho());
            if(user2 != null && user2.getName() != null){
                jiaoCaiReceiptVo.setEditwho(user2.getName());
            }

            jiaoCaiReceiptVo.setId(d.getId());
            jiaoCaiReceiptVo.setIssuenumber(d.getIssuenumber());
            jiaoCaiReceiptVo.setPack(d.getPack());
            jiaoCaiReceiptVo.setPrintPlant(d.getPrintPlant());
            jiaoCaiReceiptVo.setQtyreceipt(d.getQtyreceipt());
            jiaoCaiReceiptVo.setReceiptno(d.getReceiptno());
            jiaoCaiReceiptVo.setStatus(Constant.JiaoCaiReceiptStatus.codeOf(Integer.parseInt(d.getStatus())).getMsg());
            jiaoCaiReceiptVo.setSubcode(d.getSubcode());

            DataSourceContextHolder. setDbType(DataSourceContextHolder.SESSION_FACTORY_WMS);
            JiaoCaiSkuKey jiaoCaiSkuKey = new JiaoCaiSkuKey();
            jiaoCaiSkuKey.setIssuenumber(d.getIssuenumber());
            jiaoCaiSkuKey.setSubcode(d.getSubcode());
            JiaoCaiSku jiaoCaiSku = jiaoCaiSkuMapper.selectByPrimaryKey(jiaoCaiSkuKey);
            if(jiaoCaiSku != null){
                jiaoCaiReceiptVo.setBarcode(jiaoCaiSku.getBarcode());
                jiaoCaiReceiptVo.setDescr(jiaoCaiSku.getDescr());
                jiaoCaiReceiptVo.setPrice(jiaoCaiSku.getPrice());
                JiaoCaiStorer jiaoCaiStorer = jiaoCaiStorerMapper.selectByStorerKey(jiaoCaiSku.getPublisher());
                if(jiaoCaiStorer != null) {
                    jiaoCaiReceiptVo.setPublisher(jiaoCaiStorer.getShortname());
                    jiaoCaiReceiptVo.setStorerkey(jiaoCaiStorer.getStorerkey());
                }
            }
            jiaoCaiReceiptVo.setPrintPlant(d.getPrintPlant());
            JiaoCaiStorer j = jiaoCaiStorerMapper.selectByStorerKey(d.getPrintPlant());
            if(j != null) {
                jiaoCaiReceiptVo.setPrintPlantName(j.getShortname());
            }
            jiaoCaiReceiptVoList.add(jiaoCaiReceiptVo);

        }
        return jiaoCaiReceiptVoList;
    }
}

