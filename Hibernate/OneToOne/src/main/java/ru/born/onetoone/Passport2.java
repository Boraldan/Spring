package ru.born.onetoone;

import javax.persistence.*;

@Entity
@Table(name = "Passport2")
public class Passport2 {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "passport_number")
    private int passportNumber;

    @OneToOne
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    private Person2 person2;

    public Passport2() {
    }

    public Passport2(int passportNumber) {
        this.passportNumber = passportNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(int passportNumber) {
        this.passportNumber = passportNumber;
    }

    public Person2 getPerson2() {
        return person2;
    }

    public void setPerson2(Person2 person2) {
        this.person2 = person2;
    }

}
