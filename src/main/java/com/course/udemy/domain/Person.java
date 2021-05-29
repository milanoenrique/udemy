package com.course.udemy.domain;

import lombok.Data;
import org.aspectj.bridge.Message;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;




@Data //Sirve para agregar get y set y otros elementos para los atributos
@Entity //Se convierte clase en entidad o tabla en la bd
@Table(name="persons")
public class Person implements Serializable {

    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //se configura id como primary key de la tabla
    private Long Id;
    @NotEmpty(message = "Please provide a First Name")
    private String FirstName;
    private String LastName;
    private String Mail;
    private String Phone;
}
