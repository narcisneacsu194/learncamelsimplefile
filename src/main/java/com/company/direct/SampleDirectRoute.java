package com.company.direct;

import org.apache.camel.builder.RouteBuilder;

public class SampleDirectRoute extends RouteBuilder{
    public void configure() throws Exception {
        from("direct:sampleInput")
                .log("Received Message is ${body} and Headers are ${headers}")
                .to("file:data/sampleOutput?fileName=output.txt");
    }
}
