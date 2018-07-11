package com.company.routes.csv;

import com.company.domain.Employee;
import org.apache.camel.Exchange;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import java.util.List;

public class CsvUnmarshalRouteTest extends CamelTestSupport{

    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new CsvUnmarshalRoute();
    }

    @Test
    @SuppressWarnings("unchecked")
    public void csvUnmarshalRoute() throws InterruptedException {
        Exchange exchange = consumer.receive("direct:output");
        List<Employee> employees = (List<Employee>)exchange.getIn().getBody();

        assertEquals("Narcis", employees.get(0).getFirstName());
        assertEquals("Ionut", employees.get(1).getFirstName());
    }
}
