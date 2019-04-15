package com.management.pojo.busi;

import java.util.Date;

public class BusiMessageWx {
    private Long id;

    private Integer qtyReceiptMouth;

    private Integer qtyDeliveryMouth;

    private Integer qtyDeliveryDay;

    private Integer qtyStock;

    private Integer qtyReceiptDay;

    private String dd;

    private Date adddate;

    private String addwho;

    private String remark;

    public BusiMessageWx(Long id, Integer qtyReceiptMouth, Integer qtyDeliveryMouth, Integer qtyDeliveryDay, Integer qtyStock, Integer qtyReceiptDay, String dd, Date adddate, String addwho, String remark) {
        this.id = id;
        this.qtyReceiptMouth = qtyReceiptMouth;
        this.qtyDeliveryMouth = qtyDeliveryMouth;
        this.qtyDeliveryDay = qtyDeliveryDay;
        this.qtyStock = qtyStock;
        this.qtyReceiptDay = qtyReceiptDay;
        this.dd = dd;
        this.adddate = adddate;
        this.addwho = addwho;
        this.remark = remark;
    }

    public BusiMessageWx() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getQtyReceiptMouth() {
        return qtyReceiptMouth;
    }

    public void setQtyReceiptMouth(Integer qtyReceiptMouth) {
        this.qtyReceiptMouth = qtyReceiptMouth;
    }

    public Integer getQtyDeliveryMouth() {
        return qtyDeliveryMouth;
    }

    public void setQtyDeliveryMouth(Integer qtyDeliveryMouth) {
        this.qtyDeliveryMouth = qtyDeliveryMouth;
    }

    public Integer getQtyDeliveryDay() {
        return qtyDeliveryDay;
    }

    public void setQtyDeliveryDay(Integer qtyDeliveryDay) {
        this.qtyDeliveryDay = qtyDeliveryDay;
    }

    public Integer getQtyStock() {
        return qtyStock;
    }

    public void setQtyStock(Integer qtyStock) {
        this.qtyStock = qtyStock;
    }

    public Integer getQtyReceiptDay() {
        return qtyReceiptDay;
    }

    public void setQtyReceiptDay(Integer qtyReceiptDay) {
        this.qtyReceiptDay = qtyReceiptDay;
    }

    public String getDd() {
        return dd;
    }

    public void setDd(String dd) {
        this.dd = dd == null ? null : dd.trim();
    }

    public Date getAdddate() {
        return adddate;
    }

    public void setAdddate(Date adddate) {
        this.adddate = adddate;
    }

    public String getAddwho() {
        return addwho;
    }

    public void setAddwho(String addwho) {
        this.addwho = addwho == null ? null : addwho.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}