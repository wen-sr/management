package com.management.pojo.jc;

public class JiaoCaiStorer extends JiaoCaiStorerKey {
    private String shortname;

    private String type;

    private String phone;

    private String address1;

    private String contact;

    private Integer orderby;

    private String loc;

    private Integer sortby;

    public JiaoCaiStorer(Integer id, String storerkey, String shortname, String type, String phone, String address1, String contact, Integer orderby, String loc, Integer sortby) {
        super(id, storerkey);
        this.shortname = shortname;
        this.type = type;
        this.phone = phone;
        this.address1 = address1;
        this.contact = contact;
        this.orderby = orderby;
        this.loc = loc;
        this.sortby = sortby;
    }

    public JiaoCaiStorer() {
        super();
    }

    public String getShortname() {
        return shortname;
    }

    public void setShortname(String shortname) {
        this.shortname = shortname == null ? null : shortname.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1 == null ? null : address1.trim();
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact == null ? null : contact.trim();
    }

    public Integer getOrderby() {
        return orderby;
    }

    public void setOrderby(Integer orderby) {
        this.orderby = orderby;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc == null ? null : loc.trim();
    }

    public Integer getSortby() {
        return sortby;
    }

    public void setSortby(Integer sortby) {
        this.sortby = sortby;
    }
}