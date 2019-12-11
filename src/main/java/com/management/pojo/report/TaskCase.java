package com.management.pojo.report;

import java.util.Date;

public class TaskCase {
    private String caseoutid;

    private String caseoutbatch;

    private String docStorerkey;

    private Short qty;

    private Short scanQty;

    private String id;

    private String boxno;

    private String msg;

    private String exportBarcode;

    private String mk1;

    private String idBinder;

    private Date idBindtime;

    public TaskCase(String caseoutid, String caseoutbatch, String docStorerkey, Short qty, Short scanQty, String id, String boxno, String msg, String exportBarcode, String mk1, String idBinder, Date idBindtime) {
        this.caseoutid = caseoutid;
        this.caseoutbatch = caseoutbatch;
        this.docStorerkey = docStorerkey;
        this.qty = qty;
        this.scanQty = scanQty;
        this.id = id;
        this.boxno = boxno;
        this.msg = msg;
        this.exportBarcode = exportBarcode;
        this.mk1 = mk1;
        this.idBinder = idBinder;
        this.idBindtime = idBindtime;
    }

    public TaskCase() {
        super();
    }

    public String getCaseoutid() {
        return caseoutid;
    }

    public void setCaseoutid(String caseoutid) {
        this.caseoutid = caseoutid == null ? null : caseoutid.trim();
    }

    public String getCaseoutbatch() {
        return caseoutbatch;
    }

    public void setCaseoutbatch(String caseoutbatch) {
        this.caseoutbatch = caseoutbatch == null ? null : caseoutbatch.trim();
    }

    public String getDocStorerkey() {
        return docStorerkey;
    }

    public void setDocStorerkey(String docStorerkey) {
        this.docStorerkey = docStorerkey == null ? null : docStorerkey.trim();
    }

    public Short getQty() {
        return qty;
    }

    public void setQty(Short qty) {
        this.qty = qty;
    }

    public Short getScanQty() {
        return scanQty;
    }

    public void setScanQty(Short scanQty) {
        this.scanQty = scanQty;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getBoxno() {
        return boxno;
    }

    public void setBoxno(String boxno) {
        this.boxno = boxno == null ? null : boxno.trim();
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg == null ? null : msg.trim();
    }

    public String getExportBarcode() {
        return exportBarcode;
    }

    public void setExportBarcode(String exportBarcode) {
        this.exportBarcode = exportBarcode == null ? null : exportBarcode.trim();
    }

    public String getMk1() {
        return mk1;
    }

    public void setMk1(String mk1) {
        this.mk1 = mk1 == null ? null : mk1.trim();
    }

    public String getIdBinder() {
        return idBinder;
    }

    public void setIdBinder(String idBinder) {
        this.idBinder = idBinder == null ? null : idBinder.trim();
    }

    public Date getIdBindtime() {
        return idBindtime;
    }

    public void setIdBindtime(Date idBindtime) {
        this.idBindtime = idBindtime;
    }
}