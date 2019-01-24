package com.management.pojo.jc;

public class JiaoCaiPackKey {
    private String subcode;

    private Integer pack;

    private String issuenumber;

    public JiaoCaiPackKey(String subcode, Integer pack, String issuenumber) {
        this.subcode = subcode;
        this.pack = pack;
        this.issuenumber = issuenumber;
    }

    public JiaoCaiPackKey() {
        super();
    }

    public String getSubcode() {
        return subcode;
    }

    public void setSubcode(String subcode) {
        this.subcode = subcode == null ? null : subcode.trim();
    }

    public Integer getPack() {
        return pack;
    }

    public void setPack(Integer pack) {
        this.pack = pack;
    }

    public String getIssuenumber() {
        return issuenumber;
    }

    public void setIssuenumber(String issuenumber) {
        this.issuenumber = issuenumber == null ? null : issuenumber.trim();
    }
}