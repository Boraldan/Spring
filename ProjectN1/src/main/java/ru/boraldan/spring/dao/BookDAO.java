package ru.boraldan.spring.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.boraldan.spring.models.Book;

import java.util.List;

@Component
public class BookDAO {
    private final JdbcTemplate jdbcTemplate;


    @Autowired
    public BookDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Book> library() {
        return jdbcTemplate.query("SELECT * FROM Book", new BeanPropertyRowMapper<>(Book.class));
    }

    public Book show(int idBook) {
        return jdbcTemplate.query("SELECT * FROM Book WHERE id=?", new Object[]{idBook},
                new BeanPropertyRowMapper<>(Book.class)).stream().findAny().orElse(null);
    }

    public void save(Book book) {
        jdbcTemplate.update("INSERT INTO Book (name, author, year, idperson) VALUES (?, ?, ?, ?)",
                book.getName(), book.getAuthor(), book.getYear(), 0);
    }

    public void update(int idBook, Book book) {
        jdbcTemplate.update("UPDATE Book SET name=?, author=?, year=? WHERE id=?",
                book.getName(), book.getAuthor(), book.getYear(), idBook);
    }

    public void delete(int idBook) {
        jdbcTemplate.update("DELETE FROM Book WHERE id=?", idBook);
    }


    public List<Book> personBook(int idPerson) {
        return jdbcTemplate.query("select Book.id, Book.name, author, year, idPerson from person " +
                        "join book on person.id = Book.idperson where person.id = ?",
                new Object[]{idPerson}, new BeanPropertyRowMapper<>(Book.class));
    }
    public void give(int idBook, int idPerson) {
        jdbcTemplate.update("UPDATE Book SET idPerson=? WHERE id=?",
                idPerson, idBook);
    }

    public void pick(int idBook) {
        jdbcTemplate.update("UPDATE Book SET idperson=0 WHERE id=?", idBook);
    }

    public List<Book> freeBook(int free) {
        return jdbcTemplate.query("select * from book where idperson =?",
                new Object[]{free}, new BeanPropertyRowMapper<>(Book.class));
    }

}
