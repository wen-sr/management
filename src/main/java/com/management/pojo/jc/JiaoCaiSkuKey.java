package com.management.pojo.jc;

public class JiaoCaiSkuKey {
    private String issuenumber;

    private String subcode;

    public JiaoCaiSkuKey(String issuenumber, String subcode) {
        this.issuenumber = issuenumber;
        this.subcode = subcode;
    }

    public JiaoCaiSkuKey() {
        super();
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
}