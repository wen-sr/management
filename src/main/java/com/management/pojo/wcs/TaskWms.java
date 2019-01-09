package com.management.pojo.wcs;

public class TaskWms {
    private String sn;

    private String infid;

    private String msgid;

    private String connbr;

    private String ordernbr;

    private String stortype;

    private String tasktype;

    private String lineId;

    private String status;

    private String weight;

    private String srcloc;

    private String dsloc;

    private String heat;

    private String mark;

    private String res1;

    private String res2;

    private String timestampItf;

    private String timestampItfInsert;

    private String timestampTransInsert;

    private String stockLoc;

    public TaskWms(String sn, String infid, String msgid, String connbr, String ordernbr, String stortype, String tasktype, String lineId, String status, String weight, String srcloc, String dsloc, String heat, String mark, String res1, String res2, String timestampItf, String timestampItfInsert, String timestampTransInsert, String stockLoc) {
        this.sn = sn;
        this.infid = infid;
        this.msgid = msgid;
        this.connbr = connbr;
        this.ordernbr = ordernbr;
        this.stortype = stortype;
        this.tasktype = tasktype;
        this.lineId = lineId;
        this.status = status;
        this.weight = weight;
        this.srcloc = srcloc;
        this.dsloc = dsloc;
        this.heat = heat;
        this.mark = mark;
        this.res1 = res1;
        this.res2 = res2;
        this.timestampItf = timestampItf;
        this.timestampItfInsert = timestampItfInsert;
        this.timestampTransInsert = timestampTransInsert;
        this.stockLoc = stockLoc;
    }

    public TaskWms() {
        super();
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn == null ? null : sn.trim();
    }

    public String getInfid() {
        return infid;
    }

    public void setInfid(String infid) {
        this.infid = infid == null ? null : infid.trim();
    }

    public String getMsgid() {
        return msgid;
    }

    public void setMsgid(String msgid) {
        this.msgid = msgid == null ? null : msgid.trim();
    }

    public String getConnbr() {
        return connbr;
    }

    public void setConnbr(String connbr) {
        this.connbr = connbr == null ? null : connbr.trim();
    }

    public String getOrdernbr() {
        return ordernbr;
    }

    public void setOrdernbr(String ordernbr) {
        this.ordernbr = ordernbr == null ? null : ordernbr.trim();
    }

    public String getStortype() {
        return stortype;
    }

    public void setStortype(String stortype) {
        this.stortype = stortype == null ? null : stortype.trim();
    }

    public String getTasktype() {
        return tasktype;
    }

    public void setTasktype(String tasktype) {
        this.tasktype = tasktype == null ? null : tasktype.trim();
    }

    public String getLineId() {
        return lineId;
    }

    public void setLineId(String lineId) {
        this.lineId = lineId == null ? null : lineId.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight == null ? null : weight.trim();
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

    public String getHeat() {
        return heat;
    }

    public void setHeat(String heat) {
        this.heat = heat == null ? null : heat.trim();
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

    public String getRes2() {
        return res2;
    }

    public void setRes2(String res2) {
        this.res2 = res2 == null ? null : res2.trim();
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

    public String getStockLoc() {
        return stockLoc;
    }

    public void setStockLoc(String stockLoc) {
        this.stockLoc = stockLoc == null ? null : stockLoc.trim();
    }
}