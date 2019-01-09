package com.management.service.wcs;

import com.management.pojo.wcs.StockMiniload;

public interface IStockMiniloadService {
    StockMiniload selectByBoxno(String boxno);
}
