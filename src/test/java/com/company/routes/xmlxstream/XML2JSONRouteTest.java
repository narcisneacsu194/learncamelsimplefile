package com.company.routes.xmlxstream;

import com.company.routes.xml2json.XML2JSONRoute;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class XML2JSONRouteTest extends CamelTestSupport{

    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new XML2JSONRoute();
    }

    @Test
    public void marshalEmployeeXML2JSON(){
        String input = "<?xml version='1.0' encoding='UTF-8'?>" +
                "<employee>" +
                "<id>123</id>" +
                "<name>narcis</name>" +
                "<joinDate>12JAN2017</joinDate>" +
                "</employee>";
        String expected = "{\"id\":\"123\",\"name\":\"narcis\",\"joinDate\":\"12JAN2017\"}";

        String output = template.requestBody("direct:marshalEmployeeXml2Json", input, String.class);

        assertEquals(expected, output);
    }

    @Test
    public void unmarshalEmployeeJSON2XML(){
        String input = "{\"id\":\"123\",\"name\":\"narcis\",\"joinDate\":\"12JAN2017\"}";
        String expected = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n" +
                "<employee><id>123</id><joinDate>12JAN2017</joinDate><name>narcis</name></employee>\r\n";

        String output = template.requestBody("direct:unmarshalEmployeeXml2Json", input, String.class);

        assertEquals(expected, output);
    }
}
