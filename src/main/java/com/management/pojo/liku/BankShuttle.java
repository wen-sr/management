package com.management.pojo.liku;

public class BankShuttle {
    private Long id;

    private String guid;

    private String name;

    private Integer number;

    private Integer status;

    private String note;

    private Integer statusdetail;

    private Integer errorcode;

    private Integer banknumber;

    public BankShuttle(Long id, String guid, String name, Integer number, Integer status, String note, Integer statusdetail, Integer errorcode, Integer banknumber) {
        this.id = id;
        this.guid = guid;
        this.name = name;
        this.number = number;
        this.status = status;
        this.note = note;
        this.statusdetail = statusdetail;
        this.errorcode = errorcode;
        this.banknumber = banknumber;
    }

    public BankShuttle() {
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

    public Integer getStatusdetail() {
        return statusdetail;
    }

    public void setStatusdetail(Integer statusdetail) {
        this.statusdetail = statusdetail;
    }

    public Integer getErrorcode() {
        return errorcode;
    }

    public void setErrorcode(Integer errorcode) {
        this.errorcode = errorcode;
    }

    public Integer getBanknumber() {
        return banknumber;
    }

    public void setBanknumber(Integer banknumber) {
        this.banknumber = banknumber;
    }
}