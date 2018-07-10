package com.company.processor;

import org.apache.camel.Exchange;

public class CamelDirectExampleProcessor implements org.apache.camel.Processor {
    public void process(Exchange exchange) throws Exception {
        String str = (String)exchange.getIn().getBody();
        String newBodyContent = str.replace(",", ":");
        exchange.getIn().setBody(newBodyContent);
    }
}
