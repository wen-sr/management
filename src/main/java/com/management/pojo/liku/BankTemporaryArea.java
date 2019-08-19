package com.management.pojo.liku;

public class BankTemporaryArea {
    private Long id;

    private String guid;

    private String name;

    private Integer number;

    private Integer status;

    private String note;

    private Integer way;

    private Integer banknumber;

    public BankTemporaryArea(Long id, String guid, String name, Integer number, Integer status, String note, Integer way, Integer banknumber) {
        this.id = id;
        this.guid = guid;
        this.name = name;
        this.number = number;
        this.status = status;
        this.note = note;
        this.way = way;
        this.banknumber = banknumber;
    }

    public BankTemporaryArea() {
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

    public Integer getWay() {
        return way;
    }

    public void setWay(Integer way) {
        this.way = way;
    }

    public Integer getBanknumber() {
        return banknumber;
    }

    public void setBanknumber(Integer banknumber) {
        this.banknumber = banknumber;
    }
}