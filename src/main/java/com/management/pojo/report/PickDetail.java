package com.management.pojo.report;

import java.math.BigDecimal;
import java.util.Date;

public class PickDetail {
    private String pickdetailkey;

    private Short serialkey;

    private String whseid;

    private String caseid;

    private String pickheaderkey;

    private String orderkey;

    private String orderlinenumber;

    private String lot;

    private String storerkey;

    private String sku;

    private String altsku;

    private String uom;

    private BigDecimal uomqty;

    private BigDecimal qty;

    private BigDecimal qtymoved;

    private String status;

    private String dropid;

    private String loc;

    private String id;

    private String packkey;

    private String updatesource;

    private String cartongroup;

    private String cartontype;

    private String toloc;

    private String doreplenish;

    private String replenishzone;

    private String docartonize;

    private String pickmethod;

    private String wavekey;

    private Date effectivedate;

    private String forteFlag;

    private String fromloc;

    private String trackingid;

    private Short freightcharges;

    private String intermodalvehicle;

    private Long loadid;

    private Long stop;

    private String door;

    private String route;

    private String sortationlocation;

    private String sortationstation;

    private String batchcartonid;

    private String isclosed;

    private String qcstatus;

    private String pdudf1;

    private String pdudf2;

    private String pdudf3;

    private String picknotes;

    private String receiptkey;

    private String crossdocked;

    private Integer seqno;

    private String labeltype;

    private String companyprefix;

    private String serialreference;

    private Date adddate;

    private String addwho;

    private Date editdate;

    private String editwho;

    private String optimizecop;

    private String boxno;

    private String pickno;

    private Date pickDate;

    private String pickUser;

    private BigDecimal pickQty;

    private Short qtyold;

    private String sendcode;

    private Date sendtime;

    private String opstime;

    private String oldLoc;

    private String oldId;

    public PickDetail(String pickdetailkey, Short serialkey, String whseid, String caseid, String pickheaderkey, String orderkey, String orderlinenumber, String lot, String storerkey, String sku, String altsku, String uom, BigDecimal uomqty, BigDecimal qty, BigDecimal qtymoved, String status, String dropid, String loc, String id, String packkey, String updatesource, String cartongroup, String cartontype, String toloc, String doreplenish, String replenishzone, String docartonize, String pickmethod, String wavekey, Date effectivedate, String forteFlag, String fromloc, String trackingid, Short freightcharges, String intermodalvehicle, Long loadid, Long stop, String door, String route, String sortationlocation, String sortationstation, String batchcartonid, String isclosed, String qcstatus, String pdudf1, String pdudf2, String pdudf3, String picknotes, String receiptkey, String crossdocked, Integer seqno, String labeltype, String companyprefix, String serialreference, Date adddate, String addwho, Date editdate, String editwho, String optimizecop, String boxno, String pickno, Date pickDate, String pickUser, BigDecimal pickQty, Short qtyold, String sendcode, Date sendtime, String opstime, String oldLoc, String oldId) {
        this.pickdetailkey = pickdetailkey;
        this.serialkey = serialkey;
        this.whseid = whseid;
        this.caseid = caseid;
        this.pickheaderkey = pickheaderkey;
        this.orderkey = orderkey;
        this.orderlinenumber = orderlinenumber;
        this.lot = lot;
        this.storerkey = storerkey;
        this.sku = sku;
        this.altsku = altsku;
        this.uom = uom;
        this.uomqty = uomqty;
        this.qty = qty;
        this.qtymoved = qtymoved;
        this.status = status;
        this.dropid = dropid;
        this.loc = loc;
        this.id = id;
        this.packkey = packkey;
        this.updatesource = updatesource;
        this.cartongroup = cartongroup;
        this.cartontype = cartontype;
        this.toloc = toloc;
        this.doreplenish = doreplenish;
        this.replenishzone = replenishzone;
        this.docartonize = docartonize;
        this.pickmethod = pickmethod;
        this.wavekey = wavekey;
        this.effectivedate = effectivedate;
        this.forteFlag = forteFlag;
        this.fromloc = fromloc;
        this.trackingid = trackingid;
        this.freightcharges = freightcharges;
        this.intermodalvehicle = intermodalvehicle;
        this.loadid = loadid;
        this.stop = stop;
        this.door = door;
        this.route = route;
        this.sortationlocation = sortationlocation;
        this.sortationstation = sortationstation;
        this.batchcartonid = batchcartonid;
        this.isclosed = isclosed;
        this.qcstatus = qcstatus;
        this.pdudf1 = pdudf1;
        this.pdudf2 = pdudf2;
        this.pdudf3 = pdudf3;
        this.picknotes = picknotes;
        this.receiptkey = receiptkey;
        this.crossdocked = crossdocked;
        this.seqno = seqno;
        this.labeltype = labeltype;
        this.companyprefix = companyprefix;
        this.serialreference = serialreference;
        this.adddate = adddate;
        this.addwho = addwho;
        this.editdate = editdate;
        this.editwho = editwho;
        this.optimizecop = optimizecop;
        this.boxno = boxno;
        this.pickno = pickno;
        this.pickDate = pickDate;
        this.pickUser = pickUser;
        this.pickQty = pickQty;
        this.qtyold = qtyold;
        this.sendcode = sendcode;
        this.sendtime = sendtime;
        this.opstime = opstime;
        this.oldLoc = oldLoc;
        this.oldId = oldId;
    }

    public PickDetail() {
        super();
    }

    public String getPickdetailkey() {
        return pickdetailkey;
    }

    public void setPickdetailkey(String pickdetailkey) {
        this.pickdetailkey = pickdetailkey == null ? null : pickdetailkey.trim();
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

    public String getCaseid() {
        return caseid;
    }

    public void setCaseid(String caseid) {
        this.caseid = caseid == null ? null : caseid.trim();
    }

    public String getPickheaderkey() {
        return pickheaderkey;
    }

    public void setPickheaderkey(String pickheaderkey) {
        this.pickheaderkey = pickheaderkey == null ? null : pickheaderkey.trim();
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

    public String getLot() {
        return lot;
    }

    public void setLot(String lot) {
        this.lot = lot == null ? null : lot.trim();
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

    public String getAltsku() {
        return altsku;
    }

    public void setAltsku(String altsku) {
        this.altsku = altsku == null ? null : altsku.trim();
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

    public BigDecimal getQtymoved() {
        return qtymoved;
    }

    public void setQtymoved(BigDecimal qtymoved) {
        this.qtymoved = qtymoved;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getDropid() {
        return dropid;
    }

    public void setDropid(String dropid) {
        this.dropid = dropid == null ? null : dropid.trim();
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc == null ? null : loc.trim();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getPackkey() {
        return packkey;
    }

    public void setPackkey(String packkey) {
        this.packkey = packkey == null ? null : packkey.trim();
    }

    public String getUpdatesource() {
        return updatesource;
    }

    public void setUpdatesource(String updatesource) {
        this.updatesource = updatesource == null ? null : updatesource.trim();
    }

    public String getCartongroup() {
        return cartongroup;
    }

    public void setCartongroup(String cartongroup) {
        this.cartongroup = cartongroup == null ? null : cartongroup.trim();
    }

    public String getCartontype() {
        return cartontype;
    }

    public void setCartontype(String cartontype) {
        this.cartontype = cartontype == null ? null : cartontype.trim();
    }

    public String getToloc() {
        return toloc;
    }

    public void setToloc(String toloc) {
        this.toloc = toloc == null ? null : toloc.trim();
    }

    public String getDoreplenish() {
        return doreplenish;
    }

    public void setDoreplenish(String doreplenish) {
        this.doreplenish = doreplenish == null ? null : doreplenish.trim();
    }

    public String getReplenishzone() {
        return replenishzone;
    }

    public void setReplenishzone(String replenishzone) {
        this.replenishzone = replenishzone == null ? null : replenishzone.trim();
    }

    public String getDocartonize() {
        return docartonize;
    }

    public void setDocartonize(String docartonize) {
        this.docartonize = docartonize == null ? null : docartonize.trim();
    }

    public String getPickmethod() {
        return pickmethod;
    }

    public void setPickmethod(String pickmethod) {
        this.pickmethod = pickmethod == null ? null : pickmethod.trim();
    }

    public String getWavekey() {
        return wavekey;
    }

    public void setWavekey(String wavekey) {
        this.wavekey = wavekey == null ? null : wavekey.trim();
    }

    public Date getEffectivedate() {
        return effectivedate;
    }

    public void setEffectivedate(Date effectivedate) {
        this.effectivedate = effectivedate;
    }

    public String getForteFlag() {
        return forteFlag;
    }

    public void setForteFlag(String forteFlag) {
        this.forteFlag = forteFlag == null ? null : forteFlag.trim();
    }

    public String getFromloc() {
        return fromloc;
    }

    public void setFromloc(String fromloc) {
        this.fromloc = fromloc == null ? null : fromloc.trim();
    }

    public String getTrackingid() {
        return trackingid;
    }

    public void setTrackingid(String trackingid) {
        this.trackingid = trackingid == null ? null : trackingid.trim();
    }

    public Short getFreightcharges() {
        return freightcharges;
    }

    public void setFreightcharges(Short freightcharges) {
        this.freightcharges = freightcharges;
    }

    public String getIntermodalvehicle() {
        return intermodalvehicle;
    }

    public void setIntermodalvehicle(String intermodalvehicle) {
        this.intermodalvehicle = intermodalvehicle == null ? null : intermodalvehicle.trim();
    }

    public Long getLoadid() {
        return loadid;
    }

    public void setLoadid(Long loadid) {
        this.loadid = loadid;
    }

    public Long getStop() {
        return stop;
    }

    public void setStop(Long stop) {
        this.stop = stop;
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

    public String getSortationlocation() {
        return sortationlocation;
    }

    public void setSortationlocation(String sortationlocation) {
        this.sortationlocation = sortationlocation == null ? null : sortationlocation.trim();
    }

    public String getSortationstation() {
        return sortationstation;
    }

    public void setSortationstation(String sortationstation) {
        this.sortationstation = sortationstation == null ? null : sortationstation.trim();
    }

    public String getBatchcartonid() {
        return batchcartonid;
    }

    public void setBatchcartonid(String batchcartonid) {
        this.batchcartonid = batchcartonid == null ? null : batchcartonid.trim();
    }

    public String getIsclosed() {
        return isclosed;
    }

    public void setIsclosed(String isclosed) {
        this.isclosed = isclosed == null ? null : isclosed.trim();
    }

    public String getQcstatus() {
        return qcstatus;
    }

    public void setQcstatus(String qcstatus) {
        this.qcstatus = qcstatus == null ? null : qcstatus.trim();
    }

    public String getPdudf1() {
        return pdudf1;
    }

    public void setPdudf1(String pdudf1) {
        this.pdudf1 = pdudf1 == null ? null : pdudf1.trim();
    }

    public String getPdudf2() {
        return pdudf2;
    }

    public void setPdudf2(String pdudf2) {
        this.pdudf2 = pdudf2 == null ? null : pdudf2.trim();
    }

    public String getPdudf3() {
        return pdudf3;
    }

    public void setPdudf3(String pdudf3) {
        this.pdudf3 = pdudf3 == null ? null : pdudf3.trim();
    }

    public String getPicknotes() {
        return picknotes;
    }

    public void setPicknotes(String picknotes) {
        this.picknotes = picknotes == null ? null : picknotes.trim();
    }

    public String getReceiptkey() {
        return receiptkey;
    }

    public void setReceiptkey(String receiptkey) {
        this.receiptkey = receiptkey == null ? null : receiptkey.trim();
    }

    public String getCrossdocked() {
        return crossdocked;
    }

    public void setCrossdocked(String crossdocked) {
        this.crossdocked = crossdocked == null ? null : crossdocked.trim();
    }

    public Integer getSeqno() {
        return seqno;
    }

    public void setSeqno(Integer seqno) {
        this.seqno = seqno;
    }

    public String getLabeltype() {
        return labeltype;
    }

    public void setLabeltype(String labeltype) {
        this.labeltype = labeltype == null ? null : labeltype.trim();
    }

    public String getCompanyprefix() {
        return companyprefix;
    }

    public void setCompanyprefix(String companyprefix) {
        this.companyprefix = companyprefix == null ? null : companyprefix.trim();
    }

    public String getSerialreference() {
        return serialreference;
    }

    public void setSerialreference(String serialreference) {
        this.serialreference = serialreference == null ? null : serialreference.trim();
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

    public String getOptimizecop() {
        return optimizecop;
    }

    public void setOptimizecop(String optimizecop) {
        this.optimizecop = optimizecop == null ? null : optimizecop.trim();
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

    public BigDecimal getPickQty() {
        return pickQty;
    }

    public void setPickQty(BigDecimal pickQty) {
        this.pickQty = pickQty;
    }

    public Short getQtyold() {
        return qtyold;
    }

    public void setQtyold(Short qtyold) {
        this.qtyold = qtyold;
    }

    public String getSendcode() {
        return sendcode;
    }

    public void setSendcode(String sendcode) {
        this.sendcode = sendcode == null ? null : sendcode.trim();
    }

    public Date getSendtime() {
        return sendtime;
    }

    public void setSendtime(Date sendtime) {
        this.sendtime = sendtime;
    }

    public String getOpstime() {
        return opstime;
    }

    public void setOpstime(String opstime) {
        this.opstime = opstime == null ? null : opstime.trim();
    }

    public String getOldLoc() {
        return oldLoc;
    }

    public void setOldLoc(String oldLoc) {
        this.oldLoc = oldLoc == null ? null : oldLoc.trim();
    }

    public String getOldId() {
        return oldId;
    }

    public void setOldId(String oldId) {
        this.oldId = oldId == null ? null : oldId.trim();
    }
}