package com.company;

import com.company.direct.SampleMockRoute;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class SampleMockRouteTest extends CamelTestSupport{

    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new SampleMockRoute();
    }

    @Test
    public void sampleMockRouteTest() throws Exception{
        String input = "Hello";

        MockEndpoint mock = getMockEndpoint("mock:output");
        mock.expectedBodiesReceived(input);

        template.sendBody("direct:sampleInput", "Hello");

        assertMockEndpointsSatisfied();
    }
}
