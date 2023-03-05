package com.icrypt.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.icrypt.app.data.connection.PersonRepository;
import com.icrypt.app.multitenant.entity.Person;
import com.icrypt.app.tenantcontext.ClientDatabase;
import com.icrypt.app.tenantcontext.CustomerContextHolder;

@RestController
public class SimpleController {

	@Autowired
	private PersonRepository personRepository;

	@GetMapping("getall")
	public String getAll(@RequestBody Person person) {
		personRepository.save(person);
		return "Hi Hello";

	}

	@GetMapping("getalla")
	public String getAlla(@RequestBody Person person) {
		personRepository.save(person);
		return "Hello";
	}

}
