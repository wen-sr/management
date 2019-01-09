package com.management.service.wcs.impl;

import com.management.dao.wcs.StockMiniloadMapper;
import com.management.pojo.wcs.StockMiniload;
import com.management.service.wcs.IStockMiniloadService;
import com.management.util.DataSourceContextHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
