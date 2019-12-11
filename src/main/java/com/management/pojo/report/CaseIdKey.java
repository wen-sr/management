package com.management.pojo.report;

public class CaseIdKey {
    private String caseid;

    private String caseidBak;

    public CaseIdKey(String caseid, String caseidBak) {
        this.caseid = caseid;
        this.caseidBak = caseidBak;
    }

    public CaseIdKey() {
        super();
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
}