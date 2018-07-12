package com.company.routes.csv;

import com.company.domain.EmployeeWithFixedLength;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import java.io.File;
import java.math.BigDecimal;
import java.time.LocalDate;

public class FixedLengthMarshalCamelRouteTest extends CamelTestSupport{
    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new FixedLengthMarshalCamelRoute();
    }

    @Test
    public void marshalFixedLengthRoute(){
        EmployeeWithFixedLength employeeWithFixedLength =
                new EmployeeWithFixedLength();
        employeeWithFixedLength.setId(1);
        employeeWithFixedLength.setName("Name1");
        employeeWithFixedLength.setAge(30);
        employeeWithFixedLength.setLocalDate(LocalDate.now());
        employeeWithFixedLength.setRole("Engineer");
        employeeWithFixedLength.setSalary(new BigDecimal("40000"));

        template.sendBody("direct:input", employeeWithFixedLength);

        File file = new File("data/fixedlength/output");
        assertTrue(file.isDirectory());
    }
}
