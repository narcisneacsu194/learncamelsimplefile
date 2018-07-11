package com.company.routes.csv;

import com.company.domain.Address;
import com.company.domain.EmployeeWithAddress;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import java.io.File;

public class CsvMarshalWithLinkRouteTest extends CamelTestSupport{

    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new CsvMarshalWithLinkRoute();
    }

    @Test
    public void testCsvMarshlWithLinkRoute(){
        Address address = new Address();
        address.setAddressLine("AddressLine1");
        address.setCity("City1");
        address.setState("State1");
        address.setZip("12345");
        address.setCountry("country1");

        EmployeeWithAddress employeeWithAddress =
                new EmployeeWithAddress();
        employeeWithAddress.setId("1");
        employeeWithAddress.setFirstName("FirstName1");
        employeeWithAddress.setLastName("LastName1");
        employeeWithAddress.setAddress(address);

        template.sendBody("direct:objInput", employeeWithAddress);

        File file = new File("data/csv/output/outputWithLink.txt");

        assertTrue(file.exists());
    }
}
