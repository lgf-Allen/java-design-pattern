package com.allen.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootSingletonPatternApplication {

	public static void main(String[] args) {
//		SpringApplication.run(SpringBootSingletonPatternApplication.class, args);
	    compare();
	}
	
	public static void compare() {
	    Integer i = new Integer(125);
	    Integer j = new Integer(125);
	    System.out.println(i==j);
	}
	
}
