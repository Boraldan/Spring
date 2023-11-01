package ru.boraldan.spring.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.boraldan.spring.dao.BookDAO;
import ru.boraldan.spring.models.Book;
import ru.boraldan.spring.models.Person;

@Component
public class BookValidator implements Validator {

    private final BookDAO bookDAO;


    @Autowired
    public BookValidator(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }


    @Override
    public boolean supports(Class<?> clazz) {
        return Book.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Book book = (Book) target;

        if(book.getYear() < 0){
            errors.rejectValue("age", "", "This age be > 0");
        }
        if(book.getName().length() == 0 || book.getName().length() > 50){
            errors.rejectValue("name", "", "This name symbol between 0 - 50");
        }

        if(book.getAuthor().length() == 0 || book.getAuthor().length() > 50){
            errors.rejectValue("name", "", "This name symbol between 0 - 50");
        }

        if(!Character.isUpperCase(book.getName().codePointAt(0))){
            errors.rejectValue("name", "", "The name must begin with a capital letter");
        }

    }
}
