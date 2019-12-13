package com.management.pojo.led;

import java.math.BigDecimal;

public class ZanCunRkLed {
    private String dd;

    private String idstatus;

    private BigDecimal countid;

    public ZanCunRkLed(String dd, String idstatus, BigDecimal countid) {
        this.dd = dd;
        this.idstatus = idstatus;
        this.countid = countid;
    }

    public ZanCunRkLed() {
        super();
    }

    public String getDd() {
        return dd;
    }

    public void setDd(String dd) {
        this.dd = dd == null ? null : dd.trim();
    }

    public String getIdstatus() {
        return idstatus;
    }

    public void setIdstatus(String idstatus) {
        this.idstatus = idstatus == null ? null : idstatus.trim();
    }

    public BigDecimal getCountid() {
        return countid;
    }

    public void setCountid(BigDecimal countid) {
        this.countid = countid;
    }
}