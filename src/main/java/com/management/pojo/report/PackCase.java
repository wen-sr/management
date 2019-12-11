package com.management.pojo.report;

import java.math.BigDecimal;
import java.util.Date;

public class PackCase {
    private String packid;

    private String batchNo;

    private String fromtable;

    private String fromtype;

    private String pickdetailkey;

    private String storerkey;

    private String boxno;

    private String boxnobak;

    private String caseid;

    private String caselineno;

    private Short type;

    private String docNumber;

    private String seq;

    private String sku;

    private Short packqty;

    private Short confirmQty;

    private BigDecimal price;

    private BigDecimal discount;

    private BigDecimal my;

    private BigDecimal status;

    private String consk;

    private String shortname;

    private String exportno;

    private String susr1;

    private String susr2;

    private String susr3;

    private String susr4;

    private String susr5;

    private Date adddate;

    private String addwho;

    private Date editdate;

    private String editwho;

    private String packUser;

    private Date packDate;

    private String confirmUser;

    private Date confirmDate;

    private String mergeUser;

    private Date mergeDate;

    private String sowUser;

    private Date sowDate;

    private BigDecimal netWeight;

    private BigDecimal actWeight;

    private String barcode;

    private String descr;

    private String isMerge;

    private String pickno;

    private String route;

    private String putawayzone;

    private String packUser1;

    private Date packDate1;

    private String packloc;

    private String station;

    private String orderkey;

    private String frombox;

    private String wesHangup;

    private String mergeStatus;

    private String mergetaskno;

    private String wesHangupOld;

    private String canmerge;

    private String isRefuse;

    public PackCase(String packid, String batchNo, String fromtable, String fromtype, String pickdetailkey, String storerkey, String boxno, String boxnobak, String caseid, String caselineno, Short type, String docNumber, String seq, String sku, Short packqty, Short confirmQty, BigDecimal price, BigDecimal discount, BigDecimal my, BigDecimal status, String consk, String shortname, String exportno, String susr1, String susr2, String susr3, String susr4, String susr5, Date adddate, String addwho, Date editdate, String editwho, String packUser, Date packDate, String confirmUser, Date confirmDate, String mergeUser, Date mergeDate, String sowUser, Date sowDate, BigDecimal netWeight, BigDecimal actWeight, String barcode, String descr, String isMerge, String pickno, String route, String putawayzone, String packUser1, Date packDate1, String packloc, String station, String orderkey, String frombox, String wesHangup, String mergeStatus, String mergetaskno, String wesHangupOld, String canmerge, String isRefuse) {
        this.packid = packid;
        this.batchNo = batchNo;
        this.fromtable = fromtable;
        this.fromtype = fromtype;
        this.pickdetailkey = pickdetailkey;
        this.storerkey = storerkey;
        this.boxno = boxno;
        this.boxnobak = boxnobak;
        this.caseid = caseid;
        this.caselineno = caselineno;
        this.type = type;
        this.docNumber = docNumber;
        this.seq = seq;
        this.sku = sku;
        this.packqty = packqty;
        this.confirmQty = confirmQty;
        this.price = price;
        this.discount = discount;
        this.my = my;
        this.status = status;
        this.consk = consk;
        this.shortname = shortname;
        this.exportno = exportno;
        this.susr1 = susr1;
        this.susr2 = susr2;
        this.susr3 = susr3;
        this.susr4 = susr4;
        this.susr5 = susr5;
        this.adddate = adddate;
        this.addwho = addwho;
        this.editdate = editdate;
        this.editwho = editwho;
        this.packUser = packUser;
        this.packDate = packDate;
        this.confirmUser = confirmUser;
        this.confirmDate = confirmDate;
        this.mergeUser = mergeUser;
        this.mergeDate = mergeDate;
        this.sowUser = sowUser;
        this.sowDate = sowDate;
        this.netWeight = netWeight;
        this.actWeight = actWeight;
        this.barcode = barcode;
        this.descr = descr;
        this.isMerge = isMerge;
        this.pickno = pickno;
        this.route = route;
        this.putawayzone = putawayzone;
        this.packUser1 = packUser1;
        this.packDate1 = packDate1;
        this.packloc = packloc;
        this.station = station;
        this.orderkey = orderkey;
        this.frombox = frombox;
        this.wesHangup = wesHangup;
        this.mergeStatus = mergeStatus;
        this.mergetaskno = mergetaskno;
        this.wesHangupOld = wesHangupOld;
        this.canmerge = canmerge;
        this.isRefuse = isRefuse;
    }

    public PackCase() {
        super();
    }

    public String getPackid() {
        return packid;
    }

    public void setPackid(String packid) {
        this.packid = packid == null ? null : packid.trim();
    }

    public String getBatchNo() {
        return batchNo;
    }

    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo == null ? null : batchNo.trim();
    }

    public String getFromtable() {
        return fromtable;
    }

    public void setFromtable(String fromtable) {
        this.fromtable = fromtable == null ? null : fromtable.trim();
    }

    public String getFromtype() {
        return fromtype;
    }

    public void setFromtype(String fromtype) {
        this.fromtype = fromtype == null ? null : fromtype.trim();
    }

    public String getPickdetailkey() {
        return pickdetailkey;
    }

    public void setPickdetailkey(String pickdetailkey) {
        this.pickdetailkey = pickdetailkey == null ? null : pickdetailkey.trim();
    }

    public String getStorerkey() {
        return storerkey;
    }

    public void setStorerkey(String storerkey) {
        this.storerkey = storerkey == null ? null : storerkey.trim();
    }

    public String getBoxno() {
        return boxno;
    }

    public void setBoxno(String boxno) {
        this.boxno = boxno == null ? null : boxno.trim();
    }

    public String getBoxnobak() {
        return boxnobak;
    }

    public void setBoxnobak(String boxnobak) {
        this.boxnobak = boxnobak == null ? null : boxnobak.trim();
    }

    public String getCaseid() {
        return caseid;
    }

    public void setCaseid(String caseid) {
        this.caseid = caseid == null ? null : caseid.trim();
    }

    public String getCaselineno() {
        return caselineno;
    }

    public void setCaselineno(String caselineno) {
        this.caselineno = caselineno == null ? null : caselineno.trim();
    }

    public Short getType() {
        return type;
    }

    public void setType(Short type) {
        this.type = type;
    }

    public String getDocNumber() {
        return docNumber;
    }

    public void setDocNumber(String docNumber) {
        this.docNumber = docNumber == null ? null : docNumber.trim();
    }

    public String getSeq() {
        return seq;
    }

    public void setSeq(String seq) {
        this.seq = seq == null ? null : seq.trim();
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku == null ? null : sku.trim();
    }

    public Short getPackqty() {
        return packqty;
    }

    public void setPackqty(Short packqty) {
        this.packqty = packqty;
    }

    public Short getConfirmQty() {
        return confirmQty;
    }

    public void setConfirmQty(Short confirmQty) {
        this.confirmQty = confirmQty;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public BigDecimal getMy() {
        return my;
    }

    public void setMy(BigDecimal my) {
        this.my = my;
    }

    public BigDecimal getStatus() {
        return status;
    }

    public void setStatus(BigDecimal status) {
        this.status = status;
    }

    public String getConsk() {
        return consk;
    }

    public void setConsk(String consk) {
        this.consk = consk == null ? null : consk.trim();
    }

    public String getShortname() {
        return shortname;
    }

    public void setShortname(String shortname) {
        this.shortname = shortname == null ? null : shortname.trim();
    }

    public String getExportno() {
        return exportno;
    }

    public void setExportno(String exportno) {
        this.exportno = exportno == null ? null : exportno.trim();
    }

    public String getSusr1() {
        return susr1;
    }

    public void setSusr1(String susr1) {
        this.susr1 = susr1 == null ? null : susr1.trim();
    }

    public String getSusr2() {
        return susr2;
    }

    public void setSusr2(String susr2) {
        this.susr2 = susr2 == null ? null : susr2.trim();
    }

    public String getSusr3() {
        return susr3;
    }

    public void setSusr3(String susr3) {
        this.susr3 = susr3 == null ? null : susr3.trim();
    }

    public String getSusr4() {
        return susr4;
    }

    public void setSusr4(String susr4) {
        this.susr4 = susr4 == null ? null : susr4.trim();
    }

    public String getSusr5() {
        return susr5;
    }

    public void setSusr5(String susr5) {
        this.susr5 = susr5 == null ? null : susr5.trim();
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

    public String getPackUser() {
        return packUser;
    }

    public void setPackUser(String packUser) {
        this.packUser = packUser == null ? null : packUser.trim();
    }

    public Date getPackDate() {
        return packDate;
    }

    public void setPackDate(Date packDate) {
        this.packDate = packDate;
    }

    public String getConfirmUser() {
        return confirmUser;
    }

    public void setConfirmUser(String confirmUser) {
        this.confirmUser = confirmUser == null ? null : confirmUser.trim();
    }

    public Date getConfirmDate() {
        return confirmDate;
    }

    public void setConfirmDate(Date confirmDate) {
        this.confirmDate = confirmDate;
    }

    public String getMergeUser() {
        return mergeUser;
    }

    public void setMergeUser(String mergeUser) {
        this.mergeUser = mergeUser == null ? null : mergeUser.trim();
    }

    public Date getMergeDate() {
        return mergeDate;
    }

    public void setMergeDate(Date mergeDate) {
        this.mergeDate = mergeDate;
    }

    public String getSowUser() {
        return sowUser;
    }

    public void setSowUser(String sowUser) {
        this.sowUser = sowUser == null ? null : sowUser.trim();
    }

    public Date getSowDate() {
        return sowDate;
    }

    public void setSowDate(Date sowDate) {
        this.sowDate = sowDate;
    }

    public BigDecimal getNetWeight() {
        return netWeight;
    }

    public void setNetWeight(BigDecimal netWeight) {
        this.netWeight = netWeight;
    }

    public BigDecimal getActWeight() {
        return actWeight;
    }

    public void setActWeight(BigDecimal actWeight) {
        this.actWeight = actWeight;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode == null ? null : barcode.trim();
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr == null ? null : descr.trim();
    }

    public String getIsMerge() {
        return isMerge;
    }

    public void setIsMerge(String isMerge) {
        this.isMerge = isMerge == null ? null : isMerge.trim();
    }

    public String getPickno() {
        return pickno;
    }

    public void setPickno(String pickno) {
        this.pickno = pickno == null ? null : pickno.trim();
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route == null ? null : route.trim();
    }

    public String getPutawayzone() {
        return putawayzone;
    }

    public void setPutawayzone(String putawayzone) {
        this.putawayzone = putawayzone == null ? null : putawayzone.trim();
    }

    public String getPackUser1() {
        return packUser1;
    }

    public void setPackUser1(String packUser1) {
        this.packUser1 = packUser1 == null ? null : packUser1.trim();
    }

    public Date getPackDate1() {
        return packDate1;
    }

    public void setPackDate1(Date packDate1) {
        this.packDate1 = packDate1;
    }

    public String getPackloc() {
        return packloc;
    }

    public void setPackloc(String packloc) {
        this.packloc = packloc == null ? null : packloc.trim();
    }

    public String getStation() {
        return station;
    }

    public void setStation(String station) {
        this.station = station == null ? null : station.trim();
    }

    public String getOrderkey() {
        return orderkey;
    }

    public void setOrderkey(String orderkey) {
        this.orderkey = orderkey == null ? null : orderkey.trim();
    }

    public String getFrombox() {
        return frombox;
    }

    public void setFrombox(String frombox) {
        this.frombox = frombox == null ? null : frombox.trim();
    }

    public String getWesHangup() {
        return wesHangup;
    }

    public void setWesHangup(String wesHangup) {
        this.wesHangup = wesHangup == null ? null : wesHangup.trim();
    }

    public String getMergeStatus() {
        return mergeStatus;
    }

    public void setMergeStatus(String mergeStatus) {
        this.mergeStatus = mergeStatus == null ? null : mergeStatus.trim();
    }

    public String getMergetaskno() {
        return mergetaskno;
    }

    public void setMergetaskno(String mergetaskno) {
        this.mergetaskno = mergetaskno == null ? null : mergetaskno.trim();
    }

    public String getWesHangupOld() {
        return wesHangupOld;
    }

    public void setWesHangupOld(String wesHangupOld) {
        this.wesHangupOld = wesHangupOld == null ? null : wesHangupOld.trim();
    }

    public String getCanmerge() {
        return canmerge;
    }

    public void setCanmerge(String canmerge) {
        this.canmerge = canmerge == null ? null : canmerge.trim();
    }

    public String getIsRefuse() {
        return isRefuse;
    }

    public void setIsRefuse(String isRefuse) {
        this.isRefuse = isRefuse == null ? null : isRefuse.trim();
    }
}