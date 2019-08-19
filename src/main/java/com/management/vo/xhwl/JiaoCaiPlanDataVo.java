package com.management.vo.xhwl;

public class JiaoCaiPlanDataVo {
    private Long id;

    private String issuenumber;

    private String partment;

    private String plantingname;

    private String subcode;

    private Double price;

    private String descr;

    private String publisher;

    private Integer qtyperitem;

    private Integer qtydeliver;

    private Integer qtycase;

    private String batchno;

    private String deliverdate;

    private String handbagdate;

    private String handbagdateEnd;

    private String type;

    private String addwho;

    private String adddate;

    private String status;

    private String remark;

    private boolean flag;

    public String getPartment() {
        return partment;
    }

    public void setPartment(String partment) {
        this.partment = partment;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public String getAdddate() {
        return adddate;
    }

    public String getHandbagdateEnd() {
        return handbagdateEnd;
    }

    public void setHandbagdateEnd(String handbagdateEnd) {
        this.handbagdateEnd = handbagdateEnd;
    }

    public void setAdddate(String adddate) {
        this.adddate = adddate;
    }

    public JiaoCaiPlanDataVo() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIssuenumber() {
        return issuenumber;
    }

    public void setIssuenumber(String issuenumber) {
        this.issuenumber = issuenumber == null ? null : issuenumber.trim();
    }

    public String getPlantingname() {
        return plantingname;
    }

    public void setPlantingname(String plantingname) {
        this.plantingname = plantingname == null ? null : plantingname.trim();
    }

    public String getSubcode() {
        return subcode;
    }

    public void setSubcode(String subcode) {
        this.subcode = subcode == null ? null : subcode.trim();
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr == null ? null : descr.trim();
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher == null ? null : publisher.trim();
    }

    public Integer getQtyperitem() {
        return qtyperitem;
    }

    public void setQtyperitem(Integer qtyperitem) {
        this.qtyperitem = qtyperitem;
    }

    public Integer getQtydeliver() {
        return qtydeliver;
    }

    public void setQtydeliver(Integer qtydeliver) {
        this.qtydeliver = qtydeliver;
    }

    public Integer getQtycase() {
        return qtycase;
    }

    public void setQtycase(Integer qtycase) {
        this.qtycase = qtycase;
    }

    public String getBatchno() {
        return batchno;
    }

    public void setBatchno(String batchno) {
        this.batchno = batchno == null ? null : batchno.trim();
    }

    public String getDeliverdate() {
        return deliverdate;
    }

    public void setDeliverdate(String deliverdate) {
        this.deliverdate = deliverdate == null ? null : deliverdate.trim();
    }

    public String getHandbagdate() {
        return handbagdate;
    }

    public void setHandbagdate(String handbagdate) {
        this.handbagdate = handbagdate == null ? null : handbagdate.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getAddwho() {
        return addwho;
    }

    public void setAddwho(String addwho) {
        this.addwho = addwho == null ? null : addwho.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}