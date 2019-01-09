package com.management.pojo.wcs;

public class TaskOps {
    private String sn;

    private String guid;

    private String taskType;

    private String status;

    private String lineId;

    private String srcloc;

    private String dsloc;

    private String connbr;

    private String pri;

    private String mark;

    private String res1;

    private String timestampItf;

    private String timestampItfInsert;

    private String timestampTransInsert;

    private String heat;

    private String ordernbr;

    public TaskOps(String sn, String guid, String taskType, String status, String lineId, String srcloc, String dsloc, String connbr, String pri, String mark, String res1, String timestampItf, String timestampItfInsert, String timestampTransInsert, String heat, String ordernbr) {
        this.sn = sn;
        this.guid = guid;
        this.taskType = taskType;
        this.status = status;
        this.lineId = lineId;
        this.srcloc = srcloc;
        this.dsloc = dsloc;
        this.connbr = connbr;
        this.pri = pri;
        this.mark = mark;
        this.res1 = res1;
        this.timestampItf = timestampItf;
        this.timestampItfInsert = timestampItfInsert;
        this.timestampTransInsert = timestampTransInsert;
        this.heat = heat;
        this.ordernbr = ordernbr;
    }

    public TaskOps() {
        super();
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn == null ? null : sn.trim();
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid == null ? null : guid.trim();
    }

    public String getTaskType() {
        return taskType;
    }

    public void setTaskType(String taskType) {
        this.taskType = taskType == null ? null : taskType.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getLineId() {
        return lineId;
    }

    public void setLineId(String lineId) {
        this.lineId = lineId == null ? null : lineId.trim();
    }

    public String getSrcloc() {
        return srcloc;
    }

    public void setSrcloc(String srcloc) {
        this.srcloc = srcloc == null ? null : srcloc.trim();
    }

    public String getDsloc() {
        return dsloc;
    }

    public void setDsloc(String dsloc) {
        this.dsloc = dsloc == null ? null : dsloc.trim();
    }

    public String getConnbr() {
        return connbr;
    }

    public void setConnbr(String connbr) {
        this.connbr = connbr == null ? null : connbr.trim();
    }

    public String getPri() {
        return pri;
    }

    public void setPri(String pri) {
        this.pri = pri == null ? null : pri.trim();
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark == null ? null : mark.trim();
    }

    public String getRes1() {
        return res1;
    }

    public void setRes1(String res1) {
        this.res1 = res1 == null ? null : res1.trim();
    }

    public String getTimestampItf() {
        return timestampItf;
    }

    public void setTimestampItf(String timestampItf) {
        this.timestampItf = timestampItf == null ? null : timestampItf.trim();
    }

    public String getTimestampItfInsert() {
        return timestampItfInsert;
    }

    public void setTimestampItfInsert(String timestampItfInsert) {
        this.timestampItfInsert = timestampItfInsert == null ? null : timestampItfInsert.trim();
    }

    public String getTimestampTransInsert() {
        return timestampTransInsert;
    }

    public void setTimestampTransInsert(String timestampTransInsert) {
        this.timestampTransInsert = timestampTransInsert == null ? null : timestampTransInsert.trim();
    }

    public String getHeat() {
        return heat;
    }

    public void setHeat(String heat) {
        this.heat = heat == null ? null : heat.trim();
    }

    public String getOrdernbr() {
        return ordernbr;
    }

    public void setOrdernbr(String ordernbr) {
        this.ordernbr = ordernbr == null ? null : ordernbr.trim();
    }
}