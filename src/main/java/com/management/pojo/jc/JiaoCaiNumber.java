package com.management.pojo.jc;

public class JiaoCaiNumber {
    private Integer id;

    private String batchno;

    private String shipno;

    private String pickno;

    private String computeno;

    public JiaoCaiNumber(Integer id, String batchno, String shipno, String pickno, String computeno) {
        this.id = id;
        this.batchno = batchno;
        this.shipno = shipno;
        this.pickno = pickno;
        this.computeno = computeno;
    }

    public JiaoCaiNumber() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getComputeno() {
        return computeno;
    }

    public void setComputeno(String computeno) {
        this.computeno = computeno == null ? null : computeno.trim();
    }
}