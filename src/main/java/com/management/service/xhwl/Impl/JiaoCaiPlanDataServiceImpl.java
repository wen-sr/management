package com.management.service.xhwl.Impl;

import com.management.common.EasyuiTableResponse;
import com.management.common.RequestHolder;
import com.management.common.ServerResponse;
import com.management.dao.xhwl.JiaoCaiPlanDataMapper;
import com.management.pojo.xhwl.JiaoCaiPlanData;
import com.management.service.xhwl.IJiaoCaiPlanDataService;
import com.management.util.DataSourceContextHolder;
import com.management.vo.xhwl.JiaoCaiPlanDataVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: wen-sir
 * Description:
 * DateCrated: 2019/4/8 10:55
 * Modified By：
 */
@Service
@Transactional(value = "transactionManager_xh",readOnly = false)
public class JiaoCaiPlanDataServiceImpl implements IJiaoCaiPlanDataService {

    @Autowired
    JiaoCaiPlanDataMapper jiaoCaiPlanDataMapper;


    @Override
    public ServerResponse saveRecords(List<List<Object>> listob) {
        DataSourceContextHolder. setDbType(DataSourceContextHolder.SESSION_FACTORY_XH);
        JiaoCaiPlanData jiaoCaiPlanData = null;
        //jiaoCaiPlanDataMapper.deleteByIssuenumber(listob.get(0).toString());
        if(listob != null && listob.size() > 0){
            for(List<Object> list : listob) {
                jiaoCaiPlanData = new JiaoCaiPlanData();
                jiaoCaiPlanData.setIssuenumber(list.get(0).toString());
                jiaoCaiPlanData.setPlantingname(list.get(1).toString());
                jiaoCaiPlanData.setSubcode(list.get(2).toString());
                jiaoCaiPlanData.setPrice(Double.parseDouble(list.get(3).toString()));
                jiaoCaiPlanData.setDescr(list.get(4).toString());
                jiaoCaiPlanData.setPublisher(list.get(5).toString());
                jiaoCaiPlanData.setQtyperitem(Integer.parseInt(list.get(6).toString()));
                jiaoCaiPlanData.setQtydeliver(Integer.parseInt(list.get(7).toString()));
                jiaoCaiPlanData.setQtycase(Integer.parseInt(list.get(8).toString()));
                jiaoCaiPlanData.setBatchno(list.get(9).toString());
                jiaoCaiPlanData.setDeliverdate(list.get(10).toString());
                jiaoCaiPlanData.setHandbagdate(list.get(11).toString());
                jiaoCaiPlanData.setType(list.get(12).toString());
                jiaoCaiPlanData.setRemark(list.get(13).toString());
                jiaoCaiPlanData.setAddwho(RequestHolder.getCurrentUser().getId());
                jiaoCaiPlanDataMapper.insertSelective(jiaoCaiPlanData);
            }
        }
        return ServerResponse.createBySuccessMsg("导入成功");
    }

    @Override
    public EasyuiTableResponse findAll(JiaoCaiPlanDataVo jiaoCaiPlanDataVo, Integer pageSize, Integer pageNum) {
        DataSourceContextHolder. setDbType(DataSourceContextHolder.SESSION_FACTORY_XH);

        //PageHelper.startPage(pageNum,pageSize);
        List<JiaoCaiPlanData> jiaoCaiPlanDataList = jiaoCaiPlanDataMapper.findAll(jiaoCaiPlanDataVo);
        //PageInfo pageInfo = new PageInfo(jiaoCaiPlanDataList);
        EasyuiTableResponse response = new EasyuiTableResponse();
        response.setRows(jiaoCaiPlanDataList);
        response.setCode(0);
        response.setCount(jiaoCaiPlanDataList.size());
        response.setTotal(jiaoCaiPlanDataList.size());
        List<JiaoCaiPlanData> footers = new ArrayList<>();
        Integer sumQty = 0, sumCaseQty = 0;
        for(JiaoCaiPlanData j : jiaoCaiPlanDataList) {
            sumQty += j.getQtydeliver();
            sumCaseQty += j.getQtycase();
        }
        JiaoCaiPlanData jj = new JiaoCaiPlanData();
        jj.setQtydeliver(sumQty);
        jj.setQtycase(sumCaseQty);
        footers.add(jj);
        response.setFooter(footers);
        return response;
    }

    @Override
    public List<JiaoCaiPlanDataVo> issueNumberTips() {
        DataSourceContextHolder. setDbType(DataSourceContextHolder.SESSION_FACTORY_XH);
        return jiaoCaiPlanDataMapper.issueNumberTips();
    }

    @Override
    public List<JiaoCaiPlanDataVo> plantingnameTips() {
        DataSourceContextHolder. setDbType(DataSourceContextHolder.SESSION_FACTORY_XH);
        return jiaoCaiPlanDataMapper.plantingnameTips();
    }

    @Override
    public List<JiaoCaiPlanDataVo> subcodeTips() {
        DataSourceContextHolder. setDbType(DataSourceContextHolder.SESSION_FACTORY_XH);
        return jiaoCaiPlanDataMapper.subcodeTips();
    }

    @Override
    public List<JiaoCaiPlanDataVo> typeTips() {
        DataSourceContextHolder. setDbType(DataSourceContextHolder.SESSION_FACTORY_XH);
        return jiaoCaiPlanDataMapper.typeTips();
    }

    @Override
    public ServerResponse editInfo(JiaoCaiPlanData jiaoCaiPlanData) {
        DataSourceContextHolder. setDbType(DataSourceContextHolder.SESSION_FACTORY_XH);
        JiaoCaiPlanDataVo jo = new JiaoCaiPlanDataVo();
        jo.setIssuenumber(jiaoCaiPlanData.getIssuenumber());
        jo.setBatchno(jiaoCaiPlanData.getBatchno());
        List<JiaoCaiPlanData> jiaoCaiPlanDataList = jiaoCaiPlanDataMapper.findAll(jo);
        if(StringUtils.isNotBlank(jiaoCaiPlanData.getType())){
            if(!(jiaoCaiPlanData.getType().equals(jiaoCaiPlanDataList.get(0).getType()))){
                if(!(RequestHolder.getCurrentUser().getId().equals("LH07003")) && !(RequestHolder.getCurrentUser().getId().equals("LH07001"))){
                    return ServerResponse.createByErrorMessage("修改失败，您没有权限修改【交包类型】");
                }
            }
        }
        for(JiaoCaiPlanData j : jiaoCaiPlanDataList){
            j.setHandbagdate(jiaoCaiPlanData.getHandbagdate());
            j.setType(jiaoCaiPlanData.getType());
            j.setRemark(jiaoCaiPlanData.getRemark());
            jiaoCaiPlanDataMapper.updateByPrimaryKeySelective(j);
        }
        return ServerResponse.createBySuccessMsg("修改成功");
    }

    @Override
    public ServerResponse remove(Long id) {
        DataSourceContextHolder. setDbType(DataSourceContextHolder.SESSION_FACTORY_XH);
        jiaoCaiPlanDataMapper.deleteByPrimaryKey(id);
        return ServerResponse.createBySuccessMsg("删除成功");
    }
}
