package com.management.ws;

import com.management.ws.server.pallet.RecWMSServer;
import com.management.ws.server.pallet.RecWMSServerService;
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

    public static RecWMSServerService getInterFace2(){
        JaxWsProxyFactoryBean factoryBean = new JaxWsProxyFactoryBean();
        factoryBean.setServiceClass(RecWMSServerService.class);
//        factoryBean.setAddress("http://localhost:8080/management/ws/webSerciceTest");
        factoryBean.setAddress("http://141.168.1.108:8081/ncsmwcs/ws/recWMSInfo");
        return factoryBean.create(RecWMSServerService.class);
    }

    public static void main(String[] args) {
        //WebServiceDemoService webServiceDemoService = getInterFace();
        //System.out.println("client: "+webServiceDemoService.hello("wen-sir"));
        RecWMSServerService recWMSServerService = getInterFace2();
        RecWMSServer recWMSServer = recWMSServerService.getRecWMSServerPort();
        //recWMSServer.recWMSHandleInfo()


    }



}
