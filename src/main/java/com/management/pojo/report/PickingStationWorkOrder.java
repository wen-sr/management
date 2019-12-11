package com.management.pojo.report;

import java.util.Date;

public class PickingStationWorkOrder {
    private Integer processingid;

    private String tasktype;

    private String taskguid;

    private String pickingstationcode;

    private Integer priority;

    private String taskstatus;

    private String containercode;

    private String ordercode;

    private String mergecontainersn;

    private Date createtime;

    private Date sendedtime;

    private Date repliedtime;

    private Date banktasktime;

    private String hangupflag;

    private String callbackflag;

    private String callbacktargetcontainercode;

    private String remark;

    public PickingStationWorkOrder(Integer processingid, String tasktype, String taskguid, String pickingstationcode, Integer priority, String taskstatus, String containercode, String ordercode, String mergecontainersn, Date createtime, Date sendedtime, Date repliedtime, Date banktasktime, String hangupflag, String callbackflag, String callbacktargetcontainercode, String remark) {
        this.processingid = processingid;
        this.tasktype = tasktype;
        this.taskguid = taskguid;
        this.pickingstationcode = pickingstationcode;
        this.priority = priority;
        this.taskstatus = taskstatus;
        this.containercode = containercode;
        this.ordercode = ordercode;
        this.mergecontainersn = mergecontainersn;
        this.createtime = createtime;
        this.sendedtime = sendedtime;
        this.repliedtime = repliedtime;
        this.banktasktime = banktasktime;
        this.hangupflag = hangupflag;
        this.callbackflag = callbackflag;
        this.callbacktargetcontainercode = callbacktargetcontainercode;
        this.remark = remark;
    }

    public PickingStationWorkOrder() {
        super();
    }

    public Integer getProcessingid() {
        return processingid;
    }

    public void setProcessingid(Integer processingid) {
        this.processingid = processingid;
    }

    public String getTasktype() {
        return tasktype;
    }

    public void setTasktype(String tasktype) {
        this.tasktype = tasktype == null ? null : tasktype.trim();
    }

    public String getTaskguid() {
        return taskguid;
    }

    public void setTaskguid(String taskguid) {
        this.taskguid = taskguid == null ? null : taskguid.trim();
    }

    public String getPickingstationcode() {
        return pickingstationcode;
    }

    public void setPickingstationcode(String pickingstationcode) {
        this.pickingstationcode = pickingstationcode == null ? null : pickingstationcode.trim();
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public String getTaskstatus() {
        return taskstatus;
    }

    public void setTaskstatus(String taskstatus) {
        this.taskstatus = taskstatus == null ? null : taskstatus.trim();
    }

    public String getContainercode() {
        return containercode;
    }

    public void setContainercode(String containercode) {
        this.containercode = containercode == null ? null : containercode.trim();
    }

    public String getOrdercode() {
        return ordercode;
    }

    public void setOrdercode(String ordercode) {
        this.ordercode = ordercode == null ? null : ordercode.trim();
    }

    public String getMergecontainersn() {
        return mergecontainersn;
    }

    public void setMergecontainersn(String mergecontainersn) {
        this.mergecontainersn = mergecontainersn == null ? null : mergecontainersn.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getSendedtime() {
        return sendedtime;
    }

    public void setSendedtime(Date sendedtime) {
        this.sendedtime = sendedtime;
    }

    public Date getRepliedtime() {
        return repliedtime;
    }

    public void setRepliedtime(Date repliedtime) {
        this.repliedtime = repliedtime;
    }

    public Date getBanktasktime() {
        return banktasktime;
    }

    public void setBanktasktime(Date banktasktime) {
        this.banktasktime = banktasktime;
    }

    public String getHangupflag() {
        return hangupflag;
    }

    public void setHangupflag(String hangupflag) {
        this.hangupflag = hangupflag == null ? null : hangupflag.trim();
    }

    public String getCallbackflag() {
        return callbackflag;
    }

    public void setCallbackflag(String callbackflag) {
        this.callbackflag = callbackflag == null ? null : callbackflag.trim();
    }

    public String getCallbacktargetcontainercode() {
        return callbacktargetcontainercode;
    }

    public void setCallbacktargetcontainercode(String callbacktargetcontainercode) {
        this.callbacktargetcontainercode = callbacktargetcontainercode == null ? null : callbacktargetcontainercode.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}