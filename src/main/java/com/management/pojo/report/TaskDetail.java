package com.management.pojo.report;

import java.math.BigDecimal;
import java.util.Date;

public class TaskDetail {
    private String taskdetailkey;

    private Short serialkey;

    private String whseid;

    private String tasktype;

    private String storerkey;

    private String sku;

    private String lot;

    private String uom;

    private BigDecimal uomqty;

    private BigDecimal qty;

    private String fromloc;

    private String logicalfromloc;

    private String fromid;

    private String toloc;

    private String logicaltoloc;

    private String toid;

    private String caseid;

    private String pickmethod;

    private String status;

    private String statusmsg;

    private String priority;

    private String sourcepriority;

    private String holdkey;

    private String userkey;

    private String userposition;

    private String userkeyoverride;

    private Date starttime;

    private Date endtime;

    private String sourcetype;

    private String sourcekey;

    private String pickdetailkey;

    private String orderkey;

    private String orderlinenumber;

    private String listkey;

    private String wavekey;

    private String reasonkey;

    private String message01;

    private String message02;

    private String message03;

    private String finaltoloc;

    private Date releasedate;

    private String optbatchid;

    private String opttasksequence;

    private String optreplenishmentuom;

    private BigDecimal optqtylocminimum;

    private String optlocationtype;

    private BigDecimal optqtyloclimit;

    private Integer seqno;

    private Date adddate;

    private String addwho;

    private Date editdate;

    private String editwho;

    private String door;

    private String route;

    private String stop;

    private String putawayzone;

    private String boxno;

    private String pickno;

    private Date pickDate;

    private String pickUser;

    private String ccType;

    private BigDecimal qty01;

    private BigDecimal qty02;

    private BigDecimal qty03;

    private Date putawayDate;

    private String putawayUser;

    private String letterBoxFlag;

    private String sealUser;

    private Date sealDate;

    private String packkey;

    public TaskDetail(String taskdetailkey, Short serialkey, String whseid, String tasktype, String storerkey, String sku, String lot, String uom, BigDecimal uomqty, BigDecimal qty, String fromloc, String logicalfromloc, String fromid, String toloc, String logicaltoloc, String toid, String caseid, String pickmethod, String status, String statusmsg, String priority, String sourcepriority, String holdkey, String userkey, String userposition, String userkeyoverride, Date starttime, Date endtime, String sourcetype, String sourcekey, String pickdetailkey, String orderkey, String orderlinenumber, String listkey, String wavekey, String reasonkey, String message01, String message02, String message03, String finaltoloc, Date releasedate, String optbatchid, String opttasksequence, String optreplenishmentuom, BigDecimal optqtylocminimum, String optlocationtype, BigDecimal optqtyloclimit, Integer seqno, Date adddate, String addwho, Date editdate, String editwho, String door, String route, String stop, String putawayzone, String boxno, String pickno, Date pickDate, String pickUser, String ccType, BigDecimal qty01, BigDecimal qty02, BigDecimal qty03, Date putawayDate, String putawayUser, String letterBoxFlag, String sealUser, Date sealDate, String packkey) {
        this.taskdetailkey = taskdetailkey;
        this.serialkey = serialkey;
        this.whseid = whseid;
        this.tasktype = tasktype;
        this.storerkey = storerkey;
        this.sku = sku;
        this.lot = lot;
        this.uom = uom;
        this.uomqty = uomqty;
        this.qty = qty;
        this.fromloc = fromloc;
        this.logicalfromloc = logicalfromloc;
        this.fromid = fromid;
        this.toloc = toloc;
        this.logicaltoloc = logicaltoloc;
        this.toid = toid;
        this.caseid = caseid;
        this.pickmethod = pickmethod;
        this.status = status;
        this.statusmsg = statusmsg;
        this.priority = priority;
        this.sourcepriority = sourcepriority;
        this.holdkey = holdkey;
        this.userkey = userkey;
        this.userposition = userposition;
        this.userkeyoverride = userkeyoverride;
        this.starttime = starttime;
        this.endtime = endtime;
        this.sourcetype = sourcetype;
        this.sourcekey = sourcekey;
        this.pickdetailkey = pickdetailkey;
        this.orderkey = orderkey;
        this.orderlinenumber = orderlinenumber;
        this.listkey = listkey;
        this.wavekey = wavekey;
        this.reasonkey = reasonkey;
        this.message01 = message01;
        this.message02 = message02;
        this.message03 = message03;
        this.finaltoloc = finaltoloc;
        this.releasedate = releasedate;
        this.optbatchid = optbatchid;
        this.opttasksequence = opttasksequence;
        this.optreplenishmentuom = optreplenishmentuom;
        this.optqtylocminimum = optqtylocminimum;
        this.optlocationtype = optlocationtype;
        this.optqtyloclimit = optqtyloclimit;
        this.seqno = seqno;
        this.adddate = adddate;
        this.addwho = addwho;
        this.editdate = editdate;
        this.editwho = editwho;
        this.door = door;
        this.route = route;
        this.stop = stop;
        this.putawayzone = putawayzone;
        this.boxno = boxno;
        this.pickno = pickno;
        this.pickDate = pickDate;
        this.pickUser = pickUser;
        this.ccType = ccType;
        this.qty01 = qty01;
        this.qty02 = qty02;
        this.qty03 = qty03;
        this.putawayDate = putawayDate;
        this.putawayUser = putawayUser;
        this.letterBoxFlag = letterBoxFlag;
        this.sealUser = sealUser;
        this.sealDate = sealDate;
        this.packkey = packkey;
    }

    public TaskDetail() {
        super();
    }

    public String getTaskdetailkey() {
        return taskdetailkey;
    }

    public void setTaskdetailkey(String taskdetailkey) {
        this.taskdetailkey = taskdetailkey == null ? null : taskdetailkey.trim();
    }

    public Short getSerialkey() {
        return serialkey;
    }

    public void setSerialkey(Short serialkey) {
        this.serialkey = serialkey;
    }

    public String getWhseid() {
        return whseid;
    }

    public void setWhseid(String whseid) {
        this.whseid = whseid == null ? null : whseid.trim();
    }

    public String getTasktype() {
        return tasktype;
    }

    public void setTasktype(String tasktype) {
        this.tasktype = tasktype == null ? null : tasktype.trim();
    }

    public String getStorerkey() {
        return storerkey;
    }

    public void setStorerkey(String storerkey) {
        this.storerkey = storerkey == null ? null : storerkey.trim();
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku == null ? null : sku.trim();
    }

    public String getLot() {
        return lot;
    }

    public void setLot(String lot) {
        this.lot = lot == null ? null : lot.trim();
    }

    public String getUom() {
        return uom;
    }

    public void setUom(String uom) {
        this.uom = uom == null ? null : uom.trim();
    }

    public BigDecimal getUomqty() {
        return uomqty;
    }

    public void setUomqty(BigDecimal uomqty) {
        this.uomqty = uomqty;
    }

    public BigDecimal getQty() {
        return qty;
    }

    public void setQty(BigDecimal qty) {
        this.qty = qty;
    }

    public String getFromloc() {
        return fromloc;
    }

    public void setFromloc(String fromloc) {
        this.fromloc = fromloc == null ? null : fromloc.trim();
    }

    public String getLogicalfromloc() {
        return logicalfromloc;
    }

    public void setLogicalfromloc(String logicalfromloc) {
        this.logicalfromloc = logicalfromloc == null ? null : logicalfromloc.trim();
    }

    public String getFromid() {
        return fromid;
    }

    public void setFromid(String fromid) {
        this.fromid = fromid == null ? null : fromid.trim();
    }

    public String getToloc() {
        return toloc;
    }

    public void setToloc(String toloc) {
        this.toloc = toloc == null ? null : toloc.trim();
    }

    public String getLogicaltoloc() {
        return logicaltoloc;
    }

    public void setLogicaltoloc(String logicaltoloc) {
        this.logicaltoloc = logicaltoloc == null ? null : logicaltoloc.trim();
    }

    public String getToid() {
        return toid;
    }

    public void setToid(String toid) {
        this.toid = toid == null ? null : toid.trim();
    }

    public String getCaseid() {
        return caseid;
    }

    public void setCaseid(String caseid) {
        this.caseid = caseid == null ? null : caseid.trim();
    }

    public String getPickmethod() {
        return pickmethod;
    }

    public void setPickmethod(String pickmethod) {
        this.pickmethod = pickmethod == null ? null : pickmethod.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getStatusmsg() {
        return statusmsg;
    }

    public void setStatusmsg(String statusmsg) {
        this.statusmsg = statusmsg == null ? null : statusmsg.trim();
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority == null ? null : priority.trim();
    }

    public String getSourcepriority() {
        return sourcepriority;
    }

    public void setSourcepriority(String sourcepriority) {
        this.sourcepriority = sourcepriority == null ? null : sourcepriority.trim();
    }

    public String getHoldkey() {
        return holdkey;
    }

    public void setHoldkey(String holdkey) {
        this.holdkey = holdkey == null ? null : holdkey.trim();
    }

    public String getUserkey() {
        return userkey;
    }

    public void setUserkey(String userkey) {
        this.userkey = userkey == null ? null : userkey.trim();
    }

    public String getUserposition() {
        return userposition;
    }

    public void setUserposition(String userposition) {
        this.userposition = userposition == null ? null : userposition.trim();
    }

    public String getUserkeyoverride() {
        return userkeyoverride;
    }

    public void setUserkeyoverride(String userkeyoverride) {
        this.userkeyoverride = userkeyoverride == null ? null : userkeyoverride.trim();
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public String getSourcetype() {
        return sourcetype;
    }

    public void setSourcetype(String sourcetype) {
        this.sourcetype = sourcetype == null ? null : sourcetype.trim();
    }

    public String getSourcekey() {
        return sourcekey;
    }

    public void setSourcekey(String sourcekey) {
        this.sourcekey = sourcekey == null ? null : sourcekey.trim();
    }

    public String getPickdetailkey() {
        return pickdetailkey;
    }

    public void setPickdetailkey(String pickdetailkey) {
        this.pickdetailkey = pickdetailkey == null ? null : pickdetailkey.trim();
    }

    public String getOrderkey() {
        return orderkey;
    }

    public void setOrderkey(String orderkey) {
        this.orderkey = orderkey == null ? null : orderkey.trim();
    }

    public String getOrderlinenumber() {
        return orderlinenumber;
    }

    public void setOrderlinenumber(String orderlinenumber) {
        this.orderlinenumber = orderlinenumber == null ? null : orderlinenumber.trim();
    }

    public String getListkey() {
        return listkey;
    }

    public void setListkey(String listkey) {
        this.listkey = listkey == null ? null : listkey.trim();
    }

    public String getWavekey() {
        return wavekey;
    }

    public void setWavekey(String wavekey) {
        this.wavekey = wavekey == null ? null : wavekey.trim();
    }

    public String getReasonkey() {
        return reasonkey;
    }

    public void setReasonkey(String reasonkey) {
        this.reasonkey = reasonkey == null ? null : reasonkey.trim();
    }

    public String getMessage01() {
        return message01;
    }

    public void setMessage01(String message01) {
        this.message01 = message01 == null ? null : message01.trim();
    }

    public String getMessage02() {
        return message02;
    }

    public void setMessage02(String message02) {
        this.message02 = message02 == null ? null : message02.trim();
    }

    public String getMessage03() {
        return message03;
    }

    public void setMessage03(String message03) {
        this.message03 = message03 == null ? null : message03.trim();
    }

    public String getFinaltoloc() {
        return finaltoloc;
    }

    public void setFinaltoloc(String finaltoloc) {
        this.finaltoloc = finaltoloc == null ? null : finaltoloc.trim();
    }

    public Date getReleasedate() {
        return releasedate;
    }

    public void setReleasedate(Date releasedate) {
        this.releasedate = releasedate;
    }

    public String getOptbatchid() {
        return optbatchid;
    }

    public void setOptbatchid(String optbatchid) {
        this.optbatchid = optbatchid == null ? null : optbatchid.trim();
    }

    public String getOpttasksequence() {
        return opttasksequence;
    }

    public void setOpttasksequence(String opttasksequence) {
        this.opttasksequence = opttasksequence == null ? null : opttasksequence.trim();
    }

    public String getOptreplenishmentuom() {
        return optreplenishmentuom;
    }

    public void setOptreplenishmentuom(String optreplenishmentuom) {
        this.optreplenishmentuom = optreplenishmentuom == null ? null : optreplenishmentuom.trim();
    }

    public BigDecimal getOptqtylocminimum() {
        return optqtylocminimum;
    }

    public void setOptqtylocminimum(BigDecimal optqtylocminimum) {
        this.optqtylocminimum = optqtylocminimum;
    }

    public String getOptlocationtype() {
        return optlocationtype;
    }

    public void setOptlocationtype(String optlocationtype) {
        this.optlocationtype = optlocationtype == null ? null : optlocationtype.trim();
    }

    public BigDecimal getOptqtyloclimit() {
        return optqtyloclimit;
    }

    public void setOptqtyloclimit(BigDecimal optqtyloclimit) {
        this.optqtyloclimit = optqtyloclimit;
    }

    public Integer getSeqno() {
        return seqno;
    }

    public void setSeqno(Integer seqno) {
        this.seqno = seqno;
    }

    public Date getAdddate() {
        return adddate;
    }

    public void setAdddate(Date adddate) {
        this.adddate = adddate;
    }

    public String getAddwho() {
        return addwho;
    }

    public void setAddwho(String addwho) {
        this.addwho = addwho == null ? null : addwho.trim();
    }

    public Date getEditdate() {
        return editdate;
    }

    public void setEditdate(Date editdate) {
        this.editdate = editdate;
    }

    public String getEditwho() {
        return editwho;
    }

    public void setEditwho(String editwho) {
        this.editwho = editwho == null ? null : editwho.trim();
    }

    public String getDoor() {
        return door;
    }

    public void setDoor(String door) {
        this.door = door == null ? null : door.trim();
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route == null ? null : route.trim();
    }

    public String getStop() {
        return stop;
    }

    public void setStop(String stop) {
        this.stop = stop == null ? null : stop.trim();
    }

    public String getPutawayzone() {
        return putawayzone;
    }

    public void setPutawayzone(String putawayzone) {
        this.putawayzone = putawayzone == null ? null : putawayzone.trim();
    }

    public String getBoxno() {
        return boxno;
    }

    public void setBoxno(String boxno) {
        this.boxno = boxno == null ? null : boxno.trim();
    }

    public String getPickno() {
        return pickno;
    }

    public void setPickno(String pickno) {
        this.pickno = pickno == null ? null : pickno.trim();
    }

    public Date getPickDate() {
        return pickDate;
    }

    public void setPickDate(Date pickDate) {
        this.pickDate = pickDate;
    }

    public String getPickUser() {
        return pickUser;
    }

    public void setPickUser(String pickUser) {
        this.pickUser = pickUser == null ? null : pickUser.trim();
    }

    public String getCcType() {
        return ccType;
    }

    public void setCcType(String ccType) {
        this.ccType = ccType == null ? null : ccType.trim();
    }

    public BigDecimal getQty01() {
        return qty01;
    }

    public void setQty01(BigDecimal qty01) {
        this.qty01 = qty01;
    }

    public BigDecimal getQty02() {
        return qty02;
    }

    public void setQty02(BigDecimal qty02) {
        this.qty02 = qty02;
    }

    public BigDecimal getQty03() {
        return qty03;
    }

    public void setQty03(BigDecimal qty03) {
        this.qty03 = qty03;
    }

    public Date getPutawayDate() {
        return putawayDate;
    }

    public void setPutawayDate(Date putawayDate) {
        this.putawayDate = putawayDate;
    }

    public String getPutawayUser() {
        return putawayUser;
    }

    public void setPutawayUser(String putawayUser) {
        this.putawayUser = putawayUser == null ? null : putawayUser.trim();
    }

    public String getLetterBoxFlag() {
        return letterBoxFlag;
    }

    public void setLetterBoxFlag(String letterBoxFlag) {
        this.letterBoxFlag = letterBoxFlag == null ? null : letterBoxFlag.trim();
    }

    public String getSealUser() {
        return sealUser;
    }

    public void setSealUser(String sealUser) {
        this.sealUser = sealUser == null ? null : sealUser.trim();
    }

    public Date getSealDate() {
        return sealDate;
    }

    public void setSealDate(Date sealDate) {
        this.sealDate = sealDate;
    }

    public String getPackkey() {
        return packkey;
    }

    public void setPackkey(String packkey) {
        this.packkey = packkey == null ? null : packkey.trim();
    }
}