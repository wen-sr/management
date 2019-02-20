package com.management.ws;

import com.management.ws.IWebService;

import javax.jws.WebService;

@WebService(endpointInterface = "com.management.ws.IWebService")
public class WebServiceTest implements IWebService {

    @Override
    public String getMsg(String name) {
        return "Hello:" + name ;
    }
}
