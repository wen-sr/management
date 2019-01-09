package com.management.dao.wcs;

import com.management.pojo.wcs.StockMiniload;

public interface StockMiniloadMapper {
    int deleteByPrimaryKey(String locnId);

    int insert(StockMiniload record);

    int insertSelective(StockMiniload record);

    StockMiniload selectByPrimaryKey(String locnId);

    int updateByPrimaryKeySelective(StockMiniload record);

    int updateByPrimaryKey(StockMiniload record);

    StockMiniload selectBycontainerCodeTmp(String boxno);
}