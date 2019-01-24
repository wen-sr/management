package com.management.pojo.jc;

import java.math.BigDecimal;
import java.util.Date;

public class JiaoCaiSku extends JiaoCaiSkuKey {
    private Long id;

    private String barcode;

    private String descr;

    private BigDecimal price;

    private Long pack;

    private String publisher;

    private String addwho;

    private String editwho;

    private Date adddate;

    private Date editdate;

    private Integer bundle;

    public JiaoCaiSku(String issuenumber, String subcode, Long id, String barcode, String descr, BigDecimal price, Long pack, String publisher, String addwho, String editwho, Date adddate, Date editdate, Integer bundle) {
        super(issuenumber, subcode);
        this.id = id;
        this.barcode = barcode;
        this.descr = descr;
        this.price = price;
        this.pack = pack;
        this.publisher = publisher;
        this.addwho = addwho;
        this.editwho = editwho;
        this.adddate = adddate;
        this.editdate = editdate;
        this.bundle = bundle;
    }

    public JiaoCaiSku() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode == null ? null : barcode.trim();
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr == null ? null : descr.trim();
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Long getPack() {
        return pack;
    }

    public void setPack(Long pack) {
        this.pack = pack;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher == null ? null : publisher.trim();
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

    public Date getAdddate() {
        return adddate;
    }

    public void setAdddate(Date adddate) {
        this.adddate = adddate;
    }

    public Date getEditdate() {
        return editdate;
    }

    public void setEditdate(Date editdate) {
        this.editdate = editdate;
    }

    public Integer getBundle() {
        return bundle;
    }

    public void setBundle(Integer bundle) {
        this.bundle = bundle;
    }
}