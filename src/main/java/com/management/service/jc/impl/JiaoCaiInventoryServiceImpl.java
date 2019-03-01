package com.management.service.jc.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.management.common.RequestHolder;
import com.management.common.ServerResponse;
import com.management.dao.jc.*;
import com.management.dao.login.LoginMapper;
import com.management.dao.prd1.TaskViewMapper;
import com.management.exception.MyException;
import com.management.pojo.jc.*;
import com.management.service.jc.IJiaoCaiInventoryService;
import com.management.service.jc.IPalletService;
import com.management.util.DataSourceContextHolder;
import com.management.util.DateTimeUtil;
import com.management.util.XmlUtils;
import com.management.vo.jc.JiaoCaiInventoryVo;
import org.apache.commons.lang3.StringUtils;
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

    @Autowired
    JiaoCaiLocMapper jiaoCaiLocMapper;

    @Autowired
    JiaoCaiItrnMapper jiaoCaiItrnMapper;

    @Autowired
    TaskViewMapper taskViewMapper;

    @Autowired
    JiaoCaiComputeMapper jiaoCaiComputeMapper;

    @Autowired
    JiaoCaiTaskMapper jiaoCaiTaskMapper;

    @Autowired
    JiaoCaiTaskDetailMapper jiaoCaiTaskDetailMapper;

    @Autowired
    IPalletService palletService;

    @Override
    public int add(JiaoCaiInventory jiaoCaiInventory, JiaoCaiInventory_detail jiaoCaiInventory_detail) {
        DataSourceContextHolder. setDbType(DataSourceContextHolder.SESSION_FACTORY_WMS);
        int i = 0,j = 0;
        if(isExistInventory(jiaoCaiInventory)){
            i += jiaoCaiInventoryMapper.addInventory(jiaoCaiInventory);
        }else {
            jiaoCaiInventory.setQtyallocated(0);
            jiaoCaiInventory.setQtyshipped(0);
            i += jiaoCaiInventoryMapper.insertSelective(jiaoCaiInventory);
        }

        jiaoCaiInventory_detail.setLoc("STAGE");
        if(isExistInventoryDetail(jiaoCaiInventory_detail)){
            j += jiaoCaiInventoryDetailMapper.addInventoryDetail(jiaoCaiInventory_detail);
        }else {
            jiaoCaiInventory_detail.setQtyallocated(0);
            jiaoCaiInventory_detail.setQtyshipped(0);
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

    @Override
    public ServerResponse selectInventoryDetailTotal(Integer pageSize, Integer pageNum, JiaoCaiInventory_detail jiaoCaiInventory_detail) {
        DataSourceContextHolder. setDbType(DataSourceContextHolder.SESSION_FACTORY_WMS);
        PageHelper.startPage(pageNum,pageSize);
        List<JiaoCaiInventory_detail> jiaoCaiInventoryDetailList = jiaoCaiInventoryDetailMapper.selectAllTotal(jiaoCaiInventory_detail);
        List<JiaoCaiInventoryVo> jiaoCaiInventoryVoList = parseToJiaoCaiInventoryVo2(jiaoCaiInventoryDetailList);
        PageInfo pageInfo = new PageInfo(jiaoCaiInventoryDetailList);
        pageInfo.setList(jiaoCaiInventoryVoList);
        return ServerResponse.createBySuccess(pageInfo);
    }

    @Override
    public void executeTask(String task_no) {
        DataSourceContextHolder. setDbType(DataSourceContextHolder.SESSION_FACTORY_WMS);
        JiaoCaiTask jiaoCaiTask = new JiaoCaiTask();
        jiaoCaiTask.setTrkNo(task_no);
        List<JiaoCaiTask> jiaoCaiTaskList = jiaoCaiTaskMapper.selectAll(jiaoCaiTask);
        JiaoCaiTaskDetail jiaoCaiTaskDetail = null;
        JiaoCaiInventoryVo jiaoCaiInventoryVo = null;
        for(JiaoCaiTask jiaoCaiTask1 : jiaoCaiTaskList){
            if(jiaoCaiTask1.getOrderid() != null){
                jiaoCaiTaskDetail = new JiaoCaiTaskDetail();
                jiaoCaiTaskDetail.setTaskid(jiaoCaiTask1.getOrderid());
                List<JiaoCaiTaskDetail> jiaoCaiTaskDetailList = jiaoCaiTaskDetailMapper.selectAll(jiaoCaiTaskDetail);
                if(jiaoCaiTaskDetailList != null && jiaoCaiTaskDetailList.size() > 0){
                    for(JiaoCaiTaskDetail j : jiaoCaiTaskDetailList){
                        jiaoCaiInventoryVo = new JiaoCaiInventoryVo();
                        jiaoCaiInventoryVo.setIssuenumber(j.getIssuenumber());
                        jiaoCaiInventoryVo.setSubcode(j.getSubcode());
                        jiaoCaiInventoryVo.setContainerId(j.getFromid());
                        jiaoCaiInventoryVo.setLoc(j.getFromloc());
                        jiaoCaiInventoryVo.setToContainerId(j.getToid());
                        jiaoCaiInventoryVo.setToLoc(j.getToloc());
                        jiaoCaiInventoryVo.setQtyallocated(j.getQty());
                        jiaoCaiInventoryVo.setPack(j.getPack());
                        jiaoCaiInventoryVo.setQtyfree(j.getQty());
                        moveFromAndTo(jiaoCaiInventoryVo);
                        j.setStatus("1");
                        jiaoCaiTaskDetailMapper.updateByPrimaryKeySelective(j);
                    }
                }
            }
            jiaoCaiTask1.setSendcode("3");
            jiaoCaiTaskMapper.updateByPrimaryKeySelective(jiaoCaiTask1);
        }
    }


    @Override
    public ServerResponse selectInventory(Integer pageSize, Integer pageNum, JiaoCaiInventory jiaoCaiInventory) {
        DataSourceContextHolder. setDbType(DataSourceContextHolder.SESSION_FACTORY_WMS);
        PageHelper.startPage(pageNum,pageSize);
        List<JiaoCaiInventory> jiaoCaiInventoryList = jiaoCaiInventoryMapper.selectAll(jiaoCaiInventory);
        List<JiaoCaiInventoryVo> jiaoCaiInventoryVoList = parseToJiaoCaiInventoryVo(jiaoCaiInventoryList);
        PageInfo pageInfo = new PageInfo(jiaoCaiInventoryList);
        pageInfo.setList(jiaoCaiInventoryVoList);
        return ServerResponse.createBySuccess(pageInfo);
    }

    @Override
    public ServerResponse move(JiaoCaiInventoryVo jiaoCaiInventoryVo) {
        jiaoCaiInventoryVo.setToLoc(jiaoCaiInventoryVo.getToLoc().toUpperCase());
        if(jiaoCaiInventoryVo.getToContainerId() != null){
            jiaoCaiInventoryVo.setToContainerId(jiaoCaiInventoryVo.getToContainerId().toUpperCase());
        }
        //判断目的容器是否存在
        if(StringUtils.isNotBlank(jiaoCaiInventoryVo.getToContainerId())){
            if(!isExistContainerId(jiaoCaiInventoryVo.getToContainerId())){
                return ServerResponse.createByErrorMessage("您要移动的容器号不存在");
            }
        }
        DataSourceContextHolder. setDbType(DataSourceContextHolder.SESSION_FACTORY_WMS);
        //判断目的储位是否存在
        JiaoCaiLoc jiaoCaiLoc = jiaoCaiLocMapper.selectByLoc(jiaoCaiInventoryVo.getToLoc().toUpperCase());
        if(jiaoCaiLoc == null || StringUtils.isBlank(jiaoCaiLoc.getLoc())){
            return ServerResponse.createByErrorMessage("您要移库的目的储位不存在");
        }
        int i = 0;
        //目的储位增加库存
        //1.不是移动到智能仓库，或从特殊储位移出，则直接移动
        if((!(jiaoCaiInventoryVo.getToLoc().endsWith("SMART")))
                || (jiaoCaiInventoryVo.getLoc().equals("REP"))
                || (jiaoCaiInventoryVo.getLoc().equals("SHORT"))
                || (jiaoCaiInventoryVo.getLoc().equals("PICKTO"))){
            if(jiaoCaiInventoryVo.getToLoc().endsWith("SMART")){
                if(StringUtils.isBlank(jiaoCaiInventoryVo.getToContainerId())){
                    return ServerResponse.createByErrorMessage("移动到智能仓库目的容器号不能为空");
                }
            }
            i += moveFromAndTo(jiaoCaiInventoryVo);
        }else {
            if(StringUtils.isBlank(jiaoCaiInventoryVo.getToContainerId())){
                return ServerResponse.createByErrorMessage("移动到智能仓库目的容器号不能为空");
            }
            //2.生成从REP移动到储位的任务
            String taskid = getTaskid();
            JiaoCaiTaskDetail jiaoCaiTaskDetail = new JiaoCaiTaskDetail();
            jiaoCaiTaskDetail.setAddwho(RequestHolder.getCurrentUser().getId());
            jiaoCaiTaskDetail.setFromid(jiaoCaiInventoryVo.getContainerId());
            jiaoCaiTaskDetail.setFromloc("REP");
            jiaoCaiTaskDetail.setFromid(jiaoCaiInventoryVo.getToContainerId());
            jiaoCaiTaskDetail.setToid(jiaoCaiInventoryVo.getToContainerId());
            jiaoCaiTaskDetail.setToloc(jiaoCaiInventoryVo.getToLoc());
            jiaoCaiTaskDetail.setIssuenumber(jiaoCaiInventoryVo.getIssuenumber());
            jiaoCaiTaskDetail.setSubcode(jiaoCaiInventoryVo.getSubcode());
            jiaoCaiTaskDetail.setQty(jiaoCaiInventoryVo.getQtyfree());
            jiaoCaiTaskDetail.setStatus("0");
            jiaoCaiTaskDetail.setTaskid(taskid);
            jiaoCaiTaskDetail.setTaskType("MV");
            jiaoCaiTaskDetail.setPack(jiaoCaiInventoryVo.getPack());
            jiaoCaiTaskDetailMapper.insertSelective(jiaoCaiTaskDetail);
            //3.移动到REP储位
            String warehouseId = "";
            if(jiaoCaiInventoryVo.getToLoc().startsWith("32")){
                warehouseId = "w5";
            }else if(jiaoCaiInventoryVo.getToLoc().startsWith("42")){
                warehouseId = "w2";
            }
            //库存移动到REP储位
            jiaoCaiInventoryVo.setToLoc("REP");
            i += moveFromAndTo(jiaoCaiInventoryVo);
            //3.生成入库任务
            String taskno = getTaskno();
            JiaoCaiTask jiaoCaiTask = new JiaoCaiTask();
            jiaoCaiTask.setTrkNo(taskno);
            jiaoCaiTask.setAddwho(RequestHolder.getCurrentUser().getId());
            jiaoCaiTask.setDistrictid("A");
            jiaoCaiTask.setInfid("PALLET");
            jiaoCaiTask.setMethod("1");
            jiaoCaiTask.setNeedwinding("N");
            jiaoCaiTask.setOrderid(taskid);
            jiaoCaiTask.setWarehouseid(warehouseId);
            jiaoCaiTask.setBk1(jiaoCaiInventoryVo.getSubcode());
            jiaoCaiTask.setTraycodes(jiaoCaiInventoryVo.getToContainerId());
            jiaoCaiTask.setTasktype("Normal");
            String reply = palletService.sendToPallet(jiaoCaiTask);
            String retCode = XmlUtils.getNodeValue("//RetCode", reply);
            String retTime = XmlUtils.getNodeValue("//RetTime", reply);
            String RetInfo = XmlUtils.getNodeValue("//RetInfo", reply);
            if("SUCCESS".equals(retCode)){
                jiaoCaiTask.setSendcode("1");
            }else if("ERROR".equals(retCode)){
                jiaoCaiTask.setSendcode("2");
            }
            jiaoCaiTask.setRetmsg(RetInfo);
            jiaoCaiTask.setRettime(DateTimeUtil.strToDate(retTime));
            jiaoCaiTaskMapper.insertSelective(jiaoCaiTask);
        }
        if(i > 0){
            return ServerResponse.createBySuccessMsg("移库成功");
        }else {
            return ServerResponse.createByErrorMessage("移库失败，请联系管理员");
        }

    }

    private String getTaskno() {
        DataSourceContextHolder. setDbType(DataSourceContextHolder.SESSION_FACTORY_WMS);
        Map<String, Integer> map = new HashMap<>();
        jiaoCaiComputeMapper.getTaskno(map);
        return String.valueOf(map.get("taskno"));
    }
    private String getTaskid() {
        DataSourceContextHolder. setDbType(DataSourceContextHolder.SESSION_FACTORY_WMS);
        Map<String, Integer> map = new HashMap<>();
        jiaoCaiComputeMapper.getTaskid(map);
        return String.valueOf(map.get("taskid"));
    }

    private int moveFromAndTo(JiaoCaiInventoryVo jiaoCaiInventoryVo) {
        DataSourceContextHolder. setDbType(DataSourceContextHolder.SESSION_FACTORY_WMS);
        JiaoCaiInventory_detail jiaoCaiInventory_detail = new JiaoCaiInventory_detail();
        jiaoCaiInventory_detail.setLoc(jiaoCaiInventoryVo.getToLoc());
        jiaoCaiInventory_detail.setSubcode(jiaoCaiInventoryVo.getSubcode());
        jiaoCaiInventory_detail.setIssuenumber(jiaoCaiInventoryVo.getIssuenumber());
        jiaoCaiInventory_detail.setPack(jiaoCaiInventoryVo.getPack());
        //jiaoCaiInventory_detail.setQtyreceipt(jiaoCaiInventoryVo.getQtyfree());
        //jiaoCaiInventory_detail.setQtyfree(jiaoCaiInventoryVo.getQtyfree());
        jiaoCaiInventory_detail.setContainerId(jiaoCaiInventoryVo.getToContainerId());
        JiaoCaiInventory_detail j = jiaoCaiInventoryDetailMapper.selectByIssuenumberAndSubcodeAndPack(jiaoCaiInventory_detail);
        int i = 0,qtyreceipt = 0,qtyfree = 0;
        //1.目的储位添加库存
        if(j == null){
            //如果没有则插入一条该储位的记录
            jiaoCaiInventory_detail.setQtyfree(jiaoCaiInventoryVo.getQtyfree());
            jiaoCaiInventory_detail.setQtyreceipt(jiaoCaiInventoryVo.getQtyfree());
            i += jiaoCaiInventoryDetailMapper.insertSelective(jiaoCaiInventory_detail);
        }else {
//            如果有则在原来的库存上加上此次移动的数量
            j.setQtyreceipt(jiaoCaiInventoryVo.getQtyfree() + j.getQtyreceipt());
            j.setQtyfree(jiaoCaiInventoryVo.getQtyfree() + j.getQtyfree());
            i += jiaoCaiInventoryDetailMapper.updateByPrimaryKeySelective(j);
        }
        //2.源储位扣减库存
        j = jiaoCaiInventoryDetailMapper.selectByIssuenumberAndSubcodeAndPack(
                new JiaoCaiInventory_detail(jiaoCaiInventoryVo.getIssuenumber(),jiaoCaiInventoryVo.getSubcode(),
                        jiaoCaiInventoryVo.getPack(), jiaoCaiInventoryVo.getLoc(),jiaoCaiInventoryVo.getContainerId()));
        qtyreceipt = j.getQtyreceipt();
        qtyfree = j.getQtyfree();
        if(qtyfree - jiaoCaiInventoryVo.getQtyfree() < 0){
            throw new MyException(-1, "源储位库存不足，无法移动");
        }
        j.setLoc(jiaoCaiInventoryVo.getLoc());
        j.setQtyreceipt(qtyreceipt - jiaoCaiInventoryVo.getQtyfree());
        j.setQtyfree(qtyfree - jiaoCaiInventoryVo.getQtyfree());
        i += jiaoCaiInventoryDetailMapper.updateByPrimaryKeySelective(j);
        //记录交易记录
        JiaoCaiItrn jiaoCaiItrn = new JiaoCaiItrn();
        jiaoCaiItrn.setAddwho(RequestHolder.getCurrentUser().getId());
        jiaoCaiItrn.setFromid(jiaoCaiInventoryVo.getContainerId());
        jiaoCaiItrn.setFromloc(jiaoCaiInventoryVo.getLoc());
        jiaoCaiItrn.setToloc(jiaoCaiInventoryVo.getToLoc());
        jiaoCaiItrn.setFromtable("JiaoCaiInventory_detail");
        jiaoCaiItrn.setIssuenumber(jiaoCaiInventoryVo.getIssuenumber());
        jiaoCaiItrn.setSubcode(jiaoCaiInventoryVo.getSubcode());
        jiaoCaiItrn.setPack(jiaoCaiInventoryVo.getPack());
        jiaoCaiItrn.setQty(jiaoCaiInventoryVo.getQtyfree().longValue());
        jiaoCaiItrn.setSourceid(jiaoCaiInventoryVo.getId());
        jiaoCaiItrn.setToid(jiaoCaiInventoryVo.getToContainerId());
        jiaoCaiItrn.setType("MV");
        i += jiaoCaiItrnMapper.insertSelective(jiaoCaiItrn);
        return i;
    }

    private boolean isExistContainerId(String containerId){
        DataSourceContextHolder. setDbType(DataSourceContextHolder.SESSION_FACTORY_PRD1);
        String boxno = taskViewMapper.selectBoxno(containerId);
        if(StringUtils.isNotBlank(boxno)){
            return true;
        }
        return false;
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
            jiaoCaiInventoryVo.setContainerId(d.getContainerId());
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
