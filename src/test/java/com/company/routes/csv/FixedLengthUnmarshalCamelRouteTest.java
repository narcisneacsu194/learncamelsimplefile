package com.company.routes.csv;

import com.company.domain.EmployeeWithFixedLength;
import org.apache.camel.Exchange;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import java.time.LocalDate;
import java.util.List;

public class FixedLengthUnmarshalCamelRouteTest extends CamelTestSupport{

    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new FixedLengthUnmarshalCamelRoute();
    }

    @Test
    @SuppressWarnings("unchecked")
    public void unmarshalFixedLengthRoute(){
        Exchange exchange = consumer.receive("direct:output");
        List<EmployeeWithFixedLength> employees = (List<EmployeeWithFixedLength>) exchange.getIn().getBody();

        assertNotNull(employees);

        assertEquals(123, employees.get(0).getId());
        assertEquals("narcis", employees.get(0).getName());
        assertEquals("Engineer", employees.get(0).getRole());

        assertEquals(456, employees.get(1).getId());
        assertEquals("ionut", employees.get(1).getName());
        assertEquals("Engineer", employees.get(1).getRole());

        LocalDate expectedDate1 = LocalDate.of(2017, 01, 12);
        LocalDate expectedDate2 = LocalDate.of(2018, 01, 22);

        assertEquals(expectedDate1.getYear(), employees.get(0).getLocalDate().getYear());
        assertEquals(expectedDate2.getYear(), employees.get(1).getLocalDate().getYear());
    }
}
