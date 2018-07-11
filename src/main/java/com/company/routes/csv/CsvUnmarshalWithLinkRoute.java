package com.company.routes.csv;

import com.company.domain.EmployeeWithAddress;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.bindy.csv.BindyCsvDataFormat;
import org.apache.camel.spi.DataFormat;

public class CsvUnmarshalWithLinkRoute extends RouteBuilder{
    @Override
    public void configure() throws Exception {
        DataFormat bindy = new BindyCsvDataFormat(EmployeeWithAddress.class);

        from("file:data/csv/input?fileName=file-with-address.txt&noop=true")
                .log("Contents of consumed file: ${body}")
                .unmarshal(bindy)
                .log("Unmarshaled message is: ${body}")
                .to("direct:output");
    }
}
