package com.company.routes.gson;

import com.company.domain.Employee;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.gson.GsonDataFormat;

public class MarshalUsingGson extends RouteBuilder{
    @Override
    public void configure() throws Exception {
        GsonDataFormat gsonDataFormat = new GsonDataFormat(Employee.class);

        from("direct:marshalGSON")
                .log("Object before marshaling: ${body}")
                .marshal(gsonDataFormat)
                .log("Object after marshaling: ${body}");
    }
}
