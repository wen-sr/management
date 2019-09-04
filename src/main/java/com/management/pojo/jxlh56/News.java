package com.management.pojo.jxlh56;

import java.util.Date;

public class News {
    private Integer id;

    private String guid;

    private String title;

    private String subtitle;

    private Integer type;

    private String checkid;

    private Integer checkstatus;

    private Date checktime;

    private Integer datastatus;

    private String adduserid;

    private Date addtime;

    private String updateid;

    private Date updatetime;

    private String releaseid;

    private Date releasetime;

    private String submitid;

    private Date submittime;

    private String revokesubmitid;

    private Date revokesubmittime;

    private String downid;

    private Date downtime;

    private String deleteid;

    private Date deletetime;

    private String pictureflie;

    private String pictureflieftp;

    private Integer isnotpictures;

    private String source;

    private String author;

    private Integer istochart;

    private Date sysdate;

    private String isbignews;

    private String newscontent;

    public News(Integer id, String guid, String title, String subtitle, Integer type, String checkid, Integer checkstatus, Date checktime, Integer datastatus, String adduserid, Date addtime, String updateid, Date updatetime, String releaseid, Date releasetime, String submitid, Date submittime, String revokesubmitid, Date revokesubmittime, String downid, Date downtime, String deleteid, Date deletetime, String pictureflie, String pictureflieftp, Integer isnotpictures, String source, String author, Integer istochart, Date sysdate, String isbignews, String newscontent) {
        this.id = id;
        this.guid = guid;
        this.title = title;
        this.subtitle = subtitle;
        this.type = type;
        this.checkid = checkid;
        this.checkstatus = checkstatus;
        this.checktime = checktime;
        this.datastatus = datastatus;
        this.adduserid = adduserid;
        this.addtime = addtime;
        this.updateid = updateid;
        this.updatetime = updatetime;
        this.releaseid = releaseid;
        this.releasetime = releasetime;
        this.submitid = submitid;
        this.submittime = submittime;
        this.revokesubmitid = revokesubmitid;
        this.revokesubmittime = revokesubmittime;
        this.downid = downid;
        this.downtime = downtime;
        this.deleteid = deleteid;
        this.deletetime = deletetime;
        this.pictureflie = pictureflie;
        this.pictureflieftp = pictureflieftp;
        this.isnotpictures = isnotpictures;
        this.source = source;
        this.author = author;
        this.istochart = istochart;
        this.sysdate = sysdate;
        this.isbignews = isbignews;
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

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid == null ? null : guid.trim();
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

    public String getCheckid() {
        return checkid;
    }

    public void setCheckid(String checkid) {
        this.checkid = checkid == null ? null : checkid.trim();
    }

    public Integer getCheckstatus() {
        return checkstatus;
    }

    public void setCheckstatus(Integer checkstatus) {
        this.checkstatus = checkstatus;
    }

    public Date getChecktime() {
        return checktime;
    }

    public void setChecktime(Date checktime) {
        this.checktime = checktime;
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

    public Date getAddtime() {
        return addtime;
    }

    public void setAddtime(Date addtime) {
        this.addtime = addtime;
    }

    public String getUpdateid() {
        return updateid;
    }

    public void setUpdateid(String updateid) {
        this.updateid = updateid == null ? null : updateid.trim();
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public String getReleaseid() {
        return releaseid;
    }

    public void setReleaseid(String releaseid) {
        this.releaseid = releaseid == null ? null : releaseid.trim();
    }

    public Date getReleasetime() {
        return releasetime;
    }

    public void setReleasetime(Date releasetime) {
        this.releasetime = releasetime;
    }

    public String getSubmitid() {
        return submitid;
    }

    public void setSubmitid(String submitid) {
        this.submitid = submitid == null ? null : submitid.trim();
    }

    public Date getSubmittime() {
        return submittime;
    }

    public void setSubmittime(Date submittime) {
        this.submittime = submittime;
    }

    public String getRevokesubmitid() {
        return revokesubmitid;
    }

    public void setRevokesubmitid(String revokesubmitid) {
        this.revokesubmitid = revokesubmitid == null ? null : revokesubmitid.trim();
    }

    public Date getRevokesubmittime() {
        return revokesubmittime;
    }

    public void setRevokesubmittime(Date revokesubmittime) {
        this.revokesubmittime = revokesubmittime;
    }

    public String getDownid() {
        return downid;
    }

    public void setDownid(String downid) {
        this.downid = downid == null ? null : downid.trim();
    }

    public Date getDowntime() {
        return downtime;
    }

    public void setDowntime(Date downtime) {
        this.downtime = downtime;
    }

    public String getDeleteid() {
        return deleteid;
    }

    public void setDeleteid(String deleteid) {
        this.deleteid = deleteid == null ? null : deleteid.trim();
    }

    public Date getDeletetime() {
        return deletetime;
    }

    public void setDeletetime(Date deletetime) {
        this.deletetime = deletetime;
    }

    public String getPictureflie() {
        return pictureflie;
    }

    public void setPictureflie(String pictureflie) {
        this.pictureflie = pictureflie == null ? null : pictureflie.trim();
    }

    public String getPictureflieftp() {
        return pictureflieftp;
    }

    public void setPictureflieftp(String pictureflieftp) {
        this.pictureflieftp = pictureflieftp == null ? null : pictureflieftp.trim();
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

    public Date getSysdate() {
        return sysdate;
    }

    public void setSysdate(Date sysdate) {
        this.sysdate = sysdate;
    }

    public String getIsbignews() {
        return isbignews;
    }

    public void setIsbignews(String isbignews) {
        this.isbignews = isbignews == null ? null : isbignews.trim();
    }

    public String getNewscontent() {
        return newscontent;
    }

    public void setNewscontent(String newscontent) {
        this.newscontent = newscontent == null ? null : newscontent.trim();
    }
}