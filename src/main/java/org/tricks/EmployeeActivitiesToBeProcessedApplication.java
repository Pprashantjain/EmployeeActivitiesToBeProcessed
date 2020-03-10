package org.tricks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.tricks.helper.ApplicationHelper;

@SpringBootApplication
public class EmployeeActivitiesToBeProcessedApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeActivitiesToBeProcessedApplication.class, args);
	}

	@Autowired
	private ApplicationHelper applicationHelper;

	@Override
	public void run(String... args) throws Exception {

		applicationHelper.getPath();
	}

}
