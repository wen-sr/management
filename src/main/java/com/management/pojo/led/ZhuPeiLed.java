package com.management.pojo.led;

import java.math.BigDecimal;

public class ZhuPeiLed {
    private String ailid;

    private BigDecimal sorqty;

    private Integer skucount;

    private String dd;

    private BigDecimal efficiency;

    public ZhuPeiLed(String ailid, BigDecimal sorqty, Integer skucount, String dd, BigDecimal efficiency) {
        this.ailid = ailid;
        this.sorqty = sorqty;
        this.skucount = skucount;
        this.dd = dd;
        this.efficiency = efficiency;
    }

    public ZhuPeiLed() {
        super();
    }

    public String getAilid() {
        return ailid;
    }

    public void setAilid(String ailid) {
        this.ailid = ailid == null ? null : ailid.trim();
    }

    public BigDecimal getSorqty() {
        return sorqty;
    }

    public void setSorqty(BigDecimal sorqty) {
        this.sorqty = sorqty;
    }

    public Integer getSkucount() {
        return skucount;
    }

    public void setSkucount(Integer skucount) {
        this.skucount = skucount;
    }

    public String getDd() {
        return dd;
    }

    public void setDd(String dd) {
        this.dd = dd == null ? null : dd.trim();
    }

    public BigDecimal getEfficiency() {
        return efficiency;
    }

    public void setEfficiency(BigDecimal efficiency) {
        this.efficiency = efficiency;
    }
}