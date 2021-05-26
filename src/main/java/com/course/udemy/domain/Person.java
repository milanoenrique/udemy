package com.course.udemy.domain;

import lombok.Data;

import javax.persistence.*;
import javax.persistence.Table;
import java.io.Serializable;


@Data //Sirve para agregar get y set y otros elementos para los atributos
@Entity //Se convierte clase en entidad o tabla en la bd
@Table(name="persons")
public class Person implements Serializable {

    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //se configura id como primary key de la tabla
    private Long Id;
    private String FirstName;
    private String LastName;
    private String Mail;
    private String Phone;
}
