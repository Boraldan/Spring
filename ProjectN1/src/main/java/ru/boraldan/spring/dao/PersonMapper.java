package ru.boraldan.spring.dao;


import org.springframework.jdbc.core.RowMapper;
import ru.boraldan.spring.models.Person;

import java.sql.ResultSet;
import java.sql.SQLException;

// этот класс можно заменить автоматической генерацией new BeanPropertyRowMapper<>(Person.class)
public class PersonMapper implements RowMapper<Person> {

    @Override
    public Person mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Person person = new Person();
        person.setId(resultSet.getInt("id"));
        person.setName(resultSet.getString("name"));
        person.setEmail(resultSet.getString("email"));
        person.setAge(resultSet.getInt("age"));
        person.setAddress(resultSet.getString("address"));
        return person;
    }
}
