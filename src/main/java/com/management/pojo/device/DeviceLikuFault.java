package com.management.pojo.device;

public class DeviceLikuFault {
    private Integer id;

    private String errorCode;

    private String errorMsg;

    private String bandId;

    private String name;

    public DeviceLikuFault(Integer id, String errorCode, String errorMsg, String bandId, String name) {
        this.id = id;
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
        this.bandId = bandId;
        this.name = name;
    }

    public DeviceLikuFault() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode == null ? null : errorCode.trim();
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg == null ? null : errorMsg.trim();
    }

    public String getBandId() {
        return bandId;
    }

    public void setBandId(String bandId) {
        this.bandId = bandId == null ? null : bandId.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}