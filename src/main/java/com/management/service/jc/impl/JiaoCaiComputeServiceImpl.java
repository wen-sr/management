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

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Override
    public ServerResponse pickInfo(Integer pageSize, Integer pageNum, JiaoCaiCompute jiaoCaiCompute) {
        DataSourceContextHolder. setDbType(DataSourceContextHolder.SESSION_FACTORY_WMS);
        List<JiaoCaiComputeVo> jiaoCaiComputeVoList = null;
        PageHelper.startPage(pageNum,pageSize);
        jiaoCaiComputeVoList = jiaoCaiComputeMapper.pickInfo(jiaoCaiCompute);
        if(jiaoCaiComputeVoList != null && jiaoCaiComputeVoList.size() > 0){
            for(JiaoCaiComputeVo jiaoCaiComputeVo : jiaoCaiComputeVoList){
                jiaoCaiComputeVo.setStatus(Constant.JiaoCaiDistributeStatus.codeOf(Integer.parseInt(jiaoCaiComputeVo.getStatus())).getMsg());
                jiaoCaiComputeVo.setPicktype("0".equals(jiaoCaiComputeVo.getPicktype())?"整件拣货":"零件拣货");
                if(jiaoCaiComputeVo.getCaseqty() == 0 && jiaoCaiComputeVo.getOddpack() == 0){
                    jiaoCaiComputeVo.setTotalCase(1);
                }else {
                    jiaoCaiComputeVo.setTotalCase(jiaoCaiComputeVo.getCaseqty() + jiaoCaiComputeVo.getOddpack());
                }
            }
        }
        PageInfo pageInfo = new PageInfo(jiaoCaiComputeVoList);
        return ServerResponse.createBySuccess(pageInfo);
    }

    @Override
    public ServerResponse wholeShipInfo(Integer pageSize, Integer pageNum, JiaoCaiCompute jiaoCaiCompute) {
        DataSourceContextHolder. setDbType(DataSourceContextHolder.SESSION_FACTORY_WMS);
        return getInfo(pageSize,pageNum, jiaoCaiCompute);
    }
    @Override
    public ServerResponse<PageInfo<List<JiaoCaiComputeVo>>> wholeShipInfoEnd(Integer pageSize, Integer pageNum, JiaoCaiCompute jiaoCaiCompute) {
        DataSourceContextHolder. setDbType(DataSourceContextHolder.SESSION_FACTORY_WMS);
        List<JiaoCaiComputeVo> jiaoCaiComputeVoList = null;
        PageHelper.startPage(pageNum,pageSize);
        jiaoCaiComputeVoList = jiaoCaiComputeMapper.wholeShipInfo(jiaoCaiCompute);
        if(jiaoCaiComputeVoList != null && jiaoCaiComputeVoList.size() > 0){
            for(JiaoCaiComputeVo jiaoCaiComputeVo : jiaoCaiComputeVoList){
                if(jiaoCaiComputeVo.getCaseqty() == 0 && jiaoCaiComputeVo.getOddpack() == 0){
                    jiaoCaiComputeVo.setTotalCase(1);
                }else {
                    jiaoCaiComputeVo.setTotalCase(jiaoCaiComputeVo.getCaseqty() + jiaoCaiComputeVo.getOddpack());
                }
            }
        }
        PageInfo pageInfo = new PageInfo(jiaoCaiComputeVoList);
        return ServerResponse.createBySuccess(pageInfo);
    }

    @Override
    public ServerResponse cancel(List<Long> ids) {
        DataSourceContextHolder. setDbType(DataSourceContextHolder.SESSION_FACTORY_WMS);
        JiaoCaiCompute jiaoCaiCompute = null;
        int i = 0;
        for(long l : ids){
            jiaoCaiCompute = jiaoCaiComputeMapper.selectByPrimaryKey(l);
            jiaoCaiCompute.setShipno(null);
            jiaoCaiCompute.setBatchno(null);
            jiaoCaiCompute.setStatus("1");
            i += jiaoCaiComputeMapper.updateByPrimaryKeySelective(jiaoCaiCompute);
        }
        if(i > 0){
            return ServerResponse.createBySuccessMsg("取消成功");
        }else {
            return ServerResponse.createByErrorMessage("取消失败");
        }
    }

    @Override
    public ServerResponse pickInfoTotal(Integer pageSize, Integer pageNum, JiaoCaiCompute jiaoCaiCompute) {
        DataSourceContextHolder. setDbType(DataSourceContextHolder.SESSION_FACTORY_WMS);
        List<JiaoCaiComputeVo> jiaoCaiComputeVoList = null;
        PageHelper.startPage(pageNum,pageSize);
        jiaoCaiComputeVoList = jiaoCaiComputeMapper.pickInfoTotal(jiaoCaiCompute);
        PageInfo pageInfo = new PageInfo(jiaoCaiComputeVoList);
        return ServerResponse.createBySuccess(pageInfo);
    }

    @Override
    public ServerResponse startPick(List<Long> ids) {
        DataSourceContextHolder. setDbType(DataSourceContextHolder.SESSION_FACTORY_WMS);
        JiaoCaiCompute jiaoCaiCompute = null;
        String pickno = getPickNo();
        for(Long l : ids){
            jiaoCaiCompute = jiaoCaiComputeMapper.selectByPrimaryKey(l);
            if(!Constant.JiaoCaiDistributeStatus.ALLOWPICK.getCode().toString().equals(jiaoCaiCompute.getStatus())){
                throw new MyException(-1, "【"+ jiaoCaiCompute.getShortname() +"】的拣货任务不是可拣货状态，无法生成拣货流水号");
            }
            if(jiaoCaiCompute.getLoc().endsWith("SMART")){
                //向立库发送出库任务
                //判断是否整托出库
                //todo
            }
            jiaoCaiCompute.setStatus(Constant.JiaoCaiDistributeStatus.PICK.getCode().toString());
            jiaoCaiCompute.setPickno(pickno);
            jiaoCaiComputeMapper.updateByPrimaryKeySelective(jiaoCaiCompute);
        }
        return ServerResponse.createBySuccess("启动拣货任务成功", pickno);
    }

    @Override
    public ServerResponse confirmPick(List<Long> ids) {
        DataSourceContextHolder. setDbType(DataSourceContextHolder.SESSION_FACTORY_WMS);
        JiaoCaiCompute jiaoCaiCompute = null;
        for(Long l : ids){
            jiaoCaiCompute = jiaoCaiComputeMapper.selectByPrimaryKey(l);
            if(!Constant.JiaoCaiDistributeStatus.PICK.getCode().toString().equals(jiaoCaiCompute.getStatus())){
                throw new MyException(-1, "【"+ jiaoCaiCompute.getShortname() +"】的拣货任务不是拣货中状态，无法确认拣货");
            }
            jiaoCaiCompute.setStatus(Constant.JiaoCaiDistributeStatus.PICKED.getCode().toString());
            jiaoCaiComputeMapper.updateByPrimaryKeySelective(jiaoCaiCompute);
            //扣库存
            //todo
        }
        return ServerResponse.createBySuccessMsg("确认拣货成功");
    }

    @Override
    public ServerResponse oddPackTips(JiaoCaiCompute jiaoCaiCompute) {
        DataSourceContextHolder. setDbType(DataSourceContextHolder.SESSION_FACTORY_WMS);
        List<JiaoCaiComputeVo> jiaoCaiComputeVoList = jiaoCaiComputeMapper.selectOddPackTips(jiaoCaiCompute);
        return ServerResponse.createBySuccess(jiaoCaiComputeVoList);
    }

    @Override
    public ServerResponse oddPackInfo(Integer pageSize, Integer pageNum, JiaoCaiCompute jiaoCaiCompute) {
        DataSourceContextHolder. setDbType(DataSourceContextHolder.SESSION_FACTORY_WMS);
        return getInfo(pageSize, pageNum, jiaoCaiCompute);
    }

    @Override
    public ServerResponse wholeShipInfoTotal(Integer pageSize, Integer pageNum, JiaoCaiCompute jiaoCaiCompute) {
        DataSourceContextHolder. setDbType(DataSourceContextHolder.SESSION_FACTORY_WMS);
        List<JiaoCaiComputeVo> jiaoCaiComputeVoList = null;
        PageHelper.startPage(pageNum,pageSize);
        jiaoCaiComputeVoList = jiaoCaiComputeMapper.wholeShipInfoTotal(jiaoCaiCompute);
        PageInfo pageInfo = new PageInfo(jiaoCaiComputeVoList);
        return ServerResponse.createBySuccess(pageInfo);
    }

    @Override
    public ServerResponse addBatchno(List<Long> ids) {
        DataSourceContextHolder. setDbType(DataSourceContextHolder.SESSION_FACTORY_WMS);
        //获得批次号
        String batchno = getBatchnoNo();
        int i = 0;
        //根据id更新compute的批次号
         i += jiaoCaiComputeMapper.updateBatchnoByIds(ids, batchno);
        //判断是否需要获得shipno
        List<JiaoCaiCompute> jiaoCaiComputeList = needShipno(batchno);
        JiaoCaiCompute jiaoCaiCompute = null;
        while (jiaoCaiComputeList != null && jiaoCaiComputeList.size() > 0){
            jiaoCaiCompute = new JiaoCaiCompute();
            jiaoCaiCompute.setBatchno(batchno);
            jiaoCaiCompute.setCode(jiaoCaiComputeList.get(0).getCode());
            //给shipno为null的第一个客户更新shipno
            String shipno = getShipNo();
            jiaoCaiCompute.setShipno(shipno);
            i += jiaoCaiComputeMapper.updateShipnoByBatchno(jiaoCaiCompute);
            jiaoCaiComputeList = needShipno(batchno);
        }
        if(i > 0 ){
            return ServerResponse.createBySuccess("生成批次号和运号成功", batchno);
        }else {
            return ServerResponse.createByErrorMessage("生成批次号和运号失败，请联系管理员");
        }
    }

    private List<JiaoCaiCompute> needShipno(String batchno) {
        JiaoCaiCompute jiaoCaiCompute = new JiaoCaiCompute();
        jiaoCaiCompute.setBatchno(batchno);
        return jiaoCaiComputeMapper.findAll(jiaoCaiCompute);
    }

    private synchronized String getBatchnoNo(){
        DataSourceContextHolder. setDbType(DataSourceContextHolder.SESSION_FACTORY_WMS);
        Map<String, Integer> map = new HashMap<>();
        jiaoCaiComputeMapper.getBatchno(map);
        return String.valueOf(map.get("batchno"));
    }

    private synchronized String getShipNo(){
        DataSourceContextHolder. setDbType(DataSourceContextHolder.SESSION_FACTORY_WMS);
        Map<String, Integer> map = new HashMap<>();
        jiaoCaiComputeMapper.getShipno(map);
        return String.valueOf(map.get("shipno"));
    }

    private synchronized String getPickNo(){
        DataSourceContextHolder. setDbType(DataSourceContextHolder.SESSION_FACTORY_WMS);
        Map<String, Integer> map = new HashMap<>();
        jiaoCaiComputeMapper.getPickno(map);
        return String.valueOf(map.get("pickno"));
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
            jiaoCaiComputeVo.setBundle(d.getBundle());
            jiaoCaiComputeVo.setPack(d.getPack());
            jiaoCaiComputeVo.setPackdate(DateTimeUtil.dateToStr(d.getPackdate()));
            jiaoCaiComputeVo.setContainerid(d.getContainerid());
            jiaoCaiComputeVo.setLoc(d.getLoc());
            jiaoCaiComputeVo.setCaseqty(d.getCaseqty());
            jiaoCaiComputeVo.setPickno(d.getPickno());
            jiaoCaiComputeVo.setQtyallocated(d.getQtyallocated());
            jiaoCaiComputeVo.setShipno(d.getShipno());
            jiaoCaiComputeVo.setShortname(d.getShortname());
            jiaoCaiComputeVo.setStatus(Constant.JiaoCaiDistributeStatus.codeOf(Integer.parseInt(d.getStatus())).getMsg());
            jiaoCaiComputeVo.setSubcode(d.getSubcode());
            jiaoCaiComputeVo.setType(d.getType());
            jiaoCaiComputeVo.setPicktype(d.getPicktype()==0?"整件拣货":"零件拣货");
            if(d.getCaseqty() == 0 && d.getOddpack() == 0){
                jiaoCaiComputeVo.setTotalCase(1);
            }else {
                jiaoCaiComputeVo.setTotalCase(d.getCaseqty() + d.getOddpack());
            }

            JiaoCaiSkuKey jiaoCaiSkuKey = new JiaoCaiSkuKey();
            jiaoCaiSkuKey.setIssuenumber(d.getIssuenumber());
            jiaoCaiSkuKey.setSubcode(d.getSubcode());

            DataSourceContextHolder. setDbType(DataSourceContextHolder.SESSION_FACTORY_WMS);
            JiaoCaiSku jiaoCaiSku = jiaoCaiSkuMapper.selectByPrimaryKey(jiaoCaiSkuKey);
            if(jiaoCaiSku != null){
                jiaoCaiComputeVo.setBarcode(jiaoCaiSku.getBarcode());
                jiaoCaiComputeVo.setDescr(jiaoCaiSku.getDescr());
                jiaoCaiComputeVo.setPrice(jiaoCaiSku.getPrice());
                jiaoCaiComputeVo.setAmt(new BigDecimal(d.getQtyallocated()).multiply(jiaoCaiSku.getPrice()));
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
