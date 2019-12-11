package com.management.pojo.ops;

import java.util.Date;

public class ReContainerPickingShelfOrder {
    private String pickingresultcode;

    private String pickingstationcode;

    private String targetcontainercode;

    private String keycode;

    private String ordercode;

    private Integer taskid;

    private String taskguid;

    private String cargoid;

    private String quality;

    private Integer count;

    private String operator;

    private Date operationtime;

    private String mergesn;

    private String orderstatus;

    private Boolean allowmanualendcontainer;

    private Byte insertingplateinfo;

    public ReContainerPickingShelfOrder(String pickingresultcode, String pickingstationcode, String targetcontainercode, String keycode, String ordercode, Integer taskid, String taskguid, String cargoid, String quality, Integer count, String operator, Date operationtime, String mergesn, String orderstatus, Boolean allowmanualendcontainer, Byte insertingplateinfo) {
        this.pickingresultcode = pickingresultcode;
        this.pickingstationcode = pickingstationcode;
        this.targetcontainercode = targetcontainercode;
        this.keycode = keycode;
        this.ordercode = ordercode;
        this.taskid = taskid;
        this.taskguid = taskguid;
        this.cargoid = cargoid;
        this.quality = quality;
        this.count = count;
        this.operator = operator;
        this.operationtime = operationtime;
        this.mergesn = mergesn;
        this.orderstatus = orderstatus;
        this.allowmanualendcontainer = allowmanualendcontainer;
        this.insertingplateinfo = insertingplateinfo;
    }

    public ReContainerPickingShelfOrder() {
        super();
    }

    public String getPickingresultcode() {
        return pickingresultcode;
    }

    public void setPickingresultcode(String pickingresultcode) {
        this.pickingresultcode = pickingresultcode == null ? null : pickingresultcode.trim();
    }

    public String getPickingstationcode() {
        return pickingstationcode;
    }

    public void setPickingstationcode(String pickingstationcode) {
        this.pickingstationcode = pickingstationcode == null ? null : pickingstationcode.trim();
    }

    public String getTargetcontainercode() {
        return targetcontainercode;
    }

    public void setTargetcontainercode(String targetcontainercode) {
        this.targetcontainercode = targetcontainercode == null ? null : targetcontainercode.trim();
    }

    public String getKeycode() {
        return keycode;
    }

    public void setKeycode(String keycode) {
        this.keycode = keycode == null ? null : keycode.trim();
    }

    public String getOrdercode() {
        return ordercode;
    }

    public void setOrdercode(String ordercode) {
        this.ordercode = ordercode == null ? null : ordercode.trim();
    }

    public Integer getTaskid() {
        return taskid;
    }

    public void setTaskid(Integer taskid) {
        this.taskid = taskid;
    }

    public String getTaskguid() {
        return taskguid;
    }

    public void setTaskguid(String taskguid) {
        this.taskguid = taskguid == null ? null : taskguid.trim();
    }

    public String getCargoid() {
        return cargoid;
    }

    public void setCargoid(String cargoid) {
        this.cargoid = cargoid == null ? null : cargoid.trim();
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality == null ? null : quality.trim();
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator == null ? null : operator.trim();
    }

    public Date getOperationtime() {
        return operationtime;
    }

    public void setOperationtime(Date operationtime) {
        this.operationtime = operationtime;
    }

    public String getMergesn() {
        return mergesn;
    }

    public void setMergesn(String mergesn) {
        this.mergesn = mergesn == null ? null : mergesn.trim();
    }

    public String getOrderstatus() {
        return orderstatus;
    }

    public void setOrderstatus(String orderstatus) {
        this.orderstatus = orderstatus == null ? null : orderstatus.trim();
    }

    public Boolean getAllowmanualendcontainer() {
        return allowmanualendcontainer;
    }

    public void setAllowmanualendcontainer(Boolean allowmanualendcontainer) {
        this.allowmanualendcontainer = allowmanualendcontainer;
    }

    public Byte getInsertingplateinfo() {
        return insertingplateinfo;
    }

    public void setInsertingplateinfo(Byte insertingplateinfo) {
        this.insertingplateinfo = insertingplateinfo;
    }
}