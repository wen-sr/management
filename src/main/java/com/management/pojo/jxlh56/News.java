package com.management.pojo.jxlh56;

import java.util.Date;

public class News {
    private Integer id;

    private String title;

    private String subtitle;

    private Integer type;

    private String addtime;

    private Date sysdate;

    private Integer datastatus;

    private String adduserid;

    private Date releasetime;

    private String releaseid;

    private String pictureflie;

    private Integer releaseuserid;

    private Integer isnotpictures;

    private String source;

    private String author;

    private Integer istochart;

    private String newscontent;

    public News(Integer id, String title, String subtitle, Integer type, String addtime, Date sysdate, Integer datastatus, String adduserid, Date releasetime, String releaseid, String pictureflie, Integer releaseuserid, Integer isnotpictures, String source, String author, Integer istochart, String newscontent) {
        this.id = id;
        this.title = title;
        this.subtitle = subtitle;
        this.type = type;
        this.addtime = addtime;
        this.sysdate = sysdate;
        this.datastatus = datastatus;
        this.adduserid = adduserid;
        this.releasetime = releasetime;
        this.releaseid = releaseid;
        this.pictureflie = pictureflie;
        this.releaseuserid = releaseuserid;
        this.isnotpictures = isnotpictures;
        this.source = source;
        this.author = author;
        this.istochart = istochart;
        this.newscontent = newscontent;
    }

    public News() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle == null ? null : subtitle.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getAddtime() {
        return addtime;
    }

    public void setAddtime(String addtime) {
        this.addtime = addtime == null ? null : addtime.trim();
    }

    public Date getSysdate() {
        return sysdate;
    }

    public void setSysdate(Date sysdate) {
        this.sysdate = sysdate;
    }

    public Integer getDatastatus() {
        return datastatus;
    }

    public void setDatastatus(Integer datastatus) {
        this.datastatus = datastatus;
    }

    public String getAdduserid() {
        return adduserid;
    }

    public void setAdduserid(String adduserid) {
        this.adduserid = adduserid == null ? null : adduserid.trim();
    }

    public Date getReleasetime() {
        return releasetime;
    }

    public void setReleasetime(Date releasetime) {
        this.releasetime = releasetime;
    }

    public String getReleaseid() {
        return releaseid;
    }

    public void setReleaseid(String releaseid) {
        this.releaseid = releaseid == null ? null : releaseid.trim();
    }

    public String getPictureflie() {
        return pictureflie;
    }

    public void setPictureflie(String pictureflie) {
        this.pictureflie = pictureflie == null ? null : pictureflie.trim();
    }

    public Integer getReleaseuserid() {
        return releaseuserid;
    }

    public void setReleaseuserid(Integer releaseuserid) {
        this.releaseuserid = releaseuserid;
    }

    public Integer getIsnotpictures() {
        return isnotpictures;
    }

    public void setIsnotpictures(Integer isnotpictures) {
        this.isnotpictures = isnotpictures;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source == null ? null : source.trim();
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    public Integer getIstochart() {
        return istochart;
    }

    public void setIstochart(Integer istochart) {
        this.istochart = istochart;
    }

    public String getNewscontent() {
        return newscontent;
    }

    public void setNewscontent(String newscontent) {
        this.newscontent = newscontent == null ? null : newscontent.trim();
    }
}