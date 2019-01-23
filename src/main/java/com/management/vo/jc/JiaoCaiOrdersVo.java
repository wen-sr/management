package com.management.vo.jc;

import java.math.BigDecimal;

public class JiaoCaiOrdersVo {
    private Long id;

    private String issuenumber;

    private String subcode;

    private String barcode;

    private String descr;

    private BigDecimal price;

    private Integer orderqty;

    private String addwho;

    private String adddate;

    private String editwho;

    private String editdate;

    private String publisher;

    private String shortname;

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getShortname() {
        return shortname;
    }

    public void setShortname(String shortname) {
        this.shortname = shortname;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getAdddate() {
        return adddate;
    }

    public void setAdddate(String adddate) {
        this.adddate = adddate;
    }

    public String getEditwho() {
        return editwho;
    }

    public void setEditwho(String editwho) {
        this.editwho = editwho;
    }

    public String getEditdate() {
        return editdate;
    }

    public void setEditdate(String editdate) {
        this.editdate = editdate;
    }

    private String orderNumber;

    public JiaoCaiOrdersVo(Long id, String issuenumber, String subcode, Integer orderqty, String addwho, String adddate, String editwho, String editdate, String order) {
        this.id = id;
        this.issuenumber = issuenumber;
        this.subcode = subcode;
        this.orderqty = orderqty;
        this.addwho = addwho;
        this.adddate = adddate;
        this.editwho = editwho;
        this.editdate = editdate;
        this.orderNumber = order;
    }

    public JiaoCaiOrdersVo() {
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

    public Integer getOrderqty() {
        return orderqty;
    }

    public void setOrderqty(Integer orderqty) {
        this.orderqty = orderqty;
    }

    public String getAddwho() {
        return addwho;
    }

    public void setAddwho(String addwho) {
        this.addwho = addwho == null ? null : addwho.trim();
    }


    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber == null ? null : orderNumber.trim();
    }
}