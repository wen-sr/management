package com.management.vo.jc;

import java.math.BigDecimal;

/**
 * Author: wen-sir
 * Description:
 * DateCrated: 2019/1/25 17:38
 * Modified By：
 */
public class JiaoCaiInventoryVo {
    private Long id;

    private String issuenumber;

    private String subcode;

    private Integer qtyreceipt = 0;

    private Integer qtyallocated = 0;

    private Integer qtyshipped = 0;

    private Integer qtyfree = 0;

    private Integer pack;

    private String loc;

    private String bk1;

    private String bk2;

    private String bk3;

    private String bk4;

    private String bk5;

    private String barcode;

    private String descr;

    private BigDecimal price;

    private String publisher;

    private String storerkey;

    private String toLoc;

    private String containerId;

    private String toContainerId;

    public String getToContainerId() {
        return toContainerId;
    }

    public void setToContainerId(String toContainerId) {
        this.toContainerId = toContainerId;
    }

    public String getContainerId() {
        return containerId;
    }

    public void setContainerId(String containerId) {
        this.containerId = containerId;
    }

    public String getToLoc() {
        return toLoc;
    }

    public void setToLoc(String toLoc) {
        this.toLoc = toLoc;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getStorerkey() {
        return storerkey;
    }

    public void setStorerkey(String storerkey) {
        this.storerkey = storerkey;
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
        this.issuenumber = issuenumber;
    }

    public String getSubcode() {
        return subcode;
    }

    public void setSubcode(String subcode) {
        this.subcode = subcode;
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

    public Integer getPack() {
        return pack;
    }

    public void setPack(Integer pack) {
        this.pack = pack;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    public String getBk1() {
        return bk1;
    }

    public void setBk1(String bk1) {
        this.bk1 = bk1;
    }

    public String getBk2() {
        return bk2;
    }

    public void setBk2(String bk2) {
        this.bk2 = bk2;
    }

    public String getBk3() {
        return bk3;
    }

    public void setBk3(String bk3) {
        this.bk3 = bk3;
    }

    public String getBk4() {
        return bk4;
    }

    public void setBk4(String bk4) {
        this.bk4 = bk4;
    }

    public String getBk5() {
        return bk5;
    }

    public void setBk5(String bk5) {
        this.bk5 = bk5;
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
}
