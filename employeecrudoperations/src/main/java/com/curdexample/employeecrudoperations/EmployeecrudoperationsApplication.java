package com.curdexample.employeecrudoperations;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class EmployeecrudoperationsApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeecrudoperationsApplication.class, args);
	}

}
