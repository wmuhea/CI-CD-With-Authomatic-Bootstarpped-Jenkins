package com.springjenkinstut;

import com.springjenkinstut.entity.GubignitParkRide;
import com.springjenkinstut.repository.GubignitRideRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringJenkinsCicdApplication {

	@Bean
	CommandLineRunner initiateData(GubignitRideRepository gubignitRideRepository) {
		return (strings) -> {
			gubignitRideRepository.save(new GubignitParkRide("Megaleb", "Feresochin Megaleb", 12, 5));
			gubignitRideRepository.save(new GubignitParkRide("Mekina", "Roller Coster lay mechawet", 13, 18));
			gubignitRideRepository.save(new GubignitParkRide("Ziwaziwe", "betelleyeye kefita lay ziwaziwe mechawet0", 1, 2));

		};
	}
	public static void main(String[] args) {
		SpringApplication.run(SpringJenkinsCicdApplication.class, args);
	}

}
