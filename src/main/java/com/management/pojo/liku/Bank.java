package com.management.pojo.liku;

import java.util.Date;

public class Bank {
    private Long id;

    private String guid;

    private String name;

    private Integer number;

    private Integer status;

    private String note;

    private String bankip;

    private Integer bankport;

    private Integer control;

    private Boolean onoff;

    private Date onlinetime;

    private Date offlinetime;

    public Bank(Long id, String guid, String name, Integer number, Integer status, String note, String bankip, Integer bankport, Integer control, Boolean onoff, Date onlinetime, Date offlinetime) {
        this.id = id;
        this.guid = guid;
        this.name = name;
        this.number = number;
        this.status = status;
        this.note = note;
        this.bankip = bankip;
        this.bankport = bankport;
        this.control = control;
        this.onoff = onoff;
        this.onlinetime = onlinetime;
        this.offlinetime = offlinetime;
    }

    public Bank() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid == null ? null : guid.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
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

    public String getBankip() {
        return bankip;
    }

    public void setBankip(String bankip) {
        this.bankip = bankip == null ? null : bankip.trim();
    }

    public Integer getBankport() {
        return bankport;
    }

    public void setBankport(Integer bankport) {
        this.bankport = bankport;
    }

    public Integer getControl() {
        return control;
    }

    public void setControl(Integer control) {
        this.control = control;
    }

    public Boolean getOnoff() {
        return onoff;
    }

    public void setOnoff(Boolean onoff) {
        this.onoff = onoff;
    }

    public Date getOnlinetime() {
        return onlinetime;
    }

    public void setOnlinetime(Date onlinetime) {
        this.onlinetime = onlinetime;
    }

    public Date getOfflinetime() {
        return offlinetime;
    }

    public void setOfflinetime(Date offlinetime) {
        this.offlinetime = offlinetime;
    }
}