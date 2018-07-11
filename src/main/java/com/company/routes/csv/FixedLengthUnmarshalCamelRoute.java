package com.company.routes.csv;

import com.company.domain.EmployeeWithFixedLength;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.bindy.fixed.BindyFixedLengthDataFormat;
import org.apache.camel.spi.DataFormat;

public class FixedLengthUnmarshalCamelRoute extends RouteBuilder{
    @Override
    public void configure() throws Exception {
        DataFormat bindy = new BindyFixedLengthDataFormat(EmployeeWithFixedLength.class);

        from("file:data/fixedlength?fileName=fixedlength.txt&noop=true")
                .log("Received message from file: ${body}")
                .unmarshal(bindy)
                .log("Unmarshaled message: ${body}")
                .to("direct:output");
    }
}
