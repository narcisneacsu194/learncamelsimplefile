package com.company.routes.bean;

import com.company.bean.CamelBean;
import org.apache.camel.builder.RouteBuilder;

public class CamelModifyBeanRoute extends RouteBuilder{

    public void configure() throws Exception {
        from("direct:beanInput")
                .log("Before bean: ${body}")
                .bean(new CamelBean(), "map")
                .log("After bean: ${body}")
        .to("mock:output");
    }
}
