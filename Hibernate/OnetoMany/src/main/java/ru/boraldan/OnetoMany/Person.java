package ru.boraldan.OnetoMany;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Persister;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Person")
public class Person {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "age")
    private int age;

    //  --->  Leson 54 медот persist, каскадирования через JPA
    //    @OneToMany(mappedBy = "owner", cascade = CascadeType.PERSIST)
//    private List<Item> items;

    // Каскадирование через метод save Hibernate
    @OneToMany(mappedBy = "owner")
//    @OneToMany(mappedBy = "owner", fetch = FetchType.LAZY) // "ленивая загрузка" - грузится объект без вложенных списков(default)
//    @OneToMany(mappedBy = "owner", fetch = FetchType.EAGER) // "неленивая" - грузится сразу весь объект
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private List<Item> items;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public void addItem(Item item){
        if(items == null) {
            items = new ArrayList<>();
        }
        items.add(item);
        item.setOwner(this);
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
