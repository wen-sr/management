package com.management.pojo.jc;

import java.util.Date;

public class JiaoCaiCompute {
    private Long id;

    private String issuenumber;

    private String subcode;

    private String code;

    private String shortname;

    private Integer pack;

    private Integer qtyallocated;

    private String status;

    private Date computedate;

    private String computewho;

    private Integer caseqty;

    private Integer oddpack;

    private Integer odd;

    private Integer type;

    private String batchno;

    private String shipno;

    private String pickno;

    private String editwho;

    private Date editdate;

    private String packwho;

    private Date packdate;

    private String computeno;

    private String shipwho;

    private Date shipdate;

    private Date loaddate;

    public JiaoCaiCompute(Long id, String issuenumber, String subcode, String code, String shortname, Integer pack, Integer qtyallocated, String status, Date computedate, String computewho, Integer caseqty, Integer oddpack, Integer odd, Integer type, String batchno, String shipno, String pickno, String editwho, Date editdate, String packwho, Date packdate, String computeno, String shipwho, Date shipdate, Date loaddate) {
        this.id = id;
        this.issuenumber = issuenumber;
        this.subcode = subcode;
        this.code = code;
        this.shortname = shortname;
        this.pack = pack;
        this.qtyallocated = qtyallocated;
        this.status = status;
        this.computedate = computedate;
        this.computewho = computewho;
        this.caseqty = caseqty;
        this.oddpack = oddpack;
        this.odd = odd;
        this.type = type;
        this.batchno = batchno;
        this.shipno = shipno;
        this.pickno = pickno;
        this.editwho = editwho;
        this.editdate = editdate;
        this.packwho = packwho;
        this.packdate = packdate;
        this.computeno = computeno;
        this.shipwho = shipwho;
        this.shipdate = shipdate;
        this.loaddate = loaddate;
    }

    public JiaoCaiCompute() {
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

    public Date getComputedate() {
        return computedate;
    }

    public void setComputedate(Date computedate) {
        this.computedate = computedate;
    }

    public String getComputewho() {
        return computewho;
    }

    public void setComputewho(String computewho) {
        this.computewho = computewho == null ? null : computewho.trim();
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

    public Date getEditdate() {
        return editdate;
    }

    public void setEditdate(Date editdate) {
        this.editdate = editdate;
    }

    public String getPackwho() {
        return packwho;
    }

    public void setPackwho(String packwho) {
        this.packwho = packwho == null ? null : packwho.trim();
    }

    public Date getPackdate() {
        return packdate;
    }

    public void setPackdate(Date packdate) {
        this.packdate = packdate;
    }

    public String getComputeno() {
        return computeno;
    }

    public void setComputeno(String computeno) {
        this.computeno = computeno == null ? null : computeno.trim();
    }

    public String getShipwho() {
        return shipwho;
    }

    public void setShipwho(String shipwho) {
        this.shipwho = shipwho == null ? null : shipwho.trim();
    }

    public Date getShipdate() {
        return shipdate;
    }

    public void setShipdate(Date shipdate) {
        this.shipdate = shipdate;
    }

    public Date getLoaddate() {
        return loaddate;
    }

    public void setLoaddate(Date loaddate) {
        this.loaddate = loaddate;
    }
}