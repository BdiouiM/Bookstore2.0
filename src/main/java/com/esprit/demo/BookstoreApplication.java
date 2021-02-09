package com.esprit.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.esprit.demo.service.SendMailService;

@SpringBootApplication
public class BookstoreApplication {
/*	@Autowired
	private SendMailService sendMail;*/
	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
		
	}/*
	@Override
	public void run(String... args) throws Exception {
		sendMail.send("mejrioumaima68@gmail.com","mejrioumaima68@gmail.com", "hi", "hello");
		
	}*/

}
