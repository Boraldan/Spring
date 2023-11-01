package ru.boraldan.spring.models;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class Book {

    private int id;
    @NotEmpty(message = "Name should not be empty")
    @Size(min = 1, max = 50, message = "Название должно быть от 2 до 50 символов")
    private String name;
    @NotEmpty(message = "Name should not be empty")
    @Size(min = 1, max = 50, message = "Название должно быть от 2 до 50 символов")
    private String author;

    private int year;

    private int idPerson;

    public Book() {
    }

    public Book(int idBook, String name, String author, int year, int idPerson, String reader) {
        this.id = idBook;
        this.name = name;
        this.author = author;
        this.year = year;
        this.idPerson = idPerson;
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(int idPerson) {
        this.idPerson = idPerson;
    }


    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", year=" + year +
                ", idPerson=" + idPerson +
                '}';
    }
}
