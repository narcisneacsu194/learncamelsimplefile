package com.company.routes.gson;

import com.company.domain.Employee;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class MarshalUsingGsonTest extends CamelTestSupport{

    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new MarshalUsingGson();
    }

    @Test
    public void marshalUsingGson(){
        Employee employee = new Employee();
        employee.setId("1");
        employee.setName("Narcis");
        employee.setJoinDate("12Jan2017");

        String expected = "{\"id\":\"1\",\"name\":\"Narcis\",\"joinDate\":\"12Jan2017\"}";
        String response = template.requestBody("direct:marshalGSON", employee, String.class);

        assertEquals(expected, response);
    }
}
