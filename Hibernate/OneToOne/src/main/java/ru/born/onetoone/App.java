package ru.born.onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {
    public static void main(String[] args) {
        Configuration configuration = new Configuration()
                .addAnnotatedClass(Person.class)
                .addAnnotatedClass(Passport.class)
                .addAnnotatedClass(Person2.class)
                .addAnnotatedClass(Passport2.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

//        try {
//            session.beginTransaction();
//            Person person = new Person("Tom", 30);
//            Passport passport = new Passport(person, 12345);
            //-----------
//            Person person = new Person("Kat", 25);
//            Passport passport = new Passport(54321);
//            person.setPassport(passport);
//            session.save(person);
            //-----------
//            Person person = session.get(Person.class, 2);
//            System.out.println(person.getName());
//            System.out.println(person.getPassport().getPassportNumber());
            //----------
//            Person person = session.get(Person.class, 2);
//            person.getPassport().setPassportNumber(7531);
//            System.out.println(person.getPassport().getPassportNumber());
//            session.save(person);
            //----------
//            Person person = session.get(Person.class, 1);
//            session.remove(person);
//
//            session.getTransaction().commit();
//        } finally {
//            sessionFactory.close();
//        }


        try {
            session.beginTransaction();
            Person2 person2 = new Person2("Alis", 27);
            Passport2 passport2 = new Passport2(515151);
            person2.setPassport2(passport2);

            session.save(person2);
            session.getTransaction().commit();

        } finally {
            sessionFactory.close();
        }
}}