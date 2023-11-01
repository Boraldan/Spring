package ru.boraldan.spring.controllers;


import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.boraldan.spring.dao.BookDAO;
import ru.boraldan.spring.models.Book;
import ru.boraldan.spring.models.Person;
import ru.boraldan.spring.util.BookValidator;

import java.util.List;

@Controller
@RequestMapping("/library")
public class BookController {
    private final BookDAO bookDAO;
    private final BookValidator bookValidator;

    @Autowired
    public BookController(BookDAO bookDAO, BookValidator bookValidator) {
        this.bookDAO = bookDAO;
        this.bookValidator = bookValidator;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("library", bookDAO.library());
        return "library/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("book", bookDAO.show(id));
        return "library/show";
    }

    @GetMapping("/new")
    public String newBook(@ModelAttribute("book") Book book) {
        return "library/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("book") @Valid Book book,
                         BindingResult bindingResult) {
        bookValidator.validate(book, bindingResult);

        if (bindingResult.hasErrors())
            return "library/new";

        bookDAO.save(book);
        return "redirect:/library";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("book", bookDAO.show(id));
        return "library/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("book") @Valid Book book, BindingResult bindingResult,
                         @PathVariable("id") int id) {
        bookValidator.validate(book, bindingResult);

        if (bindingResult.hasErrors())
            return "library/edit";

        bookDAO.update(id, book);
        return "redirect:/library";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        bookDAO.delete(id);
        return "redirect:/library";
    }

    @PatchMapping("/{id}/pick")
    public String pick(@PathVariable("id") int id) {
        bookDAO.pick(id);
        return "redirect:/people";
    }

    @PatchMapping("/take/{idPerson}")
    public String take(@ModelAttribute("book") Book book, @PathVariable("idPerson") int idPerson) {

//        bookValidator.validate(book, bindingResult);
//        if (bindingResult.hasErrors())
//            return "redirect:/people/" + idPerson;

        bookDAO.give(book.getId(), idPerson);
        return "redirect:/people/" + idPerson;
    }

}
