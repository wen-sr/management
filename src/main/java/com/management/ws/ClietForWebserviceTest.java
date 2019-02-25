package com.management.ws;

import com.management.ws.server.pallet.RecWMSServerService;
import com.management.ws.server.reply.PallectReply;
import com.management.ws.server.test.WebServiceDemoService;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ClietForWebserviceTest {
    private final static Logger logger = LoggerFactory.getLogger(ClietForWebserviceTest.class);

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

    public static IReceiveReply getInterFace3(){
        JaxWsProxyFactoryBean factoryBean = new JaxWsProxyFactoryBean();
        factoryBean.setServiceClass(RecWMSServerService.class);
//        factoryBean.setAddress("http://localhost:8080/management/ws/webSerciceTest");
        factoryBean.setAddress("http://localhost:8080/management/ws/receivePalletReply");
        return factoryBean.create(IReceiveReply.class);
    }

    public static IReceiveReply getInterFace4(){
        JaxWsProxyFactoryBean factoryBean = new JaxWsProxyFactoryBean();
        factoryBean.setServiceClass(PallectReply.class);
//        factoryBean.setAddress("http://localhost:8080/management/ws/webSerciceTest");
        factoryBean.setAddress("http://171.34.100.95/management/ws/receiveReply");
        return factoryBean.create(IReceiveReply.class);
    }

    public static void main(String[] args) {
        //WebServiceDemoService webServiceDemoService = getInterFace();
        //System.out.println("client: "+webServiceDemoService.hello("wen-sir"));
        //IReceiveReply recWMSServerService = getInterFace3();
        //String msdf = "<Message><InTask_Info><TaskId>0000159995</TaskId><InType>instock</InType><WarehouseId>  </WarehouseId><DistrictId></DistrictId><TrayCode>P000155</TrayCode><OrderId>0000159995</OrderId><GroupId></GroupId><NeedWinding>N</NeedWinding><Time>2018-09-03 11:09:27</Time></InTask_Info></Message>";
        //String s = recWMSServerService.pallectReply(msdf);
        //logger.info("==========="+ s +"=========");

        IReceiveReply pallectReply = getInterFace4();
        pallectReply.pallectReply("<TASK_NO>201902250007</TASK_NO>");

    }



}
