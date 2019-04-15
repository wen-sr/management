package com.management.pojo.busi;

public class SendOpenidList {
    private String type;

    private String openid;

    public SendOpenidList(String type, String openid) {
        this.type = type;
        this.openid = openid;
    }

    public SendOpenidList() {
        super();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid == null ? null : openid.trim();
    }
}