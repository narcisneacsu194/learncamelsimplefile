package com.company.route;

import com.company.route.defaulterrorhandler.DefaultErrorHandlerRoute;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class DefaultErrorHandlerRouteTest extends CamelTestSupport{
    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new DefaultErrorHandlerRoute();
    }

    @Test(expected = RuntimeException.class)
    public void exceptionCheck(){
        String expected = "123*Narcis*12JAN2017";
        String input = null;

        String output = template.requestBody("direct:exception", input, String.class);

        assertEquals(expected, output);
    }
}
