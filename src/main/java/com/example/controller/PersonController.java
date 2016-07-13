package com.example.controller;

import com.example.model.Address;
import com.example.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private Validator validator;

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        webDataBinder.addValidators(validator);
    }
	
	@RequestMapping(value = "/fetchperson",method = RequestMethod.GET
			/*, produces = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE}*/)
	public Person getPerson() {
		Person p = new Person();
		p.setAge(28);
		p.setEmail("email@gmail.com");
		p.setName("Amar");

		return p;
	}

    @RequestMapping(value = "/test",method = RequestMethod.POST)
    public void createPerson(@Valid @RequestBody Person person) {
        System.out.println(person);
        System.out.println(">>>>>>>>>>>>>>>>>POSTED<<<<<<<<<<<<<");
    }

    @RequestMapping(value = "/entity/{id}")
    public ResponseEntity getPersonAsEntity(@PathVariable("id") String id) throws Exception {
        if(id.equals("3")) {
            throw new Exception("Custom Exception");
        }
        return new ResponseEntity(new Person(), HttpStatus.ACCEPTED);
    }

}
