package com.todowebservice.todorestfullwebservices.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	@GetMapping("/basicauth")
	public String basicAuthCheck() {
		return "Success";
	}
	
}
