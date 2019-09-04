package com.management.pojo.jxlh56;

import java.util.Date;

public class Notice {
    private Integer id;

    private String guid;

    private Integer channelid;

    private String title;

    private String subtitle;

    private Integer type;

    private Date addtime;

    private Date sysdate;

    private Integer datastatus;

    private String addname;

    private Date releasetime;

    private String releaseid;

    private String pictureflie;

    private String pictureflieftp;

    private String adduserid;

    private Integer isnotpictures;

    private String source;

    private String author;

    private Integer istochart;

    private String revokesubmitid;

    private Date revokesubmittime;

    private String checkid;

    private Integer checkstatus;

    private Date checktime;

    private String updateid;

    private Date updatetime;

    private String submitid;

    private Date submittime;

    private String downid;

    private Date downtime;

    private String deleteid;

    private Date deletetime;

    private String isbignews;

    private String noticecontent;

    public Notice(Integer id, String guid, Integer channelid, String title, String subtitle, Integer type, Date addtime, Date sysdate, Integer datastatus, String addname, Date releasetime, String releaseid, String pictureflie, String pictureflieftp, String adduserid, Integer isnotpictures, String source, String author, Integer istochart, String revokesubmitid, Date revokesubmittime, String checkid, Integer checkstatus, Date checktime, String updateid, Date updatetime, String submitid, Date submittime, String downid, Date downtime, String deleteid, Date deletetime, String isbignews, String noticecontent) {
        this.id = id;
        this.guid = guid;
        this.channelid = channelid;
        this.title = title;
        this.subtitle = subtitle;
        this.type = type;
        this.addtime = addtime;
        this.sysdate = sysdate;
        this.datastatus = datastatus;
        this.addname = addname;
        this.releasetime = releasetime;
        this.releaseid = releaseid;
        this.pictureflie = pictureflie;
        this.pictureflieftp = pictureflieftp;
        this.adduserid = adduserid;
        this.isnotpictures = isnotpictures;
        this.source = source;
        this.author = author;
        this.istochart = istochart;
        this.revokesubmitid = revokesubmitid;
        this.revokesubmittime = revokesubmittime;
        this.checkid = checkid;
        this.checkstatus = checkstatus;
        this.checktime = checktime;
        this.updateid = updateid;
        this.updatetime = updatetime;
        this.submitid = submitid;
        this.submittime = submittime;
        this.downid = downid;
        this.downtime = downtime;
        this.deleteid = deleteid;
        this.deletetime = deletetime;
        this.isbignews = isbignews;
        this.noticecontent = noticecontent;
    }

    public Notice() {
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

    public Integer getChannelid() {
        return channelid;
    }

    public void setChannelid(Integer channelid) {
        this.channelid = channelid;
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

    public Date getAddtime() {
        return addtime;
    }

    public void setAddtime(Date addtime) {
        this.addtime = addtime;
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

    public String getAddname() {
        return addname;
    }

    public void setAddname(String addname) {
        this.addname = addname == null ? null : addname.trim();
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

    public String getPictureflieftp() {
        return pictureflieftp;
    }

    public void setPictureflieftp(String pictureflieftp) {
        this.pictureflieftp = pictureflieftp == null ? null : pictureflieftp.trim();
    }

    public String getAdduserid() {
        return adduserid;
    }

    public void setAdduserid(String adduserid) {
        this.adduserid = adduserid == null ? null : adduserid.trim();
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

    public String getIsbignews() {
        return isbignews;
    }

    public void setIsbignews(String isbignews) {
        this.isbignews = isbignews == null ? null : isbignews.trim();
    }

    public String getNoticecontent() {
        return noticecontent;
    }

    public void setNoticecontent(String noticecontent) {
        this.noticecontent = noticecontent == null ? null : noticecontent.trim();
    }
}