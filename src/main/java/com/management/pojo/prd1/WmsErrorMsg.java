package com.management.pojo.prd1;

import java.math.BigDecimal;

public class WmsErrorMsg {
    private Object ifKey;

    private Object ifMessage;

    private String adddate;

    private BigDecimal flag;

    public WmsErrorMsg(Object ifKey, Object ifMessage, String adddate, BigDecimal flag) {
        this.ifKey = ifKey;
        this.ifMessage = ifMessage;
        this.adddate = adddate;
        this.flag = flag;
    }

    public WmsErrorMsg() {
        super();
    }

    public Object getIfKey() {
        return ifKey;
    }

    public void setIfKey(Object ifKey) {
        this.ifKey = ifKey;
    }

    public Object getIfMessage() {
        return ifMessage;
    }

    public void setIfMessage(Object ifMessage) {
        this.ifMessage = ifMessage;
    }

    public String getAdddate() {
        return adddate;
    }

    public void setAdddate(String adddate) {
        this.adddate = adddate == null ? null : adddate.trim();
    }

    public BigDecimal getFlag() {
        return flag;
    }

    public void setFlag(BigDecimal flag) {
        this.flag = flag;
    }
}