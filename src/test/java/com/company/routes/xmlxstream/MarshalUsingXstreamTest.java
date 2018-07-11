package com.company.routes.xmlxstream;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class MarshalUsingXstreamTest extends CamelTestSupport{

    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new MarshalUsingXstream();
    }

    @Test
    public void marshalXstreamTest() throws InterruptedException {
        String input = "123,narcis,12JAN2017";
        String expected = "<?xml version='1.0' encoding='UTF-8'?>" +
                "<com.company.domain.Employee>" +
                "<id>123</id>" +
                "<name>narcis</name>" +
                "<joinDate>12JAN2017</joinDate>" +
                "</com.company.domain.Employee>";

        MockEndpoint mock = getMockEndpoint("mock:output");
        mock.expectedBodiesReceived(expected);

        template.sendBody("direct:csvInput", input);

        assertMockEndpointsSatisfied();
    }

    @Test
    public void marshalXstreamTest_Employee_alias() throws InterruptedException {
        String input = "123,narcis,12JAN2017";
        String expected = "<?xml version='1.0' encoding='UTF-8'?>" +
                "<employee>" +
                "<id>123</id>" +
                "<name>narcis</name>" +
                "<joinDate>12JAN2017</joinDate>" +
                "</employee>";

        MockEndpoint mock = getMockEndpoint("mock:output");
        mock.expectedBodiesReceived(expected);

        template.sendBody("direct:csvInput", input);

        assertMockEndpointsSatisfied();
    }
}
