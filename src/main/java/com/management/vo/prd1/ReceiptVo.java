package com.management.vo.prd1;

import java.math.BigDecimal;

/**
 * Author: wen-sir
 * Description:
 * DateCrated: 2019/3/13 15:57
 * Modified By：
 */
public class ReceiptVo {

    private String begin;
    private String end;
    private String shipno;
    private String organizationId;
    private String businessType;
    private String storerkey;
    private String shortname;
    private String caseQty;
    private String receiveDate;
    private String register;
    private String doc_company;
    private String doc_compname;
    private String doc_number;
    private String status;
    private BigDecimal doc_eqty;
    private BigDecimal doc_aqty;
    private String descr;
    private String barcode;
    private BigDecimal price;
    private BigDecimal diffQty;
    private String reason;

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getDiffQty() {
        return diffQty;
    }

    public void setDiffQty(BigDecimal diffQty) {
        this.diffQty = diffQty;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getDoc_company() {
        return doc_company;
    }

    public void setDoc_company(String doc_company) {
        this.doc_company = doc_company;
    }

    public String getDoc_compname() {
        return doc_compname;
    }

    public void setDoc_compname(String doc_compname) {
        this.doc_compname = doc_compname;
    }

    public String getDoc_number() {
        return doc_number;
    }

    public void setDoc_number(String doc_number) {
        this.doc_number = doc_number;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BigDecimal getDoc_eqty() {
        return doc_eqty;
    }

    public void setDoc_eqty(BigDecimal doc_eqty) {
        this.doc_eqty = doc_eqty;
    }

    public BigDecimal getDoc_aqty() {
        return doc_aqty;
    }

    public void setDoc_aqty(BigDecimal doc_aqty) {
        this.doc_aqty = doc_aqty;
    }

    public String getRegister() {
        return register;
    }

    public void setRegister(String register) {
        this.register = register;
    }

    public String getBegin() {
        return begin;
    }

    public void setBegin(String begin) {
        this.begin = begin;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getShipno() {
        return shipno;
    }

    public void setShipno(String shipno) {
        this.shipno = shipno;
    }

    public String getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(String organizationId) {
        this.organizationId = organizationId;
    }

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    public String getStorerkey() {
        return storerkey;
    }

    public void setStorerkey(String storerkey) {
        this.storerkey = storerkey;
    }

    public String getShortname() {
        return shortname;
    }

    public void setShortname(String shortname) {
        this.shortname = shortname;
    }

    public String getCaseQty() {
        return caseQty;
    }

    public void setCaseQty(String caseQty) {
        this.caseQty = caseQty;
    }

    public String getReceiveDate() {
        return receiveDate;
    }

    public void setReceiveDate(String receiveDate) {
        this.receiveDate = receiveDate;
    }
}
