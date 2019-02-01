package com.management.pojo.jc;

public class JiaoCaiInventory_detail {
    private Long id;

    private String issuenumber;

    private String subcode;

    private Integer qtyreceipt;

    private Integer qtyallocated;

    private Integer qtyshipped;

    private Integer qtyfree;

    private Integer pack;

    private String loc;

    private String containerId;

    private String bk1;

    private String bk2;

    private String bk3;

    private String bk4;

    private String bk5;

    public JiaoCaiInventory_detail(String issuenumber, String subcode, Integer pack, String loc, String containerId) {
        this.issuenumber = issuenumber;
        this.subcode = subcode;
        this.pack = pack;
        this.loc = loc;
        this.containerId = containerId;
    }

    public JiaoCaiInventory_detail(String issuenumber, String subcode, Integer qtyfree, Integer pack) {
        this.issuenumber = issuenumber;
        this.subcode = subcode;
        this.qtyfree = qtyfree;
        this.pack = pack;
    }

    public JiaoCaiInventory_detail(Long id, String issuenumber, String subcode, Integer qtyreceipt, Integer qtyallocated, Integer qtyshipped, Integer qtyfree, Integer pack, String loc, String containerid, String bk1, String bk2, String bk3, String bk4, String bk5) {
        this.id = id;
        this.issuenumber = issuenumber;
        this.subcode = subcode;
        this.qtyreceipt = qtyreceipt;
        this.qtyallocated = qtyallocated;
        this.qtyshipped = qtyshipped;
        this.qtyfree = qtyfree;
        this.pack = pack;
        this.loc = loc;
        this.containerId = containerid;
        this.bk1 = bk1;
        this.bk2 = bk2;
        this.bk3 = bk3;
        this.bk4 = bk4;
        this.bk5 = bk5;
    }

    public JiaoCaiInventory_detail() {
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

    public Integer getQtyreceipt() {
        return qtyreceipt;
    }

    public void setQtyreceipt(Integer qtyreceipt) {
        this.qtyreceipt = qtyreceipt;
    }

    public Integer getQtyallocated() {
        return qtyallocated;
    }

    public void setQtyallocated(Integer qtyallocated) {
        this.qtyallocated = qtyallocated;
    }

    public Integer getQtyshipped() {
        return qtyshipped;
    }

    public void setQtyshipped(Integer qtyshipped) {
        this.qtyshipped = qtyshipped;
    }

    public Integer getQtyfree() {
        return qtyfree;
    }

    public void setQtyfree(Integer qtyfree) {
        this.qtyfree = qtyfree;
    }

    public Integer getPack() {
        return pack;
    }

    public void setPack(Integer pack) {
        this.pack = pack;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc == null ? null : loc.trim();
    }

    public String getContainerId() {
        return containerId;
    }

    public void setContainerId(String containerId) {
        this.containerId = containerId == null ? null : containerId.trim();
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
}