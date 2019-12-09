package com.management.dao.wcs;

import com.management.pojo.wcs.StockMiniload;
import com.management.vo.wcs.LocQtyVo;

import java.util.List;

public interface StockMiniloadMapper {
    int deleteByPrimaryKey(String locnId);

    int insert(StockMiniload record);

    int insertSelective(StockMiniload record);

    StockMiniload selectByPrimaryKey(String locnId);

    int updateByPrimaryKeySelective(StockMiniload record);

    int updateByPrimaryKey(StockMiniload record);

    StockMiniload selectBycontainerCodeTmp(String boxno);


    /*********************gan hong add*******************/
    List<StockMiniload> getStockMiniloadData(StockMiniload stockMiniload);//返回值是列表
    List<StockMiniload> getStockMiniloadData1(StockMiniload stockMiniload);
    List<LocQtyVo> getStockMiniloadData2(List<Long> stockMiniload);//复选框 返回值是int是一个值
    List<LocQtyVo> getStockMiniloadData3(List<Long> stockMiniload);
    //返回值是列表并且值是应用了LocQtyVo里面的,所以填<LocQtyVo>
    /*********************gan hong add*******************/
}