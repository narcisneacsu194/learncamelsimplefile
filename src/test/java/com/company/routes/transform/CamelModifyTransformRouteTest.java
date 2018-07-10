package com.company.routes.transform;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class CamelModifyTransformRouteTest extends CamelTestSupport{

    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new CamelModifyTransformRoute();
    }

    @Test
    public void transformTest(){
        String expected = "123*narcis*12JAN2017";
        String input = "123,narcis,12JAN2017";

        String output = (String)template.requestBody("direct:transformInput", input);

        assertEquals(expected, output);
    }

    @Test
    public void transformUsingMock() throws InterruptedException {
        String expected = "123*narcis*12JAN2017";
        String input = "123,narcis,12JAN2017";

        MockEndpoint mock = getMockEndpoint("mock:output");
        mock.expectedBodiesReceived(expected);

        template.sendBody("direct:transformInput", input);

        assertMockEndpointsSatisfied();
    }
}
