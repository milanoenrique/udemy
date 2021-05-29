package com.course.udemy.controllers;


import com.course.udemy.domain.Person;
import lombok.extern.slf4j.Slf4j;
import lombok.var;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import com.course.udemy.Services.PersonService;


import javax.validation.Valid;

//Estos es para retornar rest
@RestController
//@Controller //Este sirve para retornar una vista
@Slf4j


public class HomeController{

    @Autowired //Inyeccion de dependencia
    private PersonService personService;

    @GetMapping("/home")
    public List<Person> HelloWorld(Model model){
        var listPersons = personService.listPerson();
        //model.addAttribute("listPersons",listPersons);
        return listPersons;
    }

    @PostMapping("/AddPerson")
    public ResponseEntity SavePerson (@Valid @RequestBody Person person, Errors errors){
            if (errors.hasErrors())
                return new ResponseEntity(errors.getFieldErrors(),HttpStatus.BAD_REQUEST);
          personService.savePerson(person);
        return new ResponseEntity<Person>(person, HttpStatus.CREATED);
    }
    @DeleteMapping("/Delete/{PersonId}")
    public void DeletePerson(Person person){
        personService.deletePerson(person);
    }
    @PutMapping("/UpdatePerson/{id}")
    public void UpdatePerson(@RequestBody Person person){
        personService.savePerson(person);
    }
    @GetMapping("/ShowPerson/{id}")
    public Object ShowPerson(Person person){

        return personService.showPerson(person);
    }

}
