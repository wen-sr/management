package com.management.util;

public class DataSourceContextHolder {


    public final static String SESSION_FACTORY_XH = "xh";
    public final static String SESSION_FACTORY_PRD1 = "prd1";
    public final static String SESSION_FACTORY_WCS = "wcs";
    public final static String SESSION_FACTORY_WMS = "wms";
    public final static String SESSION_FACTORY_JXLH56 = "jxlh56";
    public final static String SESSION_FACTORY_LIKU = "liku";
    public final static String SESSION_FACTORY_WES = "wes";


    private static final ThreadLocal<String> contextHolder = new ThreadLocal<String>();

    public static void setDbType(String dbType) {
        contextHolder.set(dbType);
    }

    public static String getDbType() {
        return ((String) contextHolder.get());
    }

    public static void clearDbType() {
        contextHolder.remove();
    }
}
