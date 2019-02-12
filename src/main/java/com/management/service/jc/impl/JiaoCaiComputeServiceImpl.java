package com.management.service.jc.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.management.common.Constant;
import com.management.common.ServerResponse;
import com.management.dao.jc.*;
import com.management.dao.login.LoginMapper;
import com.management.exception.MyException;
import com.management.pojo.jc.*;
import com.management.pojo.login.Login;
import com.management.service.jc.IJiaoCaiComputeService;
import com.management.util.DataSourceContextHolder;
import com.management.util.DateTimeUtil;
import com.management.vo.jc.JiaoCaiComputeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: wen-sir
 * Description:
 * DateCrated: 2019/2/12 13:05
 * Modified By：
 */
@Service
@Transactional(value = "transactionManager_wms",readOnly = false)
public class JiaoCaiComputeServiceImpl implements IJiaoCaiComputeService {

    @Autowired
    JiaoCaiComputeMapper jiaoCaiComputeMapper;

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
    JiaoCaiDistributeMapper jiaoCaiDistributeMapper;

    @Override
    public ServerResponse getInfo(Integer pageSize, Integer pageNum, JiaoCaiCompute jiaoCaiCompute) {
        DataSourceContextHolder. setDbType(DataSourceContextHolder.SESSION_FACTORY_WMS);

        List<JiaoCaiCompute> jiaoCaiComputeList = null;
        PageHelper.startPage(pageNum,pageSize);

        jiaoCaiComputeList = jiaoCaiComputeMapper.findAll(jiaoCaiCompute);
        List<JiaoCaiComputeVo> jiaoCaiComputeVoList = parseToJiaoCaiComputeVo(jiaoCaiComputeList);

        PageInfo pageInfo = new PageInfo(jiaoCaiComputeList);
        pageInfo.setList(jiaoCaiComputeVoList);

        return ServerResponse.createBySuccess(pageInfo);
    }

    @Override
    public ServerResponse cancelCompute(List<Long> ids) {
        DataSourceContextHolder. setDbType(DataSourceContextHolder.SESSION_FACTORY_WMS);
        int i = 0;
        JiaoCaiCompute jiaoCaiCompute = null;
        for(Long l : ids){
            jiaoCaiCompute = jiaoCaiComputeMapper.selectByPrimaryKey(l);
            if(!Constant.JiaoCaiDistributeStatus.START.getCode().toString().equals(jiaoCaiCompute.getStatus())){
                throw new MyException(-1, "期号为【" + jiaoCaiCompute.getIssuenumber() + "】征订代码为" +
                        "【" + jiaoCaiCompute + "】客户为【" + jiaoCaiCompute.getShortname() + "】的状态不为配发完成无法取消，" +
                        "目前状态为" + Constant.JiaoCaiDistributeStatus.codeOf(Integer.parseInt(jiaoCaiCompute.getStatus())));
            }
            //1.还原库存
            //表头
            JiaoCaiInventory jiaoCaiInventory = jiaoCaiInventoryMapper.selectByIssuenumberAndSubcode(new JiaoCaiInventory(jiaoCaiCompute.getIssuenumber(), jiaoCaiCompute.getSubcode()));
            jiaoCaiInventory.setQtyfree(jiaoCaiInventory.getQtyfree() + jiaoCaiCompute.getQtyallocated());
            jiaoCaiInventory.setQtyallocated(jiaoCaiInventory.getQtyallocated() - jiaoCaiCompute.getQtyallocated());
            i += jiaoCaiInventoryMapper.updateByPrimaryKeySelective(jiaoCaiInventory);
            //明细
            JiaoCaiInventory_detail jiaoCaiInventory_detail = new JiaoCaiInventory_detail();
            jiaoCaiInventory_detail.setIssuenumber(jiaoCaiCompute.getIssuenumber());
            jiaoCaiInventory_detail.setSubcode(jiaoCaiCompute.getSubcode());
            jiaoCaiInventory_detail.setLoc(jiaoCaiCompute.getLoc());
            jiaoCaiInventory_detail.setContainerId(jiaoCaiCompute.getContainerid());
            jiaoCaiInventory_detail.setPack(jiaoCaiCompute.getPack());
            jiaoCaiInventory_detail = jiaoCaiInventoryDetailMapper.selectByIssuenumberAndSubcodeAndPack(jiaoCaiInventory_detail);
            jiaoCaiInventory_detail.setQtyallocated(jiaoCaiInventory_detail.getQtyallocated() - jiaoCaiCompute.getQtyallocated());
            jiaoCaiInventory_detail.setQtyfree(jiaoCaiInventory_detail.getQtyfree() + jiaoCaiCompute.getQtyallocated());
            i += jiaoCaiInventoryDetailMapper.updateByPrimaryKeySelective(jiaoCaiInventory_detail);

            //2.还原分发记录
            JiaoCaiDistribute jiaoCaiDistribute = new JiaoCaiDistribute();
            jiaoCaiDistribute.setId(jiaoCaiCompute.getDistributeid());
            jiaoCaiDistribute.setComputeno(null);
            jiaoCaiDistribute.setStatus("0");
            i += jiaoCaiDistributeMapper.updateByPrimaryKeySelective(jiaoCaiDistribute);

            //3.删除compute中的记录
            i += jiaoCaiComputeMapper.deleteByPrimaryKey(l);
        }
        if(i > 0){
            return ServerResponse.createBySuccessMsg("取消配发计算成功");
        }else {
            return ServerResponse.createByErrorMessage("取消配发计算失败");
        }
    }

    private List<JiaoCaiComputeVo> parseToJiaoCaiComputeVo(List<JiaoCaiCompute> jiaoCaiComputeList) {
        List<JiaoCaiComputeVo> jiaoCaiComputeVoList = new ArrayList<>();
        JiaoCaiComputeVo jiaoCaiComputeVo = null;
        for(JiaoCaiCompute d : jiaoCaiComputeList) {
            jiaoCaiComputeVo = new JiaoCaiComputeVo();
            jiaoCaiComputeVo.setComputedate(DateTimeUtil.dateToStr(d.getComputedate()));
            DataSourceContextHolder. setDbType(DataSourceContextHolder.SESSION_FACTORY_XH);
            Login user = loginMapper.selectByPrimaryKey(d.getComputewho());
            Login user2 = loginMapper.selectByPrimaryKey(d.getEditwho());
            Login user3 = loginMapper.selectByPrimaryKey(d.getPackwho());
            if(user != null && user.getName() != null){
                jiaoCaiComputeVo.setComputewho(user.getName());
            }
            if(user3 != null && user3.getName() != null){
                jiaoCaiComputeVo.setPackwho(user3.getName());
            }
            if(user2 != null && user2.getName() != null){
                jiaoCaiComputeVo.setEditwho(user2.getName());
            }
            jiaoCaiComputeVo.setBatchno(d.getBatchno());
            jiaoCaiComputeVo.setCaseqty(d.getCaseqty());
            jiaoCaiComputeVo.setCode(d.getCode());
            jiaoCaiComputeVo.setComputeno(d.getComputeno());
            jiaoCaiComputeVo.setId(d.getId());
            jiaoCaiComputeVo.setIssuenumber(d.getIssuenumber());
            jiaoCaiComputeVo.setOdd(d.getOdd());
            jiaoCaiComputeVo.setOddpack(d.getOddpack());
            jiaoCaiComputeVo.setPack(d.getPack());
            jiaoCaiComputeVo.setPackdate(DateTimeUtil.dateToStr(d.getPackdate()));
            jiaoCaiComputeVo.setCaseqty(d.getCaseqty());
            jiaoCaiComputeVo.setPickno(d.getPickno());
            jiaoCaiComputeVo.setQtyallocated(d.getQtyallocated());
            jiaoCaiComputeVo.setShipno(d.getShipno());
            jiaoCaiComputeVo.setShortname(d.getShortname());
            jiaoCaiComputeVo.setStatus(Constant.JiaoCaiDistributeStatus.codeOf(Integer.parseInt(d.getStatus())).getMsg());
            jiaoCaiComputeVo.setSubcode(d.getSubcode());
            jiaoCaiComputeVo.setType(d.getType());

            JiaoCaiSkuKey jiaoCaiSkuKey = new JiaoCaiSkuKey();
            jiaoCaiSkuKey.setIssuenumber(d.getIssuenumber());
            jiaoCaiSkuKey.setSubcode(d.getSubcode());

            DataSourceContextHolder. setDbType(DataSourceContextHolder.SESSION_FACTORY_WMS);
            JiaoCaiSku jiaoCaiSku = jiaoCaiSkuMapper.selectByPrimaryKey(jiaoCaiSkuKey);
            if(jiaoCaiSku != null){
                jiaoCaiComputeVo.setBarcode(jiaoCaiSku.getBarcode());
                jiaoCaiComputeVo.setDescr(jiaoCaiSku.getDescr());
                jiaoCaiComputeVo.setPrice(jiaoCaiSku.getPrice());
                JiaoCaiStorer jiaoCaiStorer = jiaoCaiStorerMapper.selectByStorerKey(jiaoCaiSku.getPublisher());
                if(jiaoCaiStorer != null) {
                    jiaoCaiComputeVo.setPublisher(jiaoCaiStorer.getShortname());
                    jiaoCaiComputeVo.setStorerkey(jiaoCaiStorer.getStorerkey());
                }
            }

            jiaoCaiComputeVoList.add(jiaoCaiComputeVo);
        }
        return jiaoCaiComputeVoList;
    }
}
