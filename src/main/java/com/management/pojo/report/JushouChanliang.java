package com.management.pojo.report;

public class JushouChanliang {
    private String caseid;

    private Short qty;

    private String caseqty;

    private String docType;

    private String dd;

    public JushouChanliang(String caseid, Short qty, String caseqty, String docType, String dd) {
        this.caseid = caseid;
        this.qty = qty;
        this.caseqty = caseqty;
        this.docType = docType;
        this.dd = dd;
    }

    public JushouChanliang() {
        super();
    }

    public String getCaseid() {
        return caseid;
    }

    public void setCaseid(String caseid) {
        this.caseid = caseid == null ? null : caseid.trim();
    }

    public Short getQty() {
        return qty;
    }

    public void setQty(Short qty) {
        this.qty = qty;
    }

    public String getCaseqty() {
        return caseqty;
    }

    public void setCaseqty(String caseqty) {
        this.caseqty = caseqty == null ? null : caseqty.trim();
    }

    public String getDocType() {
        return docType;
    }

    public void setDocType(String docType) {
        this.docType = docType == null ? null : docType.trim();
    }

    public String getDd() {
        return dd;
    }

    public void setDd(String dd) {
        this.dd = dd == null ? null : dd.trim();
    }
}