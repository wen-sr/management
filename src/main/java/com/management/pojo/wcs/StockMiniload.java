package com.management.pojo.wcs;

public class StockMiniload {
    private String locnId;

    private String bankLocn;

    private String bankId;

    private String bankRow;

    private String bankLayer;

    private String bankColumn;

    private String unit;

    private String locnSeial;

    private String lockStatus;

    private String validStatus;

    private String insertDate;

    private String containerCode;

    private String containerCodeTmp;

    private String area;

    private String weight;

    private String activ;

    public StockMiniload(String locnId, String bankLocn, String bankId, String bankRow, String bankLayer, String bankColumn, String unit, String locnSeial, String lockStatus, String validStatus, String insertDate, String containerCode, String containerCodeTmp, String area, String weight, String activ) {
        this.locnId = locnId;
        this.bankLocn = bankLocn;
        this.bankId = bankId;
        this.bankRow = bankRow;
        this.bankLayer = bankLayer;
        this.bankColumn = bankColumn;
        this.unit = unit;
        this.locnSeial = locnSeial;
        this.lockStatus = lockStatus;
        this.validStatus = validStatus;
        this.insertDate = insertDate;
        this.containerCode = containerCode;
        this.containerCodeTmp = containerCodeTmp;
        this.area = area;
        this.weight = weight;
        this.activ = activ;
    }

    public StockMiniload() {
        super();
    }

    public String getLocnId() {
        return locnId;
    }

    public void setLocnId(String locnId) {
        this.locnId = locnId == null ? null : locnId.trim();
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

    public String getBankRow() {
        return bankRow;
    }

    public void setBankRow(String bankRow) {
        this.bankRow = bankRow == null ? null : bankRow.trim();
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

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit == null ? null : unit.trim();
    }

    public String getLocnSeial() {
        return locnSeial;
    }

    public void setLocnSeial(String locnSeial) {
        this.locnSeial = locnSeial == null ? null : locnSeial.trim();
    }

    public String getLockStatus() {
        return lockStatus;
    }

    public void setLockStatus(String lockStatus) {
        this.lockStatus = lockStatus == null ? null : lockStatus.trim();
    }

    public String getValidStatus() {
        return validStatus;
    }

    public void setValidStatus(String validStatus) {
        this.validStatus = validStatus == null ? null : validStatus.trim();
    }

    public String getInsertDate() {
        return insertDate;
    }

    public void setInsertDate(String insertDate) {
        this.insertDate = insertDate == null ? null : insertDate.trim();
    }

    public String getContainerCode() {
        return containerCode;
    }

    public void setContainerCode(String containerCode) {
        this.containerCode = containerCode == null ? null : containerCode.trim();
    }

    public String getContainerCodeTmp() {
        return containerCodeTmp;
    }

    public void setContainerCodeTmp(String containerCodeTmp) {
        this.containerCodeTmp = containerCodeTmp == null ? null : containerCodeTmp.trim();
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area == null ? null : area.trim();
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight == null ? null : weight.trim();
    }

    public String getActiv() {
        return activ;
    }

    public void setActiv(String activ) {
        this.activ = activ == null ? null : activ.trim();
    }
}