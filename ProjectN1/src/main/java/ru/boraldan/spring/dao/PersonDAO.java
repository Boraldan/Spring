package ru.boraldan.spring.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.boraldan.spring.models.Person;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import java.util.Optional;


@Component
public class PersonDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Person> index() {
//        return jdbcTemplate.query("SELECT * FROM Person", new PersonMapper());
        return jdbcTemplate.query("SELECT * FROM Person", new BeanPropertyRowMapper<>(Person.class));
    }

    public Person show(int id) {
//        return jdbcTemplate.query("SELECT * FROM Person WHERE id=?", new Object[]{id},
//                new PersonMapper()).stream().findAny().orElse(null);
        return jdbcTemplate.query("SELECT * FROM Person WHERE id=?", new Object[]{id},
                new BeanPropertyRowMapper<>(Person.class)).stream().findAny().orElse(null);
    }

    // --- Validator  класса Person
    public Optional<Person> validPerson(String email) {
        return jdbcTemplate.query("SELECT * FROM Person WHERE email=?", new Object[]{email},
                new BeanPropertyRowMapper<>(Person.class)).stream().findAny();
    }

    public void save(Person person) {
        jdbcTemplate.update("INSERT INTO Person (name, age, email, address) VALUES (?, ?, ?, ?)",
                person.getName(), person.getAge(), person.getEmail(), person.getAddress());
    }

    public void update(int id, Person person) {
        jdbcTemplate.update("UPDATE Person SET name=?, age=?, email=?, address=? WHERE id=?",
                person.getName(), person.getAge(), person.getEmail(), person.getAddress(), id);
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM Person WHERE id=?", id);
    }


    // ------ сравниваем Batch packet с обычной вставкой на 1000 insert
    private List<Person> creatPerson1000() {
        List<Person> people = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {

            people.add(new Person(i, "Name" + i, 10 + i, "goo" + i + "@mail.ru", "SPb" + i));
        }
        return people;
    }

    public void without() {
        long befor = System.currentTimeMillis();

        List<Person> people = creatPerson1000();
        for (Person person : people) {
            jdbcTemplate.update("INSERT INTO Person  (name, age, email) VALUES (?, ?, ?, ?)",
                    person.getName(), person.getAge(), person.getEmail(), person.getAddress());
        }

        long after = System.currentTimeMillis();
        System.out.println("Time " + (after - befor));
    }

    public void with() {
        long befor = System.currentTimeMillis();

        List<Person> people = creatPerson1000();
        jdbcTemplate.batchUpdate("INSERT INTO Person  (name, age, email) VALUES (?, ?, ?, ?)",
                new BatchPreparedStatementSetter() {
                    @Override
                    public void setValues(PreparedStatement ps, int i) throws SQLException {
                        ps.setString(1, people.get(i).getName());
                        ps.setInt(2, people.get(i).getAge());
                        ps.setString(3, people.get(i).getEmail());
                        ps.setString(4, people.get(i).getAddress());
                    }

                    @Override
                    public int getBatchSize() {
                        return people.size();
                    }
                });

        long after = System.currentTimeMillis();
        System.out.println("Time " + (after - befor));
    }

    public void delBatch(int value) {
        jdbcTemplate.batchUpdate("DELETE FROM Person WHERE personId=?", new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                ps.setInt(1, i);
            }

            @Override
            public int getBatchSize() {
                return value;
            }
        });
    }

}
