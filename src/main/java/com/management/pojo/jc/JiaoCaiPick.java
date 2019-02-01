package com.management.pojo.jc;

import java.util.Date;

public class JiaoCaiPick {
    private Long id;

    private Long distributeid;

    private String issuenumber;

    private String subcode;

    private Integer qty;

    private Integer qtypicked;

    private String status;

    private String loc;

    private String containerid;

    private Integer pack;

    private String batchno;

    private String pickno;

    private String sendcode;

    private Date senddate;

    private String addwho;

    private Date adddate;

    private String pickwho;

    private String pickdate;

    public JiaoCaiPick(Long id, Long distributeid, String issuenumber, String subcode, Integer qty, Integer qtypicked, String status, String loc, String containerid, Integer pack, String batchno, String pickno, String sendcode, Date senddate, String addwho, Date adddate, String pickwho, String pickdate) {
        this.id = id;
        this.distributeid = distributeid;
        this.issuenumber = issuenumber;
        this.subcode = subcode;
        this.qty = qty;
        this.qtypicked = qtypicked;
        this.status = status;
        this.loc = loc;
        this.containerid = containerid;
        this.pack = pack;
        this.batchno = batchno;
        this.pickno = pickno;
        this.sendcode = sendcode;
        this.senddate = senddate;
        this.addwho = addwho;
        this.adddate = adddate;
        this.pickwho = pickwho;
        this.pickdate = pickdate;
    }

    public JiaoCaiPick() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDistributeid() {
        return distributeid;
    }

    public void setDistributeid(Long distributeid) {
        this.distributeid = distributeid;
    }

    public String getIssuenumber() {
        return issuenumber;
    }

    public void setIssuenumber(String issuenumber) {
        this.issuenumber = issuenumber == null ? null : issuenumber.trim();
    }

    public String getSubcode() {
        return subcode;
    }

    public void setSubcode(String subcode) {
        this.subcode = subcode == null ? null : subcode.trim();
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public Integer getQtypicked() {
        return qtypicked;
    }

    public void setQtypicked(Integer qtypicked) {
        this.qtypicked = qtypicked;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc == null ? null : loc.trim();
    }

    public String getContainerid() {
        return containerid;
    }

    public void setContainerid(String containerid) {
        this.containerid = containerid == null ? null : containerid.trim();
    }

    public Integer getPack() {
        return pack;
    }

    public void setPack(Integer pack) {
        this.pack = pack;
    }

    public String getBatchno() {
        return batchno;
    }

    public void setBatchno(String batchno) {
        this.batchno = batchno == null ? null : batchno.trim();
    }

    public String getPickno() {
        return pickno;
    }

    public void setPickno(String pickno) {
        this.pickno = pickno == null ? null : pickno.trim();
    }

    public String getSendcode() {
        return sendcode;
    }

    public void setSendcode(String sendcode) {
        this.sendcode = sendcode == null ? null : sendcode.trim();
    }

    public Date getSenddate() {
        return senddate;
    }

    public void setSenddate(Date senddate) {
        this.senddate = senddate;
    }

    public String getAddwho() {
        return addwho;
    }

    public void setAddwho(String addwho) {
        this.addwho = addwho == null ? null : addwho.trim();
    }

    public Date getAdddate() {
        return adddate;
    }

    public void setAdddate(Date adddate) {
        this.adddate = adddate;
    }

    public String getPickwho() {
        return pickwho;
    }

    public void setPickwho(String pickwho) {
        this.pickwho = pickwho == null ? null : pickwho.trim();
    }

    public String getPickdate() {
        return pickdate;
    }

    public void setPickdate(String pickdate) {
        this.pickdate = pickdate == null ? null : pickdate.trim();
    }
}