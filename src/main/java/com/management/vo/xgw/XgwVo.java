package com.management.vo.xgw;

import java.util.List;

public class XgwVo {

    private String doc_descr;
    private String doc_price;
    private Integer kd;
    private Integer ss;
    private Integer cy;
    private double cym;
    private String doc_number;
    private String consk;
    private String doc_shortname;
    private String barcode;
    private Integer qty;

    private List<XgwVo> xgwVoList;

    public List<XgwVo> getXgwVoList() {
        return xgwVoList;
    }

    public void setXgwVoList(List<XgwVo> xgwVoList) {
        this.xgwVoList = xgwVoList;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public String getConsk() {
        return consk;
    }

    public void setConsk(String consk) {
        this.consk = consk;
    }

    public String getDoc_shortname() {
        return doc_shortname;
    }

    public void setDoc_shortname(String doc_shortname) {
        this.doc_shortname = doc_shortname;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getDoc_number() {
        return doc_number;
    }

    public void setDoc_number(String doc_number) {
        this.doc_number = doc_number;
    }



    public String getDoc_descr() {
        return doc_descr;
    }

    public void setDoc_descr(String doc_descr) {
        this.doc_descr = doc_descr;
    }

    public String getDoc_price() {
        return doc_price;
    }

    public void setDoc_price(String doc_price) {
        this.doc_price = doc_price;
    }

    public Integer getKd() {
        return kd;
    }

    public void setKd(Integer kd) {
        this.kd = kd;
    }

    public Integer getSs() {
        return ss;
    }

    public void setSs(Integer ss) {
        this.ss = ss;
    }

    public Integer getCy() {
        return cy;
    }

    public void setCy(Integer cy) {
        this.cy = cy;
    }

    public double getCym() {
        return cym;
    }

    public void setCym(double cym) {
        this.cym = cym;
    }
}
