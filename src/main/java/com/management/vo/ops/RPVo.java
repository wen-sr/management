package com.management.vo.ops;

public class RPVo {
    private String ty;
    private String EmployeeName;
    private String Operator;
    private Integer COUNT;
    private Integer Task;
    private String OperationTime;

    public String getTy() {
        return ty;
    }

    public void setTy(String ty) {
        this.ty = ty;
    }

    public String getEmployeeName() {
        return EmployeeName;
    }

    public void setEmployeeName(String employeeName) {
        EmployeeName = employeeName;
    }

    public String getOperator() {
        return Operator;
    }

    public void setOperator(String operator) {
        Operator = operator;
    }

    public Integer getCOUNT() {
        return COUNT;
    }

    public void setCOUNT(Integer COUNT) {
        this.COUNT = COUNT;
    }

    public Integer getTask() {
        return Task;
    }

    public void setTask(Integer task) {
        Task = task;
    }

    public String getOperationTime() {
        return OperationTime;
    }

    public void setOperationTime(String operationTime) {
        OperationTime = operationTime;
    }
}
