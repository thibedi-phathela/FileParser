package com.eviro.assessment.grad001.kgaugelophathela;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


@SpringBootApplication
public class FileParserApplication {
	
	@Autowired
    private static CSVFileParser csvFileParser;

	public static void main(String[] args) {
		//SpringApplication.run(FileParserApplication.class, args);
		 ConfigurableApplicationContext context = SpringApplication.run(FileParserApplication.class, args);
	     csvFileParser = context.getBean(CSVFileParser.class);
	     
		 File csv = new File("path/to/csv"); //replace with file location
	     csvFileParser.parseCSV(csv);
		
	}
	

}
