package com.company.route.onexception;

import com.company.bean.DataModifier;
import com.company.processor.GenerateErrorResponseProcessor;
import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;

public class OnExceptionHandlerRoute extends RouteBuilder{
    @Override
    public void configure() throws Exception {

//        onException(RuntimeException.class, Exception.class)
//                .maximumRedeliveries(2).redeliveryDelay(5000).backOffMultiplier(2)
//                .log(LoggingLevel.INFO, "Exception in Bean caught here");

//        onException(RuntimeException.class).handled(true).maximumRedeliveries(2).delay(2000)
//                .process(new GenerateErrorResponseProcessor())
//                .log(LoggingLevel.WARN, "Exception in Processor is caught.");

        onException(RuntimeException.class).continued(true).log(LoggingLevel.WARN, "Exception in processor caught.");

        from("direct:exception")
                .bean(new DataModifier(), "mapOnException")
                .to("log:?level=INFO&showBody=true");
    }
}
