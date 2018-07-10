package com.company.routes.process;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class CamelModifyDirectProcessorRouteTest extends CamelTestSupport{

    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new CamelModifyDirectProcessorRoute();
    }

    @Test
    public void processorDirectTest(){
        String input = "123,ionut,12JAN2017";
        String expected = "123:ionut:12JAN2017";

        String output = (String) template.requestBody("direct:processorInput", input);
        assertEquals(expected, output);
    }

    @Test
    public void processorDirectUsingMock() throws InterruptedException {
        String input = "123,ionut,12JAN2017";
        String expected = "123:ionut:12JAN2017";

        MockEndpoint mock = getMockEndpoint("mock:output");
        mock.expectedBodiesReceived(expected);

        template.sendBody("direct:processorInput", input);

        assertMockEndpointsSatisfied();
    }
}
