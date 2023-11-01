package ru.born.onetoone;

import org.hibernate.annotations.Cascade;


import javax.persistence.*;

@Entity
@Table(name = "Person2")
public class Person2 {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private int age;

    @OneToOne(mappedBy = "person2")
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private Passport2 passport2;


    public Person2(){}

    public Person2(String name, int age) {
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

    public Passport2 getPassport2() {
        return passport2;
    }

    public void setPassport2(Passport2 passport2) {
        this.passport2 = passport2;
        passport2.setPerson2(this);
    }
}
