package com.management.pojo.jc;

public class JiaoCaiStorerKey {
    private Integer id;

    private String storerkey;

    public JiaoCaiStorerKey(Integer id, String storerkey) {
        this.id = id;
        this.storerkey = storerkey;
    }

    public JiaoCaiStorerKey() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStorerkey() {
        return storerkey;
    }

    public void setStorerkey(String storerkey) {
        this.storerkey = storerkey == null ? null : storerkey.trim();
    }
}