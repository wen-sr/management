package com.management.pojo.jc;

import java.util.Date;

public class JiaoCaiReceipt {
    private Integer id;

    private String issuenumber;

    private String subcode;

    private Integer pack;

    private Integer qtyreceipt;

    private String status;

    private Date adddate;

    private String addwho;

    private String editwho;

    private Date editdate;

    private String receiptno;

    private String printplant;

    public JiaoCaiReceipt(Integer id, String issuenumber, String subcode, Integer pack, Integer qtyreceipt, String status, Date adddate, String addwho, String editwho, Date editdate, String receiptno, String printplant) {
        this.id = id;
        this.issuenumber = issuenumber;
        this.subcode = subcode;
        this.pack = pack;
        this.qtyreceipt = qtyreceipt;
        this.status = status;
        this.adddate = adddate;
        this.addwho = addwho;
        this.editwho = editwho;
        this.editdate = editdate;
        this.receiptno = receiptno;
        this.printplant = printplant;
    }

    public JiaoCaiReceipt() {
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

    public String getSubcode() {
        return subcode;
    }

    public void setSubcode(String subcode) {
        this.subcode = subcode == null ? null : subcode.trim();
    }

    public Integer getPack() {
        return pack;
    }

    public void setPack(Integer pack) {
        this.pack = pack;
    }

    public Integer getQtyreceipt() {
        return qtyreceipt;
    }

    public void setQtyreceipt(Integer qtyreceipt) {
        this.qtyreceipt = qtyreceipt;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Date getAdddate() {
        return adddate;
    }

    public void setAdddate(Date adddate) {
        this.adddate = adddate;
    }

    public String getAddwho() {
        return addwho;
    }

    public void setAddwho(String addwho) {
        this.addwho = addwho == null ? null : addwho.trim();
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

    public String getReceiptno() {
        return receiptno;
    }

    public void setReceiptno(String receiptno) {
        this.receiptno = receiptno == null ? null : receiptno.trim();
    }

    public String getPrintplant() {
        return printplant;
    }

    public void setPrintplant(String printplant) {
        this.printplant = printplant == null ? null : printplant.trim();
    }
}