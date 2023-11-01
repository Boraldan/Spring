package ru.boraldan.spring.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.boraldan.spring.dao.PersonDAO;
import ru.boraldan.spring.models.Person;


@Component
public class PersonValidator implements Validator {
    private final PersonDAO personDAO;

    @Autowired
    public PersonValidator(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }


    @Override
    public boolean supports(Class<?> clazz) {
        return Person.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Person person = (Person) target;

        // проверяем, есть ли такой емейл в базе у кого-нибудь
        if(personDAO.validPerson(person.getEmail()).isPresent()){
            errors.rejectValue("email", "", "This email is already taken");        }

        if(person.getAge() < 0){
            errors.rejectValue("age", "", "This age be > 0");
        }
        if(person.getName().length() == 0 || person.getName().length() > 30){
            errors.rejectValue("name", "", "This name symbol between 0 - 30");
        }

        if(!Character.isUpperCase(person.getName().codePointAt(0))){
            errors.rejectValue("name", "", "The name must begin with a capital letter");
        }
    }

    // добавляем новы метод, который исключает проверку повторяющегося емейла при обновлении контакта
    public void validEmaiUnchangeable(Object target, Errors errors) {
        Person person = (Person) target;

        if(person.getAge() < 0){
            errors.rejectValue("age", "", "This age be > 0");
        }
        if(person.getName().length() == 0 || person.getName().length() > 30){
            errors.rejectValue("name", "", "This name symbol between 0 - 30");
        }

        if(!Character.isUpperCase(person.getName().codePointAt(0))){
            errors.rejectValue("name", "", "The name must begin with a capital letter");
        }
    }
}
