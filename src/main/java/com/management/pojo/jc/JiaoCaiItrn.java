package com.management.pojo.jc;

import java.util.Date;

public class JiaoCaiItrn {
    private Long id;

    private String issuenumber;

    private String subcode;

    private String fromloc;

    private String toloc;

    private String addwho;

    private Date adddate;

    private Long qty;

    private Long sourceid;

    private String fromid;

    private String toid;

    private String type;

    private Integer pack;

    private String bk1;

    private String bk2;

    private String bk3;

    private String bk4;

    private String bk5;

    private String fromtable;

    public JiaoCaiItrn(Long id, String issuenumber, String subcode, String fromloc, String toloc, String addwho, Date adddate, Long qty, Long sourceid, String fromid, String toid, String type, Integer pack, String bk1, String bk2, String bk3, String bk4, String bk5, String fromtable) {
        this.id = id;
        this.issuenumber = issuenumber;
        this.subcode = subcode;
        this.fromloc = fromloc;
        this.toloc = toloc;
        this.addwho = addwho;
        this.adddate = adddate;
        this.qty = qty;
        this.sourceid = sourceid;
        this.fromid = fromid;
        this.toid = toid;
        this.type = type;
        this.pack = pack;
        this.bk1 = bk1;
        this.bk2 = bk2;
        this.bk3 = bk3;
        this.bk4 = bk4;
        this.bk5 = bk5;
        this.fromtable = fromtable;
    }

    public JiaoCaiItrn() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getFromloc() {
        return fromloc;
    }

    public void setFromloc(String fromloc) {
        this.fromloc = fromloc == null ? null : fromloc.trim();
    }

    public String getToloc() {
        return toloc;
    }

    public void setToloc(String toloc) {
        this.toloc = toloc == null ? null : toloc.trim();
    }

    public String getAddwho() {
        return addwho;
    }

    public void setAddwho(String addwho) {
        this.addwho = addwho == null ? null : addwho.trim();
    }

    public Date getAdddate() {
        return adddate;
    }

    public void setAdddate(Date adddate) {
        this.adddate = adddate;
    }

    public Long getQty() {
        return qty;
    }

    public void setQty(Long qty) {
        this.qty = qty;
    }

    public Long getSourceid() {
        return sourceid;
    }

    public void setSourceid(Long sourceid) {
        this.sourceid = sourceid;
    }

    public String getFromid() {
        return fromid;
    }

    public void setFromid(String fromid) {
        this.fromid = fromid == null ? null : fromid.trim();
    }

    public String getToid() {
        return toid;
    }

    public void setToid(String toid) {
        this.toid = toid == null ? null : toid.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public Integer getPack() {
        return pack;
    }

    public void setPack(Integer pack) {
        this.pack = pack;
    }

    public String getBk1() {
        return bk1;
    }

    public void setBk1(String bk1) {
        this.bk1 = bk1 == null ? null : bk1.trim();
    }

    public String getBk2() {
        return bk2;
    }

    public void setBk2(String bk2) {
        this.bk2 = bk2 == null ? null : bk2.trim();
    }

    public String getBk3() {
        return bk3;
    }

    public void setBk3(String bk3) {
        this.bk3 = bk3 == null ? null : bk3.trim();
    }

    public String getBk4() {
        return bk4;
    }

    public void setBk4(String bk4) {
        this.bk4 = bk4 == null ? null : bk4.trim();
    }

    public String getBk5() {
        return bk5;
    }

    public void setBk5(String bk5) {
        this.bk5 = bk5 == null ? null : bk5.trim();
    }

    public String getFromtable() {
        return fromtable;
    }

    public void setFromtable(String fromtable) {
        this.fromtable = fromtable == null ? null : fromtable.trim();
    }
}