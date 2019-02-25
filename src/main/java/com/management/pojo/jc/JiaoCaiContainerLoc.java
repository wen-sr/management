package com.management.pojo.jc;

public class JiaoCaiContainerLoc {
    private String containerId;

    private String loc;

    public JiaoCaiContainerLoc(String containerId, String loc) {
        this.containerId = containerId;
        this.loc = loc;
    }

    public JiaoCaiContainerLoc() {
        super();
    }

    public String getContainerId() {
        return containerId;
    }

    public void setContainerId(String containerId) {
        this.containerId = containerId == null ? null : containerId.trim();
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc == null ? null : loc.trim();
    }
}