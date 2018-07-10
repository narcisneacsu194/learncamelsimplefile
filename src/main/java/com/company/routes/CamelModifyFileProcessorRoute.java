package com.company.routes;

import com.company.processor.CamelFileExampleProcessor;
import org.apache.camel.builder.RouteBuilder;

public class CamelModifyFileProcessorRoute extends RouteBuilder{

    public void configure() throws Exception {
        from("file:data/input?noop=true")
                .log("Received message is ${body} and headers are ${headers}")
                .process(new CamelFileExampleProcessor())
                .to("file:data/output")
                .to("mock:output");
    }
}
