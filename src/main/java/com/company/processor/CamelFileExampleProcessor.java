package com.company.processor;

import org.apache.camel.Exchange;
import org.apache.camel.component.file.GenericFile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class CamelFileExampleProcessor implements org.apache.camel.Processor {
    @SuppressWarnings("unchecked")
    public void process(Exchange exchange) throws Exception {
        System.out.println("Exchange in Processor is: " + exchange.getIn().getBody());

        GenericFile<File> file = (GenericFile<File>) exchange.getIn().getBody();

        String line;
        String newContent = "";

        if(file != null){
            FileReader fileReader = new FileReader(file.getFile());
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null){
               newContent = newContent.concat(line.replace(",", ":")).concat("\n");
            }

            exchange.getIn().setBody(newContent);
        }
    }
}
