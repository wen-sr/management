package com.management.ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public interface IWebService {
    @WebMethod
    public String getMsg(@WebParam(name = "name")String name);
}
