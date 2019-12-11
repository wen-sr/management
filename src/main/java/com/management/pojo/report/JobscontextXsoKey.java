package com.management.pojo.report;

public class JobscontextXsoKey {
    private String docNumber;

    private String docSeq;

    public JobscontextXsoKey(String docNumber, String docSeq) {
        this.docNumber = docNumber;
        this.docSeq = docSeq;
    }

    public JobscontextXsoKey() {
        super();
    }

    public String getDocNumber() {
        return docNumber;
    }

    public void setDocNumber(String docNumber) {
        this.docNumber = docNumber == null ? null : docNumber.trim();
    }

    public String getDocSeq() {
        return docSeq;
    }

    public void setDocSeq(String docSeq) {
        this.docSeq = docSeq == null ? null : docSeq.trim();
    }
}