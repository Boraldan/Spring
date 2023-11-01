package ru.boraldan.OnetoMany;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        Configuration configuration = new Configuration()
                .addAnnotatedClass(Person.class)
                .addAnnotatedClass(Item.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
//        Session session = sessionFactory.getCurrentSession();

//        try {
//            session.beginTransaction();
//            Person person = session.get(Person.class, 1);
//            System.out.println(person);
//            List<Item> items = person.getItems();
//            System.out.println(items);
//            session.getTransaction().commit();
//        }finally {
//            sessionFactory.close();
//        }

//        try {
//            session.beginTransaction();
//            Item item = session.get(Item.class, 2);
//            Person person = item.getOwner();
//            System.out.println(person);
//            session.getTransaction().commit();
//        }finally {
//            sessionFactory.close();
//        }

//        try {
//            session.beginTransaction();
//            Person person = new Person("Alex", 35);
//            Item item = new Item("Xiaomi", person);
//             person.setItems(new ArrayList<>(Collections.singletonList(item)));
//            session.save(person);
//            session.save(item);
//            System.out.println(person.getItems());
//            session.getTransaction().commit();
//        }finally {
//            sessionFactory.close();
//        }

//        try {
//            session.beginTransaction();
//            Person person = session.get(Person.class, 1);
//            List<Item> items = person.getItems();
//            for (Item el : items) {
//                session.remove(el);
//            }
//            person.getItems().clear();
//            session.getTransaction().commit();
//        } finally {
//            sessionFactory.close();
//        }

//        try {
//            session.beginTransaction();
//            Person person = session.get(Person.class, 1);
//            session.remove(person);
//            // кеш Hibernate: очищаем в предметах владельца
//            person.getItems().forEach(i -> i.setOwner(null));
//            session.getTransaction().commit();
//        } finally {
//            sessionFactory.close();
//        }

//        try {
//            session.beginTransaction();
//            Person person = session.get(Person.class, 6);
//            Item item = session.get(Item.class, 9);
//            item.getOwner().getItems().remove(item);
//            // кеш Hibernate
//            person.getItems().add(item);
//            // SQL запрос
//            item.setOwner(person);
//            session.getTransaction().commit();
//        } finally {
//            sessionFactory.close();
//        }

        // ------->  Leson 54 медот persist, каскадирования через JPA
//        try {
//            session.beginTransaction();
//            Person person = new Person("Tom persist", 32);
//            Item item = new Item("Car - persist", person);
//            person.setItems(new ArrayList<>(Collections.singletonList(item)));
//            session.persist(person);
//            session.getTransaction().commit();
//        } finally {
//            sessionFactory.close();
//        }

        // ------->  Leson 54 метод save Hibernate
//        try {
//            session.beginTransaction();
//            Person person = new Person("Tom saveH", 32);
//            Item item = new Item("Car - saveH", person);
//            person.setItems(new ArrayList<>(Collections.singletonList(item)));
//            session.save(person);
//            session.getTransaction().commit();
//        } finally {
//            sessionFactory.close();
//        }

//        try {
//            session.beginTransaction();
//            Person person = new Person("Tom saveH_Item", 33);
//            person.addItem(new Item("Item1"));
//            person.addItem(new Item("Item2"));
//            person.addItem(new Item("Item3"));
//
//            session.save(person);
//            session.getTransaction().commit();
//        } finally {
//            sessionFactory.close();
//        }

//        try (sessionFactory) {
//            Session session = sessionFactory.getCurrentSession();
//            session.beginTransaction();
//
//            Person person = session.get(Person.class, 1);
//            System.out.println("Внутри сессии");
//            System.out.println(person.getName());
//
//            // догружает вложенный список, если Lazy
//            Hibernate.initialize(person.getItems());
//
//            session.getTransaction().commit();
//
//            System.out.println("Вне сессии");
//            System.out.println(person.getItems());
//        }

        try (sessionFactory) {
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            Person person = session.get(Person.class, 1);
            System.out.println("Внутри сессии");
            System.out.println(person.getName());

            session.getTransaction().commit();
            System.out.println("Закрыли первую сессию");

            //  открываем вторую сессию, если надо подгрузить еще данные к person
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            // присоединяем к текущей сессии person
            person = (Person) session.merge(person);
            // догружает вложенный список, если Lazy
            Hibernate.initialize(person.getItems());

            session.getTransaction().commit();

            System.out.println("Вне сессии");
            System.out.println(person.getItems());
        }
    }
}
