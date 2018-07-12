package com.company.processor;

import org.apache.camel.Exchange;

public class GenerateErrorResponseProcessor implements org.apache.camel.Processor {
    @Override
    public void process(Exchange exchange) throws Exception {
        Exception exception = exchange.getProperty(Exchange.EXCEPTION_CAUGHT, Exception.class);
        System.out.println("Exception message: " + exception.getMessage());
        System.out.println("Exception actual class: " + exception.getClass());

        String failureEndpoint = exchange.getProperty(Exchange.FAILURE_ENDPOINT, String.class);
        System.out.println("Failure endpoint: " + failureEndpoint);

        exchange.getIn().setBody("Exception happened in the route.");
    }
}
