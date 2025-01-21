package com.flydubai.soap.endpoint;

import com.flydubai.soap.model.HelloSoap;
import com.flydubai.soap.model.HelloSoapResponse;
import jakarta.xml.bind.JAXBElement;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import javax.xml.namespace.QName;


@Endpoint
public class HelloSoapEndpoint {

    private static final String NAMESPACE_URI = "http://www.flydubai.com/HelloSoap";

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "HelloSoap")
    @ResponsePayload
    public JAXBElement<HelloSoapResponse> handleHelloSoapRequest(@RequestPayload HelloSoap request) {
        String clientName = request.getClientName();

        HelloSoapResponse response = new HelloSoapResponse();
        response.setResponse("Welcome " + clientName);

        return new JAXBElement<>(
                new QName(NAMESPACE_URI, "HelloSoapResponse"),
                HelloSoapResponse.class,
                response
        );
    }
}


