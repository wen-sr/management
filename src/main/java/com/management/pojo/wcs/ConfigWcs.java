package com.management.pojo.wcs;

public class ConfigWcs {
    private String paraName;

    private String paraValue;

    private String mark;

    private String updateTime;

    public ConfigWcs(String paraName, String paraValue, String mark, String updateTime) {
        this.paraName = paraName;
        this.paraValue = paraValue;
        this.mark = mark;
        this.updateTime = updateTime;
    }

    public ConfigWcs() {
        super();
    }

    public String getParaName() {
        return paraName;
    }

    public void setParaName(String paraName) {
        this.paraName = paraName == null ? null : paraName.trim();
    }

    public String getParaValue() {
        return paraValue;
    }

    public void setParaValue(String paraValue) {
        this.paraValue = paraValue == null ? null : paraValue.trim();
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark == null ? null : mark.trim();
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime == null ? null : updateTime.trim();
    }
}