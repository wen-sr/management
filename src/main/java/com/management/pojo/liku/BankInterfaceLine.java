package com.management.pojo.liku;

import java.util.Date;

public class BankInterfaceLine {
    private Long id;

    private String guid;

    private String name;

    private Integer number;

    private Integer status;

    private String note;

    private Integer way;

    private Integer layer;

    private Integer statusdetail;

    private Boolean havecontainer;

    private String oldcontainercode;

    private String containercode;

    private Integer banknumber;

    private Integer countnumber;

    private Integer direction;

    private Date arrivetime;

    private Date lastarrivetime;

    private String interfaceenumvalue;

    public BankInterfaceLine(Long id, String guid, String name, Integer number, Integer status, String note, Integer way, Integer layer, Integer statusdetail, Boolean havecontainer, String oldcontainercode, String containercode, Integer banknumber, Integer countnumber, Integer direction, Date arrivetime, Date lastarrivetime, String interfaceenumvalue) {
        this.id = id;
        this.guid = guid;
        this.name = name;
        this.number = number;
        this.status = status;
        this.note = note;
        this.way = way;
        this.layer = layer;
        this.statusdetail = statusdetail;
        this.havecontainer = havecontainer;
        this.oldcontainercode = oldcontainercode;
        this.containercode = containercode;
        this.banknumber = banknumber;
        this.countnumber = countnumber;
        this.direction = direction;
        this.arrivetime = arrivetime;
        this.lastarrivetime = lastarrivetime;
        this.interfaceenumvalue = interfaceenumvalue;
    }

    public BankInterfaceLine() {
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

    public Integer getLayer() {
        return layer;
    }

    public void setLayer(Integer layer) {
        this.layer = layer;
    }

    public Integer getStatusdetail() {
        return statusdetail;
    }

    public void setStatusdetail(Integer statusdetail) {
        this.statusdetail = statusdetail;
    }

    public Boolean getHavecontainer() {
        return havecontainer;
    }

    public void setHavecontainer(Boolean havecontainer) {
        this.havecontainer = havecontainer;
    }

    public String getOldcontainercode() {
        return oldcontainercode;
    }

    public void setOldcontainercode(String oldcontainercode) {
        this.oldcontainercode = oldcontainercode == null ? null : oldcontainercode.trim();
    }

    public String getContainercode() {
        return containercode;
    }

    public void setContainercode(String containercode) {
        this.containercode = containercode == null ? null : containercode.trim();
    }

    public Integer getBanknumber() {
        return banknumber;
    }

    public void setBanknumber(Integer banknumber) {
        this.banknumber = banknumber;
    }

    public Integer getCountnumber() {
        return countnumber;
    }

    public void setCountnumber(Integer countnumber) {
        this.countnumber = countnumber;
    }

    public Integer getDirection() {
        return direction;
    }

    public void setDirection(Integer direction) {
        this.direction = direction;
    }

    public Date getArrivetime() {
        return arrivetime;
    }

    public void setArrivetime(Date arrivetime) {
        this.arrivetime = arrivetime;
    }

    public Date getLastarrivetime() {
        return lastarrivetime;
    }

    public void setLastarrivetime(Date lastarrivetime) {
        this.lastarrivetime = lastarrivetime;
    }

    public String getInterfaceenumvalue() {
        return interfaceenumvalue;
    }

    public void setInterfaceenumvalue(String interfaceenumvalue) {
        this.interfaceenumvalue = interfaceenumvalue == null ? null : interfaceenumvalue.trim();
    }
}