package com.management.vo.jc;

import java.math.BigDecimal;

public class JiaoCaiDistributeVo {
    private Long id;

    private String issuenumber;

    private String subcode;

    private String code;

    private String shortname;

    private Integer pack;

    private Integer oldpack;

    private Integer qtyallocated;

    private String status;

    private String adddate;

    private String addwho;

    private Integer caseqty;

    private Integer oddpack;

    private Integer odd;

    private Integer type;

    private String batchno;

    private String shipno;

    private String pickno;

    private String editwho;

    private String editdate;

    private String packwho;

    private String packdate;

    private String computeno;

    private String barcode;

    private String descr;

    private BigDecimal price;

    private String publisher;

    private String storerkey;

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getStorerkey() {
        return storerkey;
    }

    public void setStorerkey(String storerkey) {
        this.storerkey = storerkey;
    }

    public String getAdddate() {
        return adddate;
    }

    public void setAdddate(String adddate) {
        this.adddate = adddate;
    }

    public String getEditdate() {
        return editdate;
    }

    public void setEditdate(String editdate) {
        this.editdate = editdate;
    }

    public String getPackdate() {
        return packdate;
    }

    public void setPackdate(String packdate) {
        this.packdate = packdate;
    }

    public JiaoCaiDistributeVo() {
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getShortname() {
        return shortname;
    }

    public void setShortname(String shortname) {
        this.shortname = shortname == null ? null : shortname.trim();
    }

    public Integer getPack() {
        return pack;
    }

    public void setPack(Integer pack) {
        this.pack = pack;
    }

    public Integer getOldpack() {
        return oldpack;
    }

    public void setOldpack(Integer oldpack) {
        this.oldpack = oldpack;
    }

    public Integer getQtyallocated() {
        return qtyallocated;
    }

    public void setQtyallocated(Integer qtyallocated) {
        this.qtyallocated = qtyallocated;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }


    public String getAddwho() {
        return addwho;
    }

    public void setAddwho(String addwho) {
        this.addwho = addwho == null ? null : addwho.trim();
    }

    public Integer getCaseqty() {
        return caseqty;
    }

    public void setCaseqty(Integer caseqty) {
        this.caseqty = caseqty;
    }

    public Integer getOddpack() {
        return oddpack;
    }

    public void setOddpack(Integer oddpack) {
        this.oddpack = oddpack;
    }

    public Integer getOdd() {
        return odd;
    }

    public void setOdd(Integer odd) {
        this.odd = odd;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getBatchno() {
        return batchno;
    }

    public void setBatchno(String batchno) {
        this.batchno = batchno == null ? null : batchno.trim();
    }

    public String getShipno() {
        return shipno;
    }

    public void setShipno(String shipno) {
        this.shipno = shipno == null ? null : shipno.trim();
    }

    public String getPickno() {
        return pickno;
    }

    public void setPickno(String pickno) {
        this.pickno = pickno == null ? null : pickno.trim();
    }

    public String getEditwho() {
        return editwho;
    }

    public void setEditwho(String editwho) {
        this.editwho = editwho == null ? null : editwho.trim();
    }


    public String getPackwho() {
        return packwho;
    }

    public void setPackwho(String packwho) {
        this.packwho = packwho == null ? null : packwho.trim();
    }

    public String getComputeno() {
        return computeno;
    }

    public void setComputeno(String computeno) {
        this.computeno = computeno == null ? null : computeno.trim();
    }
}