package com.oliver.BookStore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Collections;

@SpringBootApplication
public class BookStoreApplication {

	public static void main(String[] args) {
//		SpringApplication.run(BookStoreApplication.class, args);
		int port = Integer.parseInt(System.getenv("PORT"));
		SpringApplication app = new SpringApplication(BookStoreApplication.class);
		app.setDefaultProperties(Collections.singletonMap("server.port", String.valueOf(port)));
		app.run(args);
	}

}
