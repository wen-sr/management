//可用于连表查询出来的结果,但是记得取别名
//利用alt+insert进入选择getting and setting自动生成
//StockMiniloadMapper里面的count(*)记得加上别名
package com.management.vo.wcs;

public class LocQtyVo {
    private String flag;
    private Integer locQty;

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public Integer getLocQty() {
        return locQty;
    }

    public void setLocQty(Integer locQty) {
        this.locQty = locQty;
    }
}
