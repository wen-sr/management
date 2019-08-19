package com.management.pojo.xhwl;

import java.util.Date;

public class BZChuHuo {
    private Integer id;

    private Integer facase;

    private Integer tuicase;

    private Integer zprej;

    private Integer tuirej;

    private Integer sgfa;

    private String dzz;

    private String dd;

    private Date adddate;

    private String addwho;

    private String note;

    public BZChuHuo(Integer id, Integer facase, Integer tuicase, Integer zprej, Integer tuirej, Integer sgfa, String dzz, String dd, Date adddate, String addwho, String note) {
        this.id = id;
        this.facase = facase;
        this.tuicase = tuicase;
        this.zprej = zprej;
        this.tuirej = tuirej;
        this.sgfa = sgfa;
        this.dzz = dzz;
        this.dd = dd;
        this.adddate = adddate;
        this.addwho = addwho;
        this.note = note;
    }

    public BZChuHuo() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFacase() {
        return facase;
    }

    public void setFacase(Integer facase) {
        this.facase = facase;
    }

    public Integer getTuicase() {
        return tuicase;
    }

    public void setTuicase(Integer tuicase) {
        this.tuicase = tuicase;
    }

    public Integer getZprej() {
        return zprej;
    }

    public void setZprej(Integer zprej) {
        this.zprej = zprej;
    }

    public Integer getTuirej() {
        return tuirej;
    }

    public void setTuirej(Integer tuirej) {
        this.tuirej = tuirej;
    }

    public Integer getSgfa() {
        return sgfa;
    }

    public void setSgfa(Integer sgfa) {
        this.sgfa = sgfa;
    }

    public String getDzz() {
        return dzz;
    }

    public void setDzz(String dzz) {
        this.dzz = dzz == null ? null : dzz.trim();
    }

    public String getDd() {
        return dd;
    }

    public void setDd(String dd) {
        this.dd = dd == null ? null : dd.trim();
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

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }
}