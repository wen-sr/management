package com.management.vo.liku;

/**
 * Author: wen-sir
 * Description:
 * DateCrated: 2019/8/19 11:27
 * Modified By：
 */
public class ErrorMessageVo {

    private String errorCode;
    private String errorMsg;
    private String bankId;
    private String name;
    private String note;

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getBankId() {
        return bankId;
    }

    public void setBankId(String bankId) {
        this.bankId = bankId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
