package com.management.pojo.report;

public class ReplenishmentKey {
    private String replenishmentgroup;

    private String replenishmentkey;

    public ReplenishmentKey(String replenishmentgroup, String replenishmentkey) {
        this.replenishmentgroup = replenishmentgroup;
        this.replenishmentkey = replenishmentkey;
    }

    public ReplenishmentKey() {
        super();
    }

    public String getReplenishmentgroup() {
        return replenishmentgroup;
    }

    public void setReplenishmentgroup(String replenishmentgroup) {
        this.replenishmentgroup = replenishmentgroup == null ? null : replenishmentgroup.trim();
    }

    public String getReplenishmentkey() {
        return replenishmentkey;
    }

    public void setReplenishmentkey(String replenishmentkey) {
        this.replenishmentkey = replenishmentkey == null ? null : replenishmentkey.trim();
    }
}