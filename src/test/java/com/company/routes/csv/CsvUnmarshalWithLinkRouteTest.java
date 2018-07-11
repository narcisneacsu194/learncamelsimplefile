package com.company.routes.csv;

import com.company.domain.EmployeeWithAddress;
import org.apache.camel.Exchange;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class CsvUnmarshalWithLinkRouteTest extends CamelTestSupport{

    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new CsvUnmarshalWithLinkRoute();
    }

    @Test
    public void csvUnmarshalWithLink(){
        Exchange exchange = consumer.receive("direct:output");
        EmployeeWithAddress employeeWithAddress = (EmployeeWithAddress) exchange.getIn().getBody();

        assertEquals("USA", employeeWithAddress.getAddress().getCountry());
    }
}
