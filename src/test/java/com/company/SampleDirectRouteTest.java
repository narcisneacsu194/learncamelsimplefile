package com.company;

import com.company.direct.SampleDirectRoute;
import org.apache.camel.Exchange;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import java.io.File;

public class SampleDirectRouteTest extends CamelTestSupport{

    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new SampleDirectRoute();
    }

    @Test
    public void sampleRouteTest() throws InterruptedException {
        template.sendBody("direct:sampleInput", "1234,Narcis,Programmer");

        Thread.sleep(5000);

        File file = new File("data/sampleOutput");

        assertTrue(file.isDirectory());
        assertEquals(1, file.listFiles().length);

        Exchange exchange = consumer.receive("file:data/sampleOutput");
        assertEquals("output.txt", exchange.getIn().getHeader("CamelFileName"));
    }
}
