package com.company.routes.bean;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class CamelModifyBeanRouteTest extends CamelTestSupport{

    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new CamelModifyBeanRoute();
    }

    @Test
    public void beanTransformTest(){
        String expected = "123*ionut*12JAN2017";
        String input = "123,ionut,12JAN2017";

        String output = (String)template.requestBody("direct:beanInput", input);

        assertEquals(expected, output);
    }

    @Test
    public void beanTransformUsingMock() throws InterruptedException {
        String expected = "123*ionut*12JAN2017";
        String input = "123,ionut,12JAN2017";

        MockEndpoint mock = getMockEndpoint("mock:output");
        mock.expectedBodiesReceived(expected);

        template.sendBody("direct:beanInput", input);

        assertMockEndpointsSatisfied();
    }
}
