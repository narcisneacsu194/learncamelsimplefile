package com.company.routes.csv;

import com.company.domain.Employee;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class CsvMarshalRouteTest extends CamelTestSupport{

    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new CsvMarshalRoute();
    }

    @Test
    public void csvMarshalRoute(){
        List<Employee> employees = new ArrayList<>();
        Employee employee = new Employee();
        employee.setId("1");
        employee.setFirstName("Narcis");
        employee.setLastName("Neacsu");

        Employee employee1 = new Employee();
        employee1.setId("2");
        employee1.setFirstName("Ionut");
        employee1.setLastName("Nneacsu");

        employees.add(employee);
        employees.add(employee1);

        template.sendBody("direct:csvMarshalInput", employees);

        File file = new File("data/csv/output");

        assertTrue(file.isDirectory());
    }
}
