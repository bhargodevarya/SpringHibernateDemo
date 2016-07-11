package com.example.controller;

import com.example.model.Address;
import com.example.model.Person;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("person")
public class PersonController {
	
	@RequestMapping(name ="getperson"/*, produces = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE}*/)
	public Person getPerson() {
		Person p = new Person();
		p.setAge(28);
		p.setEmail("email@gmail.com");
		p.setName("Amar");
		return p;
	}

}
