package com.management.pojo.jc;

import com.management.common.ServerResponse;

public class JiaoCaiIssuenumber {
    private Integer id;

    private String issuenumber;

    private Integer status;

    private String note;

    public JiaoCaiIssuenumber(Integer id, String issuenumber, Integer status, String note) {
        this.id = id;
        this.issuenumber = issuenumber;
        this.status = status;
        this.note = note;
    }

    public JiaoCaiIssuenumber() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIssuenumber() {
        return issuenumber;
    }

    public void setIssuenumber(String issuenumber) {
        this.issuenumber = issuenumber == null ? null : issuenumber.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }

}