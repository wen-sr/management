package com.management.vo.jc;

import com.management.pojo.jc.JiaoCaiSkuKey;

import java.math.BigDecimal;

public class JiaoCaiSkuVo extends JiaoCaiSkuKey {
    private Long id;

    private String barcode;

    private String descr;

    private BigDecimal price;

    private Long pack;

    private String publisher;

    private String addwho;

    private String editwho;

    private String adddate;

    private String editdate;

    private Integer bundle;

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

    public JiaoCaiSkuVo(String issuenumber, String subcode, Long id, String barcode, String descr, BigDecimal price, Long pack, String publisher, String addwho, String editwho, String adddate, String editdate, Integer bundle) {
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

    public JiaoCaiSkuVo() {
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

    public Integer getBundle() {
        return bundle;
    }

    public void setBundle(Integer bundle) {
        this.bundle = bundle;
    }
}