package com.management.pojo.led;

import java.math.BigDecimal;

public class ShangJiaRKLed {
    private String dd;

    private String status;

    private BigDecimal qty;

    private BigDecimal countboxno;

    public ShangJiaRKLed(String dd, String status, BigDecimal qty, BigDecimal countboxno) {
        this.dd = dd;
        this.status = status;
        this.qty = qty;
        this.countboxno = countboxno;
    }

    public ShangJiaRKLed() {
        super();
    }

    public String getDd() {
        return dd;
    }

    public void setDd(String dd) {
        this.dd = dd == null ? null : dd.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public BigDecimal getQty() {
        return qty;
    }

    public void setQty(BigDecimal qty) {
        this.qty = qty;
    }

    public BigDecimal getCountboxno() {
        return countboxno;
    }

    public void setCountboxno(BigDecimal countboxno) {
        this.countboxno = countboxno;
    }
}