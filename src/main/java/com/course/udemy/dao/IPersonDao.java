package com.course.udemy.dao;

import com.course.udemy.domain.Person;
import org.springframework.data.repository.CrudRepository;
//al extender de crud repository automaticamente genera los metodos basicos para un repo
public interface IPersonDao extends CrudRepository<Person,Long> {

}
