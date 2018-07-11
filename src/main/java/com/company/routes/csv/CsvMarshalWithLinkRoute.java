package com.company.routes.csv;

import com.company.domain.EmployeeWithAddress;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.bindy.csv.BindyCsvDataFormat;
import org.apache.camel.spi.DataFormat;

public class CsvMarshalWithLinkRoute extends RouteBuilder{
    @Override
    public void configure() throws Exception {
        DataFormat bindy = new BindyCsvDataFormat(EmployeeWithAddress.class);

        from("direct:objInput")
                .log("Received message: ${body}")
                .marshal(bindy)
                .log("Marshaled message: ${body}")
                .to("file:data/csv/output?fileName=outputWithLink.txt");
    }
}
