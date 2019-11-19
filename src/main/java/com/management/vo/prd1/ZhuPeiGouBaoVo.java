package com.management.vo.prd1;

import java.util.List;

/**
 * Author: wen-sir
 * Description:
 * DateCrated: 2019/8/26 14:45
 * Modified By：
 */
public class ZhuPeiGouBaoVo {
    private String doc_number;
    private String doc_consk;
    private String doc_shortname;
    private String doc_sku;
    private String doc_descr;
    private double doc_price;
    private Integer doc_cqty;
    private Integer doc_case_qty;
    //整包数
    private Integer zbs;
    //零册数
    private Integer lcs;
    //尾包件数
    private Integer wbjs;
    //尾包零册数
    private Integer wblcs;
    private List<ZhuPeiGouBaoVo> zhuPeiGouBaoVoList;
    private Integer caseQty;

    public double getDoc_price() {
        return doc_price;
    }

    public void setDoc_price(double doc_price) {
        this.doc_price = doc_price;
    }

    public Integer getCaseQty() {
        return caseQty;
    }

    public void setCaseQty(Integer caseQty) {
        this.caseQty = caseQty;
    }

    public Integer getWblcs() {
        return wblcs;
    }

    public void setWblcs(Integer wblcs) {
        this.wblcs = wblcs;
    }

    public Integer getWbjs() {
        return wbjs;
    }

    public void setWbjs(Integer wbjs) {
        this.wbjs = wbjs;
    }

    public List<ZhuPeiGouBaoVo> getZhuPeiGouBaoVoList() {
        return zhuPeiGouBaoVoList;
    }

    public void setZhuPeiGouBaoVoList(List<ZhuPeiGouBaoVo> zhuPeiGouBaoVoList) {
        this.zhuPeiGouBaoVoList = zhuPeiGouBaoVoList;
    }

    public String getDoc_number() {
        return doc_number;
    }

    public void setDoc_number(String doc_number) {
        this.doc_number = doc_number;
    }

    public String getDoc_consk() {
        return doc_consk;
    }

    public void setDoc_consk(String doc_consk) {
        this.doc_consk = doc_consk;
    }

    public String getDoc_shortname() {
        return doc_shortname;
    }

    public void setDoc_shortname(String doc_shortname) {
        this.doc_shortname = doc_shortname;
    }

    public String getDoc_sku() {
        return doc_sku;
    }

    public void setDoc_sku(String doc_sku) {
        this.doc_sku = doc_sku;
    }

    public String getDoc_descr() {
        return doc_descr;
    }

    public void setDoc_descr(String doc_descr) {
        this.doc_descr = doc_descr;
    }

    public Integer getDoc_cqty() {
        return doc_cqty;
    }

    public void setDoc_cqty(Integer doc_cqty) {
        this.doc_cqty = doc_cqty;
    }

    public Integer getDoc_case_qty() {
        return doc_case_qty;
    }

    public void setDoc_case_qty(Integer doc_case_qty) {
        this.doc_case_qty = doc_case_qty;
    }

    public Integer getZbs() {
        return zbs;
    }

    public void setZbs(Integer zbs) {
        this.zbs = zbs;
    }

    public Integer getLcs() {
        return lcs;
    }

    public void setLcs(Integer lcs) {
        this.lcs = lcs;
    }
}
