package com.flydubai.soap.config;

import org.apache.camel.CamelContext;
import org.apache.camel.component.spring.ws.SpringWebserviceComponent;
import org.apache.camel.impl.DefaultCamelContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;

@Configuration
@EnableWs
public class SoapServiceConfig {

    @Bean
    public CamelContext camelContext() {
        CamelContext context = new DefaultCamelContext();
        context.addComponent("spring-ws", new SpringWebserviceComponent());
        return context;
    }

    @Bean
    public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(ApplicationContext context) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(context);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean<>(servlet, "/HelloSoapService/*");
    }

}
