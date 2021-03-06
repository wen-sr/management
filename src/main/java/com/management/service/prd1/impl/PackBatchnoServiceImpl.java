package com.management.service.prd1.impl;

import com.management.common.EasyuiTableResponse;
import com.management.common.ServerResponse;
import com.management.dao.prd1.PackBatchnoMapper;
import com.management.pojo.prd1.PackBatchno;
import com.management.service.prd1.IPackBatchnoService;
import com.management.util.DataSourceContextHolder;
import com.management.vo.prd1.GouBaoDataVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PackBatchnoServiceImpl implements IPackBatchnoService {

    @Autowired
    PackBatchnoMapper packBatchnoMapper;

    @Override
    public EasyuiTableResponse getData(String dd, String id) {
        DataSourceContextHolder. setDbType(DataSourceContextHolder.SESSION_FACTORY_PRD1);
        List<PackBatchno> packBatchnoList = packBatchnoMapper.getData(dd, id);

        Integer sumCaseQty = 0;
        for (PackBatchno p : packBatchnoList){
            sumCaseQty += p.getCaseqty().intValue();
        }

        EasyuiTableResponse response = new EasyuiTableResponse();
        response.setRows(packBatchnoList);
        response.setCode(0);
        response.setCount(packBatchnoList.size());
        response.setTotal(sumCaseQty);
        return response;
    }

    @Override
    public ServerResponse gouBaoConfirm(String dd, String id) {
        DataSourceContextHolder. setDbType(DataSourceContextHolder.SESSION_FACTORY_PRD1);
        int i = packBatchnoMapper.gouBaoConfirm(dd, id);
        return ServerResponse.createBySuccessMsg("成功确认" + i + "条");
    }

    @Override
    public ServerResponse getGouBaoData(String dd, String id) {
        DataSourceContextHolder. setDbType(DataSourceContextHolder.SESSION_FACTORY_PRD1);
        List<GouBaoDataVo> gouBaoDataList = packBatchnoMapper.getGouBaoData(dd, id);
        return ServerResponse.createBySuccess(gouBaoDataList);
    }
}
