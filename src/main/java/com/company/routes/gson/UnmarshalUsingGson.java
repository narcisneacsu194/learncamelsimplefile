package com.company.routes.gson;

import com.company.domain.Employee;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.gson.GsonDataFormat;

public class UnmarshalUsingGson extends RouteBuilder{
    @Override
    public void configure() throws Exception {
        GsonDataFormat gsonDataFormat = new GsonDataFormat(Employee.class);

        from("direct:unmarshalGSON")
                .log("Received message: ${body}")
                .unmarshal(gsonDataFormat)
                .log("Message after unmarshal: ${body}");
    }
}
