package com.management.pojo.jc;

import java.util.Date;

public class JiaoCaiTask {
    private Long id;

    private String infid;

    private String method;

    private String trkNo;

    private String tasktype;

    private String trkDesc;

    private String trkPrty;

    private String orderid;

    private String warehouseid;

    private String districtid;

    private String isback;

    private String trkSt;

    private String traycodes;

    private String needwinding;

    private String storetype;

    private String sendcode;

    private String sendmsg;

    private String retcode;

    private String retmsg;

    private Date rettime;

    private Date adddate;

    private String addwho;

    private String bk1;

    private String bk2;

    public JiaoCaiTask(Long id, String infid, String method, String trkNo, String tasktype, String trkDesc, String trkPrty, String orderid, String warehouseid, String districtid, String isback, String trkSt, String traycodes, String needwinding, String storetype, String sendcode, String sendmsg, String retcode, String retmsg, Date rettime, Date adddate, String addwho, String bk1, String bk2) {
        this.id = id;
        this.infid = infid;
        this.method = method;
        this.trkNo = trkNo;
        this.tasktype = tasktype;
        this.trkDesc = trkDesc;
        this.trkPrty = trkPrty;
        this.orderid = orderid;
        this.warehouseid = warehouseid;
        this.districtid = districtid;
        this.isback = isback;
        this.trkSt = trkSt;
        this.traycodes = traycodes;
        this.needwinding = needwinding;
        this.storetype = storetype;
        this.sendcode = sendcode;
        this.sendmsg = sendmsg;
        this.retcode = retcode;
        this.retmsg = retmsg;
        this.rettime = rettime;
        this.adddate = adddate;
        this.addwho = addwho;
        this.bk1 = bk1;
        this.bk2 = bk2;
    }

    public JiaoCaiTask() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInfid() {
        return infid;
    }

    public void setInfid(String infid) {
        this.infid = infid == null ? null : infid.trim();
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method == null ? null : method.trim();
    }

    public String getTrkNo() {
        return trkNo;
    }

    public void setTrkNo(String trkNo) {
        this.trkNo = trkNo == null ? null : trkNo.trim();
    }

    public String getTasktype() {
        return tasktype;
    }

    public void setTasktype(String tasktype) {
        this.tasktype = tasktype == null ? null : tasktype.trim();
    }

    public String getTrkDesc() {
        return trkDesc;
    }

    public void setTrkDesc(String trkDesc) {
        this.trkDesc = trkDesc == null ? null : trkDesc.trim();
    }

    public String getTrkPrty() {
        return trkPrty;
    }

    public void setTrkPrty(String trkPrty) {
        this.trkPrty = trkPrty == null ? null : trkPrty.trim();
    }

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid == null ? null : orderid.trim();
    }

    public String getWarehouseid() {
        return warehouseid;
    }

    public void setWarehouseid(String warehouseid) {
        this.warehouseid = warehouseid == null ? null : warehouseid.trim();
    }

    public String getDistrictid() {
        return districtid;
    }

    public void setDistrictid(String districtid) {
        this.districtid = districtid == null ? null : districtid.trim();
    }

    public String getIsback() {
        return isback;
    }

    public void setIsback(String isback) {
        this.isback = isback == null ? null : isback.trim();
    }

    public String getTrkSt() {
        return trkSt;
    }

    public void setTrkSt(String trkSt) {
        this.trkSt = trkSt == null ? null : trkSt.trim();
    }

    public String getTraycodes() {
        return traycodes;
    }

    public void setTraycodes(String traycodes) {
        this.traycodes = traycodes == null ? null : traycodes.trim();
    }

    public String getNeedwinding() {
        return needwinding;
    }

    public void setNeedwinding(String needwinding) {
        this.needwinding = needwinding == null ? null : needwinding.trim();
    }

    public String getStoretype() {
        return storetype;
    }

    public void setStoretype(String storetype) {
        this.storetype = storetype == null ? null : storetype.trim();
    }

    public String getSendcode() {
        return sendcode;
    }

    public void setSendcode(String sendcode) {
        this.sendcode = sendcode == null ? null : sendcode.trim();
    }

    public String getSendmsg() {
        return sendmsg;
    }

    public void setSendmsg(String sendmsg) {
        this.sendmsg = sendmsg == null ? null : sendmsg.trim();
    }

    public String getRetcode() {
        return retcode;
    }

    public void setRetcode(String retcode) {
        this.retcode = retcode == null ? null : retcode.trim();
    }

    public String getRetmsg() {
        return retmsg;
    }

    public void setRetmsg(String retmsg) {
        this.retmsg = retmsg == null ? null : retmsg.trim();
    }

    public Date getRettime() {
        return rettime;
    }

    public void setRettime(Date rettime) {
        this.rettime = rettime;
    }

    public Date getAdddate() {
        return adddate;
    }

    public void setAdddate(Date adddate) {
        this.adddate = adddate;
    }

    public String getAddwho() {
        return addwho;
    }

    public void setAddwho(String addwho) {
        this.addwho = addwho == null ? null : addwho.trim();
    }

    public String getBk1() {
        return bk1;
    }

    public void setBk1(String bk1) {
        this.bk1 = bk1 == null ? null : bk1.trim();
    }

    public String getBk2() {
        return bk2;
    }

    public void setBk2(String bk2) {
        this.bk2 = bk2 == null ? null : bk2.trim();
    }
}