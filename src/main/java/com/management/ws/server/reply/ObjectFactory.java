
package com.management.ws.server.reply;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.management.ws.server.reply package. 
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

    private final static QName _PallectReply_QNAME = new QName("http://ws.management.com/", "pallectReply");
    private final static QName _PallectReplyResponse_QNAME = new QName("http://ws.management.com/", "pallectReplyResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.management.ws.server.reply
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link PallectReply }
     * 
     */
    public PallectReply createPallectReply() {
        return new PallectReply();
    }

    /**
     * Create an instance of {@link PallectReplyResponse }
     * 
     */
    public PallectReplyResponse createPallectReplyResponse() {
        return new PallectReplyResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PallectReply }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.management.com/", name = "pallectReply")
    public JAXBElement<PallectReply> createPallectReply(PallectReply value) {
        return new JAXBElement<PallectReply>(_PallectReply_QNAME, PallectReply.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PallectReplyResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.management.com/", name = "pallectReplyResponse")
    public JAXBElement<PallectReplyResponse> createPallectReplyResponse(PallectReplyResponse value) {
        return new JAXBElement<PallectReplyResponse>(_PallectReplyResponse_QNAME, PallectReplyResponse.class, null, value);
    }

}
