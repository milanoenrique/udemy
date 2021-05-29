package com.course.udemy;

import com.course.udemy.dao.IPersonDao;
import com.course.udemy.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootApplication
public class UdemyApplication {

	public static void main(String[] args) {
		SpringApplication.run(UdemyApplication.class, args);
	}

    public static class PersonServiceImpl implements PersonService {
        @Autowired
        IPersonDao personDao;
        @Transactional(readOnly = true)
        @Override
        public List<Person> listPerson() {
            return (List<Person>) personDao.findAll();
        }
        @Transactional
        @Override
        public void savePerson(Person person) {
            personDao.save(person);
        }

        @Override
        @Transactional
        public void deletePerson(Person person) {
            personDao.delete(person);
        }

        @Override
        @Transactional(readOnly = true)
        public Person showPerson(long personId) {
            return personDao.findById(personId).orElse(null);
        }
    }

    public static interface PersonService {
        public List<Person> listPerson();
        public void savePerson(Person person);
        public void deletePerson(Person person);
        public Person showPerson(long id);
    }
}
