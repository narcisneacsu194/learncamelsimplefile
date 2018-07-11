package com.company.routes.gson;

import com.company.domain.Employee;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class UnmarshalUsingGsonTest extends CamelTestSupport{

    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new UnmarshalUsingGson();
    }

    @Test
    public void unmarshalUsingGson(){
        String input = "{\"id\":\"1\",\"name\":\"Narcis\",\"joinDate\":\"12Jan2017\"}";
        Employee employee = template.requestBody("direct:unmarshalGSON", input, Employee.class);

        assertEquals("1", employee.getId());
        assertEquals("Narcis", employee.getName());
        assertEquals("12Jan2017", employee.getJoinDate());
    }
}
