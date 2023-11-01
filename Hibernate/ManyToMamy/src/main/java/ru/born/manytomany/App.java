package ru.born.manytomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class App {
    public static void main(String[] args) {
        Configuration configuration = new Configuration()
                .addAnnotatedClass(Actor.class)
                .addAnnotatedClass(Movie.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();

//        try (sessionFactory) {
//            Session session = sessionFactory.getCurrentSession();
//            session.beginTransaction();
//
//            Movie movie = new Movie("Summer", 2000);
//            Actor actor1 = new Actor("Alex", 20);
//            Actor actor2 = new Actor("Alis", 20);
//
//            movie.setActors(new ArrayList<>(List.of(actor1, actor2)));
//            actor1.setMovies(new ArrayList<>(Collections.singletonList(movie)));
//            actor2.setMovies(new ArrayList<>(Collections.singletonList(movie)));
//
//            session.save(movie);
//            session.save(actor1);
//            session.save(actor2);
//
//            session.getTransaction().commit();
//        }

        try (sessionFactory) {
            // вызываем список актеров по фильму
//            Session session = sessionFactory.getCurrentSession();
//            session.beginTransaction();
//            Movie movie = session.get(Movie.class, 1);
//            System.out.println(movie.getActors());
//            session.getTransaction().commit();
            // --------> добавляем новый фильм актёру
//            Session session = sessionFactory.getCurrentSession();
//            session.beginTransaction();
//            Movie movie = new Movie("Spring", 2001);
//            Actor actor = session.get(Actor.class, 1);
//            movie.setActors(new ArrayList<>(Collections.singletonList(actor)));
//            actor.getMovies().add(movie);
//            session.save(movie);
//            session.getTransaction().commit();
            // --------> удаляем фильм у актёра ( equals hashCode надо реализовать, для правильной работы remove)
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            Movie movie = session.get(Movie.class, 1);
            Actor actor = session.get(Actor.class, 1);

            movie.getActors().remove(actor);
            actor.getMovies().remove(movie);

            System.out.println(actor.getMovies());

            session.getTransaction().commit();

        }
    }
}