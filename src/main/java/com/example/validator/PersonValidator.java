package com.example.validator;

import com.example.model.Person;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Created by hadoop on 12/7/16.
 */
public class PersonValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.equals(Person.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors,"name","name.empty");
        Person person = (Person)target;
        if(person.getAge() < 18) {
            errors.rejectValue("age","must be atleast 18");
        }
    }
}
