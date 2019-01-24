package com.management.vo.prd1;

import java.math.BigDecimal;

/**
 * Author: wen-sir
 * Description:
 * DateCrated: 2019/1/24 9:20
 * Modified By：
 */
public class GouBaoDataVo {

    private String id;

    private BigDecimal caseQty;

    private BigDecimal qty;

    private String dd;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BigDecimal getCaseQty() {
        return caseQty;
    }

    public void setCaseQty(BigDecimal caseQty) {
        this.caseQty = caseQty;
    }

    public BigDecimal getQty() {
        return qty;
    }

    public void setQty(BigDecimal qty) {
        this.qty = qty;
    }

    public String getDd() {
        return dd;
    }

    public void setDd(String dd) {
        this.dd = dd;
    }
}
