package com.management.pojo.liku;

public class BankHoists {
    private Long id;

    private String guid;

    private String name;

    private Integer number;

    private Integer status;

    private String note;

    private Integer banknumber;

    private Integer way;

    private Integer hoistspurpose;

    private Integer statusdetail;

    private Integer havecontainerorshuttle;

    private Integer errorcode;

    public BankHoists(Long id, String guid, String name, Integer number, Integer status, String note, Integer banknumber, Integer way, Integer hoistspurpose, Integer statusdetail, Integer havecontainerorshuttle, Integer errorcode) {
        this.id = id;
        this.guid = guid;
        this.name = name;
        this.number = number;
        this.status = status;
        this.note = note;
        this.banknumber = banknumber;
        this.way = way;
        this.hoistspurpose = hoistspurpose;
        this.statusdetail = statusdetail;
        this.havecontainerorshuttle = havecontainerorshuttle;
        this.errorcode = errorcode;
    }

    public BankHoists() {
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

    public Integer getBanknumber() {
        return banknumber;
    }

    public void setBanknumber(Integer banknumber) {
        this.banknumber = banknumber;
    }

    public Integer getWay() {
        return way;
    }

    public void setWay(Integer way) {
        this.way = way;
    }

    public Integer getHoistspurpose() {
        return hoistspurpose;
    }

    public void setHoistspurpose(Integer hoistspurpose) {
        this.hoistspurpose = hoistspurpose;
    }

    public Integer getStatusdetail() {
        return statusdetail;
    }

    public void setStatusdetail(Integer statusdetail) {
        this.statusdetail = statusdetail;
    }

    public Integer getHavecontainerorshuttle() {
        return havecontainerorshuttle;
    }

    public void setHavecontainerorshuttle(Integer havecontainerorshuttle) {
        this.havecontainerorshuttle = havecontainerorshuttle;
    }

    public Integer getErrorcode() {
        return errorcode;
    }

    public void setErrorcode(Integer errorcode) {
        this.errorcode = errorcode;
    }
}