package com.management.pojo.jc;

import java.math.BigDecimal;

public class AllowAllocate {
    private String issuenumber;

    private String subcode;

    private String barcode;

    private BigDecimal price;

    private String descr;

    private String storerkey;

    private String shortname;

    private Integer qtyreceipt;

    private Integer qtyfree;

    private Integer qtyallocated;

    private Integer allowallocate;

    public AllowAllocate(String issuenumber, String subcode, String barcode, BigDecimal price, String descr, String storerkey, String shortname, Integer qtyreceipt, Integer qtyfree, Integer qtyallocated, Integer allowallocate) {
        this.issuenumber = issuenumber;
        this.subcode = subcode;
        this.barcode = barcode;
        this.price = price;
        this.descr = descr;
        this.storerkey = storerkey;
        this.shortname = shortname;
        this.qtyreceipt = qtyreceipt;
        this.qtyfree = qtyfree;
        this.qtyallocated = qtyallocated;
        this.allowallocate = allowallocate;
    }

    public AllowAllocate() {
        super();
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

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode == null ? null : barcode.trim();
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr == null ? null : descr.trim();
    }

    public String getStorerkey() {
        return storerkey;
    }

    public void setStorerkey(String storerkey) {
        this.storerkey = storerkey == null ? null : storerkey.trim();
    }

    public String getShortname() {
        return shortname;
    }

    public void setShortname(String shortname) {
        this.shortname = shortname == null ? null : shortname.trim();
    }

    public Integer getQtyreceipt() {
        return qtyreceipt;
    }

    public void setQtyreceipt(Integer qtyreceipt) {
        this.qtyreceipt = qtyreceipt;
    }

    public Integer getQtyfree() {
        return qtyfree;
    }

    public void setQtyfree(Integer qtyfree) {
        this.qtyfree = qtyfree;
    }

    public Integer getQtyallocated() {
        return qtyallocated;
    }

    public void setQtyallocated(Integer qtyallocated) {
        this.qtyallocated = qtyallocated;
    }

    public Integer getAllowallocate() {
        return allowallocate;
    }

    public void setAllowallocate(Integer allowallocate) {
        this.allowallocate = allowallocate;
    }
}