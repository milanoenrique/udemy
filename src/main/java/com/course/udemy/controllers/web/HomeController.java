package com.course.udemy.controllers.web;

import com.course.udemy.dao.IPersonDao;
import com.course.udemy.domain.Person;
import lombok.extern.slf4j.Slf4j;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//Estos es para retornar rest
@RestController
//@Controller //Este sirve para retornar una vista
@Slf4j
// sirver para leer properties @Value()
public class HomeController {
    @Autowired
    private IPersonDao personDao;
    @GetMapping("/home")

    public Iterable<Person> HelloWorld(Model model){
        var person = new Person();
        person.setFirstName("Enrique");
        person.setLastName("Milano");
        person.setMail("milanoenrique@gmail.com");
        person.setPhone("112882175");
        personDao.save(person);

        var listPersons = personDao.findAll();
        //model.addAttribute("listPersons",listPersons);
        return listPersons;
    }

}
