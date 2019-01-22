package com.management.pojo.jc;

import java.util.Date;

public class JiaoCaiOrders {
    private Long id;

    private String issuenumber;

    private String subcode;

    private Integer orderqty;

    private String addwho;

    private Date adddate;

    private String editwho;

    private Date editdate;

    private String order;

    public JiaoCaiOrders(Long id, String issuenumber, String subcode, Integer orderqty, String addwho, Date adddate, String editwho, Date editdate, String order) {
        this.id = id;
        this.issuenumber = issuenumber;
        this.subcode = subcode;
        this.orderqty = orderqty;
        this.addwho = addwho;
        this.adddate = adddate;
        this.editwho = editwho;
        this.editdate = editdate;
        this.order = order;
    }

    public JiaoCaiOrders() {
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

    public Date getAdddate() {
        return adddate;
    }

    public void setAdddate(Date adddate) {
        this.adddate = adddate;
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

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order == null ? null : order.trim();
    }
}