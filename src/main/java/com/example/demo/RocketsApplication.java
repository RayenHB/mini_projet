package com.example.demo;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.entities.Rocket;
import com.example.demo.service.RocketService;

@SpringBootApplication
public class RocketsApplication  implements CommandLineRunner{
	
	@Autowired
	RocketService rocketService;
	public static void main(String[] args) {
		SpringApplication.run(RocketsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		rocketService.saveRocket(new Rocket("falcon 6", 2600.0, new Date()));
		rocketService.saveRocket(new Rocket("falcon 7", 2800.0, new Date()));
		rocketService.saveRocket(new Rocket("falcon 8", 900.0, new Date()));
		
	}

}
