package com.company.routes.csv;

import com.company.domain.Employee;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.bindy.csv.BindyCsvDataFormat;
import org.apache.camel.spi.DataFormat;

public class CsvUnmarshalRoute extends RouteBuilder{
    @Override
    public void configure() throws Exception {
        DataFormat csvDataFormat = new BindyCsvDataFormat(Employee.class);

        from("file:data/csv/input?fileName=file.txt&noop=true")
                .log("Message body before unmarshal: ${body}")
                .unmarshal(csvDataFormat)
                .log("Message body after unmarshal: ${body}")
                .to("direct:output");
    }
}
