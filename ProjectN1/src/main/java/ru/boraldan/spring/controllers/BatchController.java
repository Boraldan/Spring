package ru.boraldan.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.boraldan.spring.dao.PersonDAO;

@Controller
@RequestMapping("/batch")
public class BatchController {

    private final PersonDAO personDAO;

    @Autowired
    public BatchController(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    @GetMapping
    public String index() {
        return "batch/index";
    }

    @GetMapping("/without")
    public String without() {
        personDAO.without();
        return  "redirect:/people";
    }

    @GetMapping("/with")
    public String withBatch() {
        personDAO.with();
        return  "redirect:/people";
    }

    @GetMapping("/del")
    public String delBatch(){
        personDAO.delBatch(500);
        return  "redirect:/people";
    }
}
