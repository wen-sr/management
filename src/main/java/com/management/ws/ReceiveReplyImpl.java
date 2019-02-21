package com.management.ws;

import com.management.service.jc.IJiaoCaiInventoryService;
import com.management.util.XmlUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.jws.WebService;

/**
 * Author: wen-sir
 * Description:
 * DateCrated: 2019/2/20 12:44
 * Modified By：
 */
@WebService(endpointInterface = "com.management.ws.IReceiveReply")
public class ReceiveReplyImpl implements IReceiveReply {

    @Autowired
    IJiaoCaiInventoryService jiaoCaiInventoryService;
    @Override
    public String pallectReply(String msg) {

        String task_no = XmlUtils.getNodeValue("//TASK_NO", msg);
        //String infid = XmlUtils.getNodeValue("//INFID", msg);
        //String result = XmlUtils.getNodeValue("//Result", msg);
        //String message = XmlUtils.getNodeValue("//Message", msg);
        //String complete_date = XmlUtils.getNodeValue("//COMPLETE_DATE", msg);
        //String remark = XmlUtils.getNodeValue("//REMARK", msg);
        //String remark1 = XmlUtils.getNodeValue("//REMARK1", msg);
        //String remark2 = XmlUtils.getNodeValue("//REMARK2", msg);

        jiaoCaiInventoryService.executeTask(task_no);
        return null;
    }
}
