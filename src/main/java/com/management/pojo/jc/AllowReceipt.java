package com.management.pojo.jc;

import java.math.BigDecimal;

public class AllowReceipt {
    private String issuenumber;

    private String subcode;

    private String barcode;

    private String descr;

    private BigDecimal price;

    private String publisher;

    private String shortname;

    private Integer orderqty;

    private Integer qtyreceipt;

    private Integer qty;

    public AllowReceipt(String issuenumber, String subcode, String barcode, String descr, BigDecimal price, String publisher, String shortname, Integer orderqty, Integer qtyreceipt, Integer qty) {
        this.issuenumber = issuenumber;
        this.subcode = subcode;
        this.barcode = barcode;
        this.descr = descr;
        this.price = price;
        this.publisher = publisher;
        this.shortname = shortname;
        this.orderqty = orderqty;
        this.qtyreceipt = qtyreceipt;
        this.qty = qty;
    }

    public AllowReceipt() {
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

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr == null ? null : descr.trim();
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher == null ? null : publisher.trim();
    }

    public String getShortname() {
        return shortname;
    }

    public void setShortname(String shortname) {
        this.shortname = shortname == null ? null : shortname.trim();
    }

    public Integer getOrderqty() {
        return orderqty;
    }

    public void setOrderqty(Integer orderqty) {
        this.orderqty = orderqty;
    }

    public Integer getQtyreceipt() {
        return qtyreceipt;
    }

    public void setQtyreceipt(Integer qtyreceipt) {
        this.qtyreceipt = qtyreceipt;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }
}