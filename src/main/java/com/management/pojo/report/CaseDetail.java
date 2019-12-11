package com.management.pojo.report;

import java.math.BigDecimal;
import java.util.Date;

public class CaseDetail {
    private String fromtable;

    private String fromtype;

    private String caseid;

    private String caseidBak;

    private String linenumber;

    private String packid;

    private String pickdetailkey;

    private String storerkey;

    private Short type;

    private String docNumber;

    private String sku;

    private Short qty;

    private String seq;

    private BigDecimal price;

    private BigDecimal discount;

    private BigDecimal amt;

    private BigDecimal net;

    private BigDecimal netweight;

    private BigDecimal volume;

    private String susr1;

    private String susr2;

    private String susr3;

    private String susr4;

    private String susr5;

    private Date adddate;

    private String addwho;

    private Date editdate;

    private String editwho;

    private String pickno;

    private String orderkey;

    public CaseDetail(String fromtable, String fromtype, String caseid, String caseidBak, String linenumber, String packid, String pickdetailkey, String storerkey, Short type, String docNumber, String sku, Short qty, String seq, BigDecimal price, BigDecimal discount, BigDecimal amt, BigDecimal net, BigDecimal netweight, BigDecimal volume, String susr1, String susr2, String susr3, String susr4, String susr5, Date adddate, String addwho, Date editdate, String editwho, String pickno, String orderkey) {
        this.fromtable = fromtable;
        this.fromtype = fromtype;
        this.caseid = caseid;
        this.caseidBak = caseidBak;
        this.linenumber = linenumber;
        this.packid = packid;
        this.pickdetailkey = pickdetailkey;
        this.storerkey = storerkey;
        this.type = type;
        this.docNumber = docNumber;
        this.sku = sku;
        this.qty = qty;
        this.seq = seq;
        this.price = price;
        this.discount = discount;
        this.amt = amt;
        this.net = net;
        this.netweight = netweight;
        this.volume = volume;
        this.susr1 = susr1;
        this.susr2 = susr2;
        this.susr3 = susr3;
        this.susr4 = susr4;
        this.susr5 = susr5;
        this.adddate = adddate;
        this.addwho = addwho;
        this.editdate = editdate;
        this.editwho = editwho;
        this.pickno = pickno;
        this.orderkey = orderkey;
    }

    public CaseDetail() {
        super();
    }

    public String getFromtable() {
        return fromtable;
    }

    public void setFromtable(String fromtable) {
        this.fromtable = fromtable == null ? null : fromtable.trim();
    }

    public String getFromtype() {
        return fromtype;
    }

    public void setFromtype(String fromtype) {
        this.fromtype = fromtype == null ? null : fromtype.trim();
    }

    public String getCaseid() {
        return caseid;
    }

    public void setCaseid(String caseid) {
        this.caseid = caseid == null ? null : caseid.trim();
    }

    public String getCaseidBak() {
        return caseidBak;
    }

    public void setCaseidBak(String caseidBak) {
        this.caseidBak = caseidBak == null ? null : caseidBak.trim();
    }

    public String getLinenumber() {
        return linenumber;
    }

    public void setLinenumber(String linenumber) {
        this.linenumber = linenumber == null ? null : linenumber.trim();
    }

    public String getPackid() {
        return packid;
    }

    public void setPackid(String packid) {
        this.packid = packid == null ? null : packid.trim();
    }

    public String getPickdetailkey() {
        return pickdetailkey;
    }

    public void setPickdetailkey(String pickdetailkey) {
        this.pickdetailkey = pickdetailkey == null ? null : pickdetailkey.trim();
    }

    public String getStorerkey() {
        return storerkey;
    }

    public void setStorerkey(String storerkey) {
        this.storerkey = storerkey == null ? null : storerkey.trim();
    }

    public Short getType() {
        return type;
    }

    public void setType(Short type) {
        this.type = type;
    }

    public String getDocNumber() {
        return docNumber;
    }

    public void setDocNumber(String docNumber) {
        this.docNumber = docNumber == null ? null : docNumber.trim();
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku == null ? null : sku.trim();
    }

    public Short getQty() {
        return qty;
    }

    public void setQty(Short qty) {
        this.qty = qty;
    }

    public String getSeq() {
        return seq;
    }

    public void setSeq(String seq) {
        this.seq = seq == null ? null : seq.trim();
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public BigDecimal getAmt() {
        return amt;
    }

    public void setAmt(BigDecimal amt) {
        this.amt = amt;
    }

    public BigDecimal getNet() {
        return net;
    }

    public void setNet(BigDecimal net) {
        this.net = net;
    }

    public BigDecimal getNetweight() {
        return netweight;
    }

    public void setNetweight(BigDecimal netweight) {
        this.netweight = netweight;
    }

    public BigDecimal getVolume() {
        return volume;
    }

    public void setVolume(BigDecimal volume) {
        this.volume = volume;
    }

    public String getSusr1() {
        return susr1;
    }

    public void setSusr1(String susr1) {
        this.susr1 = susr1 == null ? null : susr1.trim();
    }

    public String getSusr2() {
        return susr2;
    }

    public void setSusr2(String susr2) {
        this.susr2 = susr2 == null ? null : susr2.trim();
    }

    public String getSusr3() {
        return susr3;
    }

    public void setSusr3(String susr3) {
        this.susr3 = susr3 == null ? null : susr3.trim();
    }

    public String getSusr4() {
        return susr4;
    }

    public void setSusr4(String susr4) {
        this.susr4 = susr4 == null ? null : susr4.trim();
    }

    public String getSusr5() {
        return susr5;
    }

    public void setSusr5(String susr5) {
        this.susr5 = susr5 == null ? null : susr5.trim();
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

    public Date getEditdate() {
        return editdate;
    }

    public void setEditdate(Date editdate) {
        this.editdate = editdate;
    }

    public String getEditwho() {
        return editwho;
    }

    public void setEditwho(String editwho) {
        this.editwho = editwho == null ? null : editwho.trim();
    }

    public String getPickno() {
        return pickno;
    }

    public void setPickno(String pickno) {
        this.pickno = pickno == null ? null : pickno.trim();
    }

    public String getOrderkey() {
        return orderkey;
    }

    public void setOrderkey(String orderkey) {
        this.orderkey = orderkey == null ? null : orderkey.trim();
    }
}