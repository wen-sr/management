package com.management.pojo.jc;

import java.math.BigDecimal;

public class AllowDistribution {
    private String issuenumber;

    private String subcode;

    private String barcode;

    private String descr;

    private BigDecimal price;

    private Integer qtyfree;

    private String publisher;

    private String shortname;

    public AllowDistribution(String issuenumber, String subcode, String barcode, String descr, BigDecimal price, Integer qtyfree, String publisher, String shortname) {
        this.issuenumber = issuenumber;
        this.subcode = subcode;
        this.barcode = barcode;
        this.descr = descr;
        this.price = price;
        this.qtyfree = qtyfree;
        this.publisher = publisher;
        this.shortname = shortname;
    }

    public AllowDistribution() {
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

    public Integer getQtyfree() {
        return qtyfree;
    }

    public void setQtyfree(Integer qtyfree) {
        this.qtyfree = qtyfree;
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
}