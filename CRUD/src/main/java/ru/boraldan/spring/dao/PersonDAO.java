package ru.boraldan.spring.dao;

import org.springframework.stereotype.Component;
import ru.boraldan.spring.models.Person;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private static int PEOPLE_CONT;
    private List<Person> personList;
    {
        personList = new ArrayList<>();
        personList.add(new Person(++PEOPLE_CONT, "Alex"));
        personList.add(new Person(++PEOPLE_CONT, "Olya"));
        personList.add(new Person(++PEOPLE_CONT, "Tom"));
        personList.add(new Person(++PEOPLE_CONT, "Alisa"));
    }

    public List<Person> people(){
        return personList;
    }

    public Person show(int id){
        return personList.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }

    public void creat(Person person){
        person.setId(++PEOPLE_CONT);
        personList.add(person);
    }

    public void update(int id, Person updatePerson){
        Person targetPerson = show(id);
        targetPerson.setName(updatePerson.getName());
    }

    public void delete(int id){
        personList.removeIf(p -> p.getId() == id);
    }

}
