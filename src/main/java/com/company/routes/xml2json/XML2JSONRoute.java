package com.company.routes.xml2json;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.XmlJsonDataFormat;

public class XML2JSONRoute extends RouteBuilder{
    @Override
    public void configure() throws Exception {
        from("direct:marshalEmployeeXml2Json")
                .to("log:?level=INFO&showBody=true")
                .marshal().xmljson()
                .to("log:?level=INFO&showBody=true");

        XmlJsonDataFormat xmlJsonDataFormat = new XmlJsonDataFormat();
        xmlJsonDataFormat.setRootName("employee");

        from("direct:unmarshalEmployeeXml2Json")
                .to("log:?level=INFO&showBody=true")
                .unmarshal(xmlJsonDataFormat)
                .to("log:?level=INFO&showBody=true");
    }
}
