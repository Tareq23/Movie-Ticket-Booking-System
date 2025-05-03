package com.tareq23.movieticket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class MovieTicketBookingApp {

	public static void main(String[] args) {
		SpringApplication.run(MovieTicketBookingApp.class, args);
	}


	@GetMapping("/")
	public String hello(){
		return "Welcome to this platform";
	}

}
