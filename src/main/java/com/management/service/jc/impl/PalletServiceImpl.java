package com.management.service.jc.impl;

import com.management.common.Constant;
import com.management.pojo.jc.JiaoCaiTask;
import com.management.service.jc.IPalletService;
import com.management.util.DateTimeUtil;
import com.management.ws.server.pallet.RecWMSServer;
import com.management.ws.server.pallet.RecWMSServerService;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Author: wen-sir
 * Description:
 * DateCrated: 2019/2/25 15:03
 * Modified By：
 */
@Service
public class PalletServiceImpl implements IPalletService {

    public String sendToPallet(JiaoCaiTask jiaoCaiTask) {
        JaxWsProxyFactoryBean factoryBean = new JaxWsProxyFactoryBean();
        factoryBean.setServiceClass(RecWMSServerService.class);
        factoryBean.setAddress("http://141.168.1.108:8081/ncsmwcs/ws/recWMSInfo");
        RecWMSServer recWMSServer = factoryBean.create(RecWMSServer.class);
        String data = "<Message>" +
                "  <InTask_Info>" +
                "     <TaskId>"+ jiaoCaiTask.getTrkNo() +"</TaskId>" +
                "     <InType>"+ jiaoCaiTask.getTasktype() +"</InType>" +
                "     <WarehouseId>"+ jiaoCaiTask.getWarehouseid() +"</WarehouseId>" +
                "     <DistrictId>"+ jiaoCaiTask.getDistrictid() +"</DistrictId>" +
                "     <TrayCode>"+ jiaoCaiTask.getTraycodes() +"</TrayCode>" +
                "     <OrderId>"+ jiaoCaiTask.getOrderid() +"</OrderId>" +
                "     <GroupId>"+ jiaoCaiTask.getBk1() +"</GroupId>" +
                "     <NeedWinding>"+ jiaoCaiTask.getNeedwinding() +"</NeedWinding>" +
                "     <Time>"+ DateTimeUtil.dateToStr(new Date()) +"</Time>" +
                "     <dataFrom>"+ Constant.DATA_FROM +"</dataFrom>" +
                " </InTask_Info>" +
                "  </Message>";
        return recWMSServer.recWMSHandleInfo(data);



    }


}
