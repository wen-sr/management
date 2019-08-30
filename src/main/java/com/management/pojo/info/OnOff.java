package com.management.pojo.info;

public class OnOff {
    private Integer id;

    private String name;

    private String flag;

    public OnOff(Integer id, String name, String flag) {
        this.id = id;
        this.name = name;
        this.flag = flag;
    }

    public OnOff() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag == null ? null : flag.trim();
    }
}