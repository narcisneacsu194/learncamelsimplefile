package com.company.route.defaulterrorhandler;

import com.company.bean.DataModifier;
import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;

public class DefaultErrorHandlerRoute extends RouteBuilder{
    @Override
    public void configure() throws Exception {

        errorHandler(defaultErrorHandler().maximumRedeliveries(2).redeliveryDelay(3000).retryAttemptedLogLevel(LoggingLevel.WARN));
//        errorHandler(defaultErrorHandler().maximumRedeliveries(2).redeliveryDelay(3000).backOffMultiplier(2).retryAttemptedLogLevel(LoggingLevel.WARN));

        from("direct:exception")
                .bean(new DataModifier(), "map")
                .log("log:?level=INFO&showBody=true")
                .to("mock:errorqueue");
    }
}
