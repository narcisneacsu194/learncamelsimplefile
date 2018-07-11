package com.company.routes.xmlxstream;

import com.company.domain.Employee;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class UnmarshalUsingXstreamTest extends CamelTestSupport{

    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new UnmarshalUsingXstream();
    }

    @Test
    public void unmarshalXstreamTest() throws InterruptedException {
        String input = "<?xml version='1.0' encoding='UTF-8'?>" +
                "<employee>" +
                "<id>123</id>" +
                "<name>narcis</name>" +
                "<joinDate>12JAN2017</joinDate>" +
                "</employee>";

        Employee employee = new Employee();
        employee.setId("123");
        employee.setName("narcis");
        employee.setJoinDate("12JAN2017");

        MockEndpoint mock = getMockEndpoint("mock:output");
        mock.expectedBodiesReceived(employee.toString());

        template.sendBody("direct:xmlInput", input);

        assertMockEndpointsSatisfied();
    }
}
