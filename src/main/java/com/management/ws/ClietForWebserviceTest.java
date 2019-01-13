package com.management.ws;

import com.management.ws.server.test.WebServiceDemoService;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

public class ClietForWebserviceTest {

    public static WebServiceDemoService getInterFace(){
        JaxWsProxyFactoryBean factoryBean = new JaxWsProxyFactoryBean();
        factoryBean.setServiceClass(WebServiceDemoService.class);
//        factoryBean.setAddress("http://localhost:8080/management/ws/webSerciceTest");
        factoryBean.setAddress("http://localhost:8090/project/ws/webservice");
        return factoryBean.create(WebServiceDemoService.class);
    }

    public static void main(String[] args) {
        WebServiceDemoService webServiceDemoService = getInterFace();
        System.out.println("client: "+webServiceDemoService.hello("wen-sir"));
    }
}
