package com.management.pojo.report;

import java.math.BigDecimal;
import java.util.Date;

public class CaseId extends CaseIdKey {
    private String batchno;

    private String shipkey;

    private String docStorerkey;

    private String wh;

    private String consk;

    private String shortname;

    private String status;

    private String loc;

    private Short qty;

    private BigDecimal amt;

    private BigDecimal net;

    private BigDecimal weight;

    private BigDecimal netweight;

    private BigDecimal volume;

    private String susr1;

    private String susr2;

    private String susr3;

    private String susr4;

    private String susr5;

    private Date adddate;

    private String addwho;

    private Date editdate;

    private String editwho;

    private BigDecimal boxWgt;

    private String sendUser;

    private Date sendDate;

    private String recUser;

    private Date recDate;

    private String divedeUser;

    private Date divideDate;

    private String mergeUser;

    private Date mergeDate;

    private String confirmUser;

    private Date confirmDate;

    private String loadUser;

    private Date loadDate;

    private String shipUser;

    private Date shipDate;

    private String isMerge;

    private String packUser;

    private Date packDate;

    private String boxno;

    private String flag;

    private String boxnoBind;

    private String caseoutflag;

    private String boxnoDisbind;

    private String id;

    private String idbindwho;

    private String caseinflag;

    private String caseoutbatch;

    private String caseoutid;

    private Date outbatchnodt;

    private String idvalidflag;

    private String tmsType;

    private String toloc;

    private String contoutstatus;

    private String contouttaskno;

    private Date caseintime;

    private Date idbindtime;

    private String taskno;

    private String boxnoBindHis;

    private String bindPalletUser;

    private Date bindPalletDate;

    private String idBinder;

    private Date idBindtime;

    private Date boxnoBindTime;

    private String boxnoBindWho;

    private String manualnotes;

    private String statusZjk;

    private Date caseouttime;

    private String isRefuse;

    private Date shipdate;

    private String sendType;

    private String signer;

    private Date signerdate;

    private String returner;

    private Date returndate;

    public CaseId(String caseid, String caseidBak, String batchno, String shipkey, String docStorerkey, String wh, String consk, String shortname, String status, String loc, Short qty, BigDecimal amt, BigDecimal net, BigDecimal weight, BigDecimal netweight, BigDecimal volume, String susr1, String susr2, String susr3, String susr4, String susr5, Date adddate, String addwho, Date editdate, String editwho, BigDecimal boxWgt, String sendUser, Date sendDate, String recUser, Date recDate, String divedeUser, Date divideDate, String mergeUser, Date mergeDate, String confirmUser, Date confirmDate, String loadUser, Date loadDate, String shipUser, Date shipDate, String isMerge, String packUser, Date packDate, String boxno, String flag, String boxnoBind, String caseoutflag, String boxnoDisbind, String id, String idbindwho, String caseinflag, String caseoutbatch, String caseoutid, Date outbatchnodt, String idvalidflag, String tmsType, String toloc, String contoutstatus, String contouttaskno, Date caseintime, Date idbindtime, String taskno, String boxnoBindHis, String bindPalletUser, Date bindPalletDate, String idBinder, Date idBindtime, Date boxnoBindTime, String boxnoBindWho, String manualnotes, String statusZjk, Date caseouttime, String isRefuse, Date shipdate, String sendType, String signer, Date signerdate, String returner, Date returndate) {
        super(caseid, caseidBak);
        this.batchno = batchno;
        this.shipkey = shipkey;
        this.docStorerkey = docStorerkey;
        this.wh = wh;
        this.consk = consk;
        this.shortname = shortname;
        this.status = status;
        this.loc = loc;
        this.qty = qty;
        this.amt = amt;
        this.net = net;
        this.weight = weight;
        this.netweight = netweight;
        this.volume = volume;
        this.susr1 = susr1;
        this.susr2 = susr2;
        this.susr3 = susr3;
        this.susr4 = susr4;
        this.susr5 = susr5;
        this.adddate = adddate;
        this.addwho = addwho;
        this.editdate = editdate;
        this.editwho = editwho;
        this.boxWgt = boxWgt;
        this.sendUser = sendUser;
        this.sendDate = sendDate;
        this.recUser = recUser;
        this.recDate = recDate;
        this.divedeUser = divedeUser;
        this.divideDate = divideDate;
        this.mergeUser = mergeUser;
        this.mergeDate = mergeDate;
        this.confirmUser = confirmUser;
        this.confirmDate = confirmDate;
        this.loadUser = loadUser;
        this.loadDate = loadDate;
        this.shipUser = shipUser;
        this.shipDate = shipDate;
        this.isMerge = isMerge;
        this.packUser = packUser;
        this.packDate = packDate;
        this.boxno = boxno;
        this.flag = flag;
        this.boxnoBind = boxnoBind;
        this.caseoutflag = caseoutflag;
        this.boxnoDisbind = boxnoDisbind;
        this.id = id;
        this.idbindwho = idbindwho;
        this.caseinflag = caseinflag;
        this.caseoutbatch = caseoutbatch;
        this.caseoutid = caseoutid;
        this.outbatchnodt = outbatchnodt;
        this.idvalidflag = idvalidflag;
        this.tmsType = tmsType;
        this.toloc = toloc;
        this.contoutstatus = contoutstatus;
        this.contouttaskno = contouttaskno;
        this.caseintime = caseintime;
        this.idbindtime = idbindtime;
        this.taskno = taskno;
        this.boxnoBindHis = boxnoBindHis;
        this.bindPalletUser = bindPalletUser;
        this.bindPalletDate = bindPalletDate;
        this.idBinder = idBinder;
        this.idBindtime = idBindtime;
        this.boxnoBindTime = boxnoBindTime;
        this.boxnoBindWho = boxnoBindWho;
        this.manualnotes = manualnotes;
        this.statusZjk = statusZjk;
        this.caseouttime = caseouttime;
        this.isRefuse = isRefuse;
        this.shipdate = shipdate;
        this.sendType = sendType;
        this.signer = signer;
        this.signerdate = signerdate;
        this.returner = returner;
        this.returndate = returndate;
    }

    public CaseId() {
        super();
    }

    public String getBatchno() {
        return batchno;
    }

    public void setBatchno(String batchno) {
        this.batchno = batchno == null ? null : batchno.trim();
    }

    public String getShipkey() {
        return shipkey;
    }

    public void setShipkey(String shipkey) {
        this.shipkey = shipkey == null ? null : shipkey.trim();
    }

    public String getDocStorerkey() {
        return docStorerkey;
    }

    public void setDocStorerkey(String docStorerkey) {
        this.docStorerkey = docStorerkey == null ? null : docStorerkey.trim();
    }

    public String getWh() {
        return wh;
    }

    public void setWh(String wh) {
        this.wh = wh == null ? null : wh.trim();
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc == null ? null : loc.trim();
    }

    public Short getQty() {
        return qty;
    }

    public void setQty(Short qty) {
        this.qty = qty;
    }

    public BigDecimal getAmt() {
        return amt;
    }

    public void setAmt(BigDecimal amt) {
        this.amt = amt;
    }

    public BigDecimal getNet() {
        return net;
    }

    public void setNet(BigDecimal net) {
        this.net = net;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public BigDecimal getNetweight() {
        return netweight;
    }

    public void setNetweight(BigDecimal netweight) {
        this.netweight = netweight;
    }

    public BigDecimal getVolume() {
        return volume;
    }

    public void setVolume(BigDecimal volume) {
        this.volume = volume;
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

    public BigDecimal getBoxWgt() {
        return boxWgt;
    }

    public void setBoxWgt(BigDecimal boxWgt) {
        this.boxWgt = boxWgt;
    }

    public String getSendUser() {
        return sendUser;
    }

    public void setSendUser(String sendUser) {
        this.sendUser = sendUser == null ? null : sendUser.trim();
    }

    public Date getSendDate() {
        return sendDate;
    }

    public void setSendDate(Date sendDate) {
        this.sendDate = sendDate;
    }

    public String getRecUser() {
        return recUser;
    }

    public void setRecUser(String recUser) {
        this.recUser = recUser == null ? null : recUser.trim();
    }

    public Date getRecDate() {
        return recDate;
    }

    public void setRecDate(Date recDate) {
        this.recDate = recDate;
    }

    public String getDivedeUser() {
        return divedeUser;
    }

    public void setDivedeUser(String divedeUser) {
        this.divedeUser = divedeUser == null ? null : divedeUser.trim();
    }

    public Date getDivideDate() {
        return divideDate;
    }

    public void setDivideDate(Date divideDate) {
        this.divideDate = divideDate;
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

    public String getLoadUser() {
        return loadUser;
    }

    public void setLoadUser(String loadUser) {
        this.loadUser = loadUser == null ? null : loadUser.trim();
    }

    public Date getLoadDate() {
        return loadDate;
    }

    public void setLoadDate(Date loadDate) {
        this.loadDate = loadDate;
    }

    public String getShipUser() {
        return shipUser;
    }

    public void setShipUser(String shipUser) {
        this.shipUser = shipUser == null ? null : shipUser.trim();
    }

    public Date getShipDate() {
        return shipDate;
    }

    public void setShipDate(Date shipDate) {
        this.shipDate = shipDate;
    }

    public String getIsMerge() {
        return isMerge;
    }

    public void setIsMerge(String isMerge) {
        this.isMerge = isMerge == null ? null : isMerge.trim();
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

    public String getBoxno() {
        return boxno;
    }

    public void setBoxno(String boxno) {
        this.boxno = boxno == null ? null : boxno.trim();
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag == null ? null : flag.trim();
    }

    public String getBoxnoBind() {
        return boxnoBind;
    }

    public void setBoxnoBind(String boxnoBind) {
        this.boxnoBind = boxnoBind == null ? null : boxnoBind.trim();
    }

    public String getCaseoutflag() {
        return caseoutflag;
    }

    public void setCaseoutflag(String caseoutflag) {
        this.caseoutflag = caseoutflag == null ? null : caseoutflag.trim();
    }

    public String getBoxnoDisbind() {
        return boxnoDisbind;
    }

    public void setBoxnoDisbind(String boxnoDisbind) {
        this.boxnoDisbind = boxnoDisbind == null ? null : boxnoDisbind.trim();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getIdbindwho() {
        return idbindwho;
    }

    public void setIdbindwho(String idbindwho) {
        this.idbindwho = idbindwho == null ? null : idbindwho.trim();
    }

    public String getCaseinflag() {
        return caseinflag;
    }

    public void setCaseinflag(String caseinflag) {
        this.caseinflag = caseinflag == null ? null : caseinflag.trim();
    }

    public String getCaseoutbatch() {
        return caseoutbatch;
    }

    public void setCaseoutbatch(String caseoutbatch) {
        this.caseoutbatch = caseoutbatch == null ? null : caseoutbatch.trim();
    }

    public String getCaseoutid() {
        return caseoutid;
    }

    public void setCaseoutid(String caseoutid) {
        this.caseoutid = caseoutid == null ? null : caseoutid.trim();
    }

    public Date getOutbatchnodt() {
        return outbatchnodt;
    }

    public void setOutbatchnodt(Date outbatchnodt) {
        this.outbatchnodt = outbatchnodt;
    }

    public String getIdvalidflag() {
        return idvalidflag;
    }

    public void setIdvalidflag(String idvalidflag) {
        this.idvalidflag = idvalidflag == null ? null : idvalidflag.trim();
    }

    public String getTmsType() {
        return tmsType;
    }

    public void setTmsType(String tmsType) {
        this.tmsType = tmsType == null ? null : tmsType.trim();
    }

    public String getToloc() {
        return toloc;
    }

    public void setToloc(String toloc) {
        this.toloc = toloc == null ? null : toloc.trim();
    }

    public String getContoutstatus() {
        return contoutstatus;
    }

    public void setContoutstatus(String contoutstatus) {
        this.contoutstatus = contoutstatus == null ? null : contoutstatus.trim();
    }

    public String getContouttaskno() {
        return contouttaskno;
    }

    public void setContouttaskno(String contouttaskno) {
        this.contouttaskno = contouttaskno == null ? null : contouttaskno.trim();
    }

    public Date getCaseintime() {
        return caseintime;
    }

    public void setCaseintime(Date caseintime) {
        this.caseintime = caseintime;
    }

    public Date getIdbindtime() {
        return idbindtime;
    }

    public void setIdbindtime(Date idbindtime) {
        this.idbindtime = idbindtime;
    }

    public String getTaskno() {
        return taskno;
    }

    public void setTaskno(String taskno) {
        this.taskno = taskno == null ? null : taskno.trim();
    }

    public String getBoxnoBindHis() {
        return boxnoBindHis;
    }

    public void setBoxnoBindHis(String boxnoBindHis) {
        this.boxnoBindHis = boxnoBindHis == null ? null : boxnoBindHis.trim();
    }

    public String getBindPalletUser() {
        return bindPalletUser;
    }

    public void setBindPalletUser(String bindPalletUser) {
        this.bindPalletUser = bindPalletUser == null ? null : bindPalletUser.trim();
    }

    public Date getBindPalletDate() {
        return bindPalletDate;
    }

    public void setBindPalletDate(Date bindPalletDate) {
        this.bindPalletDate = bindPalletDate;
    }

    public String getIdBinder() {
        return idBinder;
    }

    public void setIdBinder(String idBinder) {
        this.idBinder = idBinder == null ? null : idBinder.trim();
    }

    public Date getIdBindtime() {
        return idBindtime;
    }

    public void setIdBindtime(Date idBindtime) {
        this.idBindtime = idBindtime;
    }

    public Date getBoxnoBindTime() {
        return boxnoBindTime;
    }

    public void setBoxnoBindTime(Date boxnoBindTime) {
        this.boxnoBindTime = boxnoBindTime;
    }

    public String getBoxnoBindWho() {
        return boxnoBindWho;
    }

    public void setBoxnoBindWho(String boxnoBindWho) {
        this.boxnoBindWho = boxnoBindWho == null ? null : boxnoBindWho.trim();
    }

    public String getManualnotes() {
        return manualnotes;
    }

    public void setManualnotes(String manualnotes) {
        this.manualnotes = manualnotes == null ? null : manualnotes.trim();
    }

    public String getStatusZjk() {
        return statusZjk;
    }

    public void setStatusZjk(String statusZjk) {
        this.statusZjk = statusZjk == null ? null : statusZjk.trim();
    }

    public Date getCaseouttime() {
        return caseouttime;
    }

    public void setCaseouttime(Date caseouttime) {
        this.caseouttime = caseouttime;
    }

    public String getIsRefuse() {
        return isRefuse;
    }

    public void setIsRefuse(String isRefuse) {
        this.isRefuse = isRefuse == null ? null : isRefuse.trim();
    }

    public Date getShipdate() {
        return shipdate;
    }

    public void setShipdate(Date shipdate) {
        this.shipdate = shipdate;
    }

    public String getSendType() {
        return sendType;
    }

    public void setSendType(String sendType) {
        this.sendType = sendType == null ? null : sendType.trim();
    }

    public String getSigner() {
        return signer;
    }

    public void setSigner(String signer) {
        this.signer = signer == null ? null : signer.trim();
    }

    public Date getSignerdate() {
        return signerdate;
    }

    public void setSignerdate(Date signerdate) {
        this.signerdate = signerdate;
    }

    public String getReturner() {
        return returner;
    }

    public void setReturner(String returner) {
        this.returner = returner == null ? null : returner.trim();
    }

    public Date getReturndate() {
        return returndate;
    }

    public void setReturndate(Date returndate) {
        this.returndate = returndate;
    }
}