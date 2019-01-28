package com.management.pojo.jc;

public class JiaoCaiLoc {
    private Long id;

    private String loc;

    private String type;

    private String bk1;

    private String bk2;

    private String bk3;

    private String bk4;

    private String bk5;

    public JiaoCaiLoc(Long id, String loc, String type, String bk1, String bk2, String bk3, String bk4, String bk5) {
        this.id = id;
        this.loc = loc;
        this.type = type;
        this.bk1 = bk1;
        this.bk2 = bk2;
        this.bk3 = bk3;
        this.bk4 = bk4;
        this.bk5 = bk5;
    }

    public JiaoCaiLoc() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc == null ? null : loc.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
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