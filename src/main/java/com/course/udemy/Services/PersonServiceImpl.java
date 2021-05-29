package com.course.udemy.Services;

import com.course.udemy.dao.IPersonDao;
import com.course.udemy.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service //Esto es lo q permite la inyeccion de dependencias desde el controlador
public class PersonServiceImpl implements PersonService {
    @Autowired
    IPersonDao personDao;
    @Override
    public List<Person> listPerson() {
       return (List<Person>) personDao.findAll();
    }

    @Override
    public void savePerson(Person person) {
        personDao.save(person);
    }

    @Override
    public void deletePerson(Person person) {
        personDao.delete(person);
    }

    @Override
    public Person showPerson(Person person) {
        return personDao.findById(person.getId()).orElse(null);
    }

}
