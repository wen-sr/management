package com.management.service.wcs.impl;

import com.management.common.ServerResponse;
import com.management.dao.wcs.StockMiniloadMapper;
import com.management.pojo.wcs.StockMiniload;
import com.management.service.wcs.IStockMiniloadService;
import com.management.util.DataSourceContextHolder;
import com.management.vo.wcs.LocQtyVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockMiniloadServiceImpl implements IStockMiniloadService {

    @Autowired
    StockMiniloadMapper stockMiniloadMapper;

    @Override
    public StockMiniload selectByBoxno(String boxno) {
        DataSourceContextHolder. setDbType(DataSourceContextHolder.SESSION_FACTORY_WCS);
        StockMiniload stockMiniload = stockMiniloadMapper.selectBycontainerCodeTmp(boxno.toUpperCase());
        return stockMiniload;
    }

    @Override
    public ServerResponse getStockMiniloadData(StockMiniload stockMiniload){
        DataSourceContextHolder.setDbType(DataSourceContextHolder.SESSION_FACTORY_WCS);
        List<StockMiniload> stockMiniloadList = stockMiniloadMapper.getStockMiniloadData(stockMiniload);
        return ServerResponse.createBySuccess("查询成功", stockMiniloadList);
    }
    @Override
    public ServerResponse getStockMiniloadData1(StockMiniload stockMiniload){
        DataSourceContextHolder.setDbType(DataSourceContextHolder.SESSION_FACTORY_WCS);
        List<StockMiniload> stockMiniloadList = stockMiniloadMapper.getStockMiniloadData1(stockMiniload);
        return ServerResponse.createBySuccess("查询成功", stockMiniloadList);
    }
    @Override
    public ServerResponse getStockMiniloadData2(List<Long> ids){
        DataSourceContextHolder.setDbType(DataSourceContextHolder.SESSION_FACTORY_WCS);
        List<LocQtyVo> locQtyVoList = stockMiniloadMapper.getStockMiniloadData2(ids);
        return ServerResponse.createBySuccess("查询成功", locQtyVoList);
    }
    @Override
    public ServerResponse getStockMiniloadData3(List<Long> ids1){
        DataSourceContextHolder.setDbType(DataSourceContextHolder.SESSION_FACTORY_WCS);
        List<LocQtyVo> locQtyVoList = stockMiniloadMapper.getStockMiniloadData3(ids1);//注意List<LocQtyVo>
        return ServerResponse.createBySuccess("查询成功", locQtyVoList);
    }
}
