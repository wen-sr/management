package com.management.pojo.jc;

import java.util.Date;

public class JiaoCaiTaskDetail {
    private Integer id;

    private String taskType;

    private String issuenumber;

    private String subcode;

    private Integer pack;

    private Integer qty;

    private String fromloc;

    private String fromid;

    private String toloc;

    private String toid;

    private String taskid;

    private String addwho;

    private Date adddate;

    private String status;

    private String editwho;

    private Date editdate;

    public JiaoCaiTaskDetail(Integer id, String taskType, String issuenumber, String subcode, Integer pack, Integer qty, String fromloc, String fromid, String toloc, String toid, String taskid, String addwho, Date adddate, String status, String editwho, Date editdate) {
        this.id = id;
        this.taskType = taskType;
        this.issuenumber = issuenumber;
        this.subcode = subcode;
        this.pack = pack;
        this.qty = qty;
        this.fromloc = fromloc;
        this.fromid = fromid;
        this.toloc = toloc;
        this.toid = toid;
        this.taskid = taskid;
        this.addwho = addwho;
        this.adddate = adddate;
        this.status = status;
        this.editwho = editwho;
        this.editdate = editdate;
    }

    public JiaoCaiTaskDetail() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTaskType() {
        return taskType;
    }

    public void setTaskType(String taskType) {
        this.taskType = taskType == null ? null : taskType.trim();
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

    public Integer getPack() {
        return pack;
    }

    public void setPack(Integer pack) {
        this.pack = pack;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public String getFromloc() {
        return fromloc;
    }

    public void setFromloc(String fromloc) {
        this.fromloc = fromloc == null ? null : fromloc.trim();
    }

    public String getFromid() {
        return fromid;
    }

    public void setFromid(String fromid) {
        this.fromid = fromid == null ? null : fromid.trim();
    }

    public String getToloc() {
        return toloc;
    }

    public void setToloc(String toloc) {
        this.toloc = toloc == null ? null : toloc.trim();
    }

    public String getToid() {
        return toid;
    }

    public void setToid(String toid) {
        this.toid = toid == null ? null : toid.trim();
    }

    public String getTaskid() {
        return taskid;
    }

    public void setTaskid(String taskid) {
        this.taskid = taskid == null ? null : taskid.trim();
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getEditwho() {
        return editwho;
    }

    public void setEditwho(String editwho) {
        this.editwho = editwho == null ? null : editwho.trim();
    }

    public Date getEditdate() {
        return editdate;
    }

    public void setEditdate(Date editdate) {
        this.editdate = editdate;
    }
}