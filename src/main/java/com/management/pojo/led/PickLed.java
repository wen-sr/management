package com.management.pojo.led;

import java.math.BigDecimal;

public class PickLed {
    private String employeename;

    private String operationtime;

    private Integer count;

    private Integer ordercode;

    private BigDecimal efficiency;

    public PickLed(String employeename, String operationtime, Integer count, Integer ordercode, BigDecimal efficiency) {
        this.employeename = employeename;
        this.operationtime = operationtime;
        this.count = count;
        this.ordercode = ordercode;
        this.efficiency = efficiency;
    }

    public PickLed() {
        super();
    }

    public String getEmployeename() {
        return employeename;
    }

    public void setEmployeename(String employeename) {
        this.employeename = employeename == null ? null : employeename.trim();
    }

    public String getOperationtime() {
        return operationtime;
    }

    public void setOperationtime(String operationtime) {
        this.operationtime = operationtime == null ? null : operationtime.trim();
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getOrdercode() {
        return ordercode;
    }

    public void setOrdercode(Integer ordercode) {
        this.ordercode = ordercode;
    }

    public BigDecimal getEfficiency() {
        return efficiency;
    }

    public void setEfficiency(BigDecimal efficiency) {
        this.efficiency = efficiency;
    }
}