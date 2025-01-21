package com.flydubai.soap.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class SoapCamelRoute extends RouteBuilder {
    @Override
    public void configure() {
        from("spring-ws:HelloSoapService")
                .log("Processing SOAP request: ${body}")
                .to("bean:helloSoapService?method=processTestRequest(${body.clientName})");
    }
}
