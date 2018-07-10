package com.company.routes.process;

import com.company.processor.CamelDirectExampleProcessor;
import org.apache.camel.builder.RouteBuilder;

public class CamelModifyDirectProcessorRoute extends RouteBuilder{

    public void configure() throws Exception {
        from("direct:processorInput")
                .log("Received message before process is ${body} and headers are ${headers}")
                .process(new CamelDirectExampleProcessor())
                .log("Received message after process is ${body} and headers are ${headers}")
                .to("file:data/output?fileName=output.txt")
                .to("mock:output");
    }
}
