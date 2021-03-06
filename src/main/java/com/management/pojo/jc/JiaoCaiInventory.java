package com.management.pojo.jc;

public class JiaoCaiInventory {
    private Long id;

    private String issuenumber;

    private String subcode;

    private Integer qtyreceipt;

    private Integer qtyallocated;

    private Integer qtyshipped;

    private Integer qtyfree;

    public JiaoCaiInventory(Long id, String issuenumber, String subcode, Integer qtyreceipt, Integer qtyallocated, Integer qtyshipped, Integer qtyfree) {
        this.id = id;
        this.issuenumber = issuenumber;
        this.subcode = subcode;
        this.qtyreceipt = qtyreceipt;
        this.qtyallocated = qtyallocated;
        this.qtyshipped = qtyshipped;
        this.qtyfree = qtyfree;
    }

    public JiaoCaiInventory(String issuenumber, String subcode) {
        this.issuenumber = issuenumber;
        this.subcode = subcode;
    }

    public JiaoCaiInventory() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Integer getQtyreceipt() {
        return qtyreceipt;
    }

    public void setQtyreceipt(Integer qtyreceipt) {
        this.qtyreceipt = qtyreceipt;
    }

    public Integer getQtyallocated() {
        return qtyallocated;
    }

    public void setQtyallocated(Integer qtyallocated) {
        this.qtyallocated = qtyallocated;
    }

    public Integer getQtyshipped() {
        return qtyshipped;
    }

    public void setQtyshipped(Integer qtyshipped) {
        this.qtyshipped = qtyshipped;
    }

    public Integer getQtyfree() {
        return qtyfree;
    }

    public void setQtyfree(Integer qtyfree) {
        this.qtyfree = qtyfree;
    }
}