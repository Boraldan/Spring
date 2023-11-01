package ru.boraldan.hibernatestart;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class App {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().addAnnotatedClass(Person.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();


        // HibernateStart Lesson 47
//        try {
//            session.beginTransaction();
//            Person p = session.get(Person.class, 1);
//            System.out.printf("%d : %s : %d", p.getId(), p.getName(), p.getAge());
//            session.getTransaction().commit();
//        } finally {
//            sessionFactory.close();
//        }

//         HibernateStart Lesson 48

//        try {
//            session.beginTransaction();
//            Person p1 = new Person("Tom", 20);
//            Person p2 = new Person("Tom2", 21);
//            Person p3 = new Person("Tom3", 22);
//            session.save(p1);
//            session.save(p2);
//            session.save(p3);
//
//            session.getTransaction().commit();
//        } finally {
//            sessionFactory.close();
//        }

//        try {
//            session.beginTransaction();
//            Person p4 = new Person("Tom4", 20);
//            session.save(p4);
//            session.getTransaction().commit();
//            System.out.printf("%d : %s : %d", p4.getId(), p4.getName(), p4.getAge());
//
//        } finally {
//            sessionFactory.close();
//        }


//        try {
//            session.beginTransaction();
//            Person p5 = session.get(Person.class, 2);
//            p5.setName("GoGoGo");
//            System.out.printf("%d : %s : %d", p5.getId(), p5.getName(), p5.getAge());
//
//            Person p6 = session.get(Person.class, 3);
//            session.delete(p6);
//            session.getTransaction().commit();
//
//        } finally {
//            sessionFactory.close();
//        }

//        try {
//            session.beginTransaction();
//            List<Person> people = session.createQuery("FROM Person").getResultList();
//            for (Person el : people) {
//                System.out.println(el);
//            }
//            session.getTransaction().commit();
//        } finally {
//            sessionFactory.close();
//        }

//        try {
//            session.beginTransaction();
//            List<Person> people = session.createQuery("FROM Person where id < 5").getResultList();
//            for (Person el : people) {
//                System.out.println(el);
//            }
//            session.getTransaction().commit();
//        } finally {
//            sessionFactory.close();
//        }

//        try {
//            session.beginTransaction();
//            List<Person> people = session.createQuery("FROM Person where name LIKE 'T%'").getResultList();
//            for (Person el : people) {
//                System.out.println(el);
//            }
//            session.getTransaction().commit();
//        } finally {
//            sessionFactory.close();
//        }

//        try {
//            session.beginTransaction();
//            session.createQuery("update Person set name='TomNext' where age>20").executeUpdate();//
//            session.getTransaction().commit();
//        } finally {
//            sessionFactory.close();
//        }

        try {
            session.beginTransaction();
            session.createQuery("delete Person where id>5").executeUpdate();
            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }

    }
}
