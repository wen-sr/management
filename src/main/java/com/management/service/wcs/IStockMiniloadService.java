package com.management.service.wcs;

import com.management.common.ServerResponse;
import com.management.pojo.wcs.StockMiniload;

import java.util.List;

public interface IStockMiniloadService {
    StockMiniload selectByBoxno(String boxno);

    /************ganhong add*****************/
    ServerResponse getStockMiniloadData(StockMiniload stockMiniload);
    ServerResponse getStockMiniloadData1(StockMiniload stockMiniload);
    ServerResponse getStockMiniloadData2(List<Long> stockMiniload);
    ServerResponse getStockMiniloadData3(List<Long> stockMiniload);
    /************ganhong add*****************/
}
