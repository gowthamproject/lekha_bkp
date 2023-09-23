package com.wipro.lekhaclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.wipro.lekhaclient.services.AlarmService;

@SpringBootApplication
public class LekhaclientApplication {

	public static void main(String[] args) {
		SpringApplication.run(LekhaclientApplication.class, args);
		System.out.println("Lekha Application is running..");
		try {
			new AlarmService().pull_AlarmDetailsFromLekhaAPI();
			System.out.println("Lekha Application completed");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
