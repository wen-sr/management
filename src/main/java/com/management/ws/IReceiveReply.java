package com.management.ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * Author: wen-sir
 * Description:
 * DateCrated: 2019/2/20 12:42
 * Modified By：
 */
@WebService
public interface IReceiveReply {

    @WebMethod
    public String pallectReply(@WebParam(name = "name")String name);
}
