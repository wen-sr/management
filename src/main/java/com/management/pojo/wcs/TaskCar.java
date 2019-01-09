package com.management.pojo.wcs;

public class TaskCar {
    private String guid;

    private String taskType;

    private String status;

    private String bankLocn;

    private String bankId;

    private String bankLayer;

    private String bankColumn;

    private String sourcelayer;

    private String sourceaddress;

    private String targetlayer;

    private String targetaddress;

    private String containercode;

    private String ret;

    private String mark;

    private String timestampInsert;

    public TaskCar(String guid, String taskType, String status, String bankLocn, String bankId, String bankLayer, String bankColumn, String sourcelayer, String sourceaddress, String targetlayer, String targetaddress, String containercode, String ret, String mark, String timestampInsert) {
        this.guid = guid;
        this.taskType = taskType;
        this.status = status;
        this.bankLocn = bankLocn;
        this.bankId = bankId;
        this.bankLayer = bankLayer;
        this.bankColumn = bankColumn;
        this.sourcelayer = sourcelayer;
        this.sourceaddress = sourceaddress;
        this.targetlayer = targetlayer;
        this.targetaddress = targetaddress;
        this.containercode = containercode;
        this.ret = ret;
        this.mark = mark;
        this.timestampInsert = timestampInsert;
    }

    public TaskCar() {
        super();
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

    public String getBankLocn() {
        return bankLocn;
    }

    public void setBankLocn(String bankLocn) {
        this.bankLocn = bankLocn == null ? null : bankLocn.trim();
    }

    public String getBankId() {
        return bankId;
    }

    public void setBankId(String bankId) {
        this.bankId = bankId == null ? null : bankId.trim();
    }

    public String getBankLayer() {
        return bankLayer;
    }

    public void setBankLayer(String bankLayer) {
        this.bankLayer = bankLayer == null ? null : bankLayer.trim();
    }

    public String getBankColumn() {
        return bankColumn;
    }

    public void setBankColumn(String bankColumn) {
        this.bankColumn = bankColumn == null ? null : bankColumn.trim();
    }

    public String getSourcelayer() {
        return sourcelayer;
    }

    public void setSourcelayer(String sourcelayer) {
        this.sourcelayer = sourcelayer == null ? null : sourcelayer.trim();
    }

    public String getSourceaddress() {
        return sourceaddress;
    }

    public void setSourceaddress(String sourceaddress) {
        this.sourceaddress = sourceaddress == null ? null : sourceaddress.trim();
    }

    public String getTargetlayer() {
        return targetlayer;
    }

    public void setTargetlayer(String targetlayer) {
        this.targetlayer = targetlayer == null ? null : targetlayer.trim();
    }

    public String getTargetaddress() {
        return targetaddress;
    }

    public void setTargetaddress(String targetaddress) {
        this.targetaddress = targetaddress == null ? null : targetaddress.trim();
    }

    public String getContainercode() {
        return containercode;
    }

    public void setContainercode(String containercode) {
        this.containercode = containercode == null ? null : containercode.trim();
    }

    public String getRet() {
        return ret;
    }

    public void setRet(String ret) {
        this.ret = ret == null ? null : ret.trim();
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark == null ? null : mark.trim();
    }

    public String getTimestampInsert() {
        return timestampInsert;
    }

    public void setTimestampInsert(String timestampInsert) {
        this.timestampInsert = timestampInsert == null ? null : timestampInsert.trim();
    }
}