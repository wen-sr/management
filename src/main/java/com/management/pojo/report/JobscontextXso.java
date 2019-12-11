package com.management.pojo.report;

import java.math.BigDecimal;
import java.util.Date;

public class JobscontextXso extends JobscontextXsoKey {
    private String docConsk;

    private String docShortname;

    private String docSku;

    private String docDescr;

    private BigDecimal docEqty;

    private BigDecimal docCqty;

    private BigDecimal docCaseQty;

    private BigDecimal docWesqty;

    private BigDecimal docAqty;

    private BigDecimal docAmt;

    private BigDecimal docActAmt;

    private BigDecimal docNet;

    private BigDecimal docActMy;

    private BigDecimal docPrice;

    private BigDecimal docDiscount;

    private String docCat;

    private String docCatname;

    private String docExportno;

    private String docLoc;

    private String docPackkey;

    private String docSusr1;

    private String docSusr2;

    private String docSusr3;

    private String docSusr4;

    private String docSusr5;

    private Date adddate;

    private String addwho;

    private Date editdate;

    private String editwho;

    private String status;

    private BigDecimal docZqty;

    private BigDecimal docWmsAqty;

    private BigDecimal opsShelfqty;

    private String opsUser;

    private Date opsDate;

    private BigDecimal docBundleQty;

    public JobscontextXso(String docNumber, String docSeq, String docConsk, String docShortname, String docSku, String docDescr, BigDecimal docEqty, BigDecimal docCqty, BigDecimal docCaseQty, BigDecimal docWesqty, BigDecimal docAqty, BigDecimal docAmt, BigDecimal docActAmt, BigDecimal docNet, BigDecimal docActMy, BigDecimal docPrice, BigDecimal docDiscount, String docCat, String docCatname, String docExportno, String docLoc, String docPackkey, String docSusr1, String docSusr2, String docSusr3, String docSusr4, String docSusr5, Date adddate, String addwho, Date editdate, String editwho, String status, BigDecimal docZqty, BigDecimal docWmsAqty, BigDecimal opsShelfqty, String opsUser, Date opsDate, BigDecimal docBundleQty) {
        super(docNumber, docSeq);
        this.docConsk = docConsk;
        this.docShortname = docShortname;
        this.docSku = docSku;
        this.docDescr = docDescr;
        this.docEqty = docEqty;
        this.docCqty = docCqty;
        this.docCaseQty = docCaseQty;
        this.docWesqty = docWesqty;
        this.docAqty = docAqty;
        this.docAmt = docAmt;
        this.docActAmt = docActAmt;
        this.docNet = docNet;
        this.docActMy = docActMy;
        this.docPrice = docPrice;
        this.docDiscount = docDiscount;
        this.docCat = docCat;
        this.docCatname = docCatname;
        this.docExportno = docExportno;
        this.docLoc = docLoc;
        this.docPackkey = docPackkey;
        this.docSusr1 = docSusr1;
        this.docSusr2 = docSusr2;
        this.docSusr3 = docSusr3;
        this.docSusr4 = docSusr4;
        this.docSusr5 = docSusr5;
        this.adddate = adddate;
        this.addwho = addwho;
        this.editdate = editdate;
        this.editwho = editwho;
        this.status = status;
        this.docZqty = docZqty;
        this.docWmsAqty = docWmsAqty;
        this.opsShelfqty = opsShelfqty;
        this.opsUser = opsUser;
        this.opsDate = opsDate;
        this.docBundleQty = docBundleQty;
    }

    public JobscontextXso() {
        super();
    }

    public String getDocConsk() {
        return docConsk;
    }

    public void setDocConsk(String docConsk) {
        this.docConsk = docConsk == null ? null : docConsk.trim();
    }

    public String getDocShortname() {
        return docShortname;
    }

    public void setDocShortname(String docShortname) {
        this.docShortname = docShortname == null ? null : docShortname.trim();
    }

    public String getDocSku() {
        return docSku;
    }

    public void setDocSku(String docSku) {
        this.docSku = docSku == null ? null : docSku.trim();
    }

    public String getDocDescr() {
        return docDescr;
    }

    public void setDocDescr(String docDescr) {
        this.docDescr = docDescr == null ? null : docDescr.trim();
    }

    public BigDecimal getDocEqty() {
        return docEqty;
    }

    public void setDocEqty(BigDecimal docEqty) {
        this.docEqty = docEqty;
    }

    public BigDecimal getDocCqty() {
        return docCqty;
    }

    public void setDocCqty(BigDecimal docCqty) {
        this.docCqty = docCqty;
    }

    public BigDecimal getDocCaseQty() {
        return docCaseQty;
    }

    public void setDocCaseQty(BigDecimal docCaseQty) {
        this.docCaseQty = docCaseQty;
    }

    public BigDecimal getDocWesqty() {
        return docWesqty;
    }

    public void setDocWesqty(BigDecimal docWesqty) {
        this.docWesqty = docWesqty;
    }

    public BigDecimal getDocAqty() {
        return docAqty;
    }

    public void setDocAqty(BigDecimal docAqty) {
        this.docAqty = docAqty;
    }

    public BigDecimal getDocAmt() {
        return docAmt;
    }

    public void setDocAmt(BigDecimal docAmt) {
        this.docAmt = docAmt;
    }

    public BigDecimal getDocActAmt() {
        return docActAmt;
    }

    public void setDocActAmt(BigDecimal docActAmt) {
        this.docActAmt = docActAmt;
    }

    public BigDecimal getDocNet() {
        return docNet;
    }

    public void setDocNet(BigDecimal docNet) {
        this.docNet = docNet;
    }

    public BigDecimal getDocActMy() {
        return docActMy;
    }

    public void setDocActMy(BigDecimal docActMy) {
        this.docActMy = docActMy;
    }

    public BigDecimal getDocPrice() {
        return docPrice;
    }

    public void setDocPrice(BigDecimal docPrice) {
        this.docPrice = docPrice;
    }

    public BigDecimal getDocDiscount() {
        return docDiscount;
    }

    public void setDocDiscount(BigDecimal docDiscount) {
        this.docDiscount = docDiscount;
    }

    public String getDocCat() {
        return docCat;
    }

    public void setDocCat(String docCat) {
        this.docCat = docCat == null ? null : docCat.trim();
    }

    public String getDocCatname() {
        return docCatname;
    }

    public void setDocCatname(String docCatname) {
        this.docCatname = docCatname == null ? null : docCatname.trim();
    }

    public String getDocExportno() {
        return docExportno;
    }

    public void setDocExportno(String docExportno) {
        this.docExportno = docExportno == null ? null : docExportno.trim();
    }

    public String getDocLoc() {
        return docLoc;
    }

    public void setDocLoc(String docLoc) {
        this.docLoc = docLoc == null ? null : docLoc.trim();
    }

    public String getDocPackkey() {
        return docPackkey;
    }

    public void setDocPackkey(String docPackkey) {
        this.docPackkey = docPackkey == null ? null : docPackkey.trim();
    }

    public String getDocSusr1() {
        return docSusr1;
    }

    public void setDocSusr1(String docSusr1) {
        this.docSusr1 = docSusr1 == null ? null : docSusr1.trim();
    }

    public String getDocSusr2() {
        return docSusr2;
    }

    public void setDocSusr2(String docSusr2) {
        this.docSusr2 = docSusr2 == null ? null : docSusr2.trim();
    }

    public String getDocSusr3() {
        return docSusr3;
    }

    public void setDocSusr3(String docSusr3) {
        this.docSusr3 = docSusr3 == null ? null : docSusr3.trim();
    }

    public String getDocSusr4() {
        return docSusr4;
    }

    public void setDocSusr4(String docSusr4) {
        this.docSusr4 = docSusr4 == null ? null : docSusr4.trim();
    }

    public String getDocSusr5() {
        return docSusr5;
    }

    public void setDocSusr5(String docSusr5) {
        this.docSusr5 = docSusr5 == null ? null : docSusr5.trim();
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

    public BigDecimal getDocZqty() {
        return docZqty;
    }

    public void setDocZqty(BigDecimal docZqty) {
        this.docZqty = docZqty;
    }

    public BigDecimal getDocWmsAqty() {
        return docWmsAqty;
    }

    public void setDocWmsAqty(BigDecimal docWmsAqty) {
        this.docWmsAqty = docWmsAqty;
    }

    public BigDecimal getOpsShelfqty() {
        return opsShelfqty;
    }

    public void setOpsShelfqty(BigDecimal opsShelfqty) {
        this.opsShelfqty = opsShelfqty;
    }

    public String getOpsUser() {
        return opsUser;
    }

    public void setOpsUser(String opsUser) {
        this.opsUser = opsUser == null ? null : opsUser.trim();
    }

    public Date getOpsDate() {
        return opsDate;
    }

    public void setOpsDate(Date opsDate) {
        this.opsDate = opsDate;
    }

    public BigDecimal getDocBundleQty() {
        return docBundleQty;
    }

    public void setDocBundleQty(BigDecimal docBundleQty) {
        this.docBundleQty = docBundleQty;
    }
}