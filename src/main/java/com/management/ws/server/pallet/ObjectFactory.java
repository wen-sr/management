
package com.management.ws.server.pallet;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.management.ws.server.pallet package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _RecWMSHandleInfo_QNAME = new QName("http://upwms.cxf.xhwcs.shengmo.com/", "recWMSHandleInfo");
    private final static QName _RecWMSHandleInfoResponse_QNAME = new QName("http://upwms.cxf.xhwcs.shengmo.com/", "recWMSHandleInfoResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.management.ws.server.pallet
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link RecWMSHandleInfo }
     * 
     */
    public RecWMSHandleInfo createRecWMSHandleInfo() {
        return new RecWMSHandleInfo();
    }

    /**
     * Create an instance of {@link RecWMSHandleInfoResponse }
     * 
     */
    public RecWMSHandleInfoResponse createRecWMSHandleInfoResponse() {
        return new RecWMSHandleInfoResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RecWMSHandleInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://upwms.cxf.xhwcs.shengmo.com/", name = "recWMSHandleInfo")
    public JAXBElement<RecWMSHandleInfo> createRecWMSHandleInfo(RecWMSHandleInfo value) {
        return new JAXBElement<RecWMSHandleInfo>(_RecWMSHandleInfo_QNAME, RecWMSHandleInfo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RecWMSHandleInfoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://upwms.cxf.xhwcs.shengmo.com/", name = "recWMSHandleInfoResponse")
    public JAXBElement<RecWMSHandleInfoResponse> createRecWMSHandleInfoResponse(RecWMSHandleInfoResponse value) {
        return new JAXBElement<RecWMSHandleInfoResponse>(_RecWMSHandleInfoResponse_QNAME, RecWMSHandleInfoResponse.class, null, value);
    }

}
