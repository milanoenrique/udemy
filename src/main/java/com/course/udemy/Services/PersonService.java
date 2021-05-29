package com.course.udemy.Services;

import com.course.udemy.dao.IPersonDao;
import com.course.udemy.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface PersonService {
    public List<Person> listPerson();
    public void savePerson(Person person);
    public void deletePerson(Person person);
    public Person showPerson(Person personId);
}
