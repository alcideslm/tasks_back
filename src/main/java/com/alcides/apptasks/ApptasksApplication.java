package com.alcides.apptasks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ApptasksApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApptasksApplication.class, args);
	}

}
