package com.minimall.login.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/ms1")
public class DummyController {
	
	@GetMapping
	public String get() {
		return "lol";
	}

}
