package com.management.pojo.report;

import java.math.BigDecimal;
import java.util.Date;

public class Replenishment extends ReplenishmentKey {
    private Short serialkey;

    private String whseid;

    private String storerkey;

    private String sku;

    private String fromloc;

    private String toloc;

    private String lot;

    private String id;

    private BigDecimal qty;

    private BigDecimal qtymoved;

    private BigDecimal qtyinpickloc;

    private String priority;

    private String uom;

    private String packkey;

    private String idmoved;

    private String lotmoved;

    private String locmovedfrom;

    private String reason;

    private String toid;

    private String finaltoloc;

    private Date adddate;

    private String addwho;

    private Date editdate;

    private String editwho;

    private String status;

    private String sendcode;

    private Date sendtime;

    private String reType;

    public Replenishment(String replenishmentgroup, String replenishmentkey, Short serialkey, String whseid, String storerkey, String sku, String fromloc, String toloc, String lot, String id, BigDecimal qty, BigDecimal qtymoved, BigDecimal qtyinpickloc, String priority, String uom, String packkey, String idmoved, String lotmoved, String locmovedfrom, String reason, String toid, String finaltoloc, Date adddate, String addwho, Date editdate, String editwho, String status, String sendcode, Date sendtime, String reType) {
        super(replenishmentgroup, replenishmentkey);
        this.serialkey = serialkey;
        this.whseid = whseid;
        this.storerkey = storerkey;
        this.sku = sku;
        this.fromloc = fromloc;
        this.toloc = toloc;
        this.lot = lot;
        this.id = id;
        this.qty = qty;
        this.qtymoved = qtymoved;
        this.qtyinpickloc = qtyinpickloc;
        this.priority = priority;
        this.uom = uom;
        this.packkey = packkey;
        this.idmoved = idmoved;
        this.lotmoved = lotmoved;
        this.locmovedfrom = locmovedfrom;
        this.reason = reason;
        this.toid = toid;
        this.finaltoloc = finaltoloc;
        this.adddate = adddate;
        this.addwho = addwho;
        this.editdate = editdate;
        this.editwho = editwho;
        this.status = status;
        this.sendcode = sendcode;
        this.sendtime = sendtime;
        this.reType = reType;
    }

    public Replenishment() {
        super();
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

    public String getFromloc() {
        return fromloc;
    }

    public void setFromloc(String fromloc) {
        this.fromloc = fromloc == null ? null : fromloc.trim();
    }

    public String getToloc() {
        return toloc;
    }

    public void setToloc(String toloc) {
        this.toloc = toloc == null ? null : toloc.trim();
    }

    public String getLot() {
        return lot;
    }

    public void setLot(String lot) {
        this.lot = lot == null ? null : lot.trim();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
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

    public BigDecimal getQtyinpickloc() {
        return qtyinpickloc;
    }

    public void setQtyinpickloc(BigDecimal qtyinpickloc) {
        this.qtyinpickloc = qtyinpickloc;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority == null ? null : priority.trim();
    }

    public String getUom() {
        return uom;
    }

    public void setUom(String uom) {
        this.uom = uom == null ? null : uom.trim();
    }

    public String getPackkey() {
        return packkey;
    }

    public void setPackkey(String packkey) {
        this.packkey = packkey == null ? null : packkey.trim();
    }

    public String getIdmoved() {
        return idmoved;
    }

    public void setIdmoved(String idmoved) {
        this.idmoved = idmoved == null ? null : idmoved.trim();
    }

    public String getLotmoved() {
        return lotmoved;
    }

    public void setLotmoved(String lotmoved) {
        this.lotmoved = lotmoved == null ? null : lotmoved.trim();
    }

    public String getLocmovedfrom() {
        return locmovedfrom;
    }

    public void setLocmovedfrom(String locmovedfrom) {
        this.locmovedfrom = locmovedfrom == null ? null : locmovedfrom.trim();
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason == null ? null : reason.trim();
    }

    public String getToid() {
        return toid;
    }

    public void setToid(String toid) {
        this.toid = toid == null ? null : toid.trim();
    }

    public String getFinaltoloc() {
        return finaltoloc;
    }

    public void setFinaltoloc(String finaltoloc) {
        this.finaltoloc = finaltoloc == null ? null : finaltoloc.trim();
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
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

    public String getReType() {
        return reType;
    }

    public void setReType(String reType) {
        this.reType = reType == null ? null : reType.trim();
    }
}