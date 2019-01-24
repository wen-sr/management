package com.management.pojo.jc;

public class JiaoCaiPack extends JiaoCaiPackKey {
    private Integer id;

    public JiaoCaiPack(String subcode, Integer pack, String issuenumber, Integer id) {
        super(subcode, pack, issuenumber);
        this.id = id;
    }

    public JiaoCaiPack() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}