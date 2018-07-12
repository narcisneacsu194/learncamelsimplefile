package com.company.route;

import com.company.route.onexception.OnExceptionHandlerRoute;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class OnExceptionHandlerRouteTest extends CamelTestSupport{
    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new OnExceptionHandlerRoute();
    }

    @Test(expected = RuntimeException.class)
    public void onExceptionCheck(){
        String request = null;
        String response = template.requestBody("direct:exception", request, String.class);

        assertEquals("123*Narcis*12JAN2017", response);
    }

    @Test
    public void onExceptionCheck_handled(){
        String request = null;
        String expected = "Exception happened in the route.";

        String output = template.requestBody("direct:exception", request, String.class);
        assertEquals(expected, output);
    }

    @Test
    public void onExceptionCheck_ignored(){
        String request = null;
        String expected = null;
        String output = template.requestBody("direct:exception", request, String.class);

        assertEquals(expected, output);
    }
}
