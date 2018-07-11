package com.company.routes.xmlxstream;

import com.company.domain.Employee;
import com.company.processor.CustomProcessorXstream;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.XStreamDataFormat;

import java.util.HashMap;
import java.util.Map;

public class MarshalUsingXstream extends RouteBuilder{
    public void configure() throws Exception {
        from("direct:csvInput")
                .process(new CustomProcessorXstream())
                .marshal(populateStreamDef())
                .to("log:?level=INFO&showBody=true")
                .to("file:data/output?fileName=output.txt")
                .to("mock:output");
    }

    private XStreamDataFormat populateStreamDef(){
        XStreamDataFormat xStreamDataFormat = new XStreamDataFormat();
        Map<String, String> aliases = new HashMap<>();
        aliases.put("employee", Employee.class.getCanonicalName());
        xStreamDataFormat.setAliases(aliases);
        return xStreamDataFormat;
    }
}
